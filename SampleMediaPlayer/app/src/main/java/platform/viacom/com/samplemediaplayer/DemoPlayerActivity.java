package platform.viacom.com.samplemediaplayer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vmn.android.player.AndroidPlayerContext;
import com.vmn.android.player.VMNVideoPlayerImpl;
import com.vmn.android.player.model.MGID;
import com.vmn.android.player.model.VMNContentSession;
import com.vmn.android.player.view.VideoSurfaceView;
import com.vmn.functional.Optional;

import butterknife.Bind;
import butterknife.ButterKnife;
import platform.viacom.com.samplemediaplayer.playercontext.PlayerContextSingleton;

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

        session = playerContext.buildSession(MGID.make("mgid:uma:video:mtv.com:813210"), "MTV_App_Android", false).authRequired(isLocked).build();

        videoPlayer.clear();
        videoPlayer.enqueue(playerContext.prepareSession(session));

        /*Button loadVideo = (Button) findViewById(R.id.load_video);
        loadVideo.setOnClickListener(onLoad);

        lockVideo = (Button) findViewById(R.id.locked_btn);
        lockVideo.setOnClickListener(onLock);

        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(onBack);*/

    }
}
