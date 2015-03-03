package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 03-Mar-15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public final class SongDBClass {

    final Context context;

    SongDbHelper songDbHelper;
    SQLiteDatabase db;

    public SongDBClass(Context ctx)
    {
        this.context = ctx;
        songDbHelper = new SongDbHelper(context);
    }


    public static abstract class SongEntry implements BaseColumns {
        public static final String TABLE_NAME = "song";
        public static final String COLUMN_SONG_ID = "songID";
        public static final String COLUMN_SONG_NAME = "songName";
        public static final String COLUMN_SONG_ARTIST = "songArtist";
        public static final String COLUMN_SONG_ALBUM = "songAlbum";
        public static final String COLUMN_LESSON_NAME = "lessonName";
        public static final String COLUMN_LYRICS = "lyrics";
        public static final String COLUMN_IMG_PATH = "imgPath";
        public static final String COLUMN_SONG_PATH = "songPath";
    }

    public SongDBClass open() throws SQLException
    {
        db = songDbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        songDbHelper.close();
    }

    public Cursor getSongListByLesson(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query(SongEntry.TABLE_NAME, new String[]
                                {SongEntry.COLUMN_SONG_NAME, SongEntry.COLUMN_SONG_ARTIST,SongEntry.COLUMN_SONG_ALBUM, SongEntry.COLUMN_IMG_PATH},
                        SongEntry.COLUMN_LESSON_NAME + "=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor PlaySongBySongName(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query(SongEntry.TABLE_NAME, new String[]
                                {SongEntry.COLUMN_SONG_NAME, SongEntry.COLUMN_SONG_PATH,SongEntry.COLUMN_LYRICS},
                        SongEntry.COLUMN_SONG_ID + "=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
