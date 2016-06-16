package androidtutorial.example.com.criminalintent;

import android.app.ListFragment;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kathires on 6/14/16.
 */

public class CrimeListFragment extends ListFragment {

    private final String TAG = "CrimeListFragment: ";
    private CrimeLab mCrimeLab = null;
    private ArrayList<Crime> mCrimes = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActivity().setTitle( R.string.crimes_title );
        mCrimeLab = CrimeLab.getCrimeLab( getActivity() );
        mCrimes = mCrimeLab.getCrimes();

        CrimeAdapter adapter = new CrimeAdapter( mCrimes );

        setListAdapter( adapter );

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);
        Crime crime = ((CrimeAdapter) getListAdapter()).getItem( position ) ;
        Log.d( TAG, crime.getTitle()+" was clicked." );
        Intent intent = new Intent( getActivity(), CrimeActivity.class );
        intent.putExtra( CrimeFragment.EXTRA_CRIME_ID, crime.getId() );
        startActivity( intent );

    }

    @Override
    public void onResume() {

        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();

    }

    private class CrimeAdapter extends ArrayAdapter<Crime>{

        public CrimeAdapter( ArrayList<Crime> crimes ){

            super( getActivity(), 0, crimes );

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if( convertView == null ){

                convertView = getActivity().getLayoutInflater().inflate( R.layout.list_item_crime, null );

            }

            Crime crime = getItem( position );

            TextView mTextView = (TextView)convertView.findViewById( R.id.textView );
            mTextView.setText( crime.getTitle() );

            TextView mTextView2 = (TextView)convertView.findViewById( R.id.textView2 );
            mTextView2.setText( crime.getCrimeDate().toString() );

            CheckBox mCheckBox = (CheckBox)convertView.findViewById( R.id.checkBox );
            mCheckBox.setChecked( crime.isIsSolved() );

            return convertView;

        }


    }
}
