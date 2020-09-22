package br.com.redesenhe.redesenhe.service.repository

import android.content.Context
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants.SHARED.TOKEN
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.model.InfoUsuarioModel
import br.com.redesenhe.redesenhe.service.model.ObjetivoModel
import br.com.redesenhe.redesenhe.service.repository.local.SecurityPreferences
import br.com.redesenhe.redesenhe.service.repository.remote.ObjetivoService
import br.com.redesenhe.redesenhe.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigDecimal

class ObjetivoRepository(val context: Context){

    private val mRemote = RetrofitClient.createService(ObjetivoService::class.java)

    fun all(listener: APIListener<List<ObjetivoModel>>){
        val call: Call<List<ObjetivoModel>> = mRemote.getAll()
        call.enqueue(object : Callback<List<ObjetivoModel>>{
            override fun onResponse(
                call: Call<List<ObjetivoModel>>,
                response: Response<List<ObjetivoModel>>
            ) {
                if (response.code() != RedesenheConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<List<ObjetivoModel>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })
    }

    fun findById(id: Int, listener: APIListener<ObjetivoModel>){
        val call: Call<ObjetivoModel> = mRemote.getById(id)
        call.enqueue(object : Callback<ObjetivoModel>{
            override fun onResponse(
                call: Call<ObjetivoModel>,
                response: Response<ObjetivoModel>
            ) {
                if (response.code() != RedesenheConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<ObjetivoModel>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

        })
    }

    fun save(descricao: String, objetivo: Double, listener: APIListener<Void>) {

        val obj = JsonObject()
        obj.addProperty("nome", descricao)
        obj.addProperty("objetivo", objetivo)

        val call: Call<Void> = mRemote.create(obj)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(
                call: Call<Void>,
                response: Response<Void>
            ) {
                if (response.code() != RedesenheConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }

            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }
        })
    }
}