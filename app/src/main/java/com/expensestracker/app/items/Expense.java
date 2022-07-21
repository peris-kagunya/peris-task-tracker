package com.expensestracker.app.items;

public class Expense {
    public String getItemPurchased() {
        return itemPurchased;
    }

    public void setItemPurchased(String itemPurchased) {
        this.itemPurchased = itemPurchased;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getPlaceOfPurchase() {
        return placeOfPurchase;
    }

    public void setPlaceOfPurchase(String placeOfPurchase) {
        this.placeOfPurchase = placeOfPurchase;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getTime(){
        return dateOfPurchase.split(" ")[1];
    }

    public String getDate(){
        return dateOfPurchase.split(" ")[0];
    }

    public Expense(String itemPurchased, String itemCategory, String placeOfPurchase, int amountUsed, String dateOfPurchase) {
        this.itemPurchased = itemPurchased;
        this.itemCategory = itemCategory;
        this.placeOfPurchase = placeOfPurchase;
        this.amountUsed = amountUsed;
        this.dateOfPurchase = dateOfPurchase;
    }

    String itemPurchased;
    String itemCategory;
    String placeOfPurchase;
    int amountUsed;
    String dateOfPurchase;

}
