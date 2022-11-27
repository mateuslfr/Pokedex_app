package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Pokemon

class PokeStatsAdapter(private val pokemon: Pokemon) : RecyclerView.Adapter<PokeStatsAdapter.PokeStatsViewHolder>() {

    inner class PokeStatsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    //view stats
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeStatsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_text_view, parent, false)
        return PokeStatsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeStatsViewHolder, position: Int) {
        val data : TextView = holder.itemView.findViewById(R.id.data)
        //busca stats do pokemon
        data.text = String.format("${pokemon.stats[position].stat.name}: ${pokemon.stats[position].baseStat}")
    }

    override fun getItemCount(): Int {
        //pega o tamanho do array de stats
        return pokemon.stats.size
    }
}