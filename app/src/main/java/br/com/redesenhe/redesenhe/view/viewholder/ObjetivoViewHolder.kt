package br.com.redesenhe.redesenhe.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.listener.ObjetivoListener
import br.com.redesenhe.redesenhe.service.model.ObjetivoModel
import kotlinx.android.synthetic.main.row_objetivo_list.view.*

class ObjetivoViewHolder(itemView: View, val listener: ObjetivoListener) :
    RecyclerView.ViewHolder(itemView) {

    private val mTextDescricao: TextView = itemView.findViewById(R.id.row_objetivo_text_descricao)
    private val mTextValorObjetivo: TextView = itemView.findViewById(R.id.row_objetivo_text_vlr_objetivo)
    private val mPogressBar: ProgressBar = itemView.findViewById(R.id.row_objetivo_progressBar)
    private val mTextPorcentagem: TextView = itemView.findViewById(R.id.row_objetivo_text_porcentagem)
    private val mTextValorAtual: TextView = itemView.findViewById(R.id.row_objetivo_text_vlr_atual)

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    fun bindData(objetivo: ObjetivoModel) {

        this.mTextDescricao.text = ""
        this.mTextValorObjetivo.text = ""
        this.mPogressBar.max = 100
        this.mPogressBar.progress = 70
        this.mTextPorcentagem.text = "30%"
        this.mTextValorAtual.text = ""

        mTextDescricao.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remover Objetivo")
                .setMessage("Remover Objetivo?")
                .setPositiveButton("Sim") { dialog, which ->
                    // listener.onDeleteClick(task.id)
                }
                .setNeutralButton("Cancelar", null)
                .show()
            true
        }
    }
}