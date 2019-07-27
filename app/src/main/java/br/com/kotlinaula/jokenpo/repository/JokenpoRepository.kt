package br.com.kotlinaula.jokenpo.repository

import br.com.kotlinaula.jokenpo.model.PointsResponse

interface JokenpoRepository {
    fun getPoints(
        onComplete: (List<PointsResponse>) -> Unit,
        onError: (t: Throwable) -> Unit
    )
}