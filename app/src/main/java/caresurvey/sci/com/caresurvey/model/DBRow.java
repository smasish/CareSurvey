package caresurvey.sci.com.caresurvey.model;

/**
 * Created by shantanu on 5/27/16.
 */
public class DBRow {
    public int status;
    public int patientid;
    public String subdistrict;
    public String union;
    public String village;
    public String upozila;
    public String name;
    public String collector_name;
    public String division;
    public String timepick;
    public String datepick;
    public String facility;
    public String obs_type;

    public static final String KEY_NAME = "_names"; // 1 - text
    public static final String KEY_DATE_PICK= "_datepick";
    public static final String KEY_TIME_PICK= "_timepick";
    public static final String KEY_COLLECTOR_NAME= "_collectorname";
    public static final String KEY_DIVISION = "_division";
    public static final String KEY_UPOZILA= "_upozila";
    public static final String KEY_UNION= "_union";
    public static final String KEY_VILLAGE= "_village";
    public static final String KEY_OBSTYPE= "_obstype";

}
