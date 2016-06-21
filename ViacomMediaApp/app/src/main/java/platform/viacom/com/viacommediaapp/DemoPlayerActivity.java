package platform.viacom.com.viacommediaapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vmn.android.bento.logging.Logger;
import com.vmn.android.player.AndroidPlayerContext;
import com.vmn.android.player.VMNVideoPlayerImpl;
import com.vmn.android.player.model.MGID;
import com.vmn.android.player.model.VMNContentSession;
import com.vmn.android.player.view.VideoSurfaceView;
import com.vmn.functional.Optional;

import platform.viacom.com.viacommediaapp.playercontext.PlayerContextSingleton;

/**
 * Created by kathires on 6/20/16.
 */

public class DemoPlayerActivity extends Activity {

    public static final String PLAYER_SESSION_KEY = "playerSession";

    VMNContentSession session = null;

    @NonNull
    private AndroidPlayerContext playerContext;
    @NonNull private VMNVideoPlayerImpl videoPlayer;
    @NonNull private PlayerContextSingleton singleton;
    private boolean isLocked;
    private Button lockVideo;
    private Button backButton;
    private Activity activity;
    public static String EXTRA_MGID_VALUE = "mgid:uma:video:mtv.com:813210";

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.video_player_view);
        //setUpUI();
        activity = this;

        VideoSurfaceView videoPlayerView = (VideoSurfaceView) findViewById(R.id.video_player);

        // Get an instance to the app-singleton player context instance
        this.singleton = PlayerContextSingleton.getInstance();
        playerContext = singleton.getPlayerContext();

        videoPlayer = playerContext.buildPlayer().autoPlay(false)
                .offScreenRender(false).responseLooper(Looper.getMainLooper()).build();

        //Optional.of(findViewById(R.id.video_player)
        videoPlayer.setView(Optional.<View>of(videoPlayerView));

        String mgid = (String)getIntent().getSerializableExtra( EXTRA_MGID_VALUE );
        Log.d( "DemoPlayerActivity: ", mgid );
        //mgid = "mgid:uma:video:mtv.com:813210";

        if (savedInstanceState != null) session = (VMNContentSession) savedInstanceState.getSerializable(PLAYER_SESSION_KEY);
        if (session == null) session = (VMNContentSession)getIntent().getSerializableExtra(PLAYER_SESSION_KEY);
        if (session == null) {
            session = playerContext.buildSession(MGID.make(mgid), getAppName(mgid), false).authRequired(isLocked).build();
        }

        videoPlayer.clear();
        videoPlayer.enqueue(playerContext.prepareSession(session));

        /*Button loadVideo = (Button) findViewById(R.id.load_video);
        loadVideo.setOnClickListener(onLoad);

        lockVideo = (Button) findViewById(R.id.locked_btn);
        lockVideo.setOnClickListener(onLock);

        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(onBack);*/

    }

    private String getAppName( String mgidString ){

        String appName = "";

        if(mgidString.contains("mtv")){

            appName = "MTV_App_Android";

        } else if(mgidString.contains("spike")){

            appName = "Spike_TVE_App_Android";

        } else if(mgidString.contains("comedycentral")){

            appName = "CC_TVE_App_Android_App";

        } else if(mgidString.contains("nickjr")){

            appName = "CasNickJrApp_Staging";

        } else if(mgidString.contains("nick.com")){

            appName = "Nick_App_Android_Phone";

        } else if(mgidString.contains("vh1")){

            appName = "VH1_App_Android";

        } else {

            //default
            appName = "MTV_App_Android";

        }

        return appName;

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        final Optional<VMNContentSession> state = videoPlayer.getPlaybackState();
        if (state.isPresent()) outState.putSerializable(PLAYER_SESSION_KEY, state.get());
    }
}
