package br.com.redesenhe.redesenhe.service.repository.remote

import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsuarioService {

    @POST("/api/usuario/v1/login")
    fun login(@Body json: JsonObject): Call<InfoUsuarioModel>

    @POST("/api/usuario/v1/cadastro")
    fun create(@Body json: JsonObject): Call<InfoUsuarioModel>
}