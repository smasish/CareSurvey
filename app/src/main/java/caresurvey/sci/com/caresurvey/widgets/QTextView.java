package caresurvey.sci.com.caresurvey.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by shantanu on 5/25/16.
 */
public class QTextView extends TextView{
    public QTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "BorakMJ.ttf");
        setTypeface(tf,Typeface.BOLD);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
    }
    public QTextView(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "BorakMJ.ttf");
        setTypeface(tf,Typeface.BOLD);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
    }
}
