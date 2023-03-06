package com.bangkit.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bangkit.androidproject.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val actionbar = supportActionBar
        actionbar!!.title = "Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val profilePic: ImageView = findViewById(R.id.profilePic)

        profilePic.setImageResource(R.drawable.profile_pic)
    }

    override fun onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }
}