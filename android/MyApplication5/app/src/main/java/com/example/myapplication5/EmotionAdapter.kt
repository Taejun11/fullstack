package com.example.myapplication5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication5.databinding.ItemEmotionBinding
import com.example.myapplication5.Emotion

// 감정 데이터, RecycleView의 시각적 표현 사이를 연결
// RecycleView가 각 항목 뷰를 효율적으로 재활용 할 수 있도록 EmotionViewHolder를 생성 관리
class EmotionAdapter(
    private val onDelete: (Emotion) -> Unit
) : ListAdapter<Emotion, EmotionAdapter.EmotionViewHolder>(DiffCallback) {
// 삭제
    inner class EmotionViewHolder(private val binding: ItemEmotionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(emotion: Emotion) {
            binding.tvDate.text = emotion.date
            binding.tvFeeling.text = emotion.feeling
            binding.tvContent.text = emotion.content
            binding.btnDelete.setOnClickListener { onDelete(emotion) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmotionViewHolder {
        val binding = ItemEmotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmotionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmotionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Emotion>() {
            override fun areItemsTheSame(oldItem: Emotion, newItem: Emotion) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Emotion, newItem: Emotion) = oldItem == newItem
        }
    }
}