package br.com.redesenhe.redesenhe.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.viewmodel.LoginViewModel
import br.com.redesenhe.redesenhe.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_login.*

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
        TODO("Not yet implemented")
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
//        activity_login_btn.setOnClickListener(this)
//        activity_login_link_cadastro.setOnClickListener(this)
//        activity_login_text_recuperar_senha.setOnClickListener(this)
    }

    /**
     * Observa ViewModel
     */
    private fun observe() {
//        mViewModel.login.observe(this, Observer {
//            if (it.success()){
//                startActivity(Intent(this, MainActivity::class.java))
//            }else{
//                val msg = it.falure()
//                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
//            }
//        })
    }

}