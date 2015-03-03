package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 03-Mar-15.
 */
import com.example.toshiba.weehaufyp.SongDBClass.SongEntry;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SongDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WeehauFyp.db";
// Some changes (turns blue)
    private String SQL_CREATE_ENTRIES = "CREATE TABLE " + SongEntry.TABLE_NAME + "(" +
            SongEntry.COLUMN_SONG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SongEntry.COLUMN_SONG_NAME + " TEXT," +
            SongEntry.COLUMN_SONG_ARTIST + " TEXT," +
            SongEntry.COLUMN_SONG_ALBUM + " TEXT," +
            SongEntry.COLUMN_LESSON_NAME + " TEXT," +
            SongEntry.COLUMN_LYRICS + " TEXT," +
            SongEntry.COLUMN_IMG_PATH + " TEXT," +
            SongEntry.COLUMN_SONG_PATH + " TEXT)";

    private String SQL_INSERT_INITIAL_ROW = "INSERT INTO " + SongEntry.TABLE_NAME +
            " VALUES (1, 'Home Sweet Home', 'My Hotspot', 'ThisIsASampleRecord')";

    //create table and insert default value for others table
    //lesson table
    /*
    private String SQL_CREATE_ENTRIES = "CREATE TABLE " + SongEntry.TABLE_NAME + "(" +
            SongEntry.COLUMN_HOTSPOT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SongEntry.COLUMN_LOCATION + " TEXT," +
            SongEntry.COLUMN_SSID + " TEXT," +
            SongEntry.COLUMN_NETWORK_KEY + " TEXT)";

    private String SQL_INSERT_INITIAL_ROW = "INSERT INTO " + SongEntry.TABLE_NAME +
            " VALUES (1, 'Home Sweet Home', 'My Hotspot', 'ThisIsASampleRecord')";
     */

    public SongDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_INSERT_INITIAL_ROW);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}

