package git.osc.roland.mvpt.common.view;

import javax.swing.*;

/**
 * Created by Roland on 2017/6/30.
 */
public abstract class Activity {

    protected final String TAG = getClass().getSimpleName();

    protected ViewBuilder viewBuilder = null;

    protected JFrame baseFrame = null;

    public static final String EXCEPTION_NO_VIEW_BUILDER = "Call setViewBuilder(ViewBuilder) first!";

    protected abstract void onCreate();

    protected void setViewBuilder(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
        if (viewBuilder != null) {
            baseFrame = viewBuilder.getBaseFrame();
        }
    }

    public JComponent findViewByName(String name) {
        if (viewBuilder != null) {
            return viewBuilder.findViewByName(name);
        } else {
            throw new RuntimeException(EXCEPTION_NO_VIEW_BUILDER);
        }
    }

    public void show() {
        if (baseFrame != null) {
            baseFrame.setVisible(true);
        }
    }

    public void dispose() {
        if (baseFrame != null) {
            baseFrame.dispose();
        }
    }

    public static void startActivity(Activity activity) {
        activity.onCreate();
        activity.show();
    }
}
