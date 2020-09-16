package br.com.redesenhe.redesenhe.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.listener.LancamentoListener
import br.com.redesenhe.redesenhe.view.adapter.LancamentoAdapter
import br.com.redesenhe.redesenhe.viewmodel.AllLancamentoViewModel


class AllLancamentoFragment : Fragment() {

    private lateinit var mViewModel: AllLancamentoViewModel
    private lateinit var mListener: LancamentoListener
    private val mAdapter = LancamentoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        mViewModel = ViewModelProvider(this).get(AllLancamentoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all_objetivo, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_objetivo)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        // Eventos disparados ao clicar nas linhas da RecyclerView
        mListener = object : LancamentoListener {
            override fun onListClick(id: Int) {
//                val intent = Intent(context, ObjetivoActivity::class.java)
//                val bundle = Bundle()
//                bundle.putInt(RedesenheConstants.BUNDLE.OBJETIVOID, id)
//                intent.putExtras(bundle)
//                startActivity(intent)
            }

            override fun onDeleteClick(id: Int) {
            }

            override fun onCompleteClick(id: Int) {
            }

            override fun onUndoClick(id: Int) {
            }
        }

        // Cria os observadores
        observe()

        // Retorna view
        return root
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
    }

    private fun observe() {}

}
