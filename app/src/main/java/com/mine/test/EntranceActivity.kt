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
    var entranceActivityRecyclerviewAdapter: EntranceActivityRecyclerviewAdapter = EntranceActivityRecyclerviewAdapter(this, contents,this)

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
                startActivity(Intent(this, PathViewActivity::class.java))
            }
            2 -> {
                startActivity(Intent(this, ImmersionTestActivity::class.java))
            }
        }
    }


    private fun initData() {
        var entrancePageBeanToday: EntrancePageBean = EntrancePageBean()
        entrancePageBeanToday.title = "Today"
        entrancePageBeanToday.content = "Today"
        contents.add(entrancePageBeanToday)

        var entrancePageBeanPathView: EntrancePageBean = EntrancePageBean()
        entrancePageBeanPathView.title = "PathView"
        entrancePageBeanPathView.content = "PathView"
        contents.add(entrancePageBeanPathView)

        var entrancePageBeanOne: EntrancePageBean = EntrancePageBean()
        entrancePageBeanOne.title = "ImmersionTest"
        entrancePageBeanOne.content = "ImmersionTest"
        contents.add(entrancePageBeanOne)

        var entrancePageBeanTwo: EntrancePageBean = EntrancePageBean()
        entrancePageBeanTwo.title = "Two"
        entrancePageBeanTwo.content = "Two"
        contents.add(entrancePageBeanTwo)

        var entrancePageBeanThree: EntrancePageBean = EntrancePageBean()
        entrancePageBeanThree.title = "Three"
        entrancePageBeanThree.content = "Three"
        contents.add(entrancePageBeanThree)

        var entrancePageBeanFour: EntrancePageBean = EntrancePageBean()
        entrancePageBeanFour.title = "Four"
        entrancePageBeanFour.content = "Four"
        contents.add(entrancePageBeanFour)

        var entrancePageBeanFive: EntrancePageBean = EntrancePageBean()
        entrancePageBeanFive.title = "Five"
        entrancePageBeanFive.content = "Five"
        contents.add(entrancePageBeanFive)

        var entrancePageBeanSix: EntrancePageBean = EntrancePageBean()
        entrancePageBeanSix.title = "Six"
        entrancePageBeanSix.content = "Six"
        contents.add(entrancePageBeanSix)

        var entrancePageBeanSeven: EntrancePageBean = EntrancePageBean()
        entrancePageBeanSeven.title = "Seven"
        entrancePageBeanSeven.content = "Seven"
        contents.add(entrancePageBeanSeven)

    }

}
