package com.expensestracker.app.items;

public class Receivable {
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Receivable(String source, String category, String amount, String dateTime) {
        this.date = dateTime.split(" ")[0];
        this.time = dateTime.split(" ")[1];
        this.source = source;
        this.category = category;
        this.amount = amount;
    }

    String date;
    String time;
    String source;
    String category;
    String amount;
}
