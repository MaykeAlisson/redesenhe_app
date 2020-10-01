package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.listener.ValidationListener
import br.com.redesenhe.redesenhe.service.repository.LancamentoRepository

class CreateLancamentoViewModel (application: Application) : AndroidViewModel(application) {

    private val mLancamentoRepository = LancamentoRepository(application)

    private val mCreate = MutableLiveData<ValidationListener>()
    var create : LiveData<ValidationListener> = mCreate

    fun create(descricao: String, valor: String, origem: String, destino: String, idObjetivo: Int){
        val valorFinal = valor.substring(2, valor.length)
            .replace(".", "")
            .replace(",", ".")
            .toDouble()

        mLancamentoRepository.save(descricao, valorFinal, origem, destino, idObjetivo, object : APIListener<Void>{
            override fun onSuccess() {
                mCreate.value = ValidationListener()
            }

            override fun onFailure(str: String) {
                mCreate.value = ValidationListener(str)
            }
        })
    }


}