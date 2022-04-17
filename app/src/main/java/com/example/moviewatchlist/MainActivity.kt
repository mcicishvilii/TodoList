package com.example.moviewatchlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviewatchlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RVMovies.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.RVMovies.adapter = MoviesAdapter(
            mutableListOf(
                Movie(
                    "Total recall",
                    "https://i.scdn.co/image/ab67616d0000b273f528e423cc48728f36f7c353",
                ),
                Movie(
                    "Shawshank redemption",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie(
                    "Leon the professional",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie(
                    "Inception",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie("Usual suspects", "https://flxt.tmsimg.com/assets/p16422_p_v8_ag.jpg"),
                Movie("The Shining", "https://movieposters2.com/images/1511858-b.jpg"),
                Movie("American beauty", "https://flxt.tmsimg.com/assets/p23514_p_v12_ah.jpg"),
                Movie(
                    "Dark knight",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie(
                    "Dark knight",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
            )).apply {
            setOnItemClickListener {movie: Movie, i: Int ->
                movieList.add(i,
                    Movie("The Shining", "https://movieposters2.com/images/1511858-b.jpg")
                )
                notifyItemInserted(0)
            }
        }

    }
}