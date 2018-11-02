package com.mine.test

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mine.test.fragment.PathViewFragment
import com.mine.test.fragment.PiePicViewFragment
import com.mine.test.fragment.fragmentAdapter.MineFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_tab_viewpage.*
import kotlinx.android.synthetic.main.content_tab_view_page.*

class TabViewPageActivity : AppCompatActivity() {

    private var mineFragmentPagerAdapter: MineFragmentPagerAdapter = MineFragmentPagerAdapter(supportFragmentManager);
    private var fragmentList: ArrayList<Fragment> = ArrayList();
    private var tagNamesList: ArrayList<String> = ArrayList()

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
        //PathViewFragment
        var pathViewFragment: PathViewFragment = PathViewFragment();
        var namePathViewFragment: String = "画线";
        fragmentList.add(pathViewFragment)
        tagNamesList.add(namePathViewFragment)

        //PiePicViewFragment
        var piePicViewFragment: PiePicViewFragment = PiePicViewFragment();
        var namePiePicViewFragment: String = "画饼图";
        fragmentList.add(piePicViewFragment)
        tagNamesList.add(namePiePicViewFragment)

        //init fragmentList and tagNamesList
        mineFragmentPagerAdapter.fragmentList = fragmentList;
        mineFragmentPagerAdapter.tagNamesList = tagNamesList
        mineFragmentPagerAdapter.notifyDataSetChanged()
    }
}
