package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.listener.ValidationListener
import br.com.redesenhe.redesenhe.service.repository.ObjetivoRepository

class CreateObjetivoViewModel(application: Application) : AndroidViewModel(application) {

    private val mObjetivoRepository = ObjetivoRepository(application)

    private val mCreate = MutableLiveData<ValidationListener>()
    var create: LiveData<ValidationListener> = mCreate

    fun create(descricao: String, objetivo: String) {
        val valor = objetivo.substring(2, objetivo.length)
            .replace(".", "")
            .replace(",", ".")
            .toDouble()

        mObjetivoRepository.save(descricao, valor, object : APIListener<Void> {
            override fun onSuccess() {
                mCreate.value = ValidationListener()
            }

            override fun onFailure(str: String) {
                mCreate.value = ValidationListener(str)
            }
        })
    }
}