package com.example.vincent.testing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Storable {

    public static final String COL_ID = "ID";

//    protected String tableName;
//    protected Context context;
    protected int ID;


    abstract String getTableName(); //{ return this.tableName; }
    abstract Storable cursorHandler(SQLiteDatabase db, Cursor cursor);
    abstract ContentValues valuePutter();
//<T extends Storable> T
//    public Context getContext() { return this.context; }
//    public void setContext(Context context) { this.context = context; }

    public int getID() { return this.ID; }
    public void setID(int ID) { this.ID = ID; }


//    public static String getTableName(Class cls) {
//        try {
//            Object ob = cls.newInstance();
//            switch (ob.getClass().toString()) {
//                case "OfferedService":
//                    return "hey";
//                break;
//            }
//        } catch (InstantiationException e) {
//
//        } catch (IllegalAccessException e) {
//
//        }


//    }
//    abstract boolean add();
//    abstract boolean update();
//    abstract boolean delete();
//    abstract Storable find(Context context, int ID);

//    abstract HashMap<String, String> getFields();

    // Constructor
    public Storable() {
    }

//    public Storable(Context context) {
//        this.context = context;
//    }

//    protected static int indexOf(String string, String[] array) {
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].equals(string)) {
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }

    protected static int getFieldIndex(String string, ArrayList<String[]> fields) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i)[0].equals(string)) {
                return i;
            }
        }
        return -1;
    }
    public boolean add(Context context) {
        MyDBHandler dbHandler = new MyDBHandler(context);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = this.valuePutter();

        boolean result;
        if (db.insert(this.getTableName(), null, values) > 0) {
            System.out.println("The record has been added.");
            result = true;
        } else {
            System.out.println("The record could not be found.");
            result = false;
        }
        db.close();
        return result;
    }

    public boolean update(Context context) {
        MyDBHandler dbHandler = new MyDBHandler(context);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = this.valuePutter();

        boolean result;
        if (db.update(this.getTableName(), values, COL_ID + " = " + this.getID(), null) > 0) {
            System.out.println("The record has been updated.");
            result = true;
        } else {
            System.out.println("The record could not be found.");
            result = false;
        }
        db.close();
        return result;
    }

    public boolean delete(Context context) {
        MyDBHandler dbHandler = new MyDBHandler(context);
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        boolean result;
        if (db.delete(this.getTableName(), COL_ID + " = " + getID(), null) > 0) {
            System.out.println("The record has been deleted.");
            result = true;
        } else {
            System.out.println("The record could not be found.");
            result = false;
        }
        db.close();
        return result;
    }

////    public <T extends Storable> Storable find(Context context, Class<T> cls, int ID) {
//    public Storable find(Context context, int ID) {
//        try {
//            Storable storable = this.getClass().newInstance();
////            Storable storable = cls.newInstance();
//            MyDBHandler dbHandler = new MyDBHandler(context);
////            MyDBHandler dbHandler = new MyDBHandler(context);
//            SQLiteDatabase db = dbHandler.getReadableDatabase();
//            String query =
//                    "SELECT * FROM " + storable.getTableName()
//                    + " WHERE " + "ID" + " = " + ID;
//            System.out.println(query);
//            Cursor cursor = db.rawQuery(query, null);
////        OfferedService service = new OfferedService(context);
////            Object o = storable.cursorHandler(db, cursor);
////            storable = cls.cast(o);
//
//            storable = storable.cursorHandler(db, cursor);
////        if(cursor.moveToFirst()) {
////            service.setID(cursor.getInt(getFieldIndex(COL_ID, COLUMNS)));
////            service.setTypeID(cursor.getInt(getFieldIndex(COL_TYPE, COLUMNS)));
////            service.setProviderID(cursor.getInt(getFieldIndex(COL_PROVIDER, COLUMNS)));
////            service.setHourlyRate(cursor.getDouble(getFieldIndex(COL_HOURLYRATE, COLUMNS)));
////        } else {
////            service = null;
////        }
//            db.close();
//            System.out.println(this.getClass());
////            return this.getClass().cast(storable);
//
//            return storable;
////            return this.getClass().cast(storable);
//        } catch (IllegalAccessException e) {
//            System.out.println("Illegal access exception.");
//            return null;
//        } catch (InstantiationException e) {
//            System.out.println("Instantiation exception.");
//            return null;
//        }
//    }

    public Storable findAny(Context context, String fieldName, Object value) {
        try {
            // Instantiate the calling class
            Storable storable = this.getClass().newInstance();

            // Connect to the database
            MyDBHandler dbHandler = new MyDBHandler(context);
            SQLiteDatabase db = dbHandler.getReadableDatabase();

            // Store the item's data into a Storable using a cursor
            String query = "SELECT * FROM " + storable.getTableName()
                    + " WHERE " + fieldName + " = " + value;
            System.out.println(query);
            Cursor cursor = db.rawQuery(query, null);
            storable = storable.cursorHandler(db, cursor);
            db.close();
            Class currentClass = this.getClass();
            System.out.println(currentClass);
            System.out.println(storable.getClass());
            currentClass.cast(storable);
            System.out.println(storable.getClass());
            return storable;
//            return this.getClass().cast(storable);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access exception.");
            return null;
        } catch (InstantiationException e) {
            System.out.println("Instantiation exception.");
            return null;
        }
    }



}
