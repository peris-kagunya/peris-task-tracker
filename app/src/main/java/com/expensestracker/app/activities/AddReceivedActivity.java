package com.expensestracker.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.expensestracker.app.R;
import com.expensestracker.app.database.DBHelper;

public class AddReceivedActivity extends AppCompatActivity {
    EditText cash_source_txt, received_category_txt, received_amount_txt;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_received);
        dbHelper = new DBHelper(this);
        cash_source_txt = findViewById(R.id.cash_source_txt);
        received_category_txt = findViewById(R.id.cash_received_category_txt);
        received_amount_txt = findViewById(R.id.amount_receieved_txt);

        TextView errorTxtView = findViewById(R.id.receved_errorTxtView);
        Button addReceieved = findViewById(R.id.add_receieved_button);

        addReceieved.setOnClickListener(View->{
            String source = cash_source_txt.getText().toString();
            String category = received_category_txt.getText().toString();
            String amount = received_amount_txt.getText().toString();

            dbHelper.insertReceivable(source, category, amount);
            errorTxtView.setVisibility(android.view.View.VISIBLE);
            cash_source_txt.setText("");
            received_category_txt.setText("");
            received_amount_txt.setText("");
        });

    }
}