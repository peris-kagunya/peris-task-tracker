package com.expensestracker.app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.expensestracker.app.R;
import com.expensestracker.app.adapters.HomeLinkAdapter;
import com.expensestracker.app.database.DBHelper;
import com.expensestracker.app.items.HomeLink;
import com.expensestracker.app.utilities.MyUtility;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    List<HomeLink> homeLinks;
    HomeLinkAdapter adapter;
    MyUtility myUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myUtility = new MyUtility(new DBHelper(this));

        double currentBalance = myUtility.getCurrentBalance();
        double totalExpenses = myUtility.findTotalExpenses();
        double totalReceived = myUtility.findTotalReceived();

        TextView totalReceivedTxtView = findViewById(R.id.total_received_txtView);
        TextView totalExpensesTxtView = findViewById(R.id.total_expenses_txtView);
        TextView currentBalanceTxtView = findViewById(R.id.currentBalance_txtView);

        totalExpensesTxtView.setText("KSH\n"+totalExpenses);
        totalReceivedTxtView.setText("Ksh\n"+totalReceived);
        currentBalanceTxtView.setText("BALANCE: KSH "+currentBalance);


        gridView = findViewById(R.id.home_gridView);
        getHomeLinks();
        adapter = new HomeLinkAdapter(this, homeLinks);
        gridView.setAdapter(adapter);

//        onRestart();

    }

    private void getHomeLinks() {
        homeLinks = new ArrayList<>();
        homeLinks.add(new HomeLink(R.drawable.cash_out_icon, "Add Expense"));
        homeLinks.add(new HomeLink(R.drawable.cash_in_icon, "Add Received"));
        homeLinks.add(new HomeLink(R.drawable.expenses_icon, "Expenses"));
        homeLinks.add(new HomeLink(R.drawable.credits_icon, "Receivables"));
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}