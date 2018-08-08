package jgg.com.jdemo.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class XiaoMiRing extends View {
    public XiaoMiRing(Context context) {
        super(context);
    }

    public XiaoMiRing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XiaoMiRing(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public XiaoMiRing(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Path path1 = new Path();
    Path path2 = new Path();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        paint.setPathEffect(null);
        RectF rect = new RectF(100,100,900,900);
        path1.addArc(rect,-90,270);
        canvas.drawPath(path1,paint);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{2,5},0);
        paint.setStrokeWidth(15);
        paint.setPathEffect(dashPathEffect);
        path2.addArc(rect,180,90);
        canvas.drawPath(path2,paint);
    }
}
