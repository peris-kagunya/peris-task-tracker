package com.expensestracker.app.utilities;

import com.expensestracker.app.database.DBHelper;
import com.expensestracker.app.items.Expense;
import com.expensestracker.app.items.Receivable;

import java.util.List;

public class MyUtility {
    DBHelper dbHelper;
    List<Expense> expenses;
    List<Receivable> receivables;

    public MyUtility(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<Expense> getExpenses() {
        return dbHelper.getExpenses();
    }

    public List<Receivable> getReceivables() {
        return dbHelper.getReceivables();
    }

    public double findTotalReceived() {
            double total = 0;
            if (!this.getReceivables().isEmpty()){
                for (Receivable receivable: this.getReceivables()){
                    total += Integer.parseInt(receivable.getAmount());
                }
            }

            return total;
        }

    public double findTotalExpenses() {
        double total = 0;
        if (!this.getExpenses().isEmpty()){
            for (Expense expense: this.getExpenses()){
                total +=expense.getAmountUsed();
            }
        }
        return total;
    }

    public double getCurrentBalance(){
        return this.findTotalReceived() - this.findTotalExpenses();
    }
}
