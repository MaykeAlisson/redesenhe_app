package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.model.ObjetivoModel
import br.com.redesenhe.redesenhe.service.repository.ObjetivoRepository

class ObjetivoViewModel(application: Application) : AndroidViewModel(application) {

    private val mObjetivoRepository = ObjetivoRepository(application)

    private val mObjevito = MutableLiveData<ObjetivoModel>()
    var objetivo: LiveData<ObjetivoModel> = mObjevito

    fun load(id: Int) {
        mObjetivoRepository.findById(id, object : APIListener<ObjetivoModel> {
            override fun onSuccess(model: ObjetivoModel) {
                mObjevito.value = model

            }

            override fun onFailure(str: String) {

            }

        })
    }
}