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
    //tag identifies the lesson name, songID identifies which song gets played
    private String SQL_CREATE_SONG = "CREATE TABLE SONG (" +
            "songID TEXT," +
            "tag TEXT," +
            "songTitle TEXT," +
            "songArtist TEXT," +
            "songAlbum TEXT," +
            "imgPath TEXT," +
            "songPath TEXT," +
            "lyrics TEXT)";

    //Song lyrics
    private String actual_lyrics_summertime_sadness = "Kiss me hard before you go\n" + "Summertime sadness\n" + "I just wanted you to know\n" + "That, baby, youre the best\n" +
            "\n" + "I got my red dress on tonight\n" + "Dancing in the dark in the pale moonlight\n" + "Done my hair up real big beauty queen style\n" + "High heels off, Im feeling alive\n" +
            "\n" + "Oh, my God, I feel it in the air\n" + "Telephone wires above are sizzling like a snare\n" + "Honey, Im on fire, I feel it everywhere\n" + "Nothing scares me anymore\n" +
            "\n" + "(1, 2, 3, 4)\n" + "\n";

    private String actual_lyrics_stay_with_me = "stay with me stay with me\nlyrics will be shown here";

    private String actual_lyrics_locked_out_of_heaven = "locked out of heaven lyrics will be displayed here\nBruno Mars\nLocked out of Heaven\nLyrics";

    private String actual_lyrics_chandelier = "chandelier lyrics will be displayed here\nSia\n1000 Forms of Fear\nChandelier lyrics";

    private String actual_lyrics_shake_it_off = "shake it off lyrics will be shown here\ntaylor swift\1989\nshake it off lyrics";

    private String actual_lyrics_maps = "maps by maroon 5 from V\nlyrics will be shown here";

    private String actual_lyrics_happy = "happy by pharrell williams\nlyrics will be shown here";

    private String actual_lyrics_royals = "royals by lorde from pure heroine\nlyrics will be shown here";

    private String actual_lyrics_drunk_in_love = "drunk in love by beyonce from beyonce\nlyrics will be shown here";

    private String actual_lyrics_mirror = "mirror by justin timberlake from 2020 experience\nlyrics will be shown here";

    //Insert song values
    private String SQL_INSERT_SONG = "INSERT INTO SONG" +
            " VALUES ('1', 'Abstract Nouns','Summertime Sadness', 'Lana Del Rey', 'Born To Die', '"+R.drawable.lana_del_rey_born_to_die+"', '"+R.raw.lana_del_rey_summertime_sadness+"','"+actual_lyrics_summertime_sadness+"'), ('2', 'Abstract Nouns', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"'), ('3', 'Abstract Nouns', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"'), ('4', 'Abstract Nouns', 'Chandelier', 'Sia', '1000 Forms of Fears', '"+R.drawable.sia_1000_forms_of_fear+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_chandelier+"'), ('5', 'Collective Nouns', 'Shake It Off', 'Taylor Swift', '1989', '"+R.drawable.taylor_swift_1989+"', '"+R.raw.taylor_swift_blank_space+"', '"+actual_lyrics_shake_it_off+"'), ('6', 'Collective Nouns', 'Maps', 'Maroon 5', 'V', '"+R.drawable.maroon_5_v+"', '"+R.raw.maroon_5_maps+"', '"+actual_lyrics_maps+"'), ('7', 'Collective Nouns', 'Happy', 'Pharrell Williams', 'G I R L', '"+R.drawable.pharrell_williams_girl+"', '"+R.raw.pharrell_williams_happy+"', '"+actual_lyrics_happy+"'), ('8', 'Collective Nouns', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"'), ('9', 'Collective Nouns', 'Drunk In Love', 'Beyonce', 'Beyonce', '"+R.drawable.beyonce_beyonce+"', '"+R.raw.beyonce_haunted+"', '"+actual_lyrics_drunk_in_love+"'), ('10', 'Collective Nouns', 'Mirror', 'Justin Timberlake', '2020 Experience', '"+R.drawable.justin_timberlake_the_20_20_experience_2_of_2+"', '"+R.raw.justin_timberlake_mirrors+"', '"+actual_lyrics_mirror+"'), ('11', 'Collective Nouns', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"'), ('12', 'Collective Nouns', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"'), ('13', 'Abstract Nouns', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"')";

    //LESSON table ===================================================================================================================================
    //Name identifies the lesson name
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
            "VALUES ('1', 'Abstract Nouns','"+ lesson_content + "')";

    //EXERCISE table ===================================================================================================================================
    //tag identifies the lesson name
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

