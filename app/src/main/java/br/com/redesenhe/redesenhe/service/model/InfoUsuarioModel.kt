package br.com.redesenhe.redesenhe.service.model

import com.google.gson.annotations.SerializedName

class InfoUsuarioModel {

    @SerializedName("idUser")
    var idUser: Int = 0

    @SerializedName("userName")
    var userName: String = ""

    @SerializedName("token")
    var token: String = ""
}