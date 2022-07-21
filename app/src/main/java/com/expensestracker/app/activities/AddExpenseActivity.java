package com.expensestracker.app.activities;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.expensestracker.app.R;
import com.expensestracker.app.database.DBHelper;

public class AddExpenseActivity extends AppCompatActivity {

    EditText itemNameEdx, itemCategoryEdx, venueEdx, amountEdx;
    Button submitBtn;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        itemNameEdx = findViewById(R.id.item_purchased_txt);
        itemCategoryEdx =findViewById(R.id.purchased_item_category_txt);
        venueEdx = findViewById(R.id.place_of_purchased_txt);
        amountEdx = findViewById(R.id.amount_used_in_purchase_txt);

        dbHelper = new DBHelper(this);

        TextView errorTxtView = findViewById(R.id.add_expense_errorTxtView);

        submitBtn = findViewById(R.id.add_expense_button);
        submitBtn.setOnClickListener(View->{
            String itemName = itemNameEdx.getText().toString();
            String itemCategory = itemCategoryEdx.getText().toString();
            String itemVenue = venueEdx.getText().toString();
            String amountUsed = amountEdx.getText().toString();

//            insertExpense(String item_name, String item_category, String venue, String amount)
            dbHelper.insertExpense(itemName, itemCategory, itemVenue, amountUsed);
//            Toast.makeText(this, "NAme: "+itemName+"\nCategory: "+itemCategory+"\nVenue: "+itemVenue+"\nAmount: "+amountUsed+"\nResult: "+res, Toast.LENGTH_SHORT).show();
            errorTxtView.setVisibility(android.view.View.VISIBLE);
            itemNameEdx.setText("");
            itemCategoryEdx.setText("");
            venueEdx.setText("");
            amountEdx.setText("");
        });
    }
}