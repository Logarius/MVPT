package git.osc.roland.mvpt.common.view;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roland on 2017/6/30.
 */
public abstract class ViewBuilder {

    protected Map<String, JComponent> views = new HashMap<>();

    protected JFrame baseFrame = null;

    public ViewBuilder() {
        build();
        registerViews();
    }

    protected abstract void build();

    protected abstract void registerViews();

    public JComponent findViewByName(String name) {
        if (views.containsKey(name)) {
            return views.get(name);
        }
        return null;
    }

    public JFrame getBaseFrame() {
        return baseFrame;
    }
}
