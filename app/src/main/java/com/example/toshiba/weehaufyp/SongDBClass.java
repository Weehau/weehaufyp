package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 03-Mar-15.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public final class SongDBClass {

    final Context context;

    ProjectDBHelper projectDBHelper;
    SQLiteDatabase db;

    public SongDBClass(Context ctx)
    {
        this.context = ctx;
        projectDBHelper = new ProjectDBHelper(context);
    }

    public SongDBClass open() throws SQLException
    {
        db = projectDBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        projectDBHelper.close();
    }

    //Populate the song selection activity with songs + properties
    public Cursor getSongListByLesson(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("SONG", new String[]
                                {"songTitle", "songArtist","songAlbum", "imgPath", "songID"},
                        "tag=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //Play songs at audio player
    public Cursor playSongByID(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("SONG", new String[]
                                {"songTitle", "songArtist", "songAlbum", "songPath", "tag"},
                        "songID=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //Show lyrics
    public Cursor showLyricsByID(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("SONG", new String[]
                                {"lyrics"},
                        "songID=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //Show lesson content
    public Cursor showExplanationByID(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("SONG", new String[]
                                {"explanation"},
                        "songID=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
