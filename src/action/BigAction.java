package action;

import view.ViewSerivce;

import javax.xml.ws.Service;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class BigAction implements Action{
    @Override
    public void onAction(ViewSerivce viewSerivce) {
        viewSerivce.mkBig();
    }
}
