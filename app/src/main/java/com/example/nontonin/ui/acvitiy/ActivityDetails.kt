package com.example.nontonin.ui.acvitiy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nontonin.databinding.ActivityDetailsBinding

class ActivityDetails : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from intent
        val thumbnailResId = intent.getIntExtra(EXTRA_THUMBNAIL, 0)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val releaseDate = intent.getStringExtra(EXTRA_RELEASE_DATE)
        val synopsis = intent.getStringExtra(EXTRA_SYNOPSIS)

        // Bind data to views
        binding.ivThumbnail.setImageResource(thumbnailResId)
        binding.tvTitle.text = title
        binding.tvReleaseDate.text = releaseDate
        binding.tvSynopsis.text = synopsis
    }

    companion object {
        const val EXTRA_THUMBNAIL = "extra_thumbnail"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_RELEASE_DATE = "extra_release_date"
        const val EXTRA_SYNOPSIS = "extra_synopsis"
    }
}
