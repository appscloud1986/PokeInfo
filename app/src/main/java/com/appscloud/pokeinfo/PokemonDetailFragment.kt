package com.appscloud.pokeinfo

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class PokemonDetailFragment : Fragment() {

    private val args: PokemonDetailFragmentArgs by navArgs()

    private lateinit var imageView: ImageView
    private lateinit var hpText: TextView
    private lateinit var attackText: TextView
    private lateinit var defenseText: TextView
    private lateinit var speedText: TextView
    private lateinit var loadingWheel: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_pokemon_detail, container, false)

        val pokemon = args.pokemon
        imageView = rootView.findViewById(R.id.fragment_detail_image)
        hpText = rootView.findViewById(R.id.fragment_detail_hp)
        attackText = rootView.findViewById(R.id.fragment_detail_attack)
        defenseText = rootView.findViewById(R.id.fragment_detail_defense)
        speedText = rootView.findViewById(R.id.fragment_detail_speed)
        loadingWheel = rootView.findViewById(R.id.loading_wheel)


        setupToolbar(rootView, pokemon.name)
        return rootView
    }

    private fun setupToolbar(rootView: View?, name: String) {
        val toolbar = rootView?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.detail_toolbar)
        if (toolbar != null) {
            toolbar.title = name

        }
        toolbar?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar?.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }


}

