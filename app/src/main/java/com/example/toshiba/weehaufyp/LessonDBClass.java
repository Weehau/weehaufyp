package com.example.toshiba.weehaufyp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Toshiba on 11-Mar-15.
 */
public final class LessonDBClass {

    final Context context;

    ProjectDBHelper projectDBHelper;
    SQLiteDatabase db;

    public LessonDBClass (Context ctx)
    {
        this.context = ctx;
        projectDBHelper = new ProjectDBHelper(context);
    }

    public LessonDBClass open() throws SQLException
    {
        db = projectDBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        projectDBHelper.close();
    }

    //Display lesson content acording to the lesson name
    public Cursor getLessonContentByLesson(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("LESSON", new String[]
                                {"lessonContentPartOne"},
                        "tag=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //Display lesson content for lessons with two parts
    //Display lesson content acording to the lesson name
    public Cursor getTwoPartsLessonContentByLesson(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("LESSON", new String[]
                                {"lessonContentPartOne", "lessonContentPartTwo"},
                        "tag=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
