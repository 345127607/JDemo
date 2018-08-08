package jgg.com.jdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import jgg.com.jdemo.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustmView8 extends View {
    public CustmView8(Context context) {
        super(context);
    }

    public CustmView8(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustmView8(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustmView8(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    Paint paint =new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        /*
        模糊图片效果
         */
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test1);
        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));

        canvas.drawBitmap(bitmap,100,100,paint);
    }
}
