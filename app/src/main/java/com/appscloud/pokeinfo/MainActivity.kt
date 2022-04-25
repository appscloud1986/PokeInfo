package com.appscloud.pokeinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.appscloud.pokeinfo.databinding.ActivityMainBinding
import com.appscloud.pokeinfo.main.MainViewModel

class MainActivity : AppCompatActivity(), ListFragment.PokemonSelectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val adapter = PokemonAdapter()
        binding.mainNavigationContainer

        viewModel.pokemonList.observe(this, Observer {
            pokemonList ->
            adapter.submitList(pokemonList)

            handleEmptyView(pokemonList, binding)
        })











    }

    private fun handleEmptyView(
        pokemonList: MutableList<Pokemon>,
        binding: ActivityMainBinding
    ) {
        if (pokemonList.isEmpty()) {
            binding.pkEmptyView.visibility = View.VISIBLE

        } else {
            binding.pkEmptyView.visibility = View.GONE

        }
    }

   override fun onPokemonSelected(pokemon: Pokemon) {
        findNavController(R.id.main_navigation_container).navigate(ListFragmentDirections.actionListFragmentToPokemonDetailFragment(pokemon))

    }


}
