package androidtutorial.example.com.criminalintent;

import android.app.Fragment;

/**
 * Created by kathires on 6/14/16.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        return new CrimeListFragment();

    }
}
