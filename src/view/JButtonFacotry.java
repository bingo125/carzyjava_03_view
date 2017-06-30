package view;

import action.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class JButtonFacotry {
    private Action action;
    private String path;

    public JButtonFacotry(String path, View jFrame) {
        this.path = path;
        this.jFrame = jFrame;
        String actName = "action." + path.split("\\.gif")[0];
        try {
            this.action = (Action) Class.forName(actName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private View jFrame;

    public JButtonFacotry(String path) {
    }

    public JButton getButton() {
        JButton button = new JButton(  new ImageIcon("image/"+ path));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.onAction(ViewSerivce.getInstance(jFrame));
            }
        });
        return button;
    }

}
