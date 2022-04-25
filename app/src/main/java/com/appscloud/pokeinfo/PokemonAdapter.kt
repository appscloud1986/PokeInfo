package com.appscloud.pokeinfo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.appscloud.pokeinfo.databinding.PokemonListItemBinding

private val TAG = PokemonAdapter::class.java.simpleName

class PokemonAdapter: ListAdapter<Pokemon, PokemonAdapter.PkViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (Pokemon) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.PkViewHolder {
        val binding = PokemonListItemBinding.inflate(LayoutInflater.from(parent.context) )
        return PkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PkViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    inner class PkViewHolder(private val binding: PokemonListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon){
            binding.pokemonId.text
            binding.pokemonName.text


            binding.root.setOnClickListener{
                if (::onItemClickListener.isInitialized){
                    onItemClickListener(pokemon)
                    binding.root.setOnClickListener {
                        if (::onItemClickListener.isInitialized){
                            onItemClickListener(pokemon)
                        }else{
                            Log.e(TAG,"onItemClickListener not initialized"  )
                        }
                    }
                }
            }
        }
    }
}

