package br.com.redesenhe.redesenhe.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.viewmodel.LoginViewModel
import br.com.redesenhe.redesenhe.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.activity_login_btn
import kotlinx.android.synthetic.main.activity_login.activity_login_link_cadastro
import kotlinx.android.synthetic.main.activity_login.activity_login_text_recuperar_senha
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Inicializa eventos
        setListeners();
        observe()

    }

    override fun onClick(view: View) {
       when(view.id){
           R.id.activity_main_linear_objetivo -> {
               startActivity(Intent(this, ListaObjetivoActivity::class.java))
           }
           R.id.activity_main_linear_livro -> {
               Toast.makeText(applicationContext, "Em Breve!", Toast.LENGTH_LONG).show()
           }
           R.id.activity_main_linear_espirito -> {
               Toast.makeText(applicationContext, "Em Breve!", Toast.LENGTH_LONG).show()
           }
           R.id.activity_main_linear_fisico -> {
               Toast.makeText(applicationContext, "Em Breve!", Toast.LENGTH_LONG).show()
           }
       }
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        activity_main_linear_objetivo.setOnClickListener(this)
        activity_main_linear_livro.setOnClickListener(this)
        activity_main_linear_espirito.setOnClickListener(this)
        activity_main_linear_fisico.setOnClickListener(this)
    }

    /**
     * Observa ViewModel
     */
    private fun observe() {}

}