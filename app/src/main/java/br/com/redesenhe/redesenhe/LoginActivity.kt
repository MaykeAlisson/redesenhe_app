package br.com.redesenhe.redesenhe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    // Componentes


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        val activityloginInputemail = activityLogin_inputEmail
//        val activityloginInputemail1 = activityLogin_inputEmail
        activityLogin_btn.setOnClickListener(this)
      activityLogin_textLinkCadastro.setOnClickListener(this)
        activityLogin_textRecuperarSenha.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.activityLogin_textLinkCadastro){
            openViewCadastro()
        }
        if (id == R.id.activityLogin_textRecuperarSenha){
            recuperaSenha()
        }
        if (id == R.id.activityLogin_btn){
            realizaLogin()
        }
    }

    private fun openViewCadastro() {
        TODO("Not yet implemented")
    }

    private fun recuperaSenha() {
        TODO("Not yet implemented")
    }

    private fun realizaLogin() {
        val activityloginInputemail = activityLogin_inputEmail
        val activityloginInputsenha = activityLogin_inputSenha
    }
}