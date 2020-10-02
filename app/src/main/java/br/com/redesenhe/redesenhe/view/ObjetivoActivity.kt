package br.com.redesenhe.redesenhe.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants
import br.com.redesenhe.redesenhe.service.listener.LancamentoListener
import br.com.redesenhe.redesenhe.view.adapter.LancamentoAdapter
import br.com.redesenhe.redesenhe.viewmodel.ObjetivoViewModel
import kotlinx.android.synthetic.main.activity_objetivo.*

class ObjetivoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: ObjetivoViewModel
    private lateinit var mListener: LancamentoListener
    private val mAdapter = LancamentoAdapter()

    private var idObjetivo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivo)

        mViewModel = ViewModelProvider(this).get(ObjetivoViewModel::class.java)

        val recycler = findViewById<RecyclerView>(R.id.recycler_all_lancamento)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter

        mListener = object : LancamentoListener {
            override fun onListClick(id: Int) {
                TODO("Not yet implemented")
            }

            override fun onDeleteClick(id: Int) {
                TODO("Not yet implemented")
            }

//            override fun onCompleteClick(id: Int) {
//            }

//            override fun onUndoClick(id: Int) {
//            }

        }

        // Inicializa eventos
        setListeners();
        observe()

        loadDataFromActivity()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.activity_objetivo_fab -> {
                val intent = Intent(this, CreateLancamentoActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(RedesenheConstants.BUNDLE.OBJETIVOID, idObjetivo)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun loadDataFromActivity() {
        val bundle = intent.extras
        if (bundle != null) {
            idObjetivo = bundle.getInt(RedesenheConstants.BUNDLE.OBJETIVOID)
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
            val progresso = (it.lancamento.toDouble() / it.objetivo.toDouble()) * 100
            val porcentagem = "$progresso%"
            activity_objetivo_text_decricao.text = it.nome
            activity_objetivo_text_objetivo.text = it.objetivo
            activity_objetivo_progress.max = 100
            activity_objetivo_progress.progress = progresso.toInt()
            activity_objetivo_text_porcentagem.text = porcentagem
            activity_objetivo_text_valor_atual.text = it.lancamento
        })

        mViewModel.lancamentos.observe(this, Observer {
            if (it.count() > 0) {
                mAdapter.updateList(it)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.getLancamento(idObjetivo)
    }
}