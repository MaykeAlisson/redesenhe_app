package br.com.redesenhe.redesenhe.service.repository

import android.content.Context
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants.HTTP.CREATE
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants.HTTP.SUCCESS
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import br.com.redesenhe.redesenhe.service.repository.remote.RetrofitClient
import br.com.redesenhe.redesenhe.service.repository.remote.UsuarioService
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(UsuarioService::class.java)

    fun login(email: String, senha: String, listener: APIListener<InfoUsuarioModel>) {

        val obj = JsonObject()
        obj.addProperty("email", email)
        obj.addProperty("senha", senha)

        val call: Call<InfoUsuarioModel> = mRemote.login(obj)
        call.enqueue(object : Callback<InfoUsuarioModel> {
            override fun onResponse(
                call: Call<InfoUsuarioModel>,
                response: Response<InfoUsuarioModel>
            ) {
                if (response.code() != SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }

            }

            override fun onFailure(call: Call<InfoUsuarioModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })
    }

    fun create(nome: String, email: String, senha: String, listener: APIListener<InfoUsuarioModel>) {

        val obj = JsonObject()
        obj.addProperty("nome", nome)
        obj.addProperty("email", email)
        obj.addProperty("senha", senha)

        val call: Call<InfoUsuarioModel> = mRemote.create(obj)
        call.enqueue(object : Callback<InfoUsuarioModel> {
            override fun onResponse(
                call: Call<InfoUsuarioModel>,
                response: Response<InfoUsuarioModel>
            ) {
                if (response.code() != CREATE) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }

            }

            override fun onFailure(call: Call<InfoUsuarioModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })
    }
}