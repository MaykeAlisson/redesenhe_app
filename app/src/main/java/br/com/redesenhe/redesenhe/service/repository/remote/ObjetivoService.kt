package br.com.redesenhe.redesenhe.service.repository.remote

import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface ObjetivoService {

    @GET("/api/objetivo/v1/objetivo")
    fun getAll(@Header("Authorization") token: String): Call<InfoUsuarioModel>

    @GET("/api/objetivo/v1/objetivo")
    fun getById(@Header("Authorization") token: String): Call<InfoUsuarioModel>

    @POST("/api/objetivo/v1/objetivo")
    fun create(@Header("Authorization") token: String, @Body json: JsonObject): Call<InfoUsuarioModel>

    @PUT("/api/objetivo/v1/objetivo")
    fun update(@Header("Authorization") token: String, @Body json: JsonObject): Call<InfoUsuarioModel>

    @DELETE("/api/objetivo/v1/objetivo")
    fun delete(@Header("Authorization") token: String): Call<InfoUsuarioModel>


}