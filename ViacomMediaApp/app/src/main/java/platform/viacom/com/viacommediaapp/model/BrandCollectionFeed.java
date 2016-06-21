package platform.viacom.com.viacommediaapp.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;

import platform.viacom.com.viacommediaapp.util.FeedFetcher;


/**
 * Created by kathires on 6/16/16.
 */

public class BrandCollectionFeed {

    private JSONObject mFeedObject;

    public BrandCollectionFeed( JSONObject obj ){

        try {
            mFeedObject = obj;
            //JSONArray arr = (JSONArray) obj.get("brands");
            //mFeedObject = (JSONObject) arr.get(0);
        }catch(Exception e){

        }

    }

    public ArrayList<FeedProperty> getValues( String feedType ){

        try {
            if (feedType.equals( "Brand Collection" ) || feedType.equals( "Brand Details" )) {

                JSONArray arr = (JSONArray) mFeedObject.get("brands");
                mFeedObject = (JSONObject) arr.get(0);

            } else if( feedType.equals( "Show Collection" ) ){

                JSONObject obj = (JSONObject) mFeedObject.get("response");
                JSONArray arr = (JSONArray) obj.get("series");
                mFeedObject = (JSONObject) arr.get(0);

            } else if( feedType.equals( "Featured Episodes" ) ){

                JSONObject obj = (JSONObject) mFeedObject.get("response");
                JSONArray arr = (JSONArray) obj.get("episodes");
                mFeedObject = (JSONObject) arr.get(0);

            }
        }catch(Exception e){

        }

        ArrayList<FeedProperty> list = new ArrayList<FeedProperty>();

        try {
            for (int i = 0; i < mFeedObject.names().length(); i++) {

                String key = mFeedObject.names().getString(i);
                list.add( new FeedProperty( key, mFeedObject.get(key).toString( ) ) );

            }
        }catch(Exception e){

        }

        return list;

    }

}
