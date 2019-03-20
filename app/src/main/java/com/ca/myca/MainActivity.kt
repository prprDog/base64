package com.ca.myca

import android.arch.lifecycle.Observer
import android.util.Log
import com.ca.myca.base.BaseActivity
import com.ca.myca.dialog.ClipContentDialog
import com.ca.myca.main.*
import com.ca.myca.model.MainActivityModel
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MainActivity : BaseActivity() {
    private val _parentKodein: Kodein by closestKodein()
    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein)
        bind<IMainLocalRepository>() with singleton { MainLocalRepository() }
        bind<IMainRemoteRepository>() with singleton { MainRemoteRepository() }
        bind<MainRepository>() with singleton { MainRepository(instance(), instance()) }
        bind<MainActivityModel>() with singleton { MainActivityModel(instance()) }
    }
    private val viewModuel: MainActivityModel by instance()
    //用于触发注入检验是否有注入错误等问题
    override val kodeinTrigger: KodeinTrigger = KodeinTrigger()

    override fun onResume() {
        super.onResume()
        val clipContent = getClipContent()
        if (clipContent.contains("chenai://")){
            Log.i("clipContent", "clipContent:$clipContent")
            val dialog = ClipContentDialog.newInstance(clipContent)
            dialog.show(supportFragmentManager, "11")
        }
    }

    override fun initData() {
    }

    override fun initView() {
        kodeinTrigger.trigger()
        //加密
        bt_encoder.setOnClickListener {
            et_encoder.text.toString().trim().also {
                viewModuel.encoder(it)
                super.closeSoftInput()
            }
        }
        //解密
        bt_decoder.setOnClickListener {
            et_encoder.text.toString().trim().let { viewModuel.deconder(it) }
        }
        viewModuel.liveData.observe(this, Observer<String> { obj ->
            obj?.also {
                et_result.setText(it)
                super.closeSoftInput()
            }
        })
    }

    override fun initLayout(): Int {
        return R.layout.activity_main
    }
}
