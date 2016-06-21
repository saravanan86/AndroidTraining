package platform.viacom.com.viacommediaapp;

/**
 * Created by kathires on 6/20/16.
 */

import android.app.Application;

import com.vmn.android.bento.Bento;


public class DemoPlayerApplication extends Application {

    private static DemoPlayerApplication instance;

    @Override
    public void onCreate() {

        super.onCreate();
        Bento.init( getApplicationContext() );
        instance = this;
    }

    public static DemoPlayerApplication getInstance(){

        if (instance == null) throw new IllegalStateException("Tried to reference Application object before it was created");
        return instance;

    }

}