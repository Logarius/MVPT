package git.osc.roland.mvpt.deckbuilder;

import git.osc.roland.mvpt.common.view.ViewBuilder;

import javax.swing.*;

/**
 * Created by Roland on 2017/6/30.
 */
public class ViewDeckBuilder extends ViewBuilder {

    @Override
    protected void build() {
        baseFrame = new JFrame("DeckBuilder");
        baseFrame.setSize(300, 400);
        baseFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    protected void registerViews() {

    }
}
