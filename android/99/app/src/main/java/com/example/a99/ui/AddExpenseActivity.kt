package com.example.a99.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.a99.R
import com.example.a99.database.Expense
import com.example.a99.viewmodel.ExpenseViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var viewModel: ExpenseViewModel
    private lateinit var categorySpinner: Spinner
    private lateinit var dateTextView: TextView
    private var selectedDate: Long = System.currentTimeMillis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val nameEditText: EditText = findViewById(R.id.editTextName)
        val amountEditText: EditText = findViewById(R.id.editTextAmount)
        val buttonSave: Button = findViewById(R.id.buttonSave)
        categorySpinner = findViewById(R.id.spinnerCategory)
        dateTextView = findViewById(R.id.textViewDate)

        val categories = arrayOf("식비", "교통비", "기타")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        categorySpinner.adapter = adapter

        dateTextView.setOnClickListener {
            showDatePickerDialog()
        }

        buttonSave.setOnClickListener {
            val name = nameEditText.text.toString()
            val amount = amountEditText.text.toString().toDoubleOrNull() ?: 0.0
            val category = categorySpinner.selectedItem.toString()

            if (name.isNotEmpty() && amount > 0) {
                val expense = Expense(name = name, amount = amount, date = selectedDate, category = category)
                viewModel.insertExpense(expense)
                finish()
            } else {
                Toast.makeText(this, "항목명과 금액을 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDateStr = "$selectedYear-${selectedMonth + 1}-$selectedDay"
            selectedDate = Calendar.getInstance().apply {
                set(selectedYear, selectedMonth, selectedDay)
            }.timeInMillis
            dateTextView.text = selectedDateStr
        }, year, month, day)

        datePickerDialog.show()
    }
}