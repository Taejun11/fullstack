package com.example.a99.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a99.R
import com.example.a99.adapter.ExpenseAdapter
import com.example.a99.viewmodel.ExpenseViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ExpenseViewModel
    private lateinit var expenseAdapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewModel 초기화
        viewModel = ViewModelProvider(this).get(ExpenseViewModel::class.java)

        // RecyclerView 초기화
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ExpenseAdapter 초기화
        expenseAdapter = ExpenseAdapter()
        recyclerView.adapter = expenseAdapter

        // LiveData를 통해 데이터 변경을 관찰하고 RecyclerView에 갱신
        viewModel.allExpenses.observe(this, Observer { expenses ->
            expenses?.let {
                expenseAdapter.submitList(it)
            }
        })

        // 지출 추가 버튼 (FloatingActionButton) 클릭 시 AddExpenseActivity로 이동
        val fabAddExpense = findViewById<FloatingActionButton>(R.id.fabAddExpense)
        fabAddExpense.setOnClickListener {
            val intent = Intent(this, AddExpenseActivity::class.java)
            startActivity(intent)
        }
    }
}
