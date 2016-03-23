package caresurvey.sci.com.caresurvey.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.database.FormTable;
import caresurvey.sci.com.caresurvey.model.FormItem;

public class TestActivity extends AppCompatActivity {


    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        tv1=(TextView)findViewById(R.id.first);
        tv2=(TextView)findViewById(R.id.second);
        tv3=(TextView)findViewById(R.id.third);


        ArrayList<FormItem> formItems;

        FormItem formItem;
        FormTable formTable = new FormTable(TestActivity.this);
        formItems= formTable.getAll();

        for(FormItem ft: formItems)

        {
            tv1.setText(""+ft.getDelivery());
            tv2.setText(""+ft.getFamilyplanning());
            tv3.setText(""+ft.getFolictablet());
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
