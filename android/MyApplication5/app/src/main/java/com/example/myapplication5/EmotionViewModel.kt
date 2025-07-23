package com.example.myapplication5

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication5.EmotionDatabase
import com.example.myapplication5.Emotion
import kotlinx.coroutines.launch
// emotion 객체 저장, 가져옴, 삭제 등의 작업을 하는 데이터베이스
class EmotionViewModel(application: Application) : AndroidViewModel(application) {
    private val emotionDao = EmotionDatabase.getDatabase(application).emotionDao()
    val emotions: LiveData<List<Emotion>> = emotionDao.getAll()

    fun addEmotion(emotion: Emotion) = viewModelScope.launch {
        emotionDao.insert(emotion)
    }

    fun deleteEmotion(emotion: Emotion) = viewModelScope.launch {
        emotionDao.delete(emotion)
    }
}