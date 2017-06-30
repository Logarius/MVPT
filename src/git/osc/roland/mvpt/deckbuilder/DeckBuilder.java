package git.osc.roland.mvpt.deckbuilder;

import git.osc.roland.mvpt.common.view.Activity;

/**
 * Created by Roland on 2017/6/29.
 */
public class DeckBuilder extends Activity {

    @Override
    protected void onCreate() {
        setViewBuilder(new ViewDeckBuilder());
    }
}
