package caresurvey.sci.com.caresurvey.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import caresurvey.sci.com.caresurvey.R;


/**
 * Created by Mazharul.Islam1 on 2/18/2016.
 */
public class DisplayNamesWithStatusAdapter extends BaseAdapter
{
    Activity context;
    int id[];
    String name[];
    int status[];
    String inS[];
    Button button;



    public DisplayNamesWithStatusAdapter(Activity context, int[] id,String[] name,int[] status, String[] inS) {
        super();
        this.context = context;
        this.id = id;
        this.name = name;
        this.status = status;
        this.inS =inS;


    }

    public int getCount() {
        // TODO Auto-generated method stub
        return id.length;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    private class ViewHolder {
        TextView id;
        TextView  name;
        Button status;
        Button button1;


    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.display_an_item, null);
            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.id);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.status = (Button) convertView.findViewById(R.id.status);


            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }





        holder.id.setText("" +id[position]);
        holder.name.setText("" + name[position]);

        button=(Button) convertView.findViewById(R.id.button2);


        if(inS[position].equals(""))
            button.setText("Not Reviewed");
        else if(inS[position].equals("1"))
            button.setText("Inserted");
        else if(inS[position].equals("2"))
            button.setText("Submitted");
        else if(inS[position].equals("3"))
            button.setText("Not");
        else
            button.setText("Not Reviewed");



        if(status[position]==1)
        {
            holder.status.setText("Accepted");
            holder.status.setBackgroundColor(Color.GREEN);
            //  holder.status.setBackground(R.color.light_green);
        }

        else if(status[position]==2) {
            holder.status.setText("Reverted");
            holder.status.setBackgroundColor(Color.RED);
        }
        else if(status[position]==3)
        {
            holder.status.setText("Pending");
            holder.status.setBackgroundColor(Color.YELLOW);
        }

        else if(status[position]==4) {
            holder.status.setText("Submit Now");
            holder.status.setBackgroundColor(Color.BLACK);

        }


        return convertView;
    }

}
