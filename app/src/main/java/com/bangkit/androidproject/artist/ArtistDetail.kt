package com.bangkit.androidproject.artist

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bangkit.androidproject.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ArtistDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detail)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Artist"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetNameArtist: TextView = findViewById(R.id.detail_artist_name)
        val tvSetListener: TextView = findViewById(R.id.detail_artist_listener)
        val setPhoto: ImageView = findViewById(R.id.detail_logo_artist)
        val tvSetOverview: TextView = findViewById(R.id.artist_content_detail)
        val tvSetDetail: TextView = findViewById(R.id.artist_desc_detail)

        val tName = intent.getStringExtra(EXTRA_NAME)
        val tListener = intent.getStringExtra(EXTRA_LISTENER)
        val tPhoto = intent.getStringExtra(EXTRA_PHOTO)
        val tOverview = intent.getStringExtra(EXTRA_OVERVIEW)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)

        tvSetNameArtist.text = tName
        tvSetListener.text = tListener
        Glide.with(this)
            .load(tPhoto)
            .apply(RequestOptions())
            .into(setPhoto)
        tvSetOverview.text = tOverview
        tvSetDetail.text = tDetail

    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_LISTENER = "extra_listener"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}