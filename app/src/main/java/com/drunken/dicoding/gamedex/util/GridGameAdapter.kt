package com.drunken.dicoding.gamedex.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.drunken.dicoding.gamedex.databinding.GameItemGridBinding
import com.drunken.dicoding.gamedex.databinding.GameItemLayoutBinding
import com.drunken.dicoding.gamedex.models.Game

class GridGameAdapter (private val gameList : List<Game>) : RecyclerView.Adapter<GridGameAdapter.GridGameViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    class GridGameViewHolder(private val binding: GameItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gameModel : Game){

            Glide.with(itemView.context)
                .load(gameModel.image)
                .centerCrop()
                .into(binding.ivGame)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridGameViewHolder {
        return GridGameViewHolder(GameItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GridGameViewHolder, position: Int) {
        holder.bind(gameList[position])

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(gameList[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    interface OnItemClickListener{
        fun onItemClicked(data : Game)
    }
}