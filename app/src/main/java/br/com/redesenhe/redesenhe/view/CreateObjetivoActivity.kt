package br.com.redesenhe.redesenhe.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.viewmodel.CreateObjetivoViewModel
import kotlinx.android.synthetic.main.activity_create_objetivo.*

class CreateObjetivoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: CreateObjetivoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_objetivo)

        mViewModel = ViewModelProvider(this).get(CreateObjetivoViewModel::class.java)

        // Inicializa eventos
        setListeners();
        observe()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_create_objetivo_btn_salvar -> {
                handleCreate()
            }
        }
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        activity_create_objetivo_btn_salvar.setOnClickListener(this)
    }

    /**
     * Observa ViewModel
     */
    private fun observe() {
    }

    /**
     * Cria objetivo
     */
    private fun handleCreate() {
        val descricao = activity_create_objetivo_nome.text.toString()
        val objetivo = activity_create_objetivo_valor.text.toString()

        mViewModel.create(descricao, objetivo)
    }

}