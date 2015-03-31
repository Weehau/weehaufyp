package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 31-Mar-15.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public final class HelpDBClass {

    final Context context;

    ProjectDBHelper projectDBHelper;
    SQLiteDatabase db;

    public HelpDBClass(Context ctx)
    {
        this.context = ctx;
        projectDBHelper = new ProjectDBHelper(context);
    }

    public HelpDBClass open() throws SQLException
    {
        db = projectDBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        projectDBHelper.close();
    }

    //Populate the song selection activity with songs + properties
    public Cursor getHelpByTag(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("HELP", new String[]
                                {"tipImage","tipDescription"},
                        "tag=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
