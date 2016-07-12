package caresurvey.sci.com.caresurvey.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by shantanu on 7/12/16.
 */

public class QRadioButton extends AppCompatRadioButton{
    public QRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "BorakMJ.ttf");
        setTypeface(tf,Typeface.BOLD);
    }

    public QRadioButton(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "BorakMJ.ttf");
        setTypeface(tf,Typeface.BOLD);
    }
}
