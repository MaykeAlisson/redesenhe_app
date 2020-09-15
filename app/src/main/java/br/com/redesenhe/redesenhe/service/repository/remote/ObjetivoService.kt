package br.com.redesenhe.redesenhe.service.repository.remote

import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import br.com.redesenhe.redesenhe.service.model.ObjetivoModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface ObjetivoService {

    @GET("/api/objetivo/v1/objetivo")
    fun getAll(): Call<List<ObjetivoModel>>

    @GET("/api/objetivo/v1/objetivo/{id}")
    fun getById(@Path(value = "id", encoded = true) id: Int): Call<ObjetivoModel>

    @POST("/api/objetivo/v1/objetivo")
    fun create(@Body json: JsonObject): Call<InfoUsuarioModel>

    @PUT("/api/objetivo/v1/objetivo/{id}")
    fun update(@Path(value = "id", encoded = true) id: Int, @Body json: JsonObject): Call<InfoUsuarioModel>

    @DELETE("/api/objetivo/v1/objetivo/{id}")
    fun delete(@Path(value = "id", encoded = true) id: Int): Call<InfoUsuarioModel>


}