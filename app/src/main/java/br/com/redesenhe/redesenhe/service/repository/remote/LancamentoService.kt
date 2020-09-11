package br.com.redesenhe.redesenhe.service.repository.remote

import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import br.com.redesenhe.redesenhe.service.model.LancamentoModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface LancamentoService {

    @GET("/api/lancamento/v1/lancamento/{id}")
    fun getByObjetivo(@Path(value = "id", encoded = true) id: Int, @Header("Authorization") token: String): Call<List<LancamentoModel>>

    @POST("/api/lancamento/v1/lancamento")
    fun create(@Header("Authorization") token: String, @Body json: JsonObject): Call<InfoUsuarioModel>

    @PUT("/api/lancamento/v1/lancamento/{id}")
    fun update(@Path(value = "id", encoded = true) id: Int, @Header("Authorization") token: String, @Body json: JsonObject): Call<InfoUsuarioModel>

    @DELETE("/api/lancamento/v1/lancamento/{id}")
    fun delete(@Path(value = "id", encoded = true) id: Int, @Header("Authorization") token: String): Call<InfoUsuarioModel>


}