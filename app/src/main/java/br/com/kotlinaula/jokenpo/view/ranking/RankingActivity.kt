package br.com.kotlinaula.jokenpo.view.ranking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ranking.*
import org.koin.android.viewmodel.ext.android.viewModel


class RankingActivity : AppCompatActivity() {

    private val rankingViewModel: RankingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(br.com.kotlinaula.jokenpo.R.layout.activity_ranking)

        rankingViewModel.points.observe(this, Observer {
            rcv_ranking.adapter = ListRankingAdapter(it) {}
            rcv_ranking.layoutManager = LinearLayoutManager(this)
        })

    }
}
