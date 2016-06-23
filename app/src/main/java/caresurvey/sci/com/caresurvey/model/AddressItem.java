package caresurvey.sci.com.caresurvey.model;

/**
 * Created by shantanu on 6/23/16.
 */

public class AddressItem {
    public int id;

    public AddressItem(int id, String nameEng, String name) {
        this.id = id;
        this.nameEng = nameEng;
        this.name = name;
    }

    public AddressItem(){}

    public String nameEng;
    public String name;
}
