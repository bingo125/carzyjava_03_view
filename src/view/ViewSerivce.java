package view;

import javax.swing.*;
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

    public ViewSerivce(View jFrame) {
        this.jFrame = jFrame;
        fileList = new ArrayList<>();
    }

    public static ViewSerivce getInstance(View frame) {
        if (_self == null) {
            _self = new ViewSerivce(frame);
        }
        return _self;
    }
    private  String dirBk;

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
        jFrame.setBackIcon(f);
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
    }


    public void mkBig() {
    }

    public void mkSmall() {
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
}