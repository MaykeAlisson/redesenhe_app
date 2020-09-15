package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.listener.ValidationListener
import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import br.com.redesenhe.redesenhe.service.repository.UsuarioRepository
import br.com.redesenhe.redesenhe.service.repository.local.SecurityPreferences
import br.com.redesenhe.redesenhe.service.repository.remote.RetrofitClient

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val mUsuarioRepository = UsuarioRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    private val mLogin = MutableLiveData<ValidationListener>()
    var login: LiveData<ValidationListener> = mLogin

    /**
     * Faz login usando API
     */
    fun doLogin(email: String, password: String) {
//        mLogin.value = ValidationListener()

        mUsuarioRepository.login(email, password, object : APIListener<InfoUsuarioModel> {
            override fun onSuccess(model: InfoUsuarioModel) {
                mSharedPreferences.store(RedesenheConstants.SHARED.TOKEN, model.token)
                mSharedPreferences.store(RedesenheConstants.SHARED.USER_ID, model.idUser)
                mSharedPreferences.store(RedesenheConstants.SHARED.USER_NAME, model.userName)

                RetrofitClient.addHeader(model.token)
                mLogin.value = ValidationListener()

            }

            override fun onFailure(str: String) {
                mLogin.value = ValidationListener(str)
            }

        })
    }

    /**
     * Verifica se usuário está logado
     */
    fun verifyLoggedUser() {
    }
}