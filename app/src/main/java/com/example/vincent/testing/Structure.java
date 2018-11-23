package com.example.vincent.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Structure {

//    public ArrayList<HashMap<String, ArrayList<String[]>>> TABLES = new ArrayList<>();
    public HashMap<String, ArrayList<String[]>> TABLES = new HashMap<>();

    public void fill() {
        ArrayList<String[]> TABLE_FIELDS = new ArrayList<>();
//        HashMap<String, ArrayList<String[]>> TABLE = new HashMap<>();
        String tableName;

        tableName = "Table1";
        TABLE_FIELDS.add(new String[] {"col11", "type11"});
        TABLE_FIELDS.add(new String[] {"col12", "type12"});
        TABLE_FIELDS.add(new String[] {"col13", "type13"});
        TABLE_FIELDS.add(new String[] {"col14", "type14"});
        TABLES.put(tableName, TABLE_FIELDS);
//        TABLES.add(TABLE);
        TABLE_FIELDS.clear();
//        TABLE.clear();

        tableName = "Table2";
        TABLE_FIELDS.add(new String[] {"col21", "type21"});
        TABLE_FIELDS.add(new String[] {"col22", "type22"});
        TABLES.put(tableName, TABLE_FIELDS);
//        TABLES.add(TABLE);
        TABLE_FIELDS.clear();
//        TABLE.clear();

        tableName = "Table3";
        TABLE_FIELDS.add(new String[] {"col31", "type31"});
        TABLE_FIELDS.add(new String[] {"col32", "type32"});
        TABLE_FIELDS.add(new String[] {"col33", "type33"});
        TABLES.put(tableName, TABLE_FIELDS);
//        TABLES.add(TABLE);
        TABLE_FIELDS.clear();
//        TABLE.clear();
    }


}
