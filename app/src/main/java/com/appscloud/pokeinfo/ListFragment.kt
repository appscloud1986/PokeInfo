package com.appscloud.pokeinfo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appscloud.pokeinfo.api.service
import com.appscloud.pokeinfo.databinding.FragmentListBinding
import java.lang.ClassCastException

class ListFragment : Fragment() {

    interface PokemonSelectListener {
        fun onPokemonSelected(pokemon: Pokemon)
    }

    private lateinit var pokemonSelectListener: PokemonSelectListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokemonSelectListener = try {
            context as PokemonSelectListener

        }catch (e: ClassCastException){
            throw ClassCastException("$context must implement PokemonSelecListener")


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.pokemon_recycler)
        recycler.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recycler.adapter = adapter

        adapter.onItemClickListener = {
            pokemonSelectListener.onPokemonSelected(it)
            (activity as MainActivity)

        }





        return  view


    }
}