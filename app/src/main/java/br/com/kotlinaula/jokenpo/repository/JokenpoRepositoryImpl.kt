package br.com.kotlinaula.jokenpo.repository

import br.com.kotlinaula.jokenpo.api.JokenpoService
import br.com.kotlinaula.jokenpo.model.PointsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokenpoRepositoryImpl(private val jokenpoService: JokenpoService) : JokenpoRepository {
    override fun getPoints(onComplete: (List<PointsResponse>) -> Unit, onError: (t: Throwable) -> Unit) {
        jokenpoService
            .getPoints()
            .enqueue(object : Callback<List<PointsResponse>> {
                override fun onFailure(call: Call<List<PointsResponse>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<List<PointsResponse>>, response: Response<List<PointsResponse>>) {
                    if (response.isSuccessful) {
                        onComplete(response.body() ?: listOf())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }


            })
    }

}