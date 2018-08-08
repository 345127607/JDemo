package jgg.com.jdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import jgg.com.jdemo.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CustmView9 extends View {
    public CustmView9(Context context) {
        super(context);
    }

    public CustmView9(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustmView9(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustmView9(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    String[] text = {"此外你家那个老师离开都跟你说","的开始另可是你的快乐给你"};
    Paint paint =new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        /*
        文字加下划线
         */
        super.onDraw(canvas);
        paint.setTextSize(48);
        canvas.drawText(text[0],50,50,paint);
        float measure = paint.measureText(text[0]);
        canvas.drawLine(50, 50, 50 + measure, 50, paint);
        paint.setTypeface(Typeface.SERIF);
        paint.setFakeBoldText(true);//加粗
        paint.setStrikeThruText(true);//删除线
        paint.setUnderlineText(true);//下划线
        paint.setTextSkewX(0.5f);//倾斜
        paint.setTextScaleX(0.5f);//X轴变宽
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text[1], 50, 50 + paint.getFontSpacing(), paint);
    }
}
