package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.model.ObjetivoModel
import br.com.redesenhe.redesenhe.service.repository.ObjetivoRepository
import br.com.redesenhe.redesenhe.service.repository.local.SecurityPreferences

class AllObjetivoViewModel(application: Application) : AndroidViewModel(application) {

    private val mObjetivoRepository = ObjetivoRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    private val mList = MutableLiveData<List<ObjetivoModel>>()
    val objetivos: LiveData<List<ObjetivoModel>> = mList

    fun all() {
        mObjetivoRepository.all(object : APIListener<List<ObjetivoModel>> {
            override fun onSuccess(model: List<ObjetivoModel>) {
                mList.value = model
            }

            override fun onFailure(str: String) {
                mList.value = arrayListOf()
            }

        })
    }
}