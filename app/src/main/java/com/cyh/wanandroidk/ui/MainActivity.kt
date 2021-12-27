package com.cyh.wanandroidk.ui

import android.os.Bundle
import com.cyh.mvvmcore.base.BaseActivity
import com.cyh.wanandroidk.R

class MainActivity : BaseActivity() {
    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        //NoActionBar
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }


    override fun initData() {
    }

    override fun initView() {
    }


}