package com.expensestracker.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.expensestracker.app.R;
import com.expensestracker.app.items.Receivable;

import java.util.List;

public class ViewReceivablesAdapter extends BaseAdapter {
    Context  context;
    List<Receivable> receivables;

    public ViewReceivablesAdapter(Context context, List<Receivable> receivables) {
        this.context = context;
        this.receivables = receivables;
    }

    @Override
    public int getCount() {
        return receivables.size();
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
        view = LayoutInflater.from(context).inflate(R.layout.receivable_item, viewGroup, false);

        TextView receivedDate = view.findViewById(R.id.receivable_item_date_textView);
        TextView receivedTime = view.findViewById(R.id.receivable_item_time_textView);
//        TextView receivedItem = view.findViewById(R.id.expense_item_product_name_textView);
        TextView receivedSource = view.findViewById(R.id.receivable_item_source_name_textView);
        TextView receivedAmount= view.findViewById(R.id.receivable_item_amount_received_textView);

        receivedDate.setText(receivables.get(i).getDate());
        receivedTime.setText(receivables.get(i).getTime().substring(0,5));
//        receivedItem.setText(receivables.get(i).getCategory());
        receivedSource.setText(receivables.get(i).getSource());
        receivedAmount.setText("Ksh "+receivables.get(i).getAmount());

        return view;
    }
}
