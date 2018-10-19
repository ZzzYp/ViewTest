package com.mine.test

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mine.test.R
import com.mine.test.fraagment.PathViewFragment
import com.mine.test.fraagment.fragmentAdapter.MineFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_viewpage.*
import kotlinx.android.synthetic.main.content_tab_view_page.*

class TabViewPageActivity : AppCompatActivity() {

    private var mineFragmentPagerAdapter: MineFragmentPagerAdapter = MineFragmentPagerAdapter(supportFragmentManager);
    private var fragmentList: ArrayList<Fragment> = ArrayList();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_viewpage)
        setSupportActionBar(toolbar)

        initview();
        initFragment()

    }

    fun initview() {;
        //nestedScrollView 嵌套 viewpage ，设置isFillViewport为true，显示才能正常
        nestedScrollView.isFillViewport = true;
        viewPager.adapter = mineFragmentPagerAdapter;
        tablayout.setupWithViewPager(viewPager)

    }

    private fun initFragment() {
        var pathViewFragment: PathViewFragment = PathViewFragment();


        fragmentList.add(pathViewFragment)
        mineFragmentPagerAdapter.fragmentList = fragmentList;
        mineFragmentPagerAdapter.notifyDataSetChanged()
    }
}
