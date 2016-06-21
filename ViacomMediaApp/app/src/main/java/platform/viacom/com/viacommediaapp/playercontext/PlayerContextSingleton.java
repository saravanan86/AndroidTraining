package platform.viacom.com.viacommediaapp.playercontext;

/**
 * Created by kathires on 6/20/16.
 */


//import com.vmn.android.freewheel.impl.FreewheelPlugin;

import com.vmn.android.bento.Bento;
import com.vmn.android.freewheel.impl.FreewheelPlugin;
import com.vmn.android.player.AndroidPlayerContext;
import com.vmn.android.player.controls.MediaControlsPlugin;
import com.vmn.android.player.plugin.captions.CaptionsPlugin;

import platform.viacom.com.viacommediaapp.DemoPlayerApplication;

public class PlayerContextSingleton {

    private static final PlayerContextSingleton instance = new PlayerContextSingleton();
    public static PlayerContextSingleton getInstance() { return instance; }

    private final AndroidPlayerContext androidPlayerContext = new AndroidPlayerContext(
            DemoPlayerApplication.getInstance(), "demoAdvertisingId");

    public AndroidPlayerContext getPlayerContext() { return androidPlayerContext; }

    private PlayerContextSingleton() {
        // Link all plugins that each player instance will use
        CaptionsPlugin.bindPlugin(androidPlayerContext);
        FreewheelPlugin.bindPlugin(androidPlayerContext, FreewheelPlugin.HandleClicks.APPLICATION, false);
        MediaControlsPlugin.bindPlugin(androidPlayerContext);
        Bento.setPlayerContext( androidPlayerContext );
    }

}