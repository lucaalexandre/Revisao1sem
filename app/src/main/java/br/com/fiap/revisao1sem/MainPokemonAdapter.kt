package br.com.fiap.revisao1sem

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fiap.revisao1sem.api.getPicassoAuth
import br.com.fiap.revisao1sem.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_item.view.*

class ListaPokemonAdapter(private val pokemons: List<Pokemon>,
                          private val context: Context,
                          val listener: (Pokemon) -> Unit) : Adapter<ListaPokemonAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder?.let {
            it.bindView(pokemon, listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(pokemon: Pokemon,
                     listener: (Pokemon) -> Unit) = with(itemView) {

            getPicassoAuth(itemView.context)
                    .load("https://pokedexdx.herokuapp.com${pokemon.urlImagem}")
                    .error(R.drawable.pikachu_triste)
                    .placeholder(R.drawable.pokebola)
                    .into(ivPokemon)
            tvNomePokemon.text = pokemon.name
            tvNumeroPokemon.text = pokemon.numero


            setOnClickListener { listener(pokemon) }
        }
    }
}
