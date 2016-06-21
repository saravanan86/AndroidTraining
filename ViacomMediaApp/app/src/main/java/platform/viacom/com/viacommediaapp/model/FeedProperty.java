package platform.viacom.com.viacommediaapp.model;

/**
 * Created by kathires on 6/17/16.
 */

public class FeedProperty {

    private String mPropertyName;
    private String mPropertyValue;

    public FeedProperty( String name, String value ){

        mPropertyName = name;
        mPropertyValue = value;

    }

    public String getPropertyName() {
        return mPropertyName;
    }

    public String getPropertyValue() {
        return mPropertyValue;
    }
}
