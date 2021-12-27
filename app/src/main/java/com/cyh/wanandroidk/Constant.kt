package com.cyh.wanandroidk

import com.cyh.wanandroidk.util.Preference
import com.cyh.wanandroidk.util.Preference.Companion.IS_LOGIN

//Timer tag
val APP_START = "app start"

//是否登录
var isLogin by Preference(Preference.IS_LOGIN,false)