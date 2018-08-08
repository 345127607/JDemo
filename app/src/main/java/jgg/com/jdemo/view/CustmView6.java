package jgg.com.jdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustmView6 extends View {
    public CustmView6(Context context) {
        super(context);
    }

    public CustmView6(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustmView6(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustmView6(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
          /*
        渐变
         */
        paint.setStyle(Paint.Style.FILL);
        Shader shader = new LinearGradient(0,0,300,300, Color.parseColor("#E91E63")
                , Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(150,150,150,paint);
    }
}
