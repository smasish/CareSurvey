package caresurvey.sci.com.caresurvey.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import caresurvey.sci.com.caresurvey.R;
import utils.InternetConnection;
import utils.SharedPreferenceHelper;
import utils.Utils;


/**
 * Created by Dinesh on 4/19/2015.
 * @author israt.jahan
 */
public class LoginActivity extends ActionBarActivity implements View.OnClickListener {

    Context context;
    static InternetConnection internetConnection;
    static Boolean isConected = false;
    TextView txt_create_account,forgetpass,logwith,homescreen;
    Button btn_twitter, btn_login, btn_facebook;
    EditText etx_email, etx_password;


    /* Any number for uniquely distinguish your request */
    public static final int WEBVIEW_REQUEST_CODE = 100;

    private ProgressDialog pDialog;



    private static SharedPreferences mSharedPreferences;


    private String consumerKey = null;
    private String consumerSecret = null;
    private String callbackUrl = null;
    private String oAuthVerifier = null;

    static String json = "";


    private boolean flag = false;
    private static ProgressDialog pd;
    String email="",pass="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_login);
        context = this;
        initWidget();
        flag = false;




    }

    private void initWidget(){


        homescreen = (TextView)findViewById(R.id.homescreen_id);


        etx_email = (EditText)findViewById(R.id.etx_email);
        etx_password = (EditText)findViewById(R.id.etx_password);



        txt_create_account = (TextView)findViewById(R.id.create_account);

        txt_create_account.setOnClickListener(this);

        forgetpass = (TextView)findViewById(R.id.forget_password);

        forgetpass.setOnClickListener(this);


        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);








//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.create_account:
                // startActivity(new Intent(context, RegistrationActivity.class));
                //overridePendingTransition(0,0);
                // finish();
                break;
            case R.id.forget_password:
                // startActivity(new Intent(context, ForgetPassActivity.class));
                //overridePendingTransition(0,0);
                // finish();
                break;


            case R.id.btn_login:

                internetConnection = new InternetConnection(context);
                isConected = internetConnection.isConnectingToInternet();
                if(isConected){
                    flag = false;
                    // makeHttpRequest();

                    pd = ProgressDialog.show(context, "Login", "Checking username and password.", true, true);

                    email = etx_email.getText().toString();
                    pass = etx_password.getText().toString();
                    new SendOperation().execute("");


                }else{
                    Utils.AlertDialog(LoginActivity.this);
                    return;
                }
                break;



            default:
                return;
        }
    }




    private class SendOperation extends AsyncTask<String, Void, String> {
        String url = "";

        @Override
        protected String doInBackground(String... params) {


            pd.dismiss();


            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            if (flag) {
                Toast.makeText(context, "Successfully logged in", Toast.LENGTH_LONG).show();
                SharedPreferenceHelper.setUser(context, "save");
                // startActivity(new Intent(context, MainActivity.class));
                overridePendingTransition(0,0);
                finish();
                LoginActivity.this.finish();
                Log.d("---//-- ", "finish");
            } else {
                Toast.makeText(context, "Failed to login.Please try again.", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(context, MainActivity.class));
//                overridePendingTransition(0,0);
                // finish();
            }


        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

    private void makeHttpRequest() {


    }




}
