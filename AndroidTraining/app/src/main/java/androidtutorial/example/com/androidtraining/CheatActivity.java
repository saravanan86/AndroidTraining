package androidtutorial.example.com.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by kathires on 6/9/16.
 */

public class CheatActivity extends Activity {

    private Button mShowBtn;
    private Boolean mAnswer;
    public static String EXTRA_IS_ANSWER_TRUE = "androidtutorial.example.com.androidtraining.CheatActivtiy.isAnswerTrue";
    public static String EXTRA_SHOWN_ANSWER = "androidtutorial.example.com.androidtraining.CheatActivtiy.isAnswerShown";

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswer = getIntent().getBooleanExtra( EXTRA_IS_ANSWER_TRUE, false );

        mShowBtn = (Button) findViewById( R.id.cheatButton );

        mShowBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra( EXTRA_SHOWN_ANSWER, true );
                setResult( RESULT_OK, intent );
                Toast.makeText( CheatActivity.this, String.format( getString(R.string.answer), mAnswer.toString() ) , Toast.LENGTH_SHORT ).show();

            }

        });


    }

}
