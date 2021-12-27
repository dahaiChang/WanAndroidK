package com.cyh.wanandroidk.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cyh.mvvmcore.base.BaseFragment
import com.cyh.wanandroidk.R
import com.cyh.wanandroidk.isLogin
import com.cyh.wanandroidk.ui.main.home.HomeFragment
import com.cyh.wanandroidk.ui.main.navigation.NavigationFragment
import com.cyh.wanandroidk.ui.main.project.ProjectTypeFragment
import com.cyh.wanandroidk.ui.main.square.SquareFragment
import com.cyh.wanandroidk.ui.main.system.SystemFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * 首页
 */
class MainFragment : BaseFragment() {
    private val titleList = arrayOf("首页", "广场", "项目", "体系", "导航")
    private var mOnPageChangeCallback: ViewPager2.OnPageChangeCallback? = null

    override fun getLayoutResId() = R.layout.fragment_main

    override fun initView() {
        initViewPager()
        addFab.setOnClickListener {
            if (!isLogin) {

            } else {

            }
        }
    }

    override fun initData() {

    }


    private fun initViewPager() {
        //当切换到当前页面时，会默认预加载左右两侧的布局到ViewPager中
        viewPager.offscreenPageLimit = 1
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = titleList.size

            override fun createFragment(position: Int): Fragment = when (position) {
                0 -> HomeFragment()
                1 -> SquareFragment()
                2 -> ProjectTypeFragment()
                3 -> SystemFragment()
                4 -> NavigationFragment()
                else -> HomeFragment()
            }
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titleList[position]
        }.attach()
    }

    override fun onResume() {
        super.onResume()
        if (mOnPageChangeCallback == null) mOnPageChangeCallback =
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    if (position == 1) addFab.show() else addFab.hide()
                }
            }
        mOnPageChangeCallback?.let { viewPager.registerOnPageChangeCallback(it) }
    }

    override fun onPause() {
        super.onPause()
        mOnPageChangeCallback?.let{viewPager.unregisterOnPageChangeCallback(it)}
    }
}