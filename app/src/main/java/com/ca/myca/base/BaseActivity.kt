package com.ca.myca.base

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import org.kodein.di.KodeinAware


abstract class BaseActivity: AppCompatActivity(), KodeinAware {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayout())
        initView()
        initData()
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun initLayout():Int

    fun closeSoftInput(){
        val view: View?= window.peekDecorView()
        view?.let {
            val inputManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    fun getClipContent(): String{
        return(getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip.let{
            it.getItemAt(0).toString()
        }
    }
}