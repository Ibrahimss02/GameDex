package com.drunken.dicoding.gamedex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.drunken.dicoding.gamedex.R
import com.drunken.dicoding.gamedex.databinding.ActivityMainBinding
import com.drunken.dicoding.gamedex.models.Game
import com.drunken.dicoding.gamedex.models.GameData
import com.drunken.dicoding.gamedex.util.CardViewGameAdapter
import com.drunken.dicoding.gamedex.util.GridGameAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var listGame : ArrayList<Game> = arrayListOf()

    companion object{
        const val INTENT_TO_DETAIL = "game_data_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMainActivity.setHasFixedSize(true)

        listGame.addAll(GameData.listData)
        setupRecycleViewCardView()
    }

    private fun setupRecycleViewCardView() {
        binding.rvMainActivity.layoutManager = LinearLayoutManager(this)
        val adapter = CardViewGameAdapter(listGame)
        binding.rvMainActivity.adapter = adapter

        adapter.setOnItemClickCallback(object : CardViewGameAdapter.OnItemClickListener{
            override fun onItemClicked(data: Game) {
                showGameDetail(data)
            }
        })
    }

    private fun showGameDetail(data : Game){
        val intent = Intent(this, GameDetailActivity::class.java)
        intent.putExtra(INTENT_TO_DETAIL, data)
        startActivity(intent)
        onPause()
    }

    private fun setupRecycleViewGrid(){
        binding.rvMainActivity.layoutManager = GridLayoutManager(this, 2)
        val adapter = GridGameAdapter(listGame)
        binding.rvMainActivity.adapter = adapter

        adapter.setOnItemClickListener(object : GridGameAdapter.OnItemClickListener{
            override fun onItemClicked(data: Game) {
                showGameDetail(data)
            }
        })
    }

    private fun setMode(selectedMode : Int){
        when(selectedMode){
            R.id.menu_nav_home_cv -> {
                setupRecycleViewCardView()
            }
            R.id.menu_nav_home_grid -> {
                setupRecycleViewGrid()
            }
            R.id.menu_nav_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                onPause()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
}