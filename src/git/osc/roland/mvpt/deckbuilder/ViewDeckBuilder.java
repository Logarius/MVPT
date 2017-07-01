package git.osc.roland.mvpt.deckbuilder;

import git.osc.roland.mvpt.common.view.ViewBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Roland on 2017/6/30.
 */
public class ViewDeckBuilder extends ViewBuilder {

    @Override
    protected void build() {
        baseFrame = new JFrame("DeckBuilder");
        baseFrame.setSize(1366, 768);
        baseFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridBagLayout basePanelLayout = new GridBagLayout();
        baseFrame.setLayout(basePanelLayout);

        JPanel centerPanel = new JPanel();
        JPanel leftPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        JPanel rightPanel = new JPanel();

        baseFrame.add(leftPanel);
        baseFrame.add(centerPanel);
        baseFrame.add(rightPanel);

        GridBagConstraints baseConstraints = new GridBagConstraints();
        baseConstraints.fill = GridBagConstraints.BOTH;
        baseConstraints.gridwidth = 10;
        baseConstraints.weightx = 1;
        baseConstraints.weighty = 1;
        basePanelLayout.setConstraints(leftPanel, baseConstraints);

        baseConstraints.fill = GridBagConstraints.VERTICAL;
        baseConstraints.gridwidth = 1;
        baseConstraints.weightx = 0;
        baseConstraints.weighty = 1;
        basePanelLayout.setConstraints(centerPanel, baseConstraints);

        baseConstraints.fill = GridBagConstraints.BOTH;
        baseConstraints.gridwidth = 0;
        baseConstraints.weightx = 1;
        baseConstraints.weighty = 1;
        basePanelLayout.setConstraints(rightPanel, baseConstraints);

        JButton cardImageArea = new JButton();
        JButton dbListArea = new JButton();
        leftPanel.add(cardImageArea);
        leftPanel.add(dbListArea);

        JButton deckNameArea = new JButton("HHHH");
        JButton mainDeckArea = new JButton();
        JButton sideDeckArea = new JButton();
        JPanel deckPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        deckPanel.add(mainDeckArea);
        deckPanel.add(sideDeckArea);

        rightPanel.add(deckNameArea);
        rightPanel.add(deckPanel);

        GridBagLayout rightPanelLayout = new GridBagLayout();
        rightPanel.setLayout(rightPanelLayout);
        GridBagConstraints rightPanelConstraints = new GridBagConstraints();

        rightPanelConstraints.fill = GridBagConstraints.HORIZONTAL;
        rightPanelConstraints.gridwidth = 0;
        rightPanelConstraints.gridheight = 1;
        rightPanelConstraints.weightx = 1;
        rightPanelConstraints.weighty = 0;
        rightPanelLayout.setConstraints(deckNameArea, rightPanelConstraints);

        rightPanelConstraints.fill = GridBagConstraints.BOTH;
        rightPanelConstraints.gridwidth = 0;
        rightPanelConstraints.gridheight = 0;
        rightPanelConstraints.weightx = 1;
        rightPanelConstraints.weighty = 1;
        rightPanelLayout.setConstraints(deckPanel, rightPanelConstraints);
    }

    @Override
    protected void registerViews() {

    }
}
