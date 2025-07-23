package com.example.myapplication5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myapplication5.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: EmotionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = EmotionAdapter { emotion -> viewModel.deleteEmotion(emotion) }
        binding.rvEmotions.layoutManager = LinearLayoutManager(this)
        binding.rvEmotions.adapter = adapter

        viewModel.emotions.observe(this) {
            adapter.submitList(it)
        }

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddEmotionActivity::class.java))
        }
    }
}