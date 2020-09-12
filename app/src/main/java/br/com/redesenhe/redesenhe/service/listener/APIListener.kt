package br.com.redesenhe.redesenhe.service.listener

interface APIListener<T> {

    fun onSuccess(model: T){

    }

    fun onFailure(str: String){}
}