package br.com.redesenhe.redesenhe.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants
import br.com.redesenhe.redesenhe.viewmodel.ObjetivoViewModel
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

        loadDataFromActivity()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_objetivo_fab -> {
                startActivity(Intent(this, CreateLancamentoActivity::class.java))
            }
        }
    }

    private fun loadDataFromActivity() {
        val bundle = intent.extras
        if (bundle != null) {
            val idObjetivo = bundle.getInt(RedesenheConstants.BUNDLE.OBJETIVOID)
            mViewModel.load(idObjetivo)
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
        mViewModel.objetivo.observe(this, Observer {
            activity_objetivo_text_decricao.text = it.nome
            activity_objetivo_text_objetivo.text = it.objetivo
            activity_objetivo_progress.max = 100
            activity_objetivo_progress.progress = 30
            activity_objetivo_text_porcentagem.text = "30%"
            activity_objetivo_text_valor_atual.text = "400"
        })
    }
}