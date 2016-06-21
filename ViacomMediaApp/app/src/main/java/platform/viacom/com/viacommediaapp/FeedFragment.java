package platform.viacom.com.viacommediaapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.util.ArrayList;

import platform.viacom.com.viacommediaapp.model.BrandCollectionFeed;
import platform.viacom.com.viacommediaapp.model.FeedProperty;

/**
 * Created by kathires on 6/17/16.
 */

public class FeedFragment extends Fragment {

    public static final String EXTRA_FEED_NAME = "feedName";
    public static final String EXTRA_FEED_VALUE = "feedValue";
    private ArrayList<FeedProperty> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d( "FeedFragment: ", getArguments().getString( EXTRA_FEED_NAME ) );
        Log.d( "FeedFragment: ", getArguments().getString( EXTRA_FEED_VALUE ) );
        try {

            BrandCollectionFeed brandCollectionFeed = new BrandCollectionFeed(new JSONObject(getArguments().getString(EXTRA_FEED_VALUE)));
            data = brandCollectionFeed.getValues(getArguments().getString( EXTRA_FEED_NAME ));

        }catch(Exception e){


        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate( R.layout.feed_view_fragment, container, false );
        RecyclerView recyclerView = (RecyclerView) view.findViewById( R.id.recycler );
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter( new FeedViewAdapter( data ) );//getArguments().getString( EXTRA_FEED_NAME ),getArguments().getString( EXTRA_FEED_VALUE )
        recyclerView.setLayoutManager( new LinearLayoutManager( getActivity().getApplicationContext() ) );

        return view;

    }

    public static FeedFragment getNewInstance( String feedName, String feedValue ){

        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
        args.putString( EXTRA_FEED_NAME, feedName );
        args.putString( EXTRA_FEED_VALUE, feedValue );

        fragment.setArguments( args );

        return fragment;
    }
}
