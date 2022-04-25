package com.appscloud.pokeinfo.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appscloud.pokeinfo.Pokemon
import com.appscloud.pokeinfo.api.service
import kotlinx.coroutines.*
import org.json.JSONObject

class MainViewModel:ViewModel() {


    private var _pokemonList = MutableLiveData<MutableList<Pokemon>>()
    val pokemonList: LiveData<MutableList<Pokemon>>
    get() = _pokemonList


    init {
        viewModelScope.launch {


            _pokemonList.value = fetchPokemon()
        }
    }

    private suspend fun fetchPokemon(): MutableList<Pokemon> {
        return withContext(Dispatchers.IO){
            val pokemonListString = service.getPokemonList()


            Log.d("Manzana", pokemonListString)
            val pkList = parsePkResult(pokemonListString)
            pkList
        }
    }

    private fun parsePkResult(pokemonListString: String): MutableList<Pokemon> {
        val pkJsonObject = JSONObject(pokemonListString)
        val resultsJsonArray = pkJsonObject.getJSONArray("results")

        val pkList = mutableListOf<Pokemon>()

        for (i in 0 until resultsJsonArray.length()){
            val resultsJsonObject = resultsJsonArray[i] as JSONObject


            val name = resultsJsonObject.getString("name")
            val url = resultsJsonObject.getString("url")

            val pokemon = Pokemon(name, url)
            pkList.add(pokemon)


        }

        return pkList
    }
}
































/*
                Pokemon( 1, "Pikachu", 45, 98, 50, 85,Pokemon.PokemonType.ELECTRIC, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/hc_1440x810/public/media/image/2018/08/pikachu_4.jpg?itok=ZcQ-nORz"),
                Pokemon( 2, "Mewtwo", 45, 49, 50, 85,Pokemon.PokemonType.FIGHTER, "https://as01.epimg.net/meristation/imagenes/2018/09/21/noticias/1537554534_009896_1537554573_noticia_normal.jpg"),
                Pokemon( 3, "Charmander", 45, 49, 50, 85,Pokemon.PokemonType.FIRE, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/980px/public/media/image/2022/04/pokemon-charmander-2674695.jpg?itok=lJ9Gv99g"),
                Pokemon( 4, "Pichu", 47, 28, 50, 85,Pokemon.PokemonType.GRASS, "https://www.seekpng.com/png/detail/193-1938104_pichu-pokemones-pichu.png"),
                Pokemon( 5, "Mew", 12, 48, 50, 85,Pokemon.PokemonType.FIGHTER,"https://www.dexerto.es/wp-content/uploads/sites/3/2020/04/mew.jpg"))
 */