package com.example.hw_03_08

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw_03_08.databinding.FragmentCharactersBinding


class CharactersFragment : Fragment() {

    lateinit var binding: FragmentCharactersBinding
    private val charactersList = arrayListOf(
        CharacterModel(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSauq04SQwjZwgb2-FK_wRzY_oIOWznOxE63w&usqp=CAU",
            "Alive",
            "Morty Smith"
        ),
        CharacterModel(
            "https://hips.hearstapps.com/hmg-prod/images/rick-and-morty-image-1662104014.jpg?crop=0.315xw:0.560xh;0.351xw,0.168xh&resize=980:*",
            "Alive",
            "Rick Sanchez"
        ),
        CharacterModel(
            "https://i.pinimg.com/1200x/c5/be/4f/c5be4f955700ca3aad43cc2ac2d78015.jpg",
            "Alive",
            "Jerry Smith"
        ),
        CharacterModel(
            "https://sportshub.cbsistatic.com/i/2023/08/24/125a5b28-9054-47a2-bec5-a4a79d773314/rick-and-morty-season-7-preview-evil-summer.jpg",
            "Alive",
            "Summer Smith"
        ),
        CharacterModel(
            "https://static.wikia.nocookie.net/villains/images/5/58/Rick_Prime_S3.jpeg/revision/latest?cb=20230719184835",
            "Dead",
            "Rick Prime"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

    }

    fun initAdapter() {
        val adapter = CharacterAdapter(charactersList, this::onClick)
        binding.rvCharacters.adapter = adapter
    }

    private fun onClick(characterModel: CharacterModel) {
        //                             blankFragment это CharacterDetailFragment
        findNavController().navigate(R.id.blankFragment, bundleOf("character" to characterModel))
//        findNavController().navigate(R.id.blankFragment)
    }

}