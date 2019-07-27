package br.com.kotlinaula.jokenpo.view.game

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.kotlinaula.jokenpo.R
import kotlinx.android.synthetic.main.activity_game.*
import org.koin.android.viewmodel.ext.android.viewModel

class GameActivity : AppCompatActivity() {

    private val gameViewModel: GameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        game_img_paper.setOnClickListener {
            game_img_player.setImageResource(R.drawable.papel)
            game_img_computer.setImageResource(sorteiaImagem())
        }

        game_img_stone.setOnClickListener {
            game_img_player.setImageResource(R.drawable.pedra)

        }

        game_img_scissors.setOnClickListener {
            game_img_player.setImageResource(R.drawable.tesoura)

        }

        gameViewModel.playerOne.observe(this, Observer {

        })

        gameViewModel.computer.observe(this, Observer {

        })
    }

    private fun sorteiaImagem(): Int {
        var result = 0

        return result
    }
}


