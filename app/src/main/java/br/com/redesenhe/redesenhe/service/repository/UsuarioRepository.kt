package br.com.redesenhe.redesenhe.service.repository

import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import br.com.redesenhe.redesenhe.service.repository.remote.RetrofitClient
import br.com.redesenhe.redesenhe.service.repository.remote.UsuarioService
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioRepository {

    private val mRemote = RetrofitClient.createService(UsuarioService::class.java)

    fun login(email: String, senha: String){

        val obj = JsonObject()
        obj.addProperty("email", email)
        obj.addProperty("senha", senha)

        val call: Call<InfoUsuarioModel> = mRemote.login(obj)
        call.enqueue(object : Callback<InfoUsuarioModel>{
            override fun onResponse(
                call: Call<InfoUsuarioModel>,
                response: Response<InfoUsuarioModel>
            ) {
                val infoUser = response.body()
            }

            override fun onFailure(call: Call<InfoUsuarioModel>, t: Throwable) {
                val s = ""
            }
        })
    }
}