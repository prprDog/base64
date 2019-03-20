package com.ca.myca.base

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

class BaseApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidModule(this@BaseApplication))
    }

}