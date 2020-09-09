package br.com.redesenhe.redesenhe.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.listener.LancamentoListener
import br.com.redesenhe.redesenhe.view.viewholder.LancamentoViewHolder
import br.com.redesenhe.redesenhe.view.viewholder.ObjetivoViewHolder

class LancamentoAdapter : RecyclerView.Adapter<LancamentoViewHolder>() {

    // private var mList: List<TaskModel> = arrayListOf()
    private lateinit var mListener: LancamentoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LancamentoViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.row_lancamento_list, parent, false)
        return LancamentoViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return 0
        // return mList.count()
    }

    override fun onBindViewHolder(holder: LancamentoViewHolder, position: Int) {
        holder.bindData()
    }

    fun attachListener(listener: LancamentoListener) {
        mListener = listener
    }
}