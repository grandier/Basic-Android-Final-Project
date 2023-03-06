package com.bangkit.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.androidproject.artist.Artist
import com.bangkit.androidproject.artist.ArtistAdapter
import com.bangkit.androidproject.artist.ArtistData

class MainActivity : AppCompatActivity() {
    private lateinit var rvArtist: RecyclerView
    private var list: ArrayList<Artist> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "Artist"

        rvArtist = findViewById(R.id.rv_artist)
        rvArtist.setHasFixedSize(true)

        list.addAll(ArtistData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvArtist.layoutManager = LinearLayoutManager(this)
        val artistAdapter = ArtistAdapter(list)
        rvArtist.adapter = artistAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        Toast.makeText(this, "Hore Berhasil", Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val About = Intent(this@MainActivity,
                    ProfileActivity::class.java)
                startActivity(About)
            }
        }
    }

}