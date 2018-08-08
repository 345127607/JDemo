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

public class CustmView2 extends View {
    public CustmView2(Context context) {
        super(context);
    }

    public CustmView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustmView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustmView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        path.addCircle(200,50,50, Path.Direction.CW);
        path.addCircle(300,50,50, Path.Direction.CW);
        path.addCircle(200,150,50, Path.Direction.CW);
        path.addCircle(300,150,50, Path.Direction.CW);
        canvas.drawPath(path,paint);
    }
}
