package br.com.up.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapter.PokeAbilitiesAdapter
import br.com.up.pokedex.adapter.PokeStatsAdapter
import br.com.up.pokedex.adapter.PokeTypeAdapter
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class PokemonStatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_stats)

        val pokeName : TextView = findViewById(R.id.namePokemon)
        val recyclerViewAbilities : RecyclerView = findViewById(R.id.r_pokeabilities)
        val recyclerViewStats : RecyclerView = findViewById(R.id.r_pokestats)
        val recyclerViewType : RecyclerView = findViewById(R.id.r_poketypes)
        val button : Button = findViewById(R.id.moves)
        val pokemonUrl = intent.getStringExtra("pokemonUrl")
        val pokemonId = this.getPokemonId(pokemonUrl!!)

        //usa a pokeApi o metodo getPokemon
        PokeApi().getPokemonById(pokemonId) { pokemon ->
            this.setPokeImage(pokemonId)
            //verifica se o retorno do pokemon é diferente null
            if (pokemon != null) {
                pokeName.text = pokemon.name
            }

            recyclerViewStats.adapter = PokeStatsAdapter(pokemon!!)
            recyclerViewStats.layoutManager = GridLayoutManager(this, 2)

            //recebe as type do pokemon do adapter
            recyclerViewType.adapter = PokeTypeAdapter(pokemon, findViewById(R.id.typePokemon))
            recyclerViewType.layoutManager = LinearLayoutManager(this)

            //recebe as abilities do pokemon do adapter
            recyclerViewAbilities.adapter = PokeAbilitiesAdapter(pokemon, findViewById(R.id.abilitiesPokemon))
            recyclerViewAbilities.layoutManager = GridLayoutManager(this, 2)

            //sett listener no botão para redirecionar para os moves
            button.setOnClickListener {
                val intent = Intent(this, PokemonMovesActivity::class.java)
                //botão com o array dos moves
                intent.putStringArrayListExtra("Moves", ArrayList(pokemon.moves.map { pokemonMoves ->  pokemonMoves.move.name }))
                startActivity(intent)
            }
        }
    }
    //coloca imagem pokemon
    private fun setPokeImage(id: String) {
        val imageView : ImageView = findViewById(R.id.pokemon_png)
        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
        Picasso.get().load(url).into(imageView)
    }
    //pega pokemon pelo id
    private fun getPokemonId(url: String): String {
        return url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/","")
    }
}