package platform.viacom.com.viacommediaapp;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends SingleFragmentActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.show();
        //setContentView(R.layout.activity_main);
        //JSONParser jsonParser = new JSONParser();
        //jsonParser.getJSONFromUrl( "https://raw.githubusercontent.com/saravanan86/pub/master/brandCollectionFeed.json" );
        //jsonParser.execute("https://raw.githubusercontent.com/saravanan86/pub/master/brandCollectionFeed.json");
        //new BrandCollectionFeed().getFeedData("mtv");
    }*/

    @Override
    protected Fragment createFragment() {

        return new FeedTypesFragment();//CrimeFragment.getNewInstance( (UUID) getIntent().getSerializableExtra( CrimeFragment.EXTRA_CRIME_ID ) );

    }
}
