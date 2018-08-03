package br.com.fiap.revisao1sem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.fiap.revisao1sem.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPokemons.adapter = ListaPokemonAdapter(
                listaPokemons(),
                this, {
            Toast.makeText(this,
                    it.nome, Toast.LENGTH_LONG).show()
        })
        val layoutManager = LinearLayoutManager(this)
        rvPokemons.layoutManager = layoutManager
    }

    private fun listaPokemons(): List<Pokemon> {
        return listOf(
                getMewtwo(),
                getMewtwo(),
                getMewtwo(),
                getMewtwo(),
                getMewtwo()
        )
    }

    private fun getMewtwo(): Pokemon {
        return Pokemon(150, "Mewtwo", "Genetic",
                "Bla bla bla",
                ContextCompat.getDrawable(this, R.drawable.mewtwo)!!)
    }
}