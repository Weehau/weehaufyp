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

    private String presentFutureModalsLessonContent = "<b><u>“Don’t have to” and “must not”</u></b><br>" +
            "1.\t“Don’t have to” refers to an absence of obligation.<br>" +
            "[You <b>don’t have to</b> work tomorrow.]<br>" +
            "\t<br>" +
            "2.\t“Must not” refers to an obligation not to do something.<br>" +
            "[You <b>must not</b> leave the room before the end of the test.]\t<br><br><hr>" +
            "<b><u>“Should”</u></b><br>" +
            "1.\tWhere “*should” appears, “ought to” can also be used.<br>" +
            "Expectation<br>" +
            "[This film *<b>should</b> be really good.]<br>" +
            "<br>" +
            "2.\tRecommendation<br>" +
            "[I think you *<b>should</b> talk it over with your parents.]<br>" +
            "In writing, “should” can be used to express a strong obligation politely.<br>" +
            "[Guests <b>should</b> vacate their rooms by midday.]<br>" +
            "<br>" +
            "3.\tCriticism of an action<br>" +
            "[You *<b>shouldn’t</b> eat so much late at night.]<br>" +
            "<br>" +
            "4.\tUncertainty<br>" +
            "[<b>Should</b> I leave these papers on your desk?]<br>" +
            "<br>" +
            "5.\t“Should” and verbs of thinking<br>" +
            "“Should” is often used with verbs of thinking, to make an opinion less direct.<br>" +
            "[I <b>should</b> think that model would sell quite well.]<br>" +
            "<br>" +
            "6.\tWith “be” and adjectives describing chance<br>" +
            "This group of adjectives includes “odd”, “strange”, “funny” (odd), and the expression “what a coincidence”.<br>" +
            "[It’s strange that you <b>should</b> be staying in the same hotel.]<br>" +
            "<br>" +
            "7.\tAfter “in case” to emphasize unlikelihood<br>" +
            "[I’m taking an umbrella in case it <b>should</b> rain.]<br><br>" +
            "<b><u>“Could”</u></b><br>" +
            "1.\t“Could” is used to express possibility or uncertainty.<br>" +
            "[This <b>could</b> be the house.]<br>" +
            "<br>" +
            "2.\t“Could” is used with comparative adjectives to express possibility or impossibility.<br>" +
            "[The situation <b>couldn’t</b> be worse.]<br>" +
            "[It <b>could</b> be better.]<br>" +
            "<br>" +
            "3.\t“Could” is used to make suggestions.<br>" +
            "[We <b>could</b> go to that new restaurant opposite the cinema.]<br>" +
            "<br>" +
            "4.\t“Could” is used to express unwillingness.<br>" +
            "[I <b>couldn’t</b> possibly leave Tim here on his own.]<br><br>" +
            "<b><u>“Can”</u></b><br>" +
            "1.\t“Can” with “be” is used to make criticisms.<br>" +
            "[You <b>can be</b> really annoying, you know!]<br>" +
            "<br>" +
            "2.\t“Can” is also used with “be” to refer to capability.<br>" +
            "[Winter here <b>can be</b> really cold.]<br><br>" +
            "<b><u>“Must” and “can’t”</u></b><br>" +
            "1.\tThese refer to present time only. In expressing certainty, they are opposites.<br>" +
            "[This <b>must</b> be our stop.] (I’m sure it is.)<br>" +
            "[This <b>can’t</b> be our stop.] (I’m sure it isn’t.)<br><br>" +
            "<b><u>“May” and “might”</u></b><br>" +
            "1.\t“May” can be used to express “although” clauses.<br>" +
            "[She <b>may</b> be the boss, <b>but</b> that is no excuse for shouting like that.]<br>" +
            "<br>" +
            "2.\t“May/might as well”<br>" +
            "This describes the only thing left to do, something which the speaker is not enthusiastic about.<br>" +
            "[Nobody else is going to turn up now for the lesson, so you <b>may/might as well</b> go home.<br>" +
            "<br>" +
            "3.\t“May” and “might” both express possibility or uncertainty. “May” is more common in formal language.<br>" +
            "[The peace conference <b>may</b> find a solution to the problem.]<br>" +
            "<br>" +
            "4.\tThere is an idiomatic expression with “try”, using “may” for present reference, and “might” for past reference.<br>" +
            "[<b>Try</b> as I <b>might</b>, I could not pass my driving test.] (This means although I tried hard, I could not pass my driving test.)<br><br>" +
            "<b><u>“Shall”</u></b><br>" +
            "1.\t“Shall” can be used with all persons to emphasize something which the speaker feels is certain to happen or wants to happen.<br>" +
            "[I <b>shall</b> definitely give up smoking this year.]<br>" +
            "[We <b>shall</b> win!] (“shall” is stressed in this sentence)<br>" +
            "<br>" +
            "2.\tSimilarly, “shall” is used in formal rules and regulations.<br>" +
            "[No player <b>shall</b> knowingly pick up or move the ball of another player.]<br><br>" +
            "<b><u>“Will”</u></b><br>" +
            "1.\t“Will” can be used to express an assumption.<br>" +
            "[A: The phone is ringing. B: That <b>will</b> be for me.]<br>" +
            "<br>" +
            "2.\t“Will”/”won’t” can be used emphatically to tell someone of the speaker’s intention, or to forbid an action, in response to a “will” expression.<br>" +
            "[I <b>will</b> take the money anyway, so there!]<br>" +
            "[You <b>won’t</b>!]<br>" +
            "[I <b>will</b>!]<br>" +
            "<br>" +
            "Similarly “I won’t” can mean “I refuse”, and “I will” can mean “I insist”.<br>" +
            "[A: I <b>won’t</b> do it! B: Yes, you <b>will</b>!]<br><br>" +
            "<b><u>“Would”</u></b><br>" +
            "1.\t“Would” is often used in situations where a conditional sense is understood but not stated.<br>" +
            "[Nobody <b>would</b> agree with that idea.] (if we asked them)<br>" +
            "[Life <b>wouldn’t</b> be worth living without you.] (if you weren’t there)<br>" +
            "[I think Jim <b>would</b> be the best candidate.] (if he was under consideration for the job)<br>" +
            "[Sue <b>wouldn’t</b> do that, surely!] (if you think she’s capable of doing that).<br><br>" +
            "<b><u>“Need”</u></b><br>" +
            "1.\t“Need to” is a modal auxiliary, and behaves like a normal verb.<br>" +
            "[Do you <b>need to</b> use the photocopier?]<br>" +
            "<br>" +
            "2.\t“Need” is a modal auxiliary, but mainly in question and negative forms.<br>" +
            "[<b>Need</b> you make so much noise?]<br>";

    private String pastModalsLessonContent = "<b><u>“Had to” and “must have”</u></b><br>" +
            "1.\t“Had to” is the past form of “must” and refers to a past obligation.<br>" +
            "[Sorry I''m late, I <b>had to</b> post some letters.]<br>" +
            "<br>" +
            "The negative form is “didn''t have to” and refers to an absence of obligation.<br>" +
            "“Must have” refers to past certainty. (see below)<br><br>" +
            "<b><u>“Should have” and “ought to have”</u></b><br>" +
            "Where “*should” appears, “ought to” is also possible.<br>" +
            "1.\tExpectation<br>" +
            "“Should have” refers to something which was supposed to happen.<br>" +
            "[The parcel I sent you *<b>should have</b> arrived by now.]<br>" +
            "<br>" +
            "2.\tCriticism of an action<br>" +
            "[You *<b>shouldn''t have</b> eaten so much last night.]<br>" +
            "<br>" +
            "3.\t“Should have” and verbs of thinking<br>" +
            "The past form “knew” in the example is an unreal verb form, and the “should have” form is used according to “sequence of verb forms”.<br>" +
            "[I <b>should have</b> thought you knew.]<br>" +
            "<br>" +
            "4.\t\"With “be” and adjectives describing chance<br>" +
            "[It was strange that you <b>should have been</b> staying in the same hotel last year.]<br>" +
            "<br>" +
            "5.\tAs a polite expression of thanks on receiving a gift or a favour<br>" +
            "[I''ve done the washing up for you. - Oh, you really <b>shouldn''t have</b>.]<br>" +
            "The intonation should be friendly, as this is not a criticism.<br><br>" +
            "<b><u>“Could have”</u></b><br>" +
            "1.\t“Could have” refers to past possibility or uncertainty.<br>" +
            "[David <b>could have</b> won the race if he had tried.] (possibility/ability)<br>" +
            "[It <b>could have</b> been Sue, I suppose.] (uncertainty)<br>" +
            "<br>" +
            "2.\t“Couldn''t have” is also possible for both meanings.<br>" +
            "<br>" +
            "3.\t“Couldn''t have” can be used with comparative adjectives.<br>" +
            "[We <b>couldn''t have</b> been happier in those days.]<br>" +
            "<br>" +
            "4.\t“Could have” can also express unwillingness.<br>" +
            "[She <b>could have</b> gone to the party with her friends.] (but she didn''t)<br>" +
            "[We couldn''t have left the dog on its own.] (so we didn''t)<br><br>" +
            "<b><u>“Could”</u></b><br>" +
            "1.\t“Could” refers to past permission or past ability.<br>" +
            "[When I was sixteen I <b>could</b> stay out till 11.00.” (I was allowed to)<br>" +
            "[Mary <b>could</b> swim when she was three.] (she actually did)<br>" +
            "<br>" +
            "2.\tCompare:<br>" +
            "[Mary <b>could have</b> swum when she was three.] (but she didn''t)<br><br>" +
            "<b><u>“May have” and “might have”</u></b><br>" +
            "1.\t“Might have” refers to past possibility which did not happen.<br>" +
            "[You <b>might have</b> drowned!]<br>" +
            "<br>" +
            "2.\t“Might have” and “may have” refer to uncertainty.<br>" +
            "[I suppose I <b>may have</b> been rather critical.]<br>" +
            "<br>" +
            "3.\tBoth can be used in the negative to express uncertainty.<br>" +
            "[They <b>might not have</b> received our letter yet.]<br>" +
            "<br>" +
            "4.\t“Might have” is used to express annoyance at someone''s failure to do something. There is strong stress on the words underlined.<br>" +
            "[You <b>might have</b> <u>told</u> me my trousers were split!]<br>" +
            "<br>" +
            "5.\t“I might have known” + “would” is an idiom by which the speaker expresses ironically that an action was typical of someone else.<br>" +
            "[<b>I might have known</b> that he <b>would</b> be late.]<br>" +
            "[A: It was Jack who broke the vase. B: <b>I might have known</b>!]<br><br>" +
            "<b><u>“Must have” and “can’t have”</u></b><br>" +
            "1.\tThese refer to the speaker''s certainty about a past action.<br>" +
            "[Someone <b>must have</b> taken it.] (I am sure they did)<br>" +
            "[You <b>can''t have</b> lost it.] (I am sure you didn''t)<br>" +
            "<br>" +
            "2.\tBoth can also be used with surely in exclamations.<br>" +
            "[Surely you <b>can''t have</b> eaten all of it.]<br>" +
            "[Surely you <b>must have</b> noticed it.]<br><br>" +
            "<b><u>“Would not”</u></b><br>" +
            "1.\tThis expresses an unwillingness in the past.<br>" +
            "[Everyone was angry because Sam <b>wouldn''t</b> turn off the television.]<br><br>" +
            "<b><u>“Would have”</u></b><br>" +
            "1.\t“Would have” can refer to events in the past which did not actually happen.<br>" +
            "[I <b>would have</b> accepted this job, but I didn''t want to move house.]<br>" +
            "<br>" +
            "2.\tAssumptions about the past are also possible with “would have”.<br>" +
            "[A: Someone called after you left but didn''t leave a message.]<br>" +
            "[B: That <b>would have</b> been Cathy, probably.]<br><br>" +
            "<b><u>“Needn’t have and didn’t need to”</u></b><br>" +
            "1.\t“Needn''t have done” refers to an unnecessary action which was actually done.<br>" +
            "[You <b>needn''t have paid</b> all at once.] (you did pay)<br>" +
            "<br>" +
            "“Didn''t need to” refers to an unnecessary action which was not done.<br>" +
            "[I <b>didn''t need to</b> go to the dentist again, luckily.]<br>";

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

