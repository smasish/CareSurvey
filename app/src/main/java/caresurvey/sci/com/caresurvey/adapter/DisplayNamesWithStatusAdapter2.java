package caresurvey.sci.com.caresurvey.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import caresurvey.sci.com.caresurvey.R;
import caresurvey.sci.com.caresurvey.model.DBRow;

/**
 * Created by shantanu on 5/27/16.
 */
public class DisplayNamesWithStatusAdapter2 extends ArrayAdapter<DBRow>{
    int resource;
    LayoutInflater inflater;
    public DisplayNamesWithStatusAdapter2(Context context, int resource,List<DBRow> items) {
        super(context, resource,items);
        this.resource = resource;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public DisplayNamesWithStatusAdapter2(Context context, int resource) {
        super(context, resource);
        this.resource = resource;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private class ViewHolder {
        TextView id;
        TextView  name;
        Button status;
        Button button1;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null)
        {
            convertView = inflater.inflate(resource, null);
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

        holder.id.setText("" +getItem(position).id);
        if(TextUtils.isEmpty(getItem(position).name)){
            holder.name.setText(""+getItem(position).collector_name);
        }
        else {
            holder.name.setText("" + getItem(position).name);
        }
//
//        button=(Button) convertView.findViewById(R.id.button2);
//
//
//        if(inS[position].equals(""))
//            button.setText("Not Reviewed");
//        else if(inS[position].equals("1"))
//            button.setText("Inserted");
//        else if(inS[position].equals("2"))
//            button.setText("Submitted");
//        else if(inS[position].equals("3")) {
//            button.setText("Blanked");
//            button.setBackgroundColor(Color.GRAY);
//        }
//        else
//            button.setText("Not Reviewed");



        if(getItem(position).status==1)
        {
            holder.status.setText("Accepted");
            holder.status.setBackgroundColor(Color.GREEN);
            //  holder.status.setBackground(R.color.light_green);
        }

        else if(getItem(position).status==2) {
            holder.status.setText("Reverted");
            holder.status.setBackgroundColor(Color.RED);
        }
        else if(getItem(position).status==3)
        {
            holder.status.setText("Pending");
            holder.status.setBackgroundColor(Color.MAGENTA);

        }

        else if(getItem(position).status==4) {
            holder.status.setText("Resubmitted");
            holder.status.setBackgroundColor(Color.BLUE);

        }

        else if(getItem(position).status==5) {
            holder.status.setText("Blanked");
            holder.status.setBackgroundColor(Color.GRAY);

        }

        else if(getItem(position).status==6) {
            holder.status.setText("Completed");
            holder.status.setBackgroundColor(Color.GRAY);

        }


        return convertView;
    }
}
