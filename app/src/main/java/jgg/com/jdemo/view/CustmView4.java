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
public class CustmView4 extends View {
    public CustmView4(Context context) {
        super(context);
    }

    public CustmView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustmView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustmView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
        path.close();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         /*
        心形
         */
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path,paint);
    }
}
