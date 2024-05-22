package com.mirea.kt.ribo.practice_210;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private final SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean saveCarToDatabase(Car car) {
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("model", car.getModel());
        cv.put("number", car.getNumber());
        cv.put("year", car.getYearOfIssue());

        long rowId = db.insert("TABLE_CARS", null, cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }


    public ArrayList<Car> LoadAllCarsFromDatabase() {
        ArrayList<Car> cars = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_CARS", null,
                null, null, null, null, null);

        if (dbCursor.moveToFirst()) {
            do {
                String model = dbCursor.getString(dbCursor.getColumnIndexOrThrow(
                        "model"));
                String number = dbCursor.getString(dbCursor.getColumnIndexOrThrow(
                        "number"));
                int year = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("year"));
                cars.add(new Car(model, number, year));


            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return cars;

    }

}
