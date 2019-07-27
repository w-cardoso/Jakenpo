package br.com.kotlinaula.jokenpo.view.ranking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kotlinaula.jokenpo.R
import br.com.kotlinaula.jokenpo.model.PointsResponse
import kotlinx.android.synthetic.main.item_ranking.view.*

class ListRankingAdapter(
    val points: List<PointsResponse>,
    val clickListener: (PointsResponse) -> Unit
) : RecyclerView.Adapter<ListRankingAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ranking, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return points.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = points[position]
        holder.bindView(pokemon, clickListener)
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(
            pokemon: PointsResponse,
            clickListener: (PointsResponse) -> Unit
        ) = with(itemView) {
            item_ranking_txt_name.text = pokemon.nome
            item_ranking_txt_points.text = pokemon.pontos.toString()

            setOnClickListener { clickListener(pokemon) }
        }
    }
}
