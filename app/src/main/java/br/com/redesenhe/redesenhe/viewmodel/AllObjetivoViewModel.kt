package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.redesenhe.redesenhe.service.repository.ObjetivoRepository
import br.com.redesenhe.redesenhe.service.repository.UsuarioRepository
import br.com.redesenhe.redesenhe.service.repository.local.SecurityPreferences

class AllObjetivoViewModel(application: Application) : AndroidViewModel(application) {

    private val mObjetivoRepository = ObjetivoRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    fun all(){}
}