package com.expensestracker.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.helper.widget.Layer;

import com.expensestracker.app.R;
import com.expensestracker.app.items.Expense;

import java.util.List;

public class ViewExpensesAdapter extends BaseAdapter {
    Context context;
    List<Expense> expenses;


    public ViewExpensesAdapter(Context context, List<Expense> expenses) {
        this.context = context;
        this.expenses = expenses;
    }

    @Override
    public int getCount() {
        return expenses.size();
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

        view = LayoutInflater.from(context).inflate(R.layout.expense_item, viewGroup, false);

        TextView textVDate = view.findViewById(R.id.expense_item_date_textView);
        TextView textVName = view.findViewById(R.id.expense_item_product_name_textView);
        TextView textVPrice = view.findViewById(R.id.expense_item_amount_used_textView);
        TextView textVTime = view.findViewById(R.id.expense_item_time_textView);

        textVDate.setText(expenses.get(i).getDate());
        textVTime.setText(expenses.get(i).getTime().substring(0,5));
        textVName.setText(expenses.get(i).getItemPurchased());
        textVPrice.setText("Khs "+expenses.get(i).getAmountUsed());

        return view;
    }
}
