package platform.viacom.com.samplemediaplayer;

/**
 * Created by kathires on 6/20/16.
 */

import android.app.Application;


public class DemoPlayerApplication extends Application {

    private static DemoPlayerApplication instance;

    @Override
    public void onCreate() {

        super.onCreate();

        instance = this;
    }

    public static DemoPlayerApplication getInstance(){

        if (instance == null) throw new IllegalStateException("Tried to reference Application object before it was created");
        return instance;

    }

}