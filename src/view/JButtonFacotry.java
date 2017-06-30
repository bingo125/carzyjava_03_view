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
    private ViewSerivce vs;

    public JButtonFacotry(String path, ViewSerivce vs) {
        this.path = path;
        this.vs = vs;
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
                action.onAction(vs);
            }
        });
        return button;
    }

}
