package platform.viacom.com.viacommediaapp.model;

import java.util.ArrayList;

/**
 * Created by kathires on 6/17/16.
 */

public class FeedTypes {

    private ArrayList<FeedType> mFeeds;
    private static FeedTypes mFeedTypes = null;

    private FeedTypes(){

        mFeeds = new ArrayList();
        mFeeds.add( new FeedType( "Brand Collection", "https://api.viacom.com/contents/v2/brands?apiKey=9Czbr2So2iyTSgcXLsldl4fimETOBrix" ) );//https://raw.githubusercontent.com/saravanan86/pub/master/brandCollectionFeed.json
        mFeeds.add( new FeedType( "Brand Details", "https://api.viacom.com/contents/v2/brands/cc?apiKey=9Czbr2So2iyTSgcXLsldl4fimETOBrix" ) );//https://raw.githubusercontent.com/saravanan86/pub/master/brandCollectionFeed.json
        mFeeds.add( new FeedType( "Show Collection", "https://api.viacom.com/contents/v2/brands/cc/shows?apiKey=9Czbr2So2iyTSgcXLsldl4fimETOBrix" ) );//https://raw.githubusercontent.com/saravanan86/pub/master/listOfShows.json
        //mFeeds.add( new FeedType( "Delta Shows", "https://raw.githubusercontent.com/saravanan86/pub/master/brandCollectionFeed.json" ) );
        mFeeds.add( new FeedType( "Featured Episodes", "https://api.viacom.com/contents/v2/brands/cc/episodes/featured?apiKey=9Czbr2So2iyTSgcXLsldl4fimETOBrix" ) );//https://raw.githubusercontent.com/saravanan86/pub/master/featuredShows.json
        //mFeeds.add( new FeedType( "Featured Episodes", "https://raw.githubusercontent.com/saravanan86/pub/master/brandCollectionFeed.json" ) );

    }

    public static FeedTypes getFeedTypes(){

        if( mFeedTypes == null ){

            mFeedTypes = new FeedTypes();

        }

        return mFeedTypes;

    }

    public ArrayList getFeedList(){


        return mFeeds;

    }

    public FeedType getFeedType( int position ){

        return mFeeds.size() > position ? mFeeds.get( position ) : null;


    }

}
