package jgg.com.jdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import jgg.com.jdemo.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustmView7 extends View {
    public CustmView7(Context context) {
        super(context);
    }

    public CustmView7(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustmView7(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustmView7(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         /*
        圆形图片
         */
        paint.setStyle(Paint.Style.FILL);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(200,200,150,paint);
    }
}
