package br.com.redesenhe.redesenhe.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.listener.ObjetivoListener
import br.com.redesenhe.redesenhe.service.model.ObjetivoModel
import java.text.SimpleDateFormat
import java.util.*

class ObjetivoViewHolder(itemView: View, val listener: ObjetivoListener) :
    RecyclerView.ViewHolder(itemView) {

    private val mDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)

    private val mRow : ConstraintLayout = itemView.findViewById(R.id.row_objetivo_row)
    private val mTextDescricao: TextView = itemView.findViewById(R.id.row_objetivo_text_descricao)
    private val mTextValorObjetivo: TextView = itemView.findViewById(R.id.row_objetivo_text_vlr_objetivo)
    private val mPogressBar: ProgressBar = itemView.findViewById(R.id.row_objetivo_progressBar)
    private val mTextPorcentagem: TextView = itemView.findViewById(R.id.row_objetivo_text_porcentagem)
    private val mTextValorAtual: TextView = itemView.findViewById(R.id.row_objetivo_text_vlr_atual)

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    fun bindData(objetivo: ObjetivoModel) {

        val progresso = (objetivo.lancamento.toDouble() / objetivo.objetivo.toDouble() )  * 100
        val porcentagem = "$progresso%"

        this.mTextDescricao.text = objetivo.nome
        this.mTextValorObjetivo.text = objetivo.objetivo
        this.mPogressBar.max = 100
        this.mPogressBar.progress = progresso.toInt()
        this.mTextPorcentagem.text = porcentagem
        this.mTextValorAtual.text = objetivo.lancamento

        mRow.setOnClickListener{ listener.onListClick(objetivo.id) }
//        mTextDescricao.setOnClickListener{ listener.onListClick(objetivo.id) }

        mRow.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remover Objetivo")
                .setMessage("Remover Objetivo?")
                .setPositiveButton("Sim") { dialog, which ->
                     listener.onDeleteClick(objetivo.id)
                }
                .setNeutralButton("Cancelar", null)
                .show()
            true
        }

    }
}