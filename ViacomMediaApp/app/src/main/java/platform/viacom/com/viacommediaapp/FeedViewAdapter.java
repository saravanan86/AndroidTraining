package platform.viacom.com.viacommediaapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;

import platform.viacom.com.viacommediaapp.model.FeedProperty;
import platform.viacom.com.viacommediaapp.model.FeedTypes;

/**
 * Created by kathires on 6/17/16.
 */

public class FeedViewAdapter extends RecyclerView.Adapter<FeedViewAdapter.FeedViewHolder> {

    private JSONObject mFeedObject ;
    private String mFeedName;
    private ArrayList<FeedProperty> mFeedValues;
    private Context context;
    private FeedViewHolder holderObject;
    private String propertyValue;
    private Hashtable<String,String> mgidValues = new Hashtable<String, String>();

    public FeedViewAdapter( ArrayList<FeedProperty> feedValues ){//String feedName, String feedValue

        try {

            mFeedValues = feedValues;
            //mFeedObject = new JSONObject(feedValue);
            //mFeedName = feedName;

        }catch (Exception e){

        }

    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from( context );
        FeedViewAdapter.FeedViewHolder viewHolder = new FeedViewAdapter.FeedViewHolder( inflater.inflate( R.layout.feed_items_fragment, parent, false ) );

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {

        holderObject = holder;
        String key = mFeedValues.get(position).getPropertyName();
        propertyValue = mFeedValues.get(position).getPropertyValue();
        holder.mPropertyNameText.setText( key );
        try {
            holder.mPropertyValueText.setText( new JSONObject(propertyValue).toString( 2 ));
        }catch( JSONException e){
            try {
                holder.mPropertyValueText.setText(new JSONArray(propertyValue).toString(2));
            }catch (JSONException ex ){
                holder.mPropertyValueText.setText( propertyValue);
            }
        }

        if( key.equals( "mgid" ) ){

            mgidValues.put( key, propertyValue );
            holder.mPropertyValueText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent( context.getApplicationContext(), DemoPlayerActivity.class );
                    intent.putExtra( DemoPlayerActivity.EXTRA_MGID_VALUE, mgidValues.get("mgid") );
                    context.startActivity( intent );

                }
            });

        } else if( key.equals( "platforms" ) ){
            try {

                JSONArray arr = new JSONArray( mFeedValues.get(position).getPropertyValue() ) ;
                String str="";
                for( int i=0; i < arr.length(); i++ ){

                    JSONObject jObj = (JSONObject) arr.get(i);
                    if( jObj.has( "platform" ) ){
                        str += "\r\nPlatform: " +(String)jObj.get( "platform" );
                    }
                    if( jObj.has( "contentLink" ) ) {
                        str += "\r\nContent Link: " + (String) jObj.get("contentLink");
                    }
                    if( jObj.has( "authRequired" ) ) {
                        str += "\r\nAuth Required: " + (String) jObj.get("authRequired");
                    }
                    if( jObj.has( "startDate" ) ) {
                        str += "\r\nStart Date: " + (String) jObj.get("startDate");
                    }
                    if( jObj.has( "endDate" ) ) {
                        str += "\r\nEnd Date: " + (String) jObj.get("endDate");
                    }
                    if( jObj.has( "name" ) ){
                        str += "\r\nName: " + (String) jObj.get("name");
                    }
                    if( jObj.has( "link" ) ){
                        str += "\r\nLink: " + (String) jObj.get("link");
                    }
                    str += "\r\n \r\n \r\n ";

                }

                holderObject.mPropertyValueText.setText( str );
            }catch( Exception e ){


            }

        }else if( key.equals( "images" ) || key.equals( "logos" ) || key.equals( "links" ) ){

            try {

                JSONArray arr = new JSONArray(mFeedValues.get(position).getPropertyValue());
                String str="";
                for( int i=0; i < arr.length(); i++ ){

                    JSONObject jObj = (JSONObject) arr.get(i);
                    if( jObj.has( "url" ) ){
                        str += "\r\nURL: " +(String)jObj.get( "url" );
                    }
                    if( jObj.has( "type" ) ) {
                        str += "\r\nType: " + (String) jObj.get("type");
                    }
                    if( jObj.has( "aspectRatio" ) ) {
                        str += "\r\nAspect Ratio: " + (String) jObj.get("aspectRatio");
                    }
                    if( jObj.has( "usage" ) ) {
                        str += "\r\nUsage: " + (String) jObj.get("usage");
                    }
                    if( jObj.has( "rel" ) ) {
                        str += "\r\nRel: " + (String) jObj.get("rel");
                    }
                    if( jObj.has( "href" ) ) {
                        str += "\r\nHREF: " + (String) jObj.get("href");
                    }
                    str += "\r\n \r\n \r\n ";

                }
                holderObject.mPropertyValueText.setText( str );

            }catch( Exception e ){

            }

        }


    }

    @Override
    public int getItemCount() {

        return mFeedValues.size();

    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder {

        public TextView mPropertyNameText;
        public TextView mPropertyValueText;
        public ImageView mImageView;

        public FeedViewHolder( View itemView ) {

            super( itemView );

            mPropertyNameText = (TextView) itemView.findViewById( R.id.propertyName );
            mPropertyValueText = (TextView) itemView.findViewById( R.id.propertyValue );
            mImageView = (ImageView) itemView.findViewById( R.id.image );

        }

    }

}
