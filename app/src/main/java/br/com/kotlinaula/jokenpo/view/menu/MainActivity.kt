package br.com.kotlinaula.jokenpo.view.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.kotlinaula.jokenpo.R
import br.com.kotlinaula.jokenpo.view.about.AboutActivity
import br.com.kotlinaula.jokenpo.view.game.GameActivity
import br.com.kotlinaula.jokenpo.view.ranking.RankingActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn_play.setOnClickListener {
            startActivity<GameActivity>()
        }

        main_btn_exit.setOnClickListener {
            finish()
        }

        main_btn_ranking.setOnClickListener {
            startActivity<RankingActivity>()
        }

        main_btn_about.setOnClickListener {
            startActivity<AboutActivity>()
        }
    }
}