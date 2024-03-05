package com.geeks.mvvm15_1j.common

sealed class Resource<T>(val data: T? = null,val massage :String? = null){
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(massage: String) : Resource<T>(massage = massage)
}