package br.com.redesenhe.redesenhe.service.repository.remote

import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface LancamentoService {

    @GET("/api/lancamento/v1/lancamento")
    fun getByObjetivo(@Header("Authorization") token: String): Call<InfoUsuarioModel>

    @POST("/api/lancamento/v1/lancamento")
    fun create(@Header("Authorization") token: String, @Body json: JsonObject): Call<InfoUsuarioModel>

    @PUT("/api/lancamento/v1/lancamento")
    fun update(@Header("Authorization") token: String, @Body json: JsonObject): Call<InfoUsuarioModel>

    @DELETE("/api/lancamento/v1/lancamento")
    fun delete(@Header("Authorization") token: String): Call<InfoUsuarioModel>


}