package com.cyh.wanandroidk

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class App : Application(){
    /**
     * companion object 修饰为伴生对象,伴生对象在类中只能存在一个，类似于java中的静态方法 Java 中使用类访问静态成员，静态方法。
     */
    companion object{
        //空安全是Kotlin提供的功能之一
        //lateinit不能应用于原始数据类型（例如：Int）。对于原始数据类型，我们可以这样使用委托：
        var CONTEXT : Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
    }

}