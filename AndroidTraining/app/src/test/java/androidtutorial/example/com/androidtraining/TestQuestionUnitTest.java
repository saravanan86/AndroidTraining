package androidtutorial.example.com.androidtraining;

import org.junit.Test;

import androidtutorial.example.com.androidtraining.test.TestQuestion;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestQuestionUnitTest {

    @Test
    public void testQuestion_check() throws Exception {

        TestQuestion testQuestion = new TestQuestion( 0, true );
        assertEquals( 0, testQuestion.getQuestion() );
        assertEquals( true, testQuestion.getAnswer() );

    }
}