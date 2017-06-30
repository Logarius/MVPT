package git.osc.roland.mvpt.main;

import git.osc.roland.mvpt.common.utils.LogUtils;
import git.osc.roland.mvpt.common.view.Activity;
import git.osc.roland.mvpt.deckbuilder.DeckBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boot extends Activity {

    private JButton btnDeckBuilder, btnDuel;

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case ViewBoot.R.btnDeckBuilder:
                    startActivity(new DeckBuilder());
                    dispose();
                    break;

                case ViewBoot.R.btnDuel:
                    LogUtils.d(TAG, "duel");
                    break;
            }
        }
    };

    @Override
    protected void onCreate() {
        setViewBuilder(new ViewBoot());
        btnDeckBuilder = (JButton) findViewByName(ViewBoot.R.btnDeckBuilder);
        btnDuel = (JButton) findViewByName(ViewBoot.R.btnDuel);

        btnDeckBuilder.addActionListener(actionListener);
        btnDuel.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()  {
                Activity.startActivity(new Boot());
            }
        });
    }
}
