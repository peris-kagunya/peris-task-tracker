package com.expensestracker.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.expensestracker.app.activities.AddExpenseActivity;
import com.expensestracker.app.activities.AddReceivedActivity;
import com.expensestracker.app.items.HomeLink;
import com.expensestracker.app.R;
import com.expensestracker.app.activities.ViewExpensesActivity;
import com.expensestracker.app.activities.ViewReceivablesActivity;

import java.util.List;

public class HomeLinkAdapter extends BaseAdapter {
    Context context;
    List<HomeLink> homeLinks;

    public HomeLinkAdapter(Context context, List<HomeLink> homeLinks) {
        this.context = context;
        this.homeLinks = homeLinks;
    }

    @Override
    public int getCount() {
        return homeLinks.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.home_link_item, viewGroup, false);

        TextView linkName = view.findViewById(R.id.home_linkTextView);
        ImageView imageView = view.findViewById(R.id.home_linkImageView);

        linkName.setText(homeLinks.get(i).getName());
        imageView.setImageResource(homeLinks.get(i).getImage());

        view.setOnClickListener(View->{

            if (homeLinks.get(i).getName().equals("Add Expense")){
                Intent intent = new Intent(context, AddExpenseActivity.class);
                context.startActivity(intent);
            }
            if (homeLinks.get(i).getName().equals("Add Received")){
                Intent intent = new Intent(context, AddReceivedActivity.class);
                context.startActivity(intent);
            }
            if (homeLinks.get(i).getName().equals("Expenses")){
                Intent intent = new Intent(context, ViewExpensesActivity.class);
                context.startActivity(intent);
            }
            if (homeLinks.get(i).getName().equals("Receivables")){
                Intent intent = new Intent(context, ViewReceivablesActivity.class);
                context.startActivity(intent);
            }

//            Toast.makeText(context, "You Clicked: "+homeLinks.get(i).getName(), Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
