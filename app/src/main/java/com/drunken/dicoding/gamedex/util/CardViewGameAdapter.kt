package com.drunken.dicoding.gamedex.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.drunken.dicoding.gamedex.databinding.GameItemLayoutBinding
import com.drunken.dicoding.gamedex.models.Game

class CardViewGameAdapter (private val gameList : List<Game>) : RecyclerView.Adapter<CardViewGameAdapter.CardViewViewHolder>() {

    private lateinit var onItemClickListener : OnItemClickListener

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickListener){
        this.onItemClickListener = onItemClickCallback
    }

    class CardViewViewHolder(private val binding: GameItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gameModel : Game){
            with(binding){
                gameItemName.text = gameModel.name
                gameItemPublisher.text = gameModel.publisher
                gameItemRating.rating = gameModel.rating/2
            }

            Glide.with(itemView.context)
                .load(gameModel.image)
                .centerCrop()
                .into(binding.gameItemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        return CardViewViewHolder(GameItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(gameList[position])

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(gameList[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    interface OnItemClickListener {
        fun onItemClicked(data : Game)
    }
}