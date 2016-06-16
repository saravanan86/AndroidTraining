package androidtutorial.example.com.androidtraining;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {


    private static final String FAKE_STRING = "HELLO WORLD";

    @Mock
    Context mMockContext;
    Activity mMockActivity;

    /*@Test
    public void readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        when(mMockContext.getString(R.string.nextTxt))
                .thenReturn(FAKE_STRING);
        MainActivity mainActivity = new MainActivity();

        // ...when the string is returned from the object under test...
        String result = myObjectUnderTest.getHelloWorldString();

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }*/

    @Test
    public void testForNextButtonText(){

        when( mMockActivity.findViewById( R.id.next ))
                .thenReturn( Button.class );

    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

}