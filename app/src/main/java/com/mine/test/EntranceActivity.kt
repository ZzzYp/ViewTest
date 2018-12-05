package com.mine.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.mine.test.adapter.EARecAdapterInterface
import com.mine.test.adapter.EntranceActivityRecyclerviewAdapter
import com.mine.test.bean.EntrancePageBean
import kotlinx.android.synthetic.main.activity_entrance.*

class EntranceActivity : Activity(), EARecAdapterInterface {
    var contents: ArrayList<EntrancePageBean> = ArrayList()
    var entranceActivityRecyclerviewAdapter: EntranceActivityRecyclerviewAdapter = EntranceActivityRecyclerviewAdapter(this, contents, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)
        initListener()
        initData()
        initView()
    }


    private fun initListener() {

    }

    private fun initView() {
        var gridLayoutManager: GridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.setSpanSizeLookup(object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(postion: Int): Int {
                if (postion == 0) {
                    return 2
                } else {
                    return 1
                }
            }
        })

        recyclerview.layoutManager = gridLayoutManager
        recyclerview.adapter = entranceActivityRecyclerviewAdapter
        entranceActivityRecyclerviewAdapter.notifyDataSetChanged()

    }


    override fun viewClick(view: View?, position: Int) {
        when (position) {
            0 -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
            1 -> {
                startActivity(Intent(this, TabViewPageActivity::class.java))
            }
            2 -> {
                startActivity(Intent(this, ImmersionTestActivity::class.java))
            }
            3 -> {
                startActivity(Intent(this, PathViewActivity::class.java))
            }
            4 -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
            5 ->{
                startActivity(Intent(this, DataStructureTestActivity::class.java))
            }
            6 ->{
                startActivity(Intent(this, ServiceTestActivity::class.java))
            }
        }
    }


    private fun initData() {
        var entrancePageBeanToday: EntrancePageBean = EntrancePageBean()
        entrancePageBeanToday.title = "Today"
        entrancePageBeanToday.content = "Today"
        contents.add(entrancePageBeanToday)

        var entrancePageBeanPathView: EntrancePageBean = EntrancePageBean()
        entrancePageBeanPathView.title = "TabViewPageActivity"
        entrancePageBeanPathView.content = "自定义绘制Kotlin练习"
        contents.add(entrancePageBeanPathView)

        var entrancePageBeanOne: EntrancePageBean = EntrancePageBean()
        entrancePageBeanOne.title = "ImmersionTest"
        entrancePageBeanOne.content = "沉浸式状态栏颜色和背景图切换"
        contents.add(entrancePageBeanOne)

        var entrancePageBeanTwo: EntrancePageBean = EntrancePageBean()
        entrancePageBeanTwo.title = "PathView"
        entrancePageBeanTwo.content = "PathView"
        contents.add(entrancePageBeanTwo)

        var entrancePageBeanThree: EntrancePageBean = EntrancePageBean()
        entrancePageBeanThree.title = "MainActivity"
        entrancePageBeanThree.content = "MainActivity"
        contents.add(entrancePageBeanThree)

        var entrancePageBeanFour: EntrancePageBean = EntrancePageBean()
        entrancePageBeanFour.title = "DataStructureTestActivity"
        entrancePageBeanFour.content = "数据结构T"
        contents.add(entrancePageBeanFour)

        var entrancePageBeanFive: EntrancePageBean = EntrancePageBean()
        entrancePageBeanFive.title = "ServiceTestActivity"
        entrancePageBeanFive.content = "服务T"
        contents.add(entrancePageBeanFive)

        var entrancePageBeanSix: EntrancePageBean = EntrancePageBean()
        entrancePageBeanSix.title = "Seven"
        entrancePageBeanSix.content = "Seven"
        contents.add(entrancePageBeanSix)

        var entrancePageBeanSeven: EntrancePageBean = EntrancePageBean()
        entrancePageBeanSeven.title = "Eight "
        entrancePageBeanSeven.content = "Eight "
        contents.add(entrancePageBeanSeven)

    }

}
