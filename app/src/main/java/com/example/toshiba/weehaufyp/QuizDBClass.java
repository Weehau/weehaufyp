package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 24-Mar-15.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public final class QuizDBClass {

    final Context context;

    ProjectDBHelper projectDBHelper;
    SQLiteDatabase db;

    public QuizDBClass(Context ctx)
    {
        this.context = ctx;
        projectDBHelper = new ProjectDBHelper(context);
    }

    public QuizDBClass open() throws SQLException
    {
        db = projectDBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        projectDBHelper.close();
    }

    //Populate the quiz activity with all sets of questions
    public Cursor getAllQuestionsFromLesson(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query("QUESTION", new String[]
                                {"question", "answer","opta", "optb", "optc", "optd"},
                        "tag=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
