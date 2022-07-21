package com.expensestracker.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.expensestracker.app.R;
import com.expensestracker.app.adapters.ViewExpensesAdapter;
import com.expensestracker.app.database.DBHelper;
import com.expensestracker.app.items.Expense;

import java.util.ArrayList;
import java.util.List;

public class ViewExpensesActivity extends AppCompatActivity {

    List<Expense> expenseList;
    ViewExpensesAdapter adapter;
    DBHelper  dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expenses);

        ListView listView = findViewById(R.id.view_expenses_listView);
        getExpenses();
        adapter = new ViewExpensesAdapter(this, expenseList);
        listView.setAdapter(adapter);

        ImageView goBackImageView = findViewById(R.id.view_expenses_back_ImageView);
        goBackImageView.setOnClickListener(View->{
            super.onBackPressed();
        });

        double totalExpenses = findTotalExpenses();
        TextView viewTotal = findViewById(R.id.view_expense_total_TextView);
        viewTotal.setText("Total Spent: KSh "+totalExpenses);

    }

    private double findTotalExpenses() {
        double total = 0;
        for (Expense expense: expenseList){
            total +=expense.getAmountUsed();
        }
        return total;
    }

    private void getExpenses() {
        dbHelper = new DBHelper(this);
        expenseList = dbHelper.getExpenses();
    }
}