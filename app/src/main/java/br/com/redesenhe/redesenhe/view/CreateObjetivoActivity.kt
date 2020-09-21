package br.com.redesenhe.redesenhe.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.infra.util.MoneyTextWatcher
import br.com.redesenhe.redesenhe.viewmodel.CreateObjetivoViewModel
import kotlinx.android.synthetic.main.activity_create_objetivo.*
import java.util.*

class CreateObjetivoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: CreateObjetivoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_objetivo)

        mViewModel = ViewModelProvider(this).get(CreateObjetivoViewModel::class.java)

        val mLocale =  Locale("pt", "BR");
        activity_create_objetivo_valor.addTextChangedListener( MoneyTextWatcher(activity_create_objetivo_valor, mLocale))

        // Inicializa eventos
        setListeners()
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
        mViewModel.create.observe(this, Observer {
            if (it.success()){
                finish()
            }else{
                val msg = it.falure()
                Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
            }
        })
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