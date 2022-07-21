package com.expensestracker.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.expensestracker.app.R;
import com.expensestracker.app.adapters.ViewReceivablesAdapter;
import com.expensestracker.app.database.DBHelper;
import com.expensestracker.app.items.Expense;
import com.expensestracker.app.items.Receivable;

import java.util.ArrayList;
import java.util.List;

public class ViewReceivablesActivity extends AppCompatActivity {
    List<Receivable> receivables;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_receivables);

        ListView listView = findViewById(R.id.receivable_listView);
        getReceivables();
        ViewReceivablesAdapter adapter = new ViewReceivablesAdapter(this, receivables);
        listView.setAdapter(adapter);

        double totalReceived = findTotalReceived();
        TextView viewTotal = findViewById(R.id.view_received_total_TextView);
        viewTotal.setText("Total Received: KSh "+totalReceived);

        ImageView imageView = findViewById(R.id.view_receivables_back_ImageView);
        imageView.setOnClickListener(View->{
            super.onBackPressed();
        });
    }

    private double findTotalReceived() {
        double total = 0;
        for (Receivable receivable: receivables){
            total += Integer.parseInt(receivable.getAmount());
        }
        return total;
    }

    private void getReceivables() {
//        Receivable(String date, String time, String source, String category, int amount
        dbHelper = new DBHelper(this);
        receivables = dbHelper.getReceivables();
    }
}