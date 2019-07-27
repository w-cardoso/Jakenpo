package br.com.kotlinaula.jokenpo.view.ranking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.kotlinaula.jokenpo.model.PointsResponse
import br.com.kotlinaula.jokenpo.repository.JokenpoRepository

class RankingViewModel(val jokenpoRepository: JokenpoRepository) : ViewModel() {

    val points = MutableLiveData<List<PointsResponse>>()
    val messageError = MutableLiveData<String>()

    init {
        getPoints()
    }

    fun getPoints() {
        jokenpoRepository.getPoints({
            messageError.value = ""
            points.value = it

        },
            {
                messageError.value = it.message
                points.value = listOf()
            })
    }
}