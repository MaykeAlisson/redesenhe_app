package br.com.redesenhe.redesenhe.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.infra.util.LoadingDialog
import br.com.redesenhe.redesenhe.infra.util.UtilString.isValidEmail
import br.com.redesenhe.redesenhe.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: LoginViewModel

    val loadingDialog: LoadingDialog = LoadingDialog(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Inicializa eventos
        setListeners();
        observe()

        // Verifica se usuário está logado
        verifyLoggedUser()

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_login_link_cadastro -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
            R.id.activity_login_text_recuperar_senha -> {
                recuperaSenha()
            }
            R.id.activity_login_btn -> {
                handleLogin()
            }
        }
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        activity_login_btn.setOnClickListener(this)
        activity_login_link_cadastro.setOnClickListener(this)
        activity_login_text_recuperar_senha.setOnClickListener(this)
    }

    /**
     * Verifica se usuário está logado
     */
    private fun verifyLoggedUser() {
        mViewModel.verifyLoggedUser()
    }

    /**
     * Observa ViewModel
     */
    private fun observe() {
        mViewModel.login.observe(this, Observer {
            if (it.success()) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                val msg = it.falure()
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }
        })
    }

    /**
     * Autentica usuário
     */
    private fun handleLogin() {
        val email = activity_login_text_email.text.toString()
        val password = activity_login_text_senha.text.toString()

        if (email.trim().isEmpty()) {
            activity_login_text_email.error = "E-mail Obrigatorio!"
            return
        } else if (password.trim().isEmpty()){
            activity_login_text_senha.error = "Senha obrigatoria!"
            return
        }

        if (!isValidEmail(email)) {
            activity_login_text_email.error = "E-mail invalido!"
            return
        }
        mViewModel.doLogin(email, password)

    }

    /**
     * Recupera senha do usuário
     */
    private fun recuperaSenha() {
        Toast.makeText(applicationContext, "Recupera Senha", Toast.LENGTH_SHORT).show()
    }

}