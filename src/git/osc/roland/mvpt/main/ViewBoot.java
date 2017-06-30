package git.osc.roland.mvpt.main;

import git.osc.roland.mvpt.common.view.ViewBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Roland on 2017/6/30.
 */
public class ViewBoot extends ViewBuilder {

    private static final String title = "MVPT";

    private static final int width = 480;

    private static final int height = 600;

    private JButton btnDeckBuilder, btnDuel;

    @Override
    protected void build() {
        baseFrame = new JFrame(ViewBoot.title);
        baseFrame.setSize(ViewBoot.width, ViewBoot.height);
        baseFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        baseFrame.setLayout(null);

        btnDeckBuilder = new JButton("DeckBuilder");
        btnDuel = new JButton("Duel");

        int panelWidth = 100, panelHeight = 100;
        int x = (ViewBoot.width - panelWidth) / 2;
        int y = (ViewBoot.height - panelHeight) / 2;

        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(btnDeckBuilder);
        panel.add(btnDuel);
        panel.setSize(panelWidth, panelHeight);
        panel.setLocation(x, y);

        baseFrame.getContentPane().add(panel);
    }

    @Override
    protected void registerViews() {
        views.put(R.btnDeckBuilder, btnDeckBuilder);
        views.put(R.btnDuel, btnDuel);
    }

    static class R {
        static final String btnDeckBuilder = "DeckBuilder";
        static final String btnDuel = "Duel";
    }
}
