package androidtutorial.example.com.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kathires on 6/10/16.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mCrimeDate;
    private boolean mIsSolved;

    public Crime(){

        mId = UUID.randomUUID();
        mCrimeDate = new Date();

    }

    public UUID getId() {

        return mId;

    }

    public String getTitle() {

        return mTitle;

    }

    public void setTitle(String mTitle) {

        this.mTitle = mTitle;

    }

    public Date getCrimeDate() {

        return mCrimeDate;

    }

    public void setCrimeDate(Date mCrimeDate) {

        this.mCrimeDate = mCrimeDate;

    }

    public boolean isIsSolved() {

        return mIsSolved;

    }

    public void setIsSolved(boolean mIsSolved) {

        this.mIsSolved = mIsSolved;

    }

    @Override
    public String toString() {

        return mTitle;

    }
}
