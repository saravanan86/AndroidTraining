package platform.viacom.com.viacommediaapp.model;

/**
 * Created by kathires on 6/17/16.
 */

public class FeedType {

    private String mFeedName;
    private String mFeedUrl;
    private boolean mFeedAvailable;

    public FeedType( String feedName, String url ){

        mFeedName = feedName;
        mFeedUrl = url;

    }

    public String getFeedUrl() {
        return mFeedUrl;
    }

    public String getFeedName() {
        return mFeedName;
    }

    public void setFeedAvailable( boolean flag ){

        mFeedAvailable = flag;

    }




}
