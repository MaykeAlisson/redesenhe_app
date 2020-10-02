package br.com.redesenhe.redesenhe.service.repository.remote

import br.com.redesenhe.redesenhe.service.model.LancamentoModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface LancamentoService {

//    @GET("/api/lancamento/v1/lancamento/{id}")
//    fun getByObjetivo(@Path(value = "id", encoded = true) id: Int, @Header("Authorization") token: String): Call<List<LancamentoModel>>
//
    @GET("/api/lancamento/v1/lancamento/objetivo/{id}")
    fun getByObjetivo(@Path(value = "id", encoded = true) id: Int): Call<List<LancamentoModel>>

    @POST("/api/lancamento/v1/lancamento")
    fun create(@Body json: JsonObject): Call<Void>

    @PUT("/api/lancamento/v1/lancamento/{id}")
    fun update(@Path(value = "id", encoded = true) id: Int, @Body json: JsonObject): Call<Void>

    @DELETE("/api/lancamento/v1/lancamento/{id}")
    fun delete(@Path(value = "id", encoded = true) id: Int): Call<Void>


}