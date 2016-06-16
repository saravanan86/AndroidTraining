package androidtutorial.example.com.androidtraining.test;

/**
 * Created by kathires on 6/6/16.
 */

public class TestQuestion {

    private int mQuestion;
    private int mQuestionIndex = 0;
    private Boolean mAnswer = null;
    private Boolean mIsCheated = false;

    public TestQuestion( int mQuestion, Boolean mAnswer, int mQuestionIndex ){

         this.mQuestion = mQuestion;
         this.mAnswer = mAnswer;
         this.mQuestionIndex = mQuestionIndex;

    }

    public Boolean getAnswer() {

        return mAnswer;

    }

    public int getQuestion() {

        return mQuestion;

    }

    public void setIsCheated( boolean flag ){

        mIsCheated = flag;

    }

    public boolean getIsCheated(){

        return mIsCheated;

    }

    public int getQuestionIndex(){

        return mQuestionIndex;

    }
}
