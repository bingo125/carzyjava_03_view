package action;

import view.ViewSerivce;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class NextAction implements Action {
    @Override
    public void onAction(ViewSerivce viewSerivce) {
        viewSerivce.nextPic();
    }
}
