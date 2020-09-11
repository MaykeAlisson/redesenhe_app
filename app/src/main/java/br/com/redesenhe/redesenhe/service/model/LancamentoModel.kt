package br.com.redesenhe.redesenhe.service.model

import com.google.gson.annotations.SerializedName

class LancamentoModel {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("nome")
    var nome: String = ""

    @SerializedName("valor")
    var valor: String = ""

    @SerializedName("origem")
    var origem: String = ""

    @SerializedName("destino")
    var destino: String = ""

    @SerializedName("id_objetivo")
    var id_objetivo: Int = 0

    @SerializedName("criacao")
    var criacao: String = ""

}