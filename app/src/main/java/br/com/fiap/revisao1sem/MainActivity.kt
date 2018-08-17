package br.com.fiap.revisao1sem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.InputQueue
import android.widget.Toast
import br.com.fiap.revisao1sem.api.getPokemonApi
import br.com.fiap.revisao1sem.model.Pokemon
import br.com.fiap.revisao1sem.model.PokemonResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregaPokemons()

    }

    private fun exibeNaLista(pokemons: List<Pokemon>){
        rvPokemons.adapter = ListaPokemonAdapter(
                pokemons,
                this, {
            Toast.makeText(this,
                    it.nome, Toast.LENGTH_LONG).show()
        })
        val layoutManager = LinearLayoutManager(this)
        rvPokemons.layoutManager = layoutManager

    }

    private fun carregaPokemons() {

        getPokemonApi()
                .todosPokemons(150)
                .enqueue(object : Callback<PokemonResponse> {
                    override fun onFailure(call: Call<PokemonResponse>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<PokemonResponse>?, response: Response<PokemonResponse>?) {
                      if(response!!.isSuccessful){
                      exibeNaLista(response.body()!!.content)
                      }
                    }
                })


    }
}