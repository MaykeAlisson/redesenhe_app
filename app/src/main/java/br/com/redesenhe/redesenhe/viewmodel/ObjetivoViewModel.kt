package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.model.LancamentoModel
import br.com.redesenhe.redesenhe.service.model.ObjetivoModel
import br.com.redesenhe.redesenhe.service.repository.LancamentoRepository
import br.com.redesenhe.redesenhe.service.repository.ObjetivoRepository

class ObjetivoViewModel(application: Application) : AndroidViewModel(application) {

    private val mObjetivoRepository = ObjetivoRepository(application)
    private val mLancamentoRepository = LancamentoRepository(application)

    private val mObjevito = MutableLiveData<ObjetivoModel>()
    var objetivo: LiveData<ObjetivoModel> = mObjevito

    private val mList = MutableLiveData<List<LancamentoModel>>()
    val lancamentos: LiveData<List<LancamentoModel>> = mList

    fun load(id: Int) {
        mObjetivoRepository.findById(id, object : APIListener<ObjetivoModel> {
            override fun onSuccess(model: ObjetivoModel) {
                getLancamento(id)
                mObjevito.value = model

            }

            override fun onFailure(str: String) {

            }

        })
    }

    fun getLancamento(id: Int){
        mLancamentoRepository.findByIdObjetivo(id, object : APIListener<List<LancamentoModel>>{
            override fun onSuccess(model: List<LancamentoModel>) {
                mList.value = model
            }

            override fun onFailure(str: String) {
                mList.value = arrayListOf()
            }
        })
    }
}