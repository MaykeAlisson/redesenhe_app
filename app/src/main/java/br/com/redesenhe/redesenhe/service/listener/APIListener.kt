package br.com.redesenhe.redesenhe.service.listener

import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel

interface APIListener<T> {

    fun onSuccess(model: InfoUsuarioModel){

    }

    fun onFailure(str: String){}
}