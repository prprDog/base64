package com.ca.myca.base

open class BaseRepository<T: LocalRepository, R: RemoteRepository>(protected val localRepository: T, protected  val remoteRepository: R) :
    Repository {
}