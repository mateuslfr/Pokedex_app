package br.com.up.pokedex.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Pokemon
import java.util.*

class PokeTypeAdapter(private val pokemon: Pokemon, private val pokeType : TextView) : RecyclerView.Adapter<PokeTypeAdapter.PokeTypeViewHolder>() {

    inner class PokeTypeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    //view type
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeTypeViewHolder {
        pokeType.text = "Type"
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_text_view, parent, false)
        return PokeTypeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeTypeViewHolder, position: Int) {
        val data : TextView = holder.itemView.findViewById(R.id.data)
        //busca o/os type/s do pokemon
        data.text = pokemon.types[position].type.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()) else it.toString() }
    }

    override fun getItemCount(): Int {
        //pega o tamanho do array de type
        return pokemon.types.size
    }
}