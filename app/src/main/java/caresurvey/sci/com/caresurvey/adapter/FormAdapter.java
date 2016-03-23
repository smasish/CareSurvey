package caresurvey.sci.com.caresurvey.adapter;

/**
 * Created by israt.jahan on 3/7/2016.
 * @author israt.jahan
 */
public class FormAdapter {
    int formid;
    String formqdetails;
    String formqstatus;

    public FormAdapter(int formid, String formqdetails, String formqstatus) {
        this.formid = formid;
        this.formqdetails = formqdetails;
        this.formqstatus = formqstatus;
    }

    public int getFormid() {
        return formid;
    }

    public void setFormid(int formid) {
        this.formid = formid;
    }

    public String getFormqdetails() {
        return formqdetails;
    }

    public void setFormqdetails(String formqdetails) {
        this.formqdetails = formqdetails;
    }

    public String getFormqstatus() {
        return formqstatus;
    }

    public void setFormqstatus(String formqstatus) {
        this.formqstatus = formqstatus;
    }
}
