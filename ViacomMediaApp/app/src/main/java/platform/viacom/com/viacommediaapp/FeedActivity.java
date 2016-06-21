package platform.viacom.com.viacommediaapp;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;

/**
 * Created by kathires on 6/17/16.
 */

public class FeedActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        //return new FeedFragment();

        return FeedFragment.getNewInstance( (String) getIntent().getSerializableExtra( FeedFragment.EXTRA_FEED_NAME ), (String) getIntent().getSerializableExtra( FeedFragment.EXTRA_FEED_VALUE ) );

    }
}
