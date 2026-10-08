package com.example.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class DBhelpher extends SQLiteOpenHelper {
    public DBhelpher(@Nullable Context context) {
        super(context, "MyBD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE userdetails(rollno INTEGER PRIMARY KEY,name TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists userdetails");
    }

    public boolean insertToDB(int rollno, String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rollno", rollno);
        values.put("name", name);
        values.put("email", email);

        long result = db.insert("userdetails", null, values);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }


    public Cursor selectFromDB() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * from userdetails", null);
        return cursor;

    }

//    public boolean updateToDB(int rollno, String name, String email) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("name", name);
//        values.put("email", email);
//        Cursor check_user = db.rawQuery("SELECT * from userdetails WHERE rollno=?",
//                new String[]{String.valueOf(rollno)});
//        if (check_user.getCount() > 0) {
//
//
//            long update_user_query = db.update("userdetails", values,
//                    "rollno=?", new String[]{String.valueOf(rollno)});
//
//            if (update_user_query >= 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//
//            return false;
//
//        }
//    }
//
//    public boolean deleteFromDB(int rollno) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor check_user = db.rawQuery("SELECT * FROM userdetails WHERE rollno=?",
//                new String[]{String.valueOf(rollno)});
//        if (check_user.getCount() > (0)) {
//            long delete_user_query = db.delete("userdetails", "rollno=?", new
//
//                    String[]{String.valueOf(rollno)});
//            if (delete_user_query >= 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//
//            return false;
//        }
//
//    }
}
