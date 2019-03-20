package com.ca.myca.main

import android.util.Log

class MainLocalRepository: IMainLocalRepository {

    fun encoderContent(orign: String){
        Log.i("encoder start", "原始内容:$orign")
    }
}