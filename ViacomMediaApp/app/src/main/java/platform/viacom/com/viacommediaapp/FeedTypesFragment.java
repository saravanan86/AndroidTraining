package platform.viacom.com.viacommediaapp;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;

import platform.viacom.com.viacommediaapp.model.BrandCollectionFeed;
import platform.viacom.com.viacommediaapp.model.FeedType;
import platform.viacom.com.viacommediaapp.model.FeedTypes;
import platform.viacom.com.viacommediaapp.util.FeedFetcher;

/**
 * Created by kathires on 6/17/16.
 */

public class FeedTypesFragment extends ListFragment {

    private FeedTypes mFeedTypes;
    private ArrayList mFeedList;
    private FeedType mFeedType;
    private JSONObject feedObject = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //getActivity().getActionBar().setDisplayShowTitleEnabled( true );
        getActivity().setTitle( R.string.app_name );
        //ActionBar actionbar = getActivity().getActionBar();
        //actionbar.setTitle(getResources().getString( R.string.feed_types ));
        mFeedTypes = FeedTypes.getFeedTypes();
        mFeedList = mFeedTypes.getFeedList();
        FeedTypeAdapter adapter = new FeedTypeAdapter( mFeedList );
        setListAdapter( adapter );

    }

    @Override
    public void onListItemClick(ListView l, View v, final int position, long id) {

        mFeedType = mFeedTypes.getFeedType(position);
        super.onListItemClick(l, v, position, id);
        try {
            FeedFetcher feedFetcher = new FeedFetcher(new FeedFetcher.AsyncResponse() {
                @Override
                public void processFinish(JSONObject result) {

                    try {
                        mFeedType.setFeedAvailable(true);
                        feedObject = result;
                        Log.d("FeedTypesFragment: ", result.toString(2));
                        Intent intent = new Intent(getActivity(), FeedActivity.class);
                        intent.putExtra( FeedFragment.EXTRA_FEED_NAME, mFeedType.getFeedName() );
                        intent.putExtra( FeedFragment.EXTRA_FEED_VALUE, feedObject.toString() );
                        startActivity(intent);
                    }catch( Exception e ){

                    }

                }
            });
            feedFetcher.execute(mFeedType.getFeedUrl());
        }catch( Exception e ){

        }

    }

    public class FeedTypeAdapter extends ArrayAdapter<FeedType>{

        public FeedTypeAdapter( ArrayList<FeedType> feedTypes ){

            super( getActivity(), 0, feedTypes );

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if( convertView == null ){

                convertView = getActivity().getLayoutInflater().inflate( R.layout.list_feed_types, null );

            }

            FeedType type = getItem(position);

            TextView textView = (TextView) convertView.findViewById( R.id.feedType );
            textView.setText( type.getFeedName() );

            return convertView;

        }
    }

}
