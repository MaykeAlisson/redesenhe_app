package br.com.redesenhe.redesenhe.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.viewmodel.ListaObjetivoViewModel
import br.com.redesenhe.redesenhe.viewmodel.ObjetivoViewModel
import kotlinx.android.synthetic.main.activity_lista_objetivo.*
import kotlinx.android.synthetic.main.activity_lista_objetivo.activity_lista_objetivo_fab
import kotlinx.android.synthetic.main.activity_objetivo.*

class ObjetivoActivity : AppCompatActivity(),  View.OnClickListener {

    private lateinit var mViewModel: ObjetivoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivo)

        mViewModel = ViewModelProvider(this).get(ObjetivoViewModel::class.java)

        // Inicializa eventos
        setListeners();
        observe()

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_objetivo_fab -> {
                startActivity(Intent(this, CreateLancamentoActivity::class.java))
            }
        }
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        activity_objetivo_fab.setOnClickListener(this)
    }


    /**
     * Observa ViewModel
     */
    private fun observe() {

    }
}