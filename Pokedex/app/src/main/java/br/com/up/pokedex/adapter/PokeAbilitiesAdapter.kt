package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Pokemon

class PokeAbilitiesAdapter(private val pokemon: Pokemon, private val pokeAbility : TextView) : RecyclerView.Adapter<PokeAbilitiesAdapter.PokeAbilitiesViewHolder>() {

    inner class PokeAbilitiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    //view habilidades
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeAbilitiesViewHolder {
        pokeAbility.text = "Abilities"
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_text_view, parent, false)
        return PokeAbilitiesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeAbilitiesViewHolder, position: Int) {
        val data : TextView = holder.itemView.findViewById(R.id.data)
        //busca nome da habilidade e salva em var
        data.text = pokemon.abilities[position].ability.name

    }

    override fun getItemCount(): Int {
        //pega o tamanho do array de habilidades
        return pokemon.abilities.size
    }
}