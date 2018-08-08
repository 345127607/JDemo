package jgg.com.jdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Pair
import android.view.View
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import jgg.com.jdemo.view.CustomLoadMoreView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    internal var data = ArrayList<Pair<Class<*>, String>>()
    init {
        data.add(Pair(MainActivity2::class.java, "测试页面"))
        data.add(Pair(ZfbHomeActivity::class.java, "仿支付宝首页滑动"))
        data.add(Pair(IndicatorActivity::class.java, "新款滑动"))
    }

    internal var isError = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linerLayoutManager = StaggeredGridLayoutManager(3, LinearLayout.VERTICAL)
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.custom_divider)!!)
        recyclerview.layoutManager = linerLayoutManager
        recyclerview.addItemDecoration(divider)
        val mainRecycAdapter = MainRecycAdapter(R.layout.recyc_item, data)
        mainRecycAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM)
        mainRecycAdapter.setOnItemClickListener { adapter, view, position -> startActivity(Intent(this@MainActivity, data[position].first)) }
        recyclerview.adapter = mainRecycAdapter
        mainRecycAdapter.setLoadMoreView(CustomLoadMoreView())
        mainRecycAdapter.setOnLoadMoreListener({
            if (isError) {
                isError = false
                recyclerview.postDelayed({ mainRecycAdapter.loadMoreEnd() }, 2000)
            } else {
                isError = true
                recyclerview.postDelayed({ mainRecycAdapter.loadMoreFail() }, 2000)
            }
        }, recyclerview)

    }

    class MainRecycAdapter : BaseQuickAdapter<Pair<Class<*>, String>, BaseViewHolder> {


        constructor(layoutResId: Int, data: List<Pair<Class<*>, String>>?) : super(layoutResId, data) {}

        constructor(data: List<Pair<Class<*>, String>>?) : super(data) {}

        constructor(layoutResId: Int) : super(layoutResId) {}

        override fun convert(helper: BaseViewHolder, item: Pair<Class<*>, String>) {
            helper.setText(R.id.item_name, item.second)
        }
    }

}
