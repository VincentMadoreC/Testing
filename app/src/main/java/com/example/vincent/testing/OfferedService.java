package com.example.vincent.testing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OfferedService extends Storable {

    public static final String TABLE_NAME = "Services";
    public static final String COL_TYPE = "Type";
    public static final String COL_PROVIDER = "Provider";
    public static final String COL_HOURLYRATE = "HourlyRate";
//    public static final String[] COLUMNS = {COL_ID, COL_TYPE, COL_PROVIDER, COL_HOURLYRATE};
    public static final ArrayList<String[]> COLUMNS = new ArrayList<>();
    static {
        COLUMNS.add(new String[] {COL_ID, "INTEGER PRIMARY KEY AUTOINCREMENT"});
        COLUMNS.add(new String[] {COL_TYPE, "INTEGER"});
        COLUMNS.add(new String[] {COL_PROVIDER, "INTEGER"});
        COLUMNS.add(new String[] {COL_HOURLYRATE, "DOUBLE"});
    }

//    private Context context;
    //    private int ID;
    private int typeID;
    private int providerID;
    private double hourlyRate;
//    private HashMap<String, String> values;

    // Constructors
    public OfferedService () {
    }

//    public OfferedService (Context context) {
//        this.context = context;
//    }

    public OfferedService (int typeID, int providerID, double hourlyRate) {
        this.typeID = typeID;
        this.providerID = providerID;
        this.hourlyRate = hourlyRate;
    }

    // Getters and setters
    public String getTableName() { return TABLE_NAME; }

    public int getTypeID() { return this.typeID; }
    public void setTypeID(int typeID) { this.typeID = typeID; }

    public int getProviderID() { return providerID; }
    public void setProviderID(int providerID) { this.providerID = providerID; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }


//    public boolean add() {
//        boolean result;
//        MyDBHandler dbHandler = new MyDBHandler(context);
//        SQLiteDatabase db = dbHandler.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COL_TYPE, getTypeID());
//        values.put(COL_PROVIDER, getProviderID());
//        values.put(COL_HOURLYRATE, getHourlyRate());
//
//        result = db.insert(TABLE_NAME, null, values) > 0;
//        db.close();
//        return result;
//    }

//    public boolean update() {
//        boolean result;
//        MyDBHandler dbHandler = new MyDBHandler(context);
//        SQLiteDatabase db = dbHandler.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COL_TYPE, getTypeID());
//        values.put(COL_PROVIDER, getProviderID());
//        values.put(COL_HOURLYRATE, getHourlyRate());
//
//        result = db.update(TABLE_NAME, values, COL_ID + " = " + getID(), null) > 0;
//        db.close();
//        return result;
//    }

//    public boolean delete() {
//        boolean result;
//        MyDBHandler dbHandler = new MyDBHandler(context);
//        SQLiteDatabase db = dbHandler.getWritableDatabase();
//
//        result = db.delete(TABLE_NAME,COL_ID + " = " + getID(), null) > 0;
//        db.close();
//        return result;
//    }

//    public static OfferedService find(Context context, int ID) {
//        MyDBHandler dbHandler = new MyDBHandler(context);
//        SQLiteDatabase db = dbHandler.getReadableDatabase();
//        String query =
//                "SELECT * FROM " + TABLE_NAME
//                        + " WHERE " + COL_ID + " = " + ID;
//        Cursor cursor = db.rawQuery(query, null);
//        OfferedService service = new OfferedService(context);
//        if(cursor.moveToFirst()) {
//            service.setID(cursor.getInt(getFieldIndex(COL_ID, COLUMNS)));
//            service.setTypeID(cursor.getInt(getFieldIndex(COL_TYPE, COLUMNS)));
//            service.setProviderID(cursor.getInt(getFieldIndex(COL_PROVIDER, COLUMNS)));
//            service.setHourlyRate(cursor.getDouble(getFieldIndex(COL_HOURLYRATE, COLUMNS)));
//        } else {
//            service = null;
//        }
//        db.close();
//        return service;
//    }

    public OfferedService cursorHandler(SQLiteDatabase db, Cursor cursor) {
        OfferedService service = new OfferedService();
        if(cursor.moveToFirst()) {
            service.setID(cursor.getInt(getFieldIndex(COL_ID, COLUMNS)));
            service.setTypeID(cursor.getInt(getFieldIndex(COL_TYPE, COLUMNS)));
            service.setProviderID(cursor.getInt(getFieldIndex(COL_PROVIDER, COLUMNS)));
            service.setHourlyRate(cursor.getDouble(getFieldIndex(COL_HOURLYRATE, COLUMNS)));
        }
        return service;
    }

    public ContentValues valuePutter() {
        ContentValues values = new ContentValues();
        values.put(COL_TYPE, getTypeID());
        values.put(COL_PROVIDER, getProviderID());
        values.put(COL_HOURLYRATE, getHourlyRate());
        return values;
    }

    public OfferedService find(Context context, String fieldName, Object value) {
        // Connect to the database
        MyDBHandler dbHandler = new MyDBHandler(context);
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        // Store the item's data into a Storable using a cursor
        String query = "SELECT * FROM " + this.getTableName()
                + " WHERE " + fieldName + " = " + value;
        System.out.println(query);

        Cursor cursor = db.rawQuery(query, null);
        OfferedService service = new OfferedService();
        if(cursor.moveToFirst()) {
            service.setID(cursor.getInt(getFieldIndex(COL_ID, COLUMNS)));
            service.setTypeID(cursor.getInt(getFieldIndex(COL_TYPE, COLUMNS)));
            service.setProviderID(cursor.getInt(getFieldIndex(COL_PROVIDER, COLUMNS)));
            service.setHourlyRate(cursor.getDouble(getFieldIndex(COL_HOURLYRATE, COLUMNS)));
        }
        db.close();
        return service;
    }

//    public HashMap<String, Object> getValues() {
//        HashMap<String, Object> values = new HashMap<String, Object>();
//        values.put(OfferedService.COLUMNS.get().getID());
//        values.add(this.getTypeID());
//        values.add(this.getProviderID());
//        values.add(this.getHourlyRate())
//
//    }
////    /**
//     * Add the service's information to the database
//     * @return
//     */
//    public boolean add() {
//        SQLiteOpenHelper helper = new SQ
//        MyDBHandler dbHandler = new MyDBHandler(context);
//        SQLiteDatabase db =
//    }

//    public enum TABLES {
//        enum TABLE1 {
//            COL1,
//            COL2,
//            COL3
//        }
//        enum TABLE2 {
//            COL1,
//            COL2,
//            COL3
//        }
//
//        TABLE2,
//        TABLE3
//    }

//    public ArrayList<ArrayList<String[]>> TABLES = new ArrayList<ArrayList<String[]>>();
//    public void fillAL() {
//        ArrayList<String[]> TABLE1 = new ArrayList<>();
//        TABLE1.add(new String[] {"COL1", "type1"});
//        TABLE1.add(new String[] {"COL2", "type2"});
//        TABLE1.add(new String[] {"COL3", "type3"});
//        TABLE1.add(new String[] {"COL4", "type4"});
//
//        ArrayList<String[]> TABLE2 = new ArrayList<>();
//        TABLE2.add(new String[] {"COL1", "type1"});
//        TABLE2.add(new String[] {"COL2", "type2"});
//        TABLE2.add(new String[] {"COL3", "type3"});
//        TABLE2.add(new String[] {"COL4", "type4"});
//
//        ArrayList<String[]> TABLE3 = new ArrayList<>();
//        TABLE3.add(new String[] {"COL1", "type1"});
//        TABLE3.add(new String[] {"COL2", "type2"});
//        TABLE3.add(new String[] {"COL3", "type3"});
//
//        TABLES.add(TABLE1);
//        TABLES.add(TABLE2);
//        TABLES.add(TABLE3);
//
//    }

}

