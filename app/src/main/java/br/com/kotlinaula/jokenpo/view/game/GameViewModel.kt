package br.com.kotlinaula.jokenpo.view.game

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.kotlinaula.jokenpo.repository.JokenpoRepository

class GameViewModel(val jokenpoRepository: JokenpoRepository) : ViewModel() {
    val playerOne = MutableLiveData<Int>()
    val computer = MutableLiveData<Int>()


}