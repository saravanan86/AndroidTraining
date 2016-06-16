package androidtutorial.example.com.criminalintent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

        return CrimeFragment.getNewInstance( (UUID) getIntent().getSerializableExtra( CrimeFragment.EXTRA_CRIME_ID ) );

    }

}
