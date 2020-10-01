package br.com.redesenhe.redesenhe.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.infra.util.MoneyTextWatcher
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants
import br.com.redesenhe.redesenhe.viewmodel.CreateLancamentoViewModel
import br.com.redesenhe.redesenhe.viewmodel.CreateObjetivoViewModel
import kotlinx.android.synthetic.main.activity_create_lancamento.*
import kotlinx.android.synthetic.main.activity_create_objetivo.*
import java.util.*

class CreateLancamentoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: CreateLancamentoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_lancamento)

        mViewModel = ViewModelProvider(this).get(CreateLancamentoViewModel::class.java)

        val mLocale =  Locale("pt", "BR");
        activity_create_lancamento_valor.addTextChangedListener(MoneyTextWatcher(activity_create_lancamento_valor, mLocale))

        // Inicializa eventos
        setListeners()
        observe()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_create_lancamento_btn_salvar -> {
                handleCreate()
            }
        }
    }

    /**
     * Inicializa os eventos de click
     */
    private fun setListeners() {
        activity_create_lancamento_btn_salvar.setOnClickListener(this)
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
        val descricao = activity_create_lancamento_nome.text.toString()
        val origem = activity_create_lancamento_origem.text.toString()
        val destino = activity_create_lancamento_destino.text.toString()
        val valor = activity_create_lancamento_valor.text.toString()

        val bundle = intent.extras
        if (bundle != null) {
            var idObjetivo = bundle.getInt(RedesenheConstants.BUNDLE.OBJETIVOID)
        }

        when {
            descricao.trim().isEmpty() -> {
                activity_create_lancamento_nome.error = "Descrição obrigatoria!"
                return
            }
            origem.trim().isEmpty() -> {
                activity_create_lancamento_origem.error = "Origem obrigatoria!"
                return
            }
            destino.trim().isEmpty() -> {
                activity_create_lancamento_destino.error = "Destino obrigatorio!"
                return
            }
            valor.isEmpty() -> {
                activity_create_lancamento_valor.error = "Valor obrigatorio!"
                return
            }
            else -> mViewModel.create(descricao, valor, origem, destino, idObjetivo)
        }

    }

}