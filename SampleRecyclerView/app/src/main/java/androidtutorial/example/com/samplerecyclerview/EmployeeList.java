package androidtutorial.example.com.samplerecyclerview;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kathires on 6/16/16.
 */

public class EmployeeList {

    private ArrayList<EmployeeInfo> mList;
    private static EmployeeList mEmployeeList = null;

    private EmployeeList(){

        mList = new ArrayList<EmployeeInfo>();

        mList.add( new EmployeeInfo( "Employee-A", "Developer", 26 ));
        mList.add( new EmployeeInfo( "Employee-B", "Developer", 28 ));
        mList.add( new EmployeeInfo( "Employee-C", "Programmer", 22 ));
        mList.add( new EmployeeInfo( "Employee-D", "Tester", 26 ));
        mList.add( new EmployeeInfo( "Employee-E", "Tester", 23 ));
        mList.add( new EmployeeInfo( "Employee-F", "Software Engineer", 32 ));
        mList.add( new EmployeeInfo( "Employee-G", "Software Engineer", 34 ));
        mList.add( new EmployeeInfo( "Employee-H", "Software Developer", 35 ));


    }

    public static EmployeeList getEmployeeListInstance(){

        if( mEmployeeList == null ){

            mEmployeeList = new EmployeeList();

        }

        return mEmployeeList;

    }

    public ArrayList getEmployeeList(){

        return mList;

    }

}
