package jgg.com.jdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustmView5 extends View {
    public CustmView5(Context context) {
        super(context);
    }

    public CustmView5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustmView5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustmView5(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*
        扇形图表
         */
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(100,100,300,300,-90,90,true,paint);
        canvas.drawArc(100,100,310,310,0,90,true,paint);
        canvas.drawArc(100,100,300,300,90,90,true,paint);
        canvas.drawArc(90,90,300,300,180,90,true,paint);
    }
}
