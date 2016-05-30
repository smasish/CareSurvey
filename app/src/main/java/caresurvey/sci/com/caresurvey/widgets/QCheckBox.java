package caresurvey.sci.com.caresurvey.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.widget.CheckBox;

/**
 * Created by shantanu on 5/30/16.
 */
public class QCheckBox extends AppCompatCheckBox {
    public QCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "BorakMJ.ttf");
        setTypeface(tf,Typeface.BOLD);
    }

    public QCheckBox(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "BorakMJ.ttf");
        setTypeface(tf,Typeface.BOLD);
    }
}
