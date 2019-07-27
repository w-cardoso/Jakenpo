package br.com.kotlinaula.jokenpo.model

import com.google.gson.annotations.SerializedName

data class ListPointsRespponse (
    @SerializedName("content")
    val pokemons: List<PointsResponse>
)