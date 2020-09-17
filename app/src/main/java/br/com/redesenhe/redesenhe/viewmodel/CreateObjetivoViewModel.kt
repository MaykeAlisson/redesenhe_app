package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.repository.ObjetivoRepository
import java.math.BigDecimal

class CreateObjetivoViewModel(application: Application) : AndroidViewModel(application) {

    private val mObjetivoRepository = ObjetivoRepository(application)

    fun create(descricao: String, objetivo: String){

        val valor = BigDecimal(10)
        mObjetivoRepository.save(descricao, valor, object : APIListener<Void>{
            override fun onSuccess(model: Void) {

            }

            override fun onFailure(str: String) {

            }
        })
    }
}