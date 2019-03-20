package com.ca.myca.base

import android.arch.lifecycle.ViewModel

open class BaseViewModel<T: Repository>(protected val repository: T): ViewModel() {

}