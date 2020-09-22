package br.com.redesenhe.redesenhe.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.infra.util.UtilString
import br.com.redesenhe.redesenhe.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var mViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        // Inicializa eventos
        setListeners();
        observe()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_register_btn_save -> {
                handleCadastro()
            }
        }
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        activity_register_btn_save.setOnClickListener(this)
    }

    /**
     * Observa ViewModel
     */
    private fun observe() {
        mViewModel.create.observe(this, Observer {
            if (it.success()){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                val msg = it.falure()
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun handleCadastro(){
        val nome = activity_register_edit_nome.text.toString()
        val email = activity_register_edit_email.text.toString()
        val senha = activity_register_edit_senha.text.toString()

        when {
            nome.trim().isEmpty() -> {
                activity_register_edit_nome.error = "Nome obrigatorio!"
                return
            }
            senha.trim().isEmpty() -> {
                activity_register_edit_senha.error = "Senha obrigatoria!"
                return
            }
            senha.length < 6 -> {
                activity_register_edit_senha.error = "Senha muito pequena!"
                return
            }
            !UtilString.isValidEmail(email) -> {
                activity_register_edit_email.error = "E-mail invalido!"
                return
            }
            else -> mViewModel.create(nome, email, senha)
        }

    }

}