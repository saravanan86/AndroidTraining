package androidtutorial.example.com.androidtraining;

import android.content.Context;
//import android.support.test.
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentationTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public ExampleInstrumentationTest() {

        super( MainActivity.class );

    }

    @Before
    public void setUp() throws Exception {

        super.setUp();

        // Injecting the Instrumentation instance is required
        // for your test to run with AndroidJUnitRunner.
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    @Test
    public void typeOperandsAndPerformAddOperation() {
        // Call the CalculatorActivity add() method and pass in some operand values, then
        // check that the expected value is returned.
        //mActivity.findViewById( R.id.correct );
    }

    @Test
    public void testQuestionForNull(){

        TextView question = (TextView) mActivity.findViewById( R.id.question );
        assertNotNull( question );

    }

    /*@Test
    public void testQuestionForLayoutParams(){

        TextView question = (TextView) mActivity.findViewById( R.id.question );
        ViewGroup.LayoutParams params = question.getLayoutParams();
        assertEquals( params.height, ViewGroup.LayoutParams.WRAP_CONTENT );
        assertEquals( params.width, ViewGroup.LayoutParams.WRAP_CONTENT );

    }*/

    @UiThreadTest
    public void testButtonClick(){

        Button correct = (Button)mActivity.findViewById( R.id.correct );
        correct.performClick();

    }

    @Test
    public void testCorrectButtonForNull(){

        Button correct = (Button)mActivity.findViewById( R.id.correct );
        assertNotNull( correct );

    }



    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("androidtutorial.example.com.androidtraining", appContext.getPackageName());

    }

    @Override
    protected void tearDown() throws Exception {

        super.tearDown();

    }
}