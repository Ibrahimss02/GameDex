package com.drunken.dicoding.gamedex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.drunken.dicoding.gamedex.R
import com.drunken.dicoding.gamedex.databinding.ActivityGameDetailBinding
import com.drunken.dicoding.gamedex.models.Game

class GameDetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGameDetailBinding
    private var game : Game? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(MainActivity.INTENT_TO_DETAIL)){
            game = intent.getParcelableExtra(MainActivity.INTENT_TO_DETAIL)
            supportActionBar!!.title = game!!.name
            setupGameDetail()
        }

        binding.likeBtn.setOnClickListener(this)
        binding.shareBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.like_btn -> {
                Toast.makeText(this, "You just liked game ${game!!.name}", Toast.LENGTH_SHORT).show()
            }
            R.id.share_btn -> {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Hey, check this game out.\nName ${game!!.name}.\n${game!!.description}.\nRating : ${game!!.rating} by IGN.\nPublished by : ${game!!.publisher}.")
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent,  "Share game"))
            }
        }
    }

    private fun setupGameDetail() {
        with(binding){
            tvJudulGame.text = game!!.name
            tvDescriptionGame.text = game!!.description
            val publisher = "Publisher : ${game!!.publisher}"
            tvPublisherGame.text = publisher
            ratingBar.rating = game!!.rating/2
        }

        Glide.with(this).load(game!!.image).centerCrop().into(binding.gameDetailImage)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}