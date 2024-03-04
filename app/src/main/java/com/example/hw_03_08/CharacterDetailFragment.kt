package com.example.hw_03_08

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.hw_03_08.databinding.FragmentCharacterDetailBinding


class CharacterDetailFragment : Fragment() {

    lateinit var binding: FragmentCharacterDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("character") as CharacterModel
        binding.apply {
            tvNameFromMain.text = data.name
            tvStatusFromMain.text = data.status
            Glide.with(imgFromMain).load(data.image).into(imgFromMain)
        }
    }

}