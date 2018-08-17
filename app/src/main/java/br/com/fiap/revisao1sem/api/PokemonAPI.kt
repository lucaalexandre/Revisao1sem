package br.com.fiap.revisao1sem.api

import br.com.fiap.revisao1sem.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonAPI{

    @GET("/api/pokemon")
    fun todosPokemons(@Query("size") size:Int) : Call<PokemonResponse>



}