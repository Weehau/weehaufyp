package com.example.toshiba.weehaufyp;

/**
 * Created by Toshiba on 03-Mar-15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
            "lyrics TEXT," +
            "explanation TEXT)";

    //Song lyrics
    private String actual_lyrics_summertime_sadness = "Kiss me hard before you go\n" + "Summertime sadness\n" + "I just wanted you to know\n" + "That, baby, you''re the best\n" + "\n" + "I got my red dress on tonight\n" + "Dancing in the dark in the pale moonlight\n" + "Done my hair up real big beauty queen style\n" + "High heels off, I''m feeling alive\n" + "\n" + "Oh, my God, I feel it in the air\n" + "Telephone wires above are sizzling like a snare\n" + "Honey, I''m on fire, I feel it everywhere\n" + "Nothing scares me anymore\n" + "\n" + "(1, 2, 3, 4)\n" + "\n" + "Kiss me hard before you go\n" + "Summertime sadness\n" + "I just wanted you to know\n" + "That, baby, you''re the best\n" + "\n" + "I got that summertime, summertime sadness\n" + "S-s-summertime, summertime sadness\n" + "Got that summertime, summertime sadness\n" + "Oh, oh, oh, oh, oh\n" + "\n" + "I''m feelin'' electric tonight\n" + "Cruising down the coast goin'' ''bout 99\n" + "Got my bad baby by my heavenly side\n" + "I know if I go, I''ll die happy tonight\n" + "\n" + "Oh, my God, I feel it in the air\n" + "Telephone wires above are sizzling like a snare\n" + "Honey, I''m on fire, I feel it everywhere\n" + "Nothing scares me anymore\n" + "\n" + "(1, 2, 3, 4)\n" + "\n" + "Kiss me hard before you go\n" + "Summertime sadness\n" + "I just wanted you to know\n" + "That, baby, you''re the best\n" + "\n" + "I got that summertime, summertime sadness\n" + "S-s-summertime, summertime sadness\n" + "Got that summertime, summertime sadness\n" + "Oh, oh, oh, oh, oh\n" + "\n" + "Think I''ll miss you forever\n" + "Like the stars miss the sun in the morning sky\n" + "Later''s better than never\n" + "Even if you''re gone I''m gonna drive (drive, drive)\n" + "\n" + "I got that summertime, summertime sadness\n" + "S-s-summertime, summertime sadness\n" + "Got that summertime, summertime sadness\n" + "Oh, oh, oh, oh, oh\n" + "\n" + "Kiss me hard before you go\n" + "Summertime sadness\n" + "I just wanted you to know\n" + "That, baby, you''re the best\n" + "\n" + "I got that summertime, summertime sadness\n" + "S-s-summertime, summertime sadness\n" + "Got that summertime, summertime sadness\n" + "Oh, oh, oh, oh, oh";

    private String actual_lyrics_stay_with_me = "stay with me stay with me\nlyrics will be shown here";
    private String actual_lyrics_locked_out_of_heaven = "locked out of heaven lyrics will be displayed here\nBruno Mars\nLocked out of Heaven\nLyrics";
    private String actual_lyrics_chandelier = "chandelier lyrics will be displayed here\nSia\n1000 Forms of Fear\nChandelier lyrics";
    private String actual_lyrics_shake_it_off = "shake it off lyrics will be shown here\ntaylor swift\1989\nshake it off lyrics";
    private String actual_lyrics_maps = "maps by maroon 5 from V\nlyrics will be shown here";
    private String actual_lyrics_happy = "It might seem crazy what I''m about to say\n" + "Sunshine she''s here, you can take a break\n" + "I''m a hot air balloon that could go to space\n" + "With the air, like I don''t care baby by the way\n" + "\n" + "Because I''m happy\n" + "Clap along if you feel like a room without a roof\n" + "Because I''m happy\n" + "Clap along if you feel like happiness is the truth\n" + "Because I''m happy\n" + "Clap along if you know what happiness is to you\n" + "Because I''m happy\n" + "Clap along if you feel like that''s what you wanna do\n" + "\n" + "Here come bad news talking this and that, yeah,\n" + "Well, give me all you got, and don''t hold it back, yeah,\n" + "Well, I should probably warn you I''ll be just fine, yeah,\n" + "No offense to you, don''t waste your time\n" + "Here''s why\n" + "\n" + "Because I''m happy\n" + "Clap along if you feel like a room without a roof\n" + "Because I''m happy\n" + "Clap along if you feel like happiness is the truth\n" + "Because I''m happy\n" + "Clap along if you know what happiness is to you\n" + "Because I''m happy\n" + "Clap along if you feel like that''s what you wanna do\n" + "\n" + "(Happy)\n" + "Bring me down\n" + "Can''t nothing\n" + "Bring me down\n" + "My level''s too high\n" + "Bring me down\n" + "Can''t nothing\n" + "Bring me down\n" + "I said (let me tell you now)\n" + "Bring me down\n" + "Can''t nothing\n" + "Bring me down\n" + "My level''s too high\n" + "Bring me down\n" + "Can''t nothing\n" + "Bring me down\n" + "I said\n" + "\n" + "Because I''m happy\n" + "Clap along if you feel like a room without a roof\n" + "Because I''m happy\n" + "Clap along if you feel like happiness is the truth\n" + "Because I''m happy\n" + "Clap along if you know what happiness is to you\n" + "Because I''m happy\n" + "Clap along if you feel like that''s what you wanna do\n" + "\n" + "Because I''m happy\n" + "Clap along if you feel like a room without a roof\n" + "Because I''m happy\n" + "Clap along if you feel like happiness is the truth\n" + "Because I''m happy\n" + "Clap along if you know what happiness is to you\n" + "Because I''m happy\n" + "Clap along if you feel like that''s what you wanna do\n" + "\n" + "(Happy) [repeats]\n" + "Bring me down... can''t nothing...\n" + "Bring me down... my level''s too high...\n" + "Bring me down... can''t nothing...\n" + "Bring me down, I said (let me tell you now)\n" + "\n" + "Because I''m happy\n" + "Clap along if you feel like a room without a roof\n" + "Because I''m happy\n" + "Clap along if you feel like happiness is the truth\n" + "Because I''m happy\n" + "Clap along if you know what happiness is to you\n" + "Because I''m happy\n" + "Clap along if you feel like that''s what you wanna do\n" + "\n" + "Because I''m happy\n" + "Clap along if you feel like a room without a roof\n" + "Because I''m happy\n" + "Clap along if you feel like happiness is the truth\n" + "Because I''m happy\n" + "Clap along if you know what happiness is to you\n" + "Because I''m happy\n" + "Clap along if you feel like that''s what you wanna do";

    private String actual_lyrics_royals = "I''ve never seen a diamond in the flesh\n" + "I cut my teeth on wedding rings in the movies\n" + "And I''m not proud of my address\n" + "In a torn-up town, no postcode envy\n" + "\n" + "But every song''s like gold teeth, grey goose, trippin'' in the bathroom\n" + "Blood stains, ball gowns, trashin'' the hotel room\n" + "We don''t care, we''re driving Cadillacs in our dreams\n" + "But everybody''s like Cristal, Maybach, diamonds on your timepiece\n" + "Jet planes, islands, tigers on a gold leash\n" + "We don''t care, we aren''t caught up in your love affair\n" + "\n" + "And we''ll never be royals (royals)\n" + "It don''t run in our blood\n" + "That kind of luxe just ain''t for us\n" + "We crave a different kind of buzz\n" + "Let me be your ruler (ruler)\n" + "You can call me queen Bee\n" + "And baby I''ll rule, I''ll rule, I''ll rule, I''ll rule\n" + "Let me live that fantasy\n" + "\n" + "My friends and I, we''ve cracked the code\n" + "We count our dollars on the train to the party\n" + "And everyone who knows us knows that we''re fine with this\n" + "We didn''t come from money\n" + "\n" + "But every song''s like gold teeth, grey goose, trippin'' in the bathroom\n" + "Blood stains, ball gowns, trashin'' the hotel room\n" + "We don''t care, we''re driving Cadillacs in our dreams\n" + "But everybody''s like Cristal, Maybach, diamonds on your timepiece\n" + "Jet planes, islands, tigers on a gold leash\n" + "We don''t care, we aren''t caught up in your love affair\n" + "\n" + "And we''ll never be royals (royals)\n" + "It don''t run in our blood\n" + "That kind of luxe just ain''t for us\n" + "We crave a different kind of buzz\n" + "Let me be your ruler (ruler)\n" + "You can call me queen Bee\n" + "And baby I''ll rule, I''ll rule, I''ll rule, I''ll rule\n" + "Let me live that fantasy\n" + "\n" + "Ooh ooh oh\n" + "We''re bigger than we ever dreamed\n" + "And I''m in love with being queen\n" + "Ooh ooh oh\n" + "Life is great without a care\n" + "We aren''t caught up in your love affair\n" + "\n" + "And we''ll never be royals (royals)\n" + "It don''t run in our blood\n" + "That kind of luxe just ain''t for us\n" + "We crave a different kind of buzz\n" + "Let me be your ruler (ruler)\n" + "You can call me queen Bee\n" + "And baby I''ll rule, I''ll rule, I''ll rule, I''ll rule\n" + "Let me live that fantasy";
    private String actual_lyrics_drunk_in_love = "drunk in love by beyonce from beyonce\nlyrics will be shown here";
    private String actual_lyrics_mirror = "mirror by justin timberlake from 2020 experience\nlyrics will be shown here";

    //Song lesson contents
    private String actual_explanation_summertime_sadness = "the lesson content for summertime sadness will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_locked_out_of_heaven_abstract_nouns = "the lesson content for locked out of heaven under the lesson name of abstract nouns will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_stay_with_me_abstract_nouns = "the lesson content for stay with me under the lesson name of abstract nouns will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_chandelier = "the lesson content for chandelier will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_royals_abstract_nouns = "the lesson content for royals under the lesson name of abstract nounswill be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_shake_it_off = "the lesson content for shake_it_off will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_maps = "the lesson content for maps will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_happy = "the lesson content for happy will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_royals_collective_nouns = "the lesson content for royals under the lesson name of collective nouns will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_drunk_in_love = "the lesson content for drunk in love will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_mirror = "the lesson content for mirror will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_stay_with_me_collective_nouns = "the lesson content for stay with me under the lesson name of collective nouns will be shown here, with explanation, examples, and some vocabs";
    private String actual_explanation_locked_out_of_heaven_collective_nouns = "the lesson content for locked out of heaven under the lesson name of collective nouns will be shown here, with explanation, examples, and some vocabs";

    //Insert song values
    private String SQL_INSERT_SONG = "INSERT INTO SONG" +
            " VALUES ('1', 'Present / Future Modals','Summertime Sadness', 'Lana Del Rey', 'Born To Die', '"+R.drawable.lana_del_rey_born_to_die+"', '"+R.raw.lana_del_rey_summertime_sadness+"','"+actual_lyrics_summertime_sadness+"', '"+actual_explanation_summertime_sadness+"'), ('2', 'Present / Future Modals', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"', '"+actual_explanation_locked_out_of_heaven_abstract_nouns+"'), ('3', 'Present / Future Modals', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"', '"+actual_explanation_stay_with_me_abstract_nouns+"'), ('4', 'Present / Future Modals', 'Chandelier', 'Sia', '1000 Forms of Fears', '"+R.drawable.sia_1000_forms_of_fear+"', '"+R.raw.sia_chandelier+"', '"+actual_lyrics_chandelier+"', '"+actual_explanation_chandelier+"'), ('5', 'Present / Future Modals', 'Shake It Off', 'Taylor Swift', '1989', '"+R.drawable.taylor_swift_1989+"', '"+R.raw.taylor_swift_blank_space+"', '"+actual_lyrics_shake_it_off+"', '"+actual_explanation_shake_it_off+"'), ('6', 'Present / Future Modals', 'Maps', 'Maroon 5', 'V', '"+R.drawable.maroon_5_v+"', '"+R.raw.maroon_5_maps+"', '"+actual_lyrics_maps+"', '"+actual_explanation_maps+"'), ('7', 'Present / Future Modals', 'Happy', 'Pharrell Williams', 'G I R L', '"+R.drawable.pharrell_williams_girl+"', '"+R.raw.pharrell_williams_happy+"', '"+actual_lyrics_happy+"', '"+actual_explanation_happy+"'), ('8', 'Past Modals', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"', '"+actual_explanation_royals_collective_nouns+"'), ('9', 'Past Modals', 'Drunk In Love', 'Beyonce', 'Beyonce', '"+R.drawable.beyonce_beyonce+"', '"+R.raw.beyonce_haunted+"', '"+actual_lyrics_drunk_in_love+"', '"+actual_explanation_drunk_in_love+"'), ('10', 'Past Modals', 'Mirror', 'Justin Timberlake', '20/20 Experience', '"+R.drawable.justin_timberlake_the_20_20_experience_2_of_2+"', '"+R.raw.justin_timberlake_mirrors+"', '"+actual_lyrics_mirror+"', '"+actual_explanation_mirror+"'), ('11', 'Past Modals', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"', '"+actual_explanation_stay_with_me_collective_nouns+"'), ('12', 'Past Modals', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"', '"+actual_explanation_locked_out_of_heaven_collective_nouns+"'), ('13', 'Past Modals', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"', '"+actual_explanation_royals_abstract_nouns+"')";

    //LESSON table ===================================================================================================================================
    private String SQL_CREATE_LESSON = "CREATE TABLE LESSON (" +
            "LessonID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tag TEXT," +
            "lessonContent TEXT)";

    private String presentFutureModalsLessonContent = "This is the lesson content for present / future modals";
    private String pastModalsLessonContent = "This is the lesson content for past modals";

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
            "VALUES ('1', 'Present / Future Modals','"+presentFutureModalsLessonContent+ "'), ('2', 'Past Modals', '"+pastModalsLessonContent+"')";

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
            "VALUES ('1', 'Abstract Nouns','this is a question.','0,1','2')";
    //"VALUES ('1', 'Abstract Nouns','1,2','0,1','2')";

    //QUESTION table ===================================================================================================================================
    private String SQL_CREATE_QUESTION = "CREATE TABLE QUESTION (" +
            "questionID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "question TEXT," +
            "answer TEXT," +
            "choices TEXT)";

    //Insert table values
    private String SQL_INSERT_QUESTION = "INSERT INTO QUESTION " +
            "VALUES ('1','question 1','1','A,B,C,D')";

    // tasks table name=============================================================================================================
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d
    private SQLiteDatabase dbase;

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

        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT, "+KEY_OPTD+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }

    //Quiz DB starts here ===========================================================================================
    private void addQuestions()
    {
        //question, a, b, c, d, answer
        //public Question(String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD, String aNSWER)
        Question q1=new Question("1 + 1 = " + "how much?","1", "2", "3", "4", "2");
        this.addQuestion(q1);
        Question q2=new Question("1 * 2 = " + "how much?", "2", "4", "6", "8", "2");
        this.addQuestion(q2);
        Question q3=new Question("8 / 2 = " + "how much?","4", "8","12", "14","4");
        this.addQuestion(q3);
        Question q4=new Question("10 - 1 = " + "how much?", "3", "6", "9", "12","9");
        this.addQuestion(q4);
        Question q5=new Question("5 + 5 = " + " how much?","5","10","15", "20","10");
        this.addQuestion(q5);
        Question q6=new Question("3 * 7 = " + " how much?","7","14","21", "28","21");
        this.addQuestion(q6);
        Question q7=new Question("200 - 100 = " + " how much?","50","100","150", "200","100");
        this.addQuestion(q7);
        Question q8=new Question("40 / 8 = " + " how much?","5","10","15", "20","5");
        this.addQuestion(q8);
        Question q9=new Question("12 + 21 = " + " how much?","11","22","33", "44","33");
        this.addQuestion(q9);
        Question q10=new Question("9 * 9 = " + " how much?","18","81","80", "1.8","81");
        this.addQuestion(q10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}

