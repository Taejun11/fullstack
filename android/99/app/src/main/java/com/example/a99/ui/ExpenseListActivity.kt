package com.example.a99.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a99.R
import com.example.a99.database.Expense
import com.example.a99.viewmodel.ExpenseViewModel

class ExpenseListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var totalExpenseTextView: TextView
    private lateinit var viewModel: ExpenseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_list)

        recyclerView = findViewById(R.id.recyclerView)
        totalExpenseTextView = findViewById(R.id.textViewTotalExpense)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ExpenseAdapter(emptyList()) { expense ->
            viewModel.deleteExpense(expense)
        }
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(ExpenseViewModel::class.java)

        viewModel.allExpenses.observe(this, Observer { expenses ->
            expenses?.let {
                adapter.updateList(it)
            }
        })

        // 날짜별 지출 총합 표시
        val selectedDate = System.currentTimeMillis()
        viewModel.getTotalExpenseByDate(selectedDate).observe(this, Observer { total ->
            totalExpenseTextView.text = "총 지출: ${total ?: 0.0} 원"
        })
    }
}