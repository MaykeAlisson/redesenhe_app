package br.com.redesenhe.redesenhe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.redesenhe.redesenhe.service.repository.UsuarioRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val mUsuarioRepository = UsuarioRepository()

    /**
     * Faz login usando API
     */
    fun doLogin(email: String, password: String) {
        mUsuarioRepository.login(email, password)
    }

    /**
     * Verifica se usuário está logado
     */
    fun verifyLoggedUser() {
    }
}