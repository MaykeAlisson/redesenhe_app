package br.com.redesenhe.redesenhe.service.listener

interface APIListener<T> {

    fun onSuccess(model: T){}

    fun onSuccess(){}

    fun onFailure(str: String){}
}