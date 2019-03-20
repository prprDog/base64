package com.ca.myca.model
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ca.myca.base.BaseViewModel
import com.ca.myca.main.MainRepository


class MainActivityModel(repository: MainRepository) : BaseViewModel<MainRepository>(repository) {
    val liveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun encoder(content: String){
        liveData.value = content
        repository.getEncoder(liveData)
    }

    fun deconder(content: String){
        liveData.value = content
        repository.getDecoder(liveData)
    }

    fun validClipboardContent(content: String){

    }

}