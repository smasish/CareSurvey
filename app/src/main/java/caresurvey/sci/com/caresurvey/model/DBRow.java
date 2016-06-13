package caresurvey.sci.com.caresurvey.model;

/**
 * Created by shantanu on 5/27/16.
 */
public class DBRow {

    public String form_type;

    public DBRow(){
        id = 0;
    }
    public int status;
    public long id;
    public String subdistrict;
    public String union;
    public String village;
    public String upozila;
    public String name;
    public String designation;
    public String collector_name;
    public String division;
    public String timepick;
    public String datepick;
    public String facility;
    public String obs_type;
    public String district;

    //for supervisor
    public String user_id;
    public String meta;
    public String submittedBy;
    public String comments;
    public String fields;

    public static final String KEY_NAME = "_names"; // 1 - text
    public static final String KEY_DATE_PICK= "_datepick";
    public static final String KEY_TIME_PICK= "_timepick";
    public static final String KEY_COLLECTOR_NAME= "_collectorname";
    public static final String KEY_DIVISION = "_division";
    public static final String KEY_UPOZILA= "_upozila";
    public static final String KEY_UNION= "_union";
    public static final String KEY_VILLAGE= "_village";
    public static final String KEY_OBSTYPE= "_obstype";
    public static final String KEY_FACILITY = "_facility";
    public static final String KEY_STATUS = "_status";
    public static final String KEY_FACI_ID = "_facilityid";

    public int facilityID;
}
