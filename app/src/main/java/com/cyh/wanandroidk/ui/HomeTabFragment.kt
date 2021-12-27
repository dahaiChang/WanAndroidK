package com.cyh.wanandroidk.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cyh.mvvmcore.base.BaseFragment
import com.cyh.wanandroidk.R
import com.cyh.wanandroidk.ui.Project.ProjectFragment
import com.cyh.wanandroidk.ui.blog.BlogFragment
import com.cyh.wanandroidk.ui.main.MainFragment
import com.cyh.wanandroidk.ui.my.MyFragment
import com.cyh.wanandroidk.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home_tab.*

class HomeTabFragment : BaseFragment() {
    override fun getLayoutResId(): Int = R.layout.fragment_home_tab

    override fun initView() {
        initViewPager()
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelected)
    }


    override fun initData() {

    }


    private fun initViewPager() {
        //禁止用户滑动
        mainViewpager.isUserInputEnabled = false
        mainViewpager.offscreenPageLimit = 2
        mainViewpager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 5

            override fun createFragment(position: Int) =
                when (position) {
                    0 -> MainFragment()
                    1 -> BlogFragment()
                    2-> SearchFragment()
                    3 -> ProjectFragment()
                    4 -> MyFragment()
                    else -> MainFragment()
                }

        }
    }

    private  val onNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.home -> switchFragment(0)
            R.id.blog -> switchFragment(1)
            R.id.search -> switchFragment(2)
            R.id.project -> switchFragment(3)
            R.id.profile -> switchFragment(4)
            else -> {switchFragment(0)}
        }
    }

    private fun switchFragment(position: Int): Boolean {
        mainViewpager.setCurrentItem(position, false)
        return true
    }
}