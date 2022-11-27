package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import java.util.*

class PokeMovesAdapter(private val pokemonMoves: ArrayList<String>) : RecyclerView.Adapter<PokeMovesAdapter.PokeMovesViewHolder>() {

    inner class PokeMovesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    //view moves
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeMovesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_text_view, parent, false)
        return PokeMovesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeMovesViewHolder, position: Int) {
        val data : TextView = holder.itemView.findViewById(R.id.data)
        //busca os moves do pokemon
        data.text = pokemonMoves[position].replaceFirstChar { if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()) else it.toString() }
    }

    override fun getItemCount(): Int {
        //pega o tamanho do array dos moves do pokemon
        return pokemonMoves.size
    }
}