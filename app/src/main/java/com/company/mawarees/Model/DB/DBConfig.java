package com.company.mawarees.Model.DB;

import android.provider.BaseColumns;

import java.util.ArrayList;

public class DBConfig {

    private static final String DROP_TABLE_LBL = "DROP TABLE IF EXISTS ";
    private static final String CREATE_TABLE_LBL = "CREATE TABLE IF NOT EXISTS ";
    private static final String DATA_TYPE_TEXT = " TEXT COLLATE NOCASE";
    private static final String DATA_TYPE_DATE_TIME = " DATETIME ";
    private static final String DATA_TYPE_DATE = " DATE";
    private static final String DATA_TYPE_INTEGER = " INTEGER";
    private static final String DATA_TYPE_REAL = " REAL";
    private static final String DATA_TYPE_NUMERIC = " NUMERIC";


    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor public.
    public DBConfig() {
    }


    /* Inner class that defines the CustomersTable contents */
    public static class ProofsTable implements BaseColumns {
        static final String TABLE_NAME = "ProofsTable";
        static final String COLUMN_NAME_ID = "ID";
        static final String COLUMN_NAME_RELATION = "Relation";
        static final String COLUMN_NAME_RELIGION = "Religion";
        static final String COLUMN_NAME_KEY = "Key";
        static final String COLUMN_NAME_VALUE = "Value";
    }


    private static final String SQL_CREATE_PROOFS_TABLE = CREATE_TABLE_LBL + ProofsTable.TABLE_NAME +
            " (" + ProofsTable.COLUMN_NAME_ID + " TEXT , " +
            ProofsTable.COLUMN_NAME_RELATION + " TEXT , " + // الصلة او القرابة
            ProofsTable.COLUMN_NAME_RELIGION + " TEXT , " + // المذهب المختار
            ProofsTable.COLUMN_NAME_KEY + " TEXT , " + // Ex: E1, p1, ..etc
            ProofsTable.COLUMN_NAME_VALUE + " TEXT );"; // // proof, explanation

    static class TablesSqlStatements {

        static ArrayList<String> getAllSqlCreationStatements() {
            ArrayList<String> listTablesCreationStatementSql = new ArrayList<>();
            listTablesCreationStatementSql.add(SQL_CREATE_PROOFS_TABLE);
            return listTablesCreationStatementSql;
        }

        static String deleteTable(String tableName) {
            return DROP_TABLE_LBL + tableName;
        }
    }
}
