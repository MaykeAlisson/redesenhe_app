package br.com.redesenhe.redesenhe.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants
import br.com.redesenhe.redesenhe.service.listener.ObjetivoListener
import br.com.redesenhe.redesenhe.view.adapter.ObjetivoAdapter
import br.com.redesenhe.redesenhe.viewmodel.ListaObjetivoViewModel
import br.com.redesenhe.redesenhe.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_lista_objetivo.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.activity_login_btn

class ListaObjetivoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: ListaObjetivoViewModel
    private lateinit var mListener: ObjetivoListener
    private val mAdapter = ObjetivoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_objetivo)

        mViewModel = ViewModelProvider(this).get(ListaObjetivoViewModel::class.java)

        val recycler = findViewById<RecyclerView>(R.id.recycler_all_objetivo)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter

        // Eventos disparados ao clicar nas linhas da RecyclerView
        mListener = object : ObjetivoListener {
            override fun onListClick(id: Int) {
                val intent = Intent(applicationContext, ObjetivoActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(RedesenheConstants.BUNDLE.OBJETIVOID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDeleteClick(id: Int) {
            }

//            override fun onCompleteClick(id: Int) {
//            }
//
//            override fun onUndoClick(id: Int) {
//            }
        }

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
        mViewModel.objetivos.observe(this, Observer {
            if (it.count() > 0) {
                mAdapter.updateList(it)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.all()
    }
}