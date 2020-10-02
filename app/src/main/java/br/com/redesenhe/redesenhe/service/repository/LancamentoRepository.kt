package br.com.redesenhe.redesenhe.service.repository

import android.content.Context
import br.com.redesenhe.redesenhe.R
import br.com.redesenhe.redesenhe.service.constants.RedesenheConstants
import br.com.redesenhe.redesenhe.service.listener.APIListener
import br.com.redesenhe.redesenhe.service.model.LancamentoModel
import br.com.redesenhe.redesenhe.service.repository.remote.LancamentoService
import br.com.redesenhe.redesenhe.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LancamentoRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(LancamentoService::class.java)

    fun findByIdObjetivo(id: Int, listener: APIListener<List<LancamentoModel>>) {
        val call: Call<List<LancamentoModel>> = mRemote.getByObjetivo(id)
        call.enqueue(object : Callback<List<LancamentoModel>> {
            override fun onResponse(
                call: Call<List<LancamentoModel>>,
                response: Response<List<LancamentoModel>>
            ) {
                if (response.code() != RedesenheConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()?.let { listener.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<List<LancamentoModel>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

        })
    }

    fun save(descricao: String, valor: Double, origem: String, destino: String, idObjetivo: Int, listener: APIListener<Void>){

        val obj = JsonObject()
        obj.addProperty("nome", descricao)
        obj.addProperty("valor", valor)
        obj.addProperty("origem", origem)
        obj.addProperty("destino", destino)
        obj.addProperty("id_objetivo", idObjetivo)

        val call: Call<Void> = mRemote.create(obj)
        call.enqueue(object : Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() != RedesenheConstants.HTTP.CREATE) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.toString(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    listener.onSuccess()
//                    response.body()?.let { listener.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

        })
    }
}