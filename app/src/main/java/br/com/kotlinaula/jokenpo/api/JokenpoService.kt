package br.com.kotlinaula.jokenpo.api

import br.com.kotlinaula.jokenpo.model.PointsResponse
import retrofit2.Call
import retrofit2.http.GET

interface JokenpoService {

    @GET("/jokenpokemon/pontuacao")
    fun getPoints(): Call<List<PointsResponse>>

}