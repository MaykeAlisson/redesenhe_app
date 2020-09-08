package br.com.redesenhe.redesenhe

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        val activityloginInputemail = activityLogin_inputEmail
//        val activityloginInputemail1 = activityLogin_inputEmail
        activity_login_btn.setOnClickListener(this)
        activity_login_link_cadastro.setOnClickListener(this)
        activity_login_text_recuperar_senha.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_login_link_cadastro -> {
                openViewCadastro()
            }
            R.id.activity_login_text_recuperar_senha -> {
                recuperaSenha()
            }
            R.id.activity_login_btn -> {
                realizaLogin()
            }
        }
    }

    private fun openViewCadastro() {
        TODO("Not yet implemented")
    }

    private fun recuperaSenha() {
        TODO("Not yet implemented")
    }

    private fun realizaLogin() {
        val mEmail = activity_login_text_email.text.toString()
        val mSenha = activity_login_text_senha.text.toString()
    }
}