package com.example.moviewatchlist

import android.animation.LayoutTransition
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviewatchlist.databinding.LayoutMovieItemBinding

class MoviesAdapter (val movieList:MutableList<Movie>): RecyclerView.Adapter <MoviesViewHolder>() {

    private lateinit var  itemClickListener:(Movie,Int) -> Unit




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoviesViewHolder(binding)
    }

    fun setOnItemClickListener(ClickListener:(Movie,Int) -> Unit){
        itemClickListener = ClickListener
    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        Glide.with(holder.itemView.context).load(movie.picture).into(holder.binding.IVMoviePoster)
        holder.binding.TWMovieName.text = movie.movieName

        holder.binding.TWMovieName.setOnClickListener {
            itemClickListener.invoke(movie,movieList.indexOf(movie))
        }

        holder.binding.IVMoviePoster.setOnClickListener {
            itemClickListener.invoke(movie,movieList.indexOf(movie))
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}


data class Movie(
    val movieName:String,
    val picture:String,
    )

class MoviesViewHolder(val binding: LayoutMovieItemBinding):RecyclerView.ViewHolder (binding.root)