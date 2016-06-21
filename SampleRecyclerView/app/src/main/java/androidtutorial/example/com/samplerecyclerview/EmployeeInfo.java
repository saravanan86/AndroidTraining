package androidtutorial.example.com.samplerecyclerview;

/**
 * Created by kathires on 6/16/16.
 */

public class EmployeeInfo {

    private String mName;
    private String mRole;
    private int mAge;

    public EmployeeInfo(String name, String role, int age ){

        mName = name;
        mRole = role;
        mAge = age;

    }

    public String getName() {
        return mName;
    }

    public String getRole() {
        return mRole;
    }

    public int getAge() {
        return mAge;
    }
}
