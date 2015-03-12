package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 03-Mar-15.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProjectDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WeehauFyp.db";

    //SONG table ===================================================================================================================================
    private String SQL_CREATE_SONG = "CREATE TABLE SONG (" +
            "songID TEXT," +
            "tag TEXT," +
            "songTitle TEXT," +
            "songArtist TEXT," +
            "songAlbum TEXT," +
            "imgPath TEXT," +
            "songPath TEXT," +
            "lyrics TEXT)";

    private String actual_lyrics_summertime_sadness = "Kiss me hard before you go\n" + "Summertime sadness\n" + "I just wanted you to know\n" + "That, baby, youre the best\n" +
            "\n" + "I got my red dress on tonight\n" + "Dancing in the dark in the pale moonlight\n" + "Done my hair up real big beauty queen style\n" + "High heels off, Im feeling alive\n" +
            "\n" + "Oh, my God, I feel it in the air\n" + "Telephone wires above are sizzling like a snare\n" + "Honey, Im on fire, I feel it everywhere\n" + "Nothing scares me anymore\n" +
            "\n" + "(1, 2, 3, 4)\n" + "\n";

    private String actual_lyrics_stay_with_me = "stay with me stay with me";

    //Insert song values
    private String SQL_INSERT_SONG = "INSERT INTO SONG" +
            " VALUES ('1', 'Abstract Nouns','Summertime Sadness', 'Lana Del Rey', 'Born To Die', '"+R.drawable.lana_del_rey_born_to_die+"', '"+R.raw.lana_del_rey_summertime_sadness+"','"+actual_lyrics_summertime_sadness+"')";

    //LESSON table ===================================================================================================================================
    private String SQL_CREATE_LESSON = "CREATE TABLE LESSON (" +
            "LessonID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Name TEXT," +
            "Content TEXT)";

    String lesson_content = "The present continuous is used to talk about present situations which we see as short-term or temporary. We use the present simple to talk about present situations which we see as long-term or permanent.<br>" +
            "<br>" +
            "In these examples, the action is taking place at the time of speaking.<br>" +
            "<br>" +
            "- Its raining.<br>" +
            "- Who is Kate talking to on the phone?<br>" +
            "- Look, somebody is trying to steal that mans wallet.<br>" +
            "- Im not looking. My eyes are closed tightly.<br>" +
            "<br>" +
            "In these examples, the action is true at the present time but we dont think it will be true in the long term.<br>" +
            "<br>" +
            "- Im looking for a new apartment.<br>" +
            "- Hes thinking about leaving his job.<br>" +
            "- Theyre considering making an appeal against the judgment.<br>" +
            "- Are you getting enough sleep?<br>" +
            "<br>" +
            "In these examples, the action is at a definite point in the future and it has already been arranged.<br>" +
            "<br>" +
            "- Im meeting her at 6.30.<br>" +
            "- They arent arriving until Tuesday.<br>" +
            "- We are having a special dinner at a top restaurant for all the senior managers.<br>" +
            "- Isnt he coming to the dinner?<br>";

    //Insert lesson values
    private String SQL_INSERT_LESSON = "INSERT INTO LESSON " +
            "VALUES ('1', 'Present Continuous','"+ lesson_content + "')";

    //EXERCISE table ===================================================================================================================================
    private String SQL_CREATE_EXERCISE = "CREATE TABLE EXERCISE (" +
            "exerciseID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tag TEXT," +
            "questions TEXT," +
            "pastResult TEXT," +
            "currentResult TEXT)";

    //Insert exercise values
    private String SQL_INSERT_EXERCISE = "INSERT INTO EXERCISE " +
            "VALUES ('1', 'Abstract Nouns','1,2','0,1','2')";

    //QUESTION table ===================================================================================================================================
    private String SQL_CREATE_QUESTION = "CREATE TABLE QUESTION (" +
            "questionID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "question TEXT," +
            "answer TEXT," +
            "choices TEXT)";

    //Insert table values
    private String SQL_INSERT_QUESTION = "INSERT INTO QUESTION " +
            "VALUES ('1','question 1','1','A,B,C,D')";

    public ProjectDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SONG);
        db.execSQL(SQL_INSERT_SONG);
        db.execSQL(SQL_CREATE_LESSON);
        db.execSQL(SQL_INSERT_LESSON);
        db.execSQL(SQL_CREATE_EXERCISE);
        db.execSQL(SQL_INSERT_EXERCISE);
        db.execSQL(SQL_CREATE_QUESTION);
        db.execSQL(SQL_INSERT_QUESTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

