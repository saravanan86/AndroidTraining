package androidtutorial.example.com.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by kathires on 6/14/16.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab = null;
    private Context mApplicationContext = null;
    private ArrayList<Crime> mCrimes = null;

    private CrimeLab( Context appContext ){

        mApplicationContext = appContext;
        mCrimes = new ArrayList<Crime>();

        for( int i = 0; i < 100; i++ ){

            Crime c = new Crime();
            c.setTitle( "Crime #"+i );
            c.setIsSolved( i % 2 == 0 );
            mCrimes.add(c);
        }

    }

    public static CrimeLab getCrimeLab( Context appContext ){

        if( sCrimeLab == null ){

            sCrimeLab = new CrimeLab( appContext.getApplicationContext() );

        }

        return sCrimeLab;

    }
    
    public ArrayList<Crime> getCrimes(){
        
        return mCrimes;
        
    }
    
    public Crime getCrime( UUID id ){

        for ( Crime c : mCrimes ){

            if( c.getId().equals( id ) ){

                return c;

            }

        }
        return null;
        
    }

}
