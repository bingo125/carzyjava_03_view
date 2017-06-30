package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class ViewSerivce {

    private static ViewSerivce _self = null;
    private View jFrame;
    private MyChooseFile chooseFile;
    private File curFile = null;
    private List<File> fileList;
    private  JLabel label;
    private  String dirBk;



    public ViewSerivce(View jFrame, JLabel label) {
        this.jFrame = jFrame;
        this.label = label;
        fileList = new ArrayList<>();
    }


    public void open() {
        if (dirBk == null) {
            chooseFile = new MyChooseFile();
        }else{

            chooseFile = new MyChooseFile(dirBk);
        }

        if (chooseFile.showOpenDialog(jFrame) == JFileChooser.APPROVE_OPTION) {
            File f = chooseFile.getSelectedFile();
            dirBk = chooseFile.getCurrentDirectory().getAbsolutePath();

            if (fileList.isEmpty() || !fileList.contains(f)) {
                fileList.add(f);
                curFile = f;
            }
            System.out.println(f.getName());
            showPic(f);
        }
    }

    private void showPic(File f) {
        String path = f.getAbsolutePath();
        label.setIcon(new ImageIcon(path));
    }

    public void nextPic() {
        if (fileList.isEmpty()) {
            showPic(curFile);
        } else {
            int idx = fileList.indexOf(curFile);
            if (idx == -1) {
                curFile = curFile;
            } else if (fileList.size() -1 == idx) {
                curFile = fileList.get(0);
            } else {
                curFile = fileList.get(idx+1);
            }
        }
        showPic(curFile);
    }

    public void del() {
        File last = curFile;
        nextPic();
        fileList.remove(last);
        last.delete();
    }

    private final double dispersion = 0.2;

    public void mkBig() {
        zoom(false);
    }

    public void mkSmall() {
        zoom(true);

    }

    private void zoom(boolean isTrue) {
        int  wid = 0;
        if(isTrue){
            wid = (int) (label.getIcon().getIconWidth() * (1 - dispersion));
        }else{
            wid = (int) (label.getIcon().getIconWidth() * (1 + dispersion));
        }
        String path = curFile.getPath();
        ImageIcon image = new ImageIcon(path);

        ImageIcon newImage = new ImageIcon(image.getImage().getScaledInstance(wid, -1, Image.SCALE_DEFAULT));
        label.setIcon(newImage);
    }

    public void previous() {

        int idx = fileList.indexOf(curFile);
        if (idx == -1) {
            curFile = curFile;
        } else if (0 == idx) {
            curFile = fileList.get(fileList.size()-1);
        } else {
            curFile = fileList.get(idx-1);
        }
        showPic(curFile);
    }

    public void menuDo(String menu) {
        switch (menu) {
            case "打开(O)":
                open();
                break;
            case "退出(X)":
                System.exit(0);
                break;
            case "放大(M)":
                zoom(false);
                break;
            case "缩小(O)":
                zoom(true);
                break;
            case "上一个(X)":
                previous();
                break;
            case "下一个(P)":
                nextPic();
                break;
            case "帮助主题":

                break;
            case "关于":
                showDialog();
                break;
        }
    }

    private void showDialog() {
        JOptionPane.showMessageDialog(jFrame, "Eggs are not supposed to be green.", "关于", JOptionPane.INFORMATION_MESSAGE);
    }
}