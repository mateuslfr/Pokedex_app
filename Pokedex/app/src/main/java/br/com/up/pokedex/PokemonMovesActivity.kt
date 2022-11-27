package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.adapter.PokeMovesAdapter
import java.util.ArrayList

class PokemonMovesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_moves)
        //recebe o array de moves da intent enviada pelo botão
        val pokemonMoves = intent.getStringArrayListExtra("Moves") as ArrayList<String>
        val recyclerViewMoves : RecyclerView = findViewById(R.id.r_pokemoves)
        //recebe os moves do pokemon da resposta do adapter
        recyclerViewMoves.adapter = PokeMovesAdapter(pokemonMoves)
        recyclerViewMoves.layoutManager = GridLayoutManager(this, 2)
    }
}