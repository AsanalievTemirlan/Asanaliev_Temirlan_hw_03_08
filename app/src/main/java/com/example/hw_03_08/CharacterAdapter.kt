package com.example.hw_03_08

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.hw_03_08.databinding.ItemListCharactersBinding

class CharacterAdapter(private var charakterList: ArrayList<CharacterModel>, val onClick: (model: CharacterModel) -> Unit) :
    Adapter<CharacterAdapter.ViewHolder>() {
    inner class ViewHolder(private var binding: ItemListCharactersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (characterModel: CharacterModel){
            binding.apply {
                characterModel.apply {
                    tvStatus.text = status
                    tvName.text = name
                    Glide.with(imgPhoto).load(image).into(imgPhoto)

                    itemView.setOnClickListener {
                        onClick.invoke(characterModel)
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return charakterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(charakterList[position])
    }
}