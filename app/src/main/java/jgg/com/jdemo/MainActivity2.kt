package jgg.com.jdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.transitionseverywhere.TransitionManager
import kotlinx.android.synthetic.main.activty_transition.*
import android.R.attr.visible
import android.animation.PropertyValuesHolder
import android.os.Handler
import android.view.Gravity
import android.view.View
import com.transitionseverywhere.Slide
import jgg.com.jdemo.utils.ACache


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_transition)
        var visible = false
        btn.setOnClickListener {
            TransitionManager.beginDelayedTransition(viewgroup,Slide(Gravity.RIGHT))
            visible = !visible
            content.visibility = if (visible) View.VISIBLE else View.GONE
        }
        ACache.get(this,"Main2").put("name","")
        val asString = ACache.get(this, "Main2").getAsString("name")
    }
}