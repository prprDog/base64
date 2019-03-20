package com.ca.myca.main

import android.arch.lifecycle.MutableLiveData
import android.util.Base64
import android.util.Log
import com.ca.myca.base.BaseRepository

class MainRepository(localRepository: IMainLocalRepository, remoteRepository: IMainRemoteRepository):
    BaseRepository<IMainLocalRepository, IMainRemoteRepository>(localRepository, remoteRepository) {

    fun getEncoder(content: MutableLiveData<String>){
        val origin = content.value
        Log.i("origin", "=========$origin=======")
        origin?.let {
            content.value = Base64.encodeToString(it.toByteArray(), Base64.DEFAULT)
            Log.i("aaaaaaaaaaaaaaa", "=========加密成功=======")
        }
    }

    fun getDecoder(content: MutableLiveData<String>) {
        val origin = content.value
        Log.i("origin", "=========$origin=======")
        origin?.let {
            content.value = String(Base64.decode(it.toByteArray(), Base64.DEFAULT))
            Log.i("aaaaaaaaaaaaaaa", "=========解密成功=======")
        }
    }
}