package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 03-Mar-15.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public final class ExerciseDBClass {

    final Context context;

    ProjectDBHelper projectDBHelper;
    SQLiteDatabase db;

    public ExerciseDBClass(Context ctx)
    {
        this.context = ctx;
        projectDBHelper = new ProjectDBHelper(context);
    }

    public ExerciseDBClass open() throws SQLException
    {
        db = projectDBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        projectDBHelper.close();
    }

    public Cursor getExerciseByLesson(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("EXERCISE", new String[]
                                {"questions"},
                        "tag=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
