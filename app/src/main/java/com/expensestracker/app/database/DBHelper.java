package com.expensestracker.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.expensestracker.app.items.Expense;
import com.expensestracker.app.items.Receivable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "expense_tracker.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_EXPENSES = "expenses";
    private static final String TABLE_RECEIVABLES = "receivables";
    private static final String KEY_AMOUNT = "_amount";
    private static final String KEY_VENUE = "_venue";
    private static final String KEY_ITEM_BOUGHT_CATEGORY = "_item_category";
    private static final String KEY_ITEM_BOUGHT_NAME = "_item_name";
    private static final String KEY_ID = "id";
    private static final String KEY_TIMESTAMP = "dt";
    private static final String KEY_CASH_CATEGORY = "_cash_category";
    private static final String KEY_CASH_SOURCE = "_cash_source";

    SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_EXPENSES+" ("
                +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +KEY_ITEM_BOUGHT_NAME+" TEXT, "
                +KEY_ITEM_BOUGHT_CATEGORY+" TEXT, "
                +KEY_VENUE+" TEXT, "
                +KEY_AMOUNT+" VRACHAR (20), "
                +KEY_TIMESTAMP+" DATETIME NOT NULL DEFAULT (datetime(CURRENT_TIMESTAMP, 'localtime')));";
        db.execSQL(query);

        String query2 = "CREATE TABLE "+TABLE_RECEIVABLES+" ("
                +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +KEY_CASH_SOURCE+" TEXT, "
                +KEY_CASH_CATEGORY+" TEXT, "
                +KEY_AMOUNT+" VARCHAR (20), "
                +KEY_TIMESTAMP+" DATETIME NOT NULL DEFAULT (datetime(CURRENT_TIMESTAMP, 'localtime')));";
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXPENSES);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_RECEIVABLES);
        onCreate(db);
    }

    public long insertExpense(String item_name, String item_category, String venue, String amount){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ITEM_BOUGHT_NAME, item_name);
        contentValues.put(KEY_ITEM_BOUGHT_CATEGORY, item_category);
        contentValues.put(KEY_VENUE, venue);
        contentValues.put(KEY_AMOUNT, amount);
        return db.insert(TABLE_EXPENSES,null, contentValues);
    }

    public long insertReceivable(String source, String category, String amount){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CASH_SOURCE, source);
        contentValues.put(KEY_CASH_CATEGORY, category);
        contentValues.put(KEY_AMOUNT, amount);
        return db.insert(TABLE_RECEIVABLES,null, contentValues);
    }

    public List<Expense> getExpenses(){
        List<Expense> expenses = new ArrayList<>();
        db = this.getReadableDatabase();
        String [] columns = new String[]{ KEY_ID, KEY_ITEM_BOUGHT_NAME, KEY_ITEM_BOUGHT_CATEGORY, KEY_VENUE, KEY_AMOUNT, KEY_TIMESTAMP};
        Cursor cursor = db.query(TABLE_EXPENSES, columns, null, null, null, null, null);
//        int iId = cursor.getColumnIndex(KEY_ID);
        int iItemName = cursor.getColumnIndex(KEY_ITEM_BOUGHT_NAME);
        int iItemCategory = cursor.getColumnIndex(KEY_ITEM_BOUGHT_CATEGORY);
        int iVenue = cursor.getColumnIndex(KEY_VENUE);
        int iAmount = cursor.getColumnIndex(KEY_AMOUNT);
        int iTimeStamp = cursor.getColumnIndex(KEY_TIMESTAMP);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            expenses.add(new Expense(
                    cursor.getString(iItemName),
                    cursor.getString(iItemCategory),
                    cursor.getString(iVenue),
                    Integer.parseInt(cursor.getString(iAmount)),
                    cursor.getString(iTimeStamp)
            ));
        }
        return expenses;
    }


    public List<Receivable> getReceivables(){
        List<Receivable> receivables = new ArrayList<>();
        db = this.getReadableDatabase();
        String [] columns = new String[]{ KEY_ID, KEY_CASH_SOURCE, KEY_CASH_CATEGORY, KEY_AMOUNT, KEY_TIMESTAMP};
        Cursor cursor = db.query(TABLE_RECEIVABLES, columns, null, null, null, null, null);
//        int iId = cursor.getColumnIndex(KEY_ID);
        int iCashSource = cursor.getColumnIndex(KEY_CASH_SOURCE);
        int iCashCategory = cursor.getColumnIndex(KEY_CASH_CATEGORY);
        int iAmount = cursor.getColumnIndex(KEY_AMOUNT);
        int iTimeStamp = cursor.getColumnIndex(KEY_TIMESTAMP);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){

//            Receivable(String source, String category, int amount, String dateTime)
            receivables.add(new Receivable(
                  cursor.getString(iCashSource),
                  cursor.getString(iCashCategory),
                  cursor.getString(iAmount),
                  cursor.getString(iTimeStamp)
            ));


        }
        return receivables;
    }

}
