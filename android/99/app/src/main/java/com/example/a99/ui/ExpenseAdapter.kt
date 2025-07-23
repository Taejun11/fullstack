package com.example.a99.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a99.R
import com.example.a99.database.Expense
import com.example.a99.databinding.ItemExpenseBinding
import java.text.SimpleDateFormat
import java.util.*

class ExpenseAdapter(private var expenses: List<Expense>, private val onDelete: (Expense) -> Unit) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]
        holder.bind(expense)
    }

    override fun getItemCount(): Int = expenses.size

    inner class ExpenseViewHolder(private val binding: ItemExpenseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(expense: Expense) {
            binding.textViewName.text = expense.name
            binding.textViewAmount.text = "${expense.amount} 원"
            binding.textViewDate.text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(expense.date))
            binding.textViewCategory.text = expense.category

            binding.buttonDelete.setOnClickListener {
                onDelete(expense)
            }
        }
    }

    fun updateList(newExpenses: List<Expense>) {
        expenses = newExpenses
        notifyDataSetChanged()
    }
}