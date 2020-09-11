package br.com.redesenhe.redesenhe.service.model

import com.google.gson.annotations.SerializedName

class ObjetivoModel {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("nome")
    var nome: String = ""

    @SerializedName("objetivo")
    var objetivo: String = ""

    @SerializedName("criacao")
    var criacao: String = ""

}