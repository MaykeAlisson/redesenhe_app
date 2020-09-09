package br.com.redesenhe.redesenhe.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.listener.ObjetivoListener
import br.com.redesenhe.redesenhe.view.viewholder.ObjetivoViewHolder

class ObjetivoAdapter : RecyclerView.Adapter<ObjetivoViewHolder>() {

    // private var mList: List<TaskModel> = arrayListOf()
    private lateinit var mListener: ObjetivoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjetivoViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.row_objetivo_list, parent, false)
        return ObjetivoViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return 0
        // return mList.count()
    }

    override fun onBindViewHolder(holder: ObjetivoViewHolder, position: Int) {
        holder.bindData()
    }

    fun attachListener(listener: ObjetivoListener) {
        mListener = listener
    }

}