package com.example.a99.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.a99.database.Expense
import com.example.a99.database.ExpenseDatabase
import com.example.a99.database.ExpenseDao
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {

    private val expenseDao: ExpenseDao = ExpenseDatabase.getDatabase(application).expenseDao()
    val allExpenses: LiveData<List<Expense>> = expenseDao.getAllExpenses()

    fun insertExpense(expense: Expense) {
        viewModelScope.launch {
            expenseDao.insert(expense)
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            expenseDao.delete(expense)
        }
    }

    fun getTotalExpenseByDate(date: Long): LiveData<Double> {
        return expenseDao.getTotalExpenseByDate(date)
    }
}