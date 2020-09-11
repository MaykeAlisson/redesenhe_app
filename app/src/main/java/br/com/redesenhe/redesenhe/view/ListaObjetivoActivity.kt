package br.com.redesenhe.redesenhe.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.viewmodel.ListaObjetivoViewModel
import br.com.redesenhe.redesenhe.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_lista_objetivo.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.activity_login_btn

class ListaObjetivoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: ListaObjetivoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_objetivo)

        mViewModel = ViewModelProvider(this).get(ListaObjetivoViewModel::class.java)

        // Inicializa eventos
        setListeners();
        observe()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_lista_objetivo_fab -> {
                startActivity(Intent(this, CreateObjetivoActivity::class.java))
            }
        }
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        activity_lista_objetivo_fab.setOnClickListener(this)
    }


    /**
     * Observa ViewModel
     */
    private fun observe() {

    }
}