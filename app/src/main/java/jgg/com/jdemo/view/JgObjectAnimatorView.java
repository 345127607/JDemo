package jgg.com.jdemo.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

import jgg.com.jdemo.utils.Utils;

public class JgObjectAnimatorView extends View {
    final float radius = Utils.dpToPixel(80);
    RectF arcRectF = new RectF();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    // TODO 为 progress 添加 getter 和 setter 方法（setter 方法记得加 invalidate()）
    float progress = 0;

    {
        paint.setTextSize(Utils.dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public JgObjectAnimatorView(Context context) {
        super(context);
    }

    public JgObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public JgObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(final float progresss) {
        progress = progresss;
        invalidate();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setPro(float progresss)
    {
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX",1);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY",1);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha",1);
        Keyframe keyframe1 = Keyframe.ofFloat(0,0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f,100);
        Keyframe keyframe3 = Keyframe.ofFloat(1,80);
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("progress",keyframe1,keyframe2,keyframe3);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 0, progresss);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(this, holder,holder1,holder2,holder3);
        animator.setDuration(1000);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.start();

       /* AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator).after(animator);*/
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(Utils.dpToPixel(15));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
    }
}