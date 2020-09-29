package br.com.redesenhe.redesenhe.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.listener.LancamentoListener
import br.com.redesenhe.redesenhe.service.model.LancamentoModel

class LancamentoViewHolder(itemView: View, val listener: LancamentoListener) :
    RecyclerView.ViewHolder(itemView) {

    private val mTextValor : TextView = itemView.findViewById(R.id.row_lancamento_list_text_valor)
    private val mTextOrigem : TextView = itemView.findViewById(R.id.row_lancamento_list_text_origem)
    private val mImgSeta : ImageView = itemView.findViewById(R.id.row_lancamento_list_img_seta)
    private val mTextDestino : TextView = itemView.findViewById(R.id.row_lancamento_list_text_destino)
    private val mTextData : TextView = itemView.findViewById(R.id.row_lancamento_list_text_data)

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    fun bindData(lancamento: LancamentoModel) {

        this.mTextValor.text = lancamento.valor
        this.mTextOrigem.text = lancamento.origem
        this.mTextDestino.text = lancamento.destino
        this.mTextData.text = lancamento.criacao
    }
}