package com.mine.test.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.mine.test.R
import com.mine.test.fraagment.fragmentAdapter.MineFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_viewpage.*
import kotlinx.android.synthetic.main.content_tab_view_page.*

class TabViewPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_viewpage)
        setSupportActionBar(toolbar)

        initview();

    }

    fun initview() {
        //nestedScrollView 嵌套 viewpage ，设置isFillViewport为true，显示才能正常
        nestedScrollView.isFillViewport = true;
        var mineFragmentPagerAdapter: MineFragmentPagerAdapter = MineFragmentPagerAdapter(supportFragmentManager);
        viewPager.adapter = mineFragmentPagerAdapter;
        tablayout.setupWithViewPager(viewPager)

    }
}
