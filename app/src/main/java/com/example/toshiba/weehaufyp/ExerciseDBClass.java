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

public final class ExerciseDBClass {

    final Context context;

    SongDbHelper songDbHelper;
    SQLiteDatabase db;

    public ExerciseDBClass(Context ctx)
    {
        this.context = ctx;
        songDbHelper = new SongDbHelper(context);
    }


    public static abstract class ExerciseEntry implements BaseColumns {
        public static final String TABLE_NAME = "exercise";
        public static final String COLUMN_EXERCISE_ID = "exerciseID";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ANSWER = "answer";
        public static final String COLUMN_RESULT = "result";
        public static final String COLUMN_LESSON_NAME = "lessonName";
    }

    public ExerciseDBClass open() throws SQLException
    {
        db = songDbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        songDbHelper.close();
    }

    public Cursor getExerciseByLesson(String selected) throws SQLException
    {
        Cursor mCursor =
                db.query(ExerciseEntry.TABLE_NAME, new String[]
                                {ExerciseEntry.COLUMN_QUESTION, ExerciseEntry.COLUMN_ANSWER, ExerciseEntry.COLUMN_RESULT,},
                        ExerciseEntry.COLUMN_LESSON_NAME + "=?", new String[] {selected}, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}
