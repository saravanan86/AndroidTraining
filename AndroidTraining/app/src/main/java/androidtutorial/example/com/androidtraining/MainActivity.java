package androidtutorial.example.com.androidtraining;

import android.content.Intent;
import android.os.PersistableBundle;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidtutorial.example.com.androidtraining.test.TestQuestion;

public class MainActivity extends AppCompatActivity {

    private TextView mQuestion;
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private Button mCheatButton;
    private TestQuestion[] mTestQuestion;
    private TestQuestion mCurrentQuestion;
    private int mQuestionCounter = 0;
    private static String SAVED_QUESTION_KEY = "prevQuestion";
    private static String SAVED_QUESTION_CHEATED = "prevQuestionCheated";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = (TextView)findViewById( R.id.question );
        mTrueButton = (Button)findViewById( R.id.correct );
        mFalseButton = (Button)findViewById( R.id.wrong );
        mNextButton = (ImageButton) findViewById( R.id.next );
        mPrevButton = (ImageButton)findViewById( R.id.prev );
        mNextButton.setImageResource( android.R.drawable.ic_media_next );
        mPrevButton.setImageResource( android.R.drawable.ic_media_previous );
        mCheatButton = (Button) findViewById( R.id.cheatBtn );
        mTestQuestion = new TestQuestion[]{

                new TestQuestion( R.string.q1, true, 0 ),
                new TestQuestion( R.string.q2, false, 1 ),
                new TestQuestion( R.string.q3, true, 2 ),
                new TestQuestion( R.string.q4, false, 3 ),
                new TestQuestion( R.string.q5, true, 4 ),
                new TestQuestion( R.string.q6, false, 5 ),
                new TestQuestion( R.string.q7, true, 6 ),
                new TestQuestion( R.string.q8, false, 7 ),
                new TestQuestion( R.string.q9, true, 8 ),
                new TestQuestion( R.string.q10, false, 9 )

        };

        if( savedInstanceState != null ){

            mQuestionCounter = savedInstanceState.getInt( SAVED_QUESTION_KEY );
            mCurrentQuestion = mTestQuestion[ mQuestionCounter ];
            mCurrentQuestion.setIsCheated( savedInstanceState.getBoolean( SAVED_QUESTION_CHEATED ) );

        }else{

            mCurrentQuestion = mTestQuestion[ mQuestionCounter ];
        }

        mQuestion.setText( mCurrentQuestion.getQuestion() );

        mTrueButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showAnswer( mCurrentQuestion.getAnswer() == true );

            }

        });

        mFalseButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showAnswer( mCurrentQuestion.getAnswer() == false );

            }

        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setPrevQuestion();

            }

        });

        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setNextQuestion();

            }

        });

        mQuestion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setNextQuestion();

            }

        });

        mCheatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent( MainActivity.this, CheatActivity.class );
                intent.putExtra( CheatActivity.EXTRA_IS_ANSWER_TRUE, mCurrentQuestion.getAnswer() );
                //startActivity( intent );
                startActivityForResult( intent, 0 );

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.d( "MainActivity:", requestCode+"==="+resultCode );
        if( data != null ){

            //mIsCheated = data.getBooleanExtra( CheatActivity.EXTRA_SHOWN_ANSWER, false );
            mCurrentQuestion.setIsCheated( data.getBooleanExtra( CheatActivity.EXTRA_SHOWN_ANSWER, false ) );

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt( SAVED_QUESTION_KEY, mCurrentQuestion.getQuestionIndex() );
        outState.putBoolean( SAVED_QUESTION_CHEATED, mCurrentQuestion.getIsCheated() );

    }

    private void showAnswer(boolean answer ){

        if( mCurrentQuestion.getIsCheated() ){

            Toast.makeText( MainActivity.this, R.string.cheatTxt, Toast.LENGTH_SHORT ).show();

        } else if( answer ){

            Toast.makeText( MainActivity.this, R.string.rightTxt, Toast.LENGTH_SHORT ).show();

        } else {

            Toast.makeText( MainActivity.this, R.string.wrongTxt, Toast.LENGTH_SHORT ).show();

        }

    }

    private void setNextQuestion(){

        mQuestionCounter = mQuestionCounter + 1;
        if( mQuestionCounter >= mTestQuestion.length ) {

            mQuestionCounter = 0;

        }

        mCurrentQuestion = mTestQuestion[ mQuestionCounter ];
        mQuestion.setText( mCurrentQuestion.getQuestion() );

    }

    private void setPrevQuestion(){

        mQuestionCounter = mQuestionCounter - 1;
        if( mQuestionCounter <= 0 ) {

            mQuestionCounter = 0;

        }

        mCurrentQuestion = mTestQuestion[ mQuestionCounter ];
        mQuestion.setText( mCurrentQuestion.getQuestion() );

    }

}
