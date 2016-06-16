package androidtutorial.example.com.criminalintent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kathires on 6/10/16.
 */

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mCrimeTitle;
    private Button mCrimeDate;
    private CheckBox mCrimeSolved;
    public static final String EXTRA_CRIME_ID = "crimeId";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID)getArguments().getSerializable( EXTRA_CRIME_ID );
        CrimeLab crimeLab = CrimeLab.getCrimeLab( getActivity() );
        mCrime = crimeLab.getCrime( crimeId );
        //Log.d("CrimeFragment", getActivity().getIntent().getSerializableExtra( EXTRA_CRIME_ID ).toString() );

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate( R.layout.fragment_crime, container, false );

        mCrimeTitle = (EditText) view.findViewById( R.id.crime_title );
        mCrimeTitle.setText( mCrime.getTitle() );
        mCrimeDate = (Button) view.findViewById( R.id.crime_date );
        mCrimeDate.setText( DateFormat.getLongDateFormat( this.getContext() ).format( mCrime.getCrimeDate() ) );
        mCrimeSolved = (CheckBox) view.findViewById( R.id.crime_solved );
        mCrimeSolved.setChecked( mCrime.isIsSolved() );
        //mCrimeDate.setText( DateFormat.getLongDateFormat( this.getContext() ).format( new Date() ) );


        mCrimeTitle.addTextChangedListener( new TextWatcher(){

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mCrime.setTitle( s.toString() );

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

        });

        mCrimeSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                mCrime.setIsSolved( isChecked );

            }
        });

        return view;

    }

    public static CrimeFragment getNewInstance(UUID crimeId){

        CrimeFragment crimeFragment = new CrimeFragment();
        Bundle args = new Bundle();
        args.putSerializable( EXTRA_CRIME_ID, crimeId );

        crimeFragment.setArguments( args );

        return crimeFragment;

    }
}
