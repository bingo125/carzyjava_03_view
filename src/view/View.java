package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class View extends JFrame{

    private int width = 800;
    private int heigh = 600;
    private  JLabel jLabel;
    public View() throws HeadlessException {
        initUI();
    }

    private void initUI() {
        setPreferredSize(new Dimension(width , heigh));
        setResizable(false);
        setTitle("看图工具");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        creatMenu();
        jPanel.add(BorderLayout.NORTH, createToolBar());
        jLabel = new JLabel();
        jPanel.add(BorderLayout.CENTER, new JScrollPane(jLabel));
        this.add(jPanel);
        pack();
        setVisible(true);
    }


    private  String [] images = {
            "OpenAction.gif",
            "BigAction.gif",
            "SmallAction.gif",
            "LastAction.gif",
            "NextAction.gif",
            "Del.gif",
    };
    private JPanel createToolBar() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < images.length; i++) {
            JButton button = new JButtonFacotry(images[i], this).getButton();
            jPanel.add(button);
        }
        return jPanel;
    }


    private void creatMenu() {

        JMenuBar menuBar = new JMenuBar();
        // 菜单文字数组，以下面的menuItemArr一一对应
        String[] menuArrs = { "文件(F)", "工具(T)", "帮助(H)" };
        // 菜单项文字数组
        String[][] menuItemArrs = {{"打开(O)", "-", "退出(X)"},
                {"放大(M)", "缩小(O)", "-", "上一个(X)", "下一个(P)"}, {"帮助主题", "关于"}};
        for (int i = 0; i < menuArrs.length; i++) {
            JMenu menu = new JMenu(menuArrs[i]);

            for (int j = 0; j < menuItemArrs[i].length; j++) {
                if (menuItemArrs[i][j].equals("-")) {
                    menu.addSeparator();
                }else{
                    menu.add(new JMenuItem(menuItemArrs[i][j]));
                }
            }
            menuBar.add(menu);
        }
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        View v = new View();
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println("hello world");
    }

    public void setBackIcon(File f) {
        String imagePath = f.getAbsolutePath();
        ImageIcon image = new ImageIcon(imagePath);
        jLabel.setIcon(image);
    }
}