package br.com.up.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.R
import br.com.up.pokedex.model.Pokemon
import com.squareup.picasso.Picasso
import java.util.*

class PokeAdapter(private val pokemons:List<Pokemon>, private val listener:(pokemon:Pokemon) -> Unit ) : RecyclerView.Adapter<PokeAdapter.PokeViewHolder>() {

    inner class PokeViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = layoutInflater.inflate(R.layout.poke_item_view, parent, false)
        return PokeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {

        val pokemon = pokemons[position]
        val id = pokemon.url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/","")
        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
        val imageView : ImageView = holder.itemView.findViewById(R.id.poke_image)
        val data : TextView = holder.itemView.findViewById(R.id.textView)
        data.text = pokemon.name

        imageView.setOnClickListener {
            listener(pokemon)
        }

        Picasso.get().load(url).into(imageView)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}