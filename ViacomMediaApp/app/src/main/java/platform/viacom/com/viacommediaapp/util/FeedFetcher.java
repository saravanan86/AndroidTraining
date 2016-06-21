package platform.viacom.com.viacommediaapp.util;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by kathires on 6/16/16.
 */

public class FeedFetcher extends AsyncTask<String,Integer,JSONObject> {

    public interface AsyncResponse{

        void processFinish( JSONObject result );

    }

    public AsyncResponse delegate = null;

    public FeedFetcher( AsyncResponse delegate ){

        this.delegate = delegate;

    }

    @Override
    protected JSONObject doInBackground(String... params) {

        HttpURLConnection connection = null;
        URL url;
        String responseStr = null;
        JSONObject jsonObject = null;

        try {

            url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
                //response.append('\r');
            }
            rd.close();
            responseStr = response.toString();
            jsonObject = new JSONObject(responseStr);
            Log.d( "JSONParser: ", responseStr );

        }catch (Exception e){
            Log.d( "JSONParser: ", "ERROR: "+e.toString() );
        }

        return jsonObject;
    }

    protected void onPostExecute(JSONObject result) {

        this.delegate.processFinish( result );

    }



}
