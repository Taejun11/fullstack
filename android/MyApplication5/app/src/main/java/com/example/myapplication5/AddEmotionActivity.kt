package com.example.myapplication5

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.myapplication5.databinding.ActivityAddEmotionBinding

import java.text.SimpleDateFormat
import java.util.*

class AddEmotionActivity : ComponentActivity() {
    private lateinit var binding: ActivityAddEmotionBinding
    private val viewModel: EmotionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEmotionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val feelings = listOf("🙂 행복", "😢 슬픔", "😡 화남", "😨 불안", "😐 무표정")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, feelings)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFeeling.adapter = spinnerAdapter

        binding.btnSave.setOnClickListener {
            val feeling = binding.spinnerFeeling.selectedItem.toString()
            val content = binding.etContent.text.toString()
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

            if (content.isNotBlank()) {
                val emotion = Emotion(date = date, feeling = feeling, content = content)
                viewModel.addEmotion(emotion)
                finish()
            }
        }
    }
}