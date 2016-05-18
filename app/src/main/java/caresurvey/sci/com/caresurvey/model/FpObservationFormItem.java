package caresurvey.sci.com.caresurvey.model;

import caresurvey.sci.com.caresurvey.database.DatabaseHelper;

/**
 * Created by Shahin on 5/6/2016.
 */
public class FpObservationFormItem {
    private static final String TABLE_NAME = DatabaseHelper.FORM_FP_OBSERVATION;
    private static final String KEY_FP_OBSERVATION_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANS = "answer";

    private String status;
    private String sp_client;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSp_client() {
        return sp_client;
    }

    public void setSp_client(String sp_client) {
        this.sp_client = sp_client;
    }

}
