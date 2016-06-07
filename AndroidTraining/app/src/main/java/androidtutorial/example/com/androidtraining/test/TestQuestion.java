package androidtutorial.example.com.androidtraining.test;

/**
 * Created by kathires on 6/6/16.
 */

public class TestQuestion {

    private int mQuestion;
    private Boolean mAnswer = null;

    public TestQuestion( int mQuestion, Boolean mAnswer ){

         this.mQuestion = mQuestion;
         this.mAnswer = mAnswer;

    }

    public Boolean getAnswer() {

        return mAnswer;

    }

    public int getQuestion() {

        return mQuestion;

    }
}
