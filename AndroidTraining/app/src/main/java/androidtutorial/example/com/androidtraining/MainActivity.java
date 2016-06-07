package androidtutorial.example.com.androidtraining;

import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private TestQuestion[] mTestQuestion;
    private TestQuestion mCurrentQuestion;
    private int mQuestionCounter = 0;

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
        mTestQuestion = new TestQuestion[]{

                new TestQuestion( R.string.q1, true ),
                new TestQuestion( R.string.q2, false ),
                new TestQuestion( R.string.q3, true ),
                new TestQuestion( R.string.q4, false ),
                new TestQuestion( R.string.q5, true ),
                new TestQuestion( R.string.q6, false ),
                new TestQuestion( R.string.q7, true ),
                new TestQuestion( R.string.q8, false ),
                new TestQuestion( R.string.q9, true ),
                new TestQuestion( R.string.q10, false )

        };

        mCurrentQuestion = mTestQuestion[ mQuestionCounter ];

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

    }

    private void showAnswer( boolean answer ){

        if( answer ){

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
