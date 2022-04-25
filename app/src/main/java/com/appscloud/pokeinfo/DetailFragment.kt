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
import androidx.databinding.DataBindingUtil
import com.appscloud.pokeinfo.databinding.FragmentListBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class DetailFragment : Fragment() {

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
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        imageView = rootView.findViewById(R.id.fragment_detail_image)
        hpText = rootView.findViewById(R.id.fragment_detail_hp)
        attackText = rootView.findViewById(R.id.fragment_detail_attack)
        defenseText = rootView.findViewById(R.id.fragment_detail_defense)
        speedText = rootView.findViewById(R.id.fragment_detail_speed)
        loadingWheel = rootView.findViewById(R.id.loading_wheel)


        return rootView
    }
}

   /* fun setPokemonData(pokemon: Pokemon){
        loadingWheel.visibility = View.VISIBLE
        Glide.with(this).load(pokemon.url).listener(object : RequestListener<Drawable>{
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                loadingWheel.visibility = View.GONE
                imageView.setImageResource(R.drawable.ic_image_not_supported_fill0_wght400_grad0_opsz48)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                loadingWheel.visibility = View.GONE
                return false
            }
        }).error(R.drawable.ic_image_not_supported_fill0_wght400_grad0_opsz48).into(imageView)



        hpText.text = getString(R.string.hp_format, pokemon.hp)
        attackText.text = getString(R.string.attack_format, pokemon.attack)
        defenseText.text = getString(R.string.defense_format, pokemon.defense)
        speedText.text = getString(R.string.speed_format, pokemon.speed)
    }
}

    */