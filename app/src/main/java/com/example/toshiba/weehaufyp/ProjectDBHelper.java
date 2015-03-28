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
            " VALUES ('1', 'Tense Consolidation','Summertime Sadness', 'Lana Del Rey', 'Born To Die', '"+R.drawable.lana_del_rey_born_to_die+"', '"+R.raw.lana_del_rey_summertime_sadness+"','"+actual_lyrics_summertime_sadness+"', '"+actual_explanation_summertime_sadness+"'), ('2', 'Passive', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"', '"+actual_explanation_locked_out_of_heaven_abstract_nouns+"'), ('3', 'Conditionals and if-sentences', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"', '"+actual_explanation_stay_with_me_abstract_nouns+"'), ('4', 'Present / Future Modals', 'Chandelier', 'Sia', '1000 Forms of Fears', '"+R.drawable.sia_1000_forms_of_fear+"', '"+R.raw.sia_chandelier+"', '"+actual_lyrics_chandelier+"', '"+actual_explanation_chandelier+"'), ('5', 'Past Modals', 'Shake It Off', 'Taylor Swift', '1989', '"+R.drawable.taylor_swift_1989+"', '"+R.raw.taylor_swift_blank_space+"', '"+actual_lyrics_shake_it_off+"', '"+actual_explanation_shake_it_off+"'), ('6', 'Articles', 'Maps', 'Maroon 5', 'V', '"+R.drawable.maroon_5_v+"', '"+R.raw.maroon_5_maps+"', '"+actual_lyrics_maps+"', '"+actual_explanation_maps+"'), ('7', 'Prepositions', 'Happy', 'Pharrell Williams', 'G I R L', '"+R.drawable.pharrell_williams_girl+"', '"+R.raw.pharrell_williams_happy+"', '"+actual_lyrics_happy+"', '"+actual_explanation_happy+"'), ('8', 'Tense Consolidation', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"', '"+actual_explanation_royals_collective_nouns+"'), ('9', 'Passive', 'Drunk In Love', 'Beyonce', 'Beyonce', '"+R.drawable.beyonce_beyonce+"', '"+R.raw.beyonce_haunted+"', '"+actual_lyrics_drunk_in_love+"', '"+actual_explanation_drunk_in_love+"'), ('10', 'Conditionals and if-sentences', 'Mirror', 'Justin Timberlake', '20/20 Experience', '"+R.drawable.justin_timberlake_the_20_20_experience_2_of_2+"', '"+R.raw.justin_timberlake_mirrors+"', '"+actual_lyrics_mirror+"', '"+actual_explanation_mirror+"'), ('11', 'Present / Future Modals', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"', '"+actual_explanation_stay_with_me_collective_nouns+"'), ('12', 'Past Modals', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"', '"+actual_explanation_locked_out_of_heaven_collective_nouns+"'), ('13', 'Articles', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"', '"+actual_explanation_royals_abstract_nouns+"')";

    //LESSON table ===================================================================================================================================
    private String SQL_CREATE_LESSON = "CREATE TABLE LESSON (" +
            "LessonID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tag TEXT," +
            "lessonContent TEXT)";

    private String tenseConsolidationLessonContent = "This lesson contains 4 sections: present time, future time, past time, and present perfect<br>" +
            "<h4>(A) Present time</h4>" +
            "<b><u>Basic contrasts: present simple and present continuous</u></b><br>" +
            "1.\tPresent simple generally refers to:<br>" +
            "Facts that are always true: [Water <b>boils</b> at 100 degrees Celsius.]<br>" +
            "Habits: [British people <b>drink</b> a lot of tea.]<br>" +
            "States: [I <b>don’t like</b> gangster films.]<br>" +
            "<br>" +
            "2.\tPresent continuous (progressive) generally refers to actions which are in progress at the moment. These can be temporary: [I’<b>m staying</b> in a hotel until I find a flat.]<br>" +
            "They can be actually in progress: [The dog <b>is sleeping</b> on our bed.]<br>" +
            "Or they can be generally in progress but not actually happening at the moment: [I’<b>m learning</b> to drive.]<br><br>" +
            "<b><u>State verbs and event (action or dynamic) verbs</u></b><br>" +
            "1.\tState verbs describe a continuing state, so do not usually have a continuous form. Typical examples are:<br>" +
            "“believe”, “belong”, “consist”, “contain”, “doubt”, “fit”, “have”, “know”, “like”, “love”, “matter”, “mean”, “own”, “prefer”, “understand”, “seem”, “suppose”, “suspect”, “want”, “wish”<br>" +
            "<br>" +
            "2.\tSome verbs have a stative meaning and a different active meaning. Typical examples are:<br>" +
            "“be”, “depend”, “feel”, “have”, “measure”, “see”, “taste”, “think”, “weigh”<br><br>" +
            "<b><u>Other uses of present continuous</u></b><br>" +
            "1.\tTemporary situations<br>" +
            "[<b>Are</b> you <b>enjoying</b> your stay here?]<br>" +
            "<br>" +
            "2.\tRepeated actions<br>" +
            "[My car has broken down, so I <b>am walking</b> to work these days.]<br>" +
            "<br>" +
            "3.\tComplaints about annoying habits<br>" +
            "[You <b>are</b> always <b>making snide remarks</b> about my cooking.]<br>" +
            "<br>" +
            "4.\tWith verbs describing change and development:<br>" +
            "[The weather <b>is getting</b> worse.]<br>" +
            "[More and more people <b>are giving up</b> smoking.]<br><br>" +
            "<b><u>Other uses of present simple</u></b><br>" +
            "1.\tMaking declarations<br>" +
            "Verbs describing opinions and feelings tend to be state verbs.<br>" +
            "[I <b>hope</b> you''ll come to my party.]<br>" +
            "[I <b>bet</b> you don''t know the answer.]<br>" +
            "<br>" +
            "2.\tHeadlines<br>" +
            "These are written in a ''telegram'' style, and references to the past are usually simplified to present simple.<br>" +
            "[Ship <b>sinks</b> in midnight collision.]<br>" +
            "<br>" +
            "3.\tInstructions and itineraries<br>" +
            "Instructions and recipes can be written in present simple instead of in imperative forms. This style is more personal.<br>" +
            "[First you <b>roll out</b> the pastry.]<br>" +
            "<br>" +
            "Itineraries are descriptions of travel arrangements.<br>" +
            "[On day three we <b>visit</b> Stratford-upon-Avon.]<br>" +
            "<br>" +
            "4.\tSummaries of events<br>" +
            "Plots of stories, films etc., and summaries of historical events use present (and present perfect) verb forms.<br>" +
            "[May 1945: The war in Europe <b>comes</b> to an end.]<br>" +
            "[At the end of the play both families <b>realize</b> that their hatred caused the deaths of the lovers.]<br>" +
            "<br>" +
            "5.\t‘Historic present’ in narrative and funny stories<br>" +
            "In informal speech, it is possible to use what we call the ''historic present'' to describe past events, especially to make the narration seem more immediate and dramatic.<br>" +
            "[So then the second man <b>asks</b> the first one why he <b>has</b> a banana in his ear and the first one says ...]<br>" +
            " <br>" +
            "<h4>(B) Future time</h4>" +
            "<b><u>Basic contrasts: will, going to, present continuous</u></b><br>" +
            "1.\t“Will” is normally known as the predictive future, and describes known facts, or what we suppose is true.<br>" +
            "[I''<b>ll</b> be late home this evening.]<br>" +
            "[The company <b>will</b> make a profit next year.]<br>" +
            "<br>" +
            "This can also take the form of an assumption.<br>" +
            "[That''<b>ll</b> be Jim at the door.] (This means that I suppose it is Jim.)<br>" +
            "<br>" +
            "2.\t“Will” is also used to express an immediate decision.<br>" +
            "[I’<b>ll</b> take this one.]<br>" +
            "<br>" +
            "3.\t“Be going to” describes intentions or plans. At the moment of speaking the plans have already been made.<br>" +
            "[I''<b>m going to</b> wait here until Carol gets back.]<br>" +
            "<br>" +
            "“Going to” is also used to describe an event whose cause is present or evident.<br>" +
            "[Look at that tree! It''<b>s going to</b> fall.]<br>" +
            "<br>" +
            "Decisions expressed with going to refer to a more distant point in the future.<br>" +
            "<br>" +
            "4.\tPresent continuous describes fixed arrangements, especially social and travel arrangements. A time reference is usually included. Note the strong similarity to the “going to” future.<br>" +
            "[I <b>am having</b> a party next week] and [I <b>am going to have</b> a party next week] are communicating the same message.<br><br>" +
            "<b><u>Future continuous</u></b><br>" +
            "1.\tThis describes an event which will be happening at a future point.<br>" +
            "[Come round in the morning. I''<b>ll be painting</b> in the kitchen.]<br>" +
            "<br>" +
            "2.\tIt can also describe events which are going to happen anyway, rather than events which we choose to make happen.<br>" +
            "[I won''t bother to fix a time to see you, because I''<b>ll be calling</b> into the office anyway several times next week.]<br>" +
            "<br>" +
            "3.\tIn some contexts future continuous also sounds more polite than “will”.<br>" +
            "[<b>Will</b> you <b>be going</b> to the shops later? If you go, could you get me some milk?]<br>" +
            "<br>" +
            "4.\tIt can also be used to refer to fixed arrangements and plans.<br>" +
            "[The band <b>will be performing</b> live in Paris this summer.]<br><br>" +
            "<b><u>Future perfect</u></b><br>" +
            "1.\tThis has both simple and continuous forms, and refers to time which we look back at from a future point.<br>" +
            "[In two years’ time I''<b>ll have finished</b> the book.]<br>" +
            "[By the end of the month, I''<b>ll have been working</b> for this firm for a year.]<br>" +
            "<br>" +
            "2.\tIt can also be used to express an assumption on the part of the speaker.<br>" +
            "[You <b>won''t have heard</b> the news, of course.] (This means that I assume you have not heard the news.)<br><br>" +
            "<h4>(C) Past time</h4>" +
            "<b><u>Basic contrasts: past simple and past continuous</u></b><br>" +
            "1.\tPast simple generally refers to:<br>" +
            "Completed actions: [I <b>got</b> up, <b>switched</b> off the radio, and <b>sat</b> down again.]<br>" +
            "Habits: [Every day I <b>went</b> to the park.]<br>" +
            "States: [In those days, I <b>didn''t like</b> reading.]<br>" +
            "<br>" +
            "2.\tPast continuous (progressive) generally refers to:<br>" +
            "Actions in progress (often interrupted by events)<br>" +
            "[I <b>was drinking</b> my coffee at the time.]<br>" +
            "[While I <b>was opening</b> the letter, the phone rang.]<br>" +
            "<br>" +
            "Background description in narrative<br>" +
            "[[I entered the office and looked around. Most people <b>were working</b> at their desks, but Jane <b>was staring</b> out of the window and <b>pretending</b> to write something at the same time.]<br>" +
            "<br>" +
            "Changing states<br>" +
            "[The car <b>was getting</b> worse all the time. One of the headlights <b>was</b> gradually <b>falling off</b>, and the engine <b>was making</b> more and more funny noises.]<br>" +
            "<br>" +
            "Repeated actions - criticism<br>" +
            "With a frequency adverb, this use is similar to the use of present continuous to express annoyance.<br>" +
            "[When Jane was at school, she <b>was</b> always <b>losing</b> things.]<br>" +
            "<br>" +
            "3.\tPast continuous is not used to describe general habitual actions, without the sense of criticism mentioned above. Past simple is used for this meaning.<br>" +
            "[When I lived in London, I <b>walked through</b> the park every day.]<br><br>" +
            "<b><u>Past perfect simple and continuous</u></b><br>" +
            "1.\tWe use the past perfect when we are already talking about the past, and we want to go back to an earlier past time (''double past'').<br>" +
            "[By the time I got to the station, the train <b>had left</b>.]<br>" +
            "<br>" +
            "2.\tPast perfect continuous (progressive)<br>" +
            "The same contrasts between past simple and past continuous (see previous section) can be made in past perfect verb forms for events further back in the past.<br>" +
            "<br>" +
            "[I <b>had been living</b> in a bed-sitter up to then.]<br>" +
            "[While I <b>had been talking</b> on the phone, Jimmy <b>had escaped</b>.]<br>" +
            "[The whole place was deserted, but it was obvious that someone <b>had been living</b> there. They''<b>d been cooking</b> in the kitchen for a start, and they <b>hadn''t bothered</b> to clear up the mess.]<br><br>" +
            "<b><u>“Used to” and “would”</u></b><br>" +
            "1.\t“Used to”<br>" +
            "This often contrasts with the present. The contrast may be stated or understood.<br>" +
            "[I <b>used to go</b> swimming a lot.] (but I don''t now)<br>" +
            "<br>" +
            "2.\t“Would”<br>" +
            "This is used to describe repeated actions, not states. It describes a habitual activity which was typical of a person.<br>" +
            "[Every week he''<b>d buy</b> his mother a bunch of flowers.]<br><br>" +
            "<b><u>Unfulfilled past events</u></b><br>" +
            "1.\tThese describe events intended to take place, but which did not happen.<br>" +
            "[I <b>was going to</b> phone you, but I forgot.]<br>" +
            "[I <b>was thinking of going</b> to Italy this year, but I haven''t decided.]<br>" +
            "[I <b>was about to</b> do it, but I started doing something else.]<br>" +
            "[Jack <b>was to have taken</b> part, but he fell ill.]<br>" +
            "<br>" +
            "2.\tThe contrasting past event is often understood, but not stated.<br>" +
            "[How are you? I <b>was going to</b> phone you.] (but I didn''t).<br>" +
            "<br>" +
            "3.\tPolite forms<br>" +
            "These are common with “wonder”.<br>" +
            "[I <b>was wondering</b> if you wanted to come to the cinema.]<br><br>" +
            "<h4>(D) Present perfect</h4>" +
            "<b><u>Present perfect simple</u></b><br>" +
            "1.\tPresent perfect simple refers to:<br>" +
            "Recent events, without a definite time given. The recentness may be indicated by “just”.<br>" +
            "[We''<b>ve missed</b> the turning.]<br>" +
            "[I''<b>ve just</b> seen a ghost!]<br>" +
            "<br>" +
            "Indefinite events, which happened at an unknown time in the past. No definite time is given.<br>" +
            "[Jim <b>has had</b> three car accidents.] (up to the present)<br>" +
            "<br>" +
            "Indefinite events which may have an obvious result in the present: [I''<b>ve twisted</b> my ankle] (that''s why I''m limping)<br>" +
            "With state verbs, a state which lasts up to the present: [I''<b>ve lived</b> here for the past ten years.]<br>" +
            "A habitual action in a period of time up to the present: [I''<b>ve been jogging</b> every morning for the last month.]<br>" +
            "<br>" +
            "2.\tContrast with past simple<br>" +
            "Past simple is used with time expressions which refer to definite times. The time may be stated or understood. Compare:<br>" +
            "[I''<b>ve bought</b> a new car.] (indefinite)<br>" +
            "[I <b>bought</b> a new car <b>last week</b>.] (definite)<br>" +
            "[I <b>bought</b> the car after all.] (implied definite: the car we talked about)<br>" +
            "<br>" +
            "Choice between past simple and present perfect for recent events may depend on the attitude of the speaker. This in turn may depend on whether the speaker feels distant in time or place from the event.<br>" +
            "<br>" +
            "[I''<b>ve left</b> my wallet in the car. I''m going back to get it.]<br>" +
            "Here the speaker may be about to return, and feels that the event is connected with the present.<br>" +
            "<br>" +
            "[I <b>left</b> my wallet in the car. I''m going back to get it.]<br>" +
            "The speaker may feel separated in time from the event, or be further away.<br><br>" +
            "<u>Present perfect continuous</u><br>" +
            "1.\tPresent perfect continuous (progressive) can refer to a range of meanings, depending on the time expression used and the context.<br>" +
            "<br>" +
            "A state which lasts up to the present moment: [I''<b>ve been waiting</b> for you for three hours.]<br>" +
            "An incomplete activity: [I''<b>ve been cleaning</b> the house but I still haven''t finished.]<br>" +
            "To emphasize duration: [I''<b>ve been writing</b> letters all morning.]<br>" +
            "A recently finished activity: [I''<b>ve been running</b>. That''s why I look hot.]<br>" +
            "A repeated activity: [I''<b>ve been taking</b> French lessons this year]<br>" +
            "<br>" +
            "2.\tContrasts with present perfect simple<br>" +
            "There may be little contrast when some state verbs are used.<br>" +
            "[How long <b>have</b> you <b>lived</b> here?]<br>" +
            "[How long <b>have</b> you <b>been living</b> here?]<br>" +
            "<br>" +
            "Some verbs (especially “sit”, “lie”, “wait” and “stay”) prefer the continuous form.<br>" +
            "There may be a contrast between completion and incompletion, especially if the number of items completed is mentioned.<br>" +
            "Completed: emphasis on achievement. [I''<b>ve ironed</b> five shirts this morning.]<br>" +
            "Incomplete, or recently completed: emphasis on duration. [I''<b>ve been ironing</b> my shirts this morning.]<br><br>" +
            "<u>Time expressions with present perfect</u><br>" +
            "1.\tMeaning with present perfect verb forms is associated with certain time expressions.<br>" +
            "Contrast with past simple may depend on the choice of time expression.<br>" +
            "<br>" +
            "Past simple: referring to a specific finished time: “yesterday”, “last week”, “on Sunday”<br>" +
            "Present perfect: with ''indefinite'' time expressions meaning ''up to now'': “since 1968”, “already”<br>" +
            "<br>" +
            "Many time expressions are not associated with a specific verb form, since they refer both to finished time or time up to the present, depending on the speaker''s perspective.<br>" +
            "[I <b>haven''t seen</b> Helen <b>recently</b>.]<br>" +
            "[I <b>saw</b> Jim <b>recently</b>.]<br>";

    private String passiveLessonContent = "<b><u>Basic uses of the passive</u></b><br>" +
            "1.\tAgent and instrument<br>" +
            "The person who performs an action in a passive sentence is called the <b>agent</b>, introduced by “by”. The agent may or may not be mentioned.<br>" +
            "[My purse was found by <b>one of the cleaners</b>.]<br>" +
            "<br>" +
            "An object which causes something to happen is called an <b>instrument</b>, introduced by “with”.<br>" +
            "[He was hit on the head with a <b>hammer</b>.]<br>" +
            "<br>" +
            "2.\tVerbs with two objects<br>" +
            "Verbs which have two objects can be made passive in two ways.<br>" +
            "[<b>I</b> was handed a <b>note</b>.] [A <b>note</b> was handed to <b>me</b>.]<br>" +
            "<br>" +
            "Other common verbs of this type are:<br>" +
            "“bring”, “give”, “lend”, “pass”, “pay”, “promise”, “sell”, “send”, “show”, “tell”<br>" +
            "<br>" +
            "3.\tVerbs with object and complement<br>" +
            "Some verbs have a noun or adjective which describes their object.<br>" +
            "[We elected Jim <b>class representative</b>.]<br>" +
            "[Everyone considered him a <b>failure</b>.]<br>" +
            "<br>" +
            "When these are made passive, the complement goes directly after the verb.<br>" +
            "[Jim was elected class representative.]<br>" +
            "[He was considered a failure.]<br><br>" +
            "<b><u>Using and not mentioning the agent</u></b><br>" +
            "1.\tChange of focus<br>" +
            "The passive can change the emphasis of a sentence.<br>" +
            "[<b>Jack</b> won the prize.] (focus on Jack)<br>" +
            "[The <b>prize</b> was won by Jack.] (focus on the prize)<br>" +
            "<br>" +
            "2.\tUnknown agent<br>" +
            "The agent is not mentioned if unknown.<br>" +
            "[My wallet <b>has been taken</b>.]<br>" +
            "In this case, there is no point in adding an agent: ''by somebody''.<br>" +
            "<br>" +
            "3.\tGeneralized agent<br>" +
            "If the subject is ''people in general'' or ''you'' the agent is not mentioned.<br>" +
            "[Bicycles <b>are</b> widely <b>used</b> in the city instead of public transport.]<br>" +
            "<br>" +
            "4.\tObvious agent<br>" +
            "If the agent is obvious or has already been referred to, it is not mentioned.<br>" +
            "[Linda <b>has been arrested</b>.] (we assume by the police)<br>" +
            "[The company agreed to our request and a new car park <b>was opened</b>.]<br>" +
            "<br>" +
            "5.\tUnimportant agent<br>" +
            "If the agent is not important to the meaning of the sentence it is not mentioned.<br>" +
            "[I <b>was advised</b> to obtain a visa in advance.]<br>" +
            "<br>" +
            "6.\tImpersonality<br>" +
            "Using the passive is a way of avoiding the naming of a specific person who is responsible for an action.<br>" +
            "[It <b>has been decided</b> to reduce all salaries by 10%.]<br>" +
            "<br>" +
            "In descriptions of processes, there is emphasis on the actions performed rather than on the people who perform them.<br>" +
            "[Then the packets <b>are packed</b> into boxes of twenty-four.]<br><br>" +
            "<b><u>“Have” and “get something done”, “need doing”</u></b><br>" +
            "1.\t“Have”/”get something done”<br>" +
            "This typically describes a service performed for us by someone else.<br>" +
            "[I''ve just <b>had/got</b> my car <b>serviced</b>. I <b>have/get</b> it <b>done</b> every winter.]<br>" +
            "<br>" +
            "It can also describe something unfortunate that happens to someone.<br>" +
            "[We <b>had/got</b> our car <b>broken</b> into last month.]<br>" +
            "<br>" +
            "“Get” is more likely to be used than have when:<br>" +
            "i) there is a feeling that something must be done.<br>" +
            "[I really must <b>get/have</b> my hair <b>cut</b>.]<br>" +
            "<br>" +
            "ii) there is a feeling of eventually managing to do something.<br>" +
            "[I eventually <b>got/had</b> the car <b>fixed</b> at the Fast Service garage.]<br>" +
            "<br>" +
            "iii) in orders and imperatives.<br>" +
            "[<b>Get</b> your hair <b>cut</b>!]<br>" +
            "<br>" +
            "Note that “get” should not be used in the present perfect passive, where it would be confused with “have got”.<br>" +
            "<br>" +
            "2.\tThe need to have a service done can be described with “need doing”.<br>" +
            "[Your hair <b>needs cutting</b>.]<br><br>" +
            "<b><u>Passive “get”</u></b><br>" +
            "1.\t“Get” can be used instead of be to form the passive in spoken language.<br>" +
            "[Martin <b>got arrested</b> at a football match.]<br><br>" +
            "<b><u>Reporting verbs</u></b><br>" +
            "1.\tPresent reference<br>" +
            "With verbs such as “believe”, “know”, “say”, “think”, which report people''s opinions, a passive construction is often used to avoid a weak subject, and to give a generalized opinion.<br>" +
            "With present reference, the passive is followed by the present infinitive.<br>" +
            "[The criminal <b>is thought to be</b> in hiding in the London area.]<br>" +
            "[Vitamin C <b>is known to be</b> good for treating colds.]<br>" +
            "<br>" +
            "2.\tPast reference<br>" +
            "With past reference, the passive is followed by the past infinitive.<br>" +
            "[Smith <b>is believed to have left</b> England last week.]<br>" +
            "<br>" +
            "3.\tPast reporting verb<br>" +
            "If the reporting verb is in the past, the past infinitive tends to follow, though not always if the verb “be” is used.<br>" +
            "[People thought Sue had paid too much.]<br>" +
            "[Sue <b>was thought to have paid</b> too much.]<br>" +
            "<br>" +
            "[The police thought that the thief was still in the house.]<br>" +
            "[The thief <b>was thought to</b> still <b>be</b> in the house.]<br>" +
            "<br>" +
            "4.\tPast reference with two objects<br>" +
            "In this case there are two ways of making a passive sentence.<br>" +
            "[Everyone knows the portrait was painted by an Italian.]<br>" +
            "[The portrait <b>is known to have been painted</b> by an Italian.]<br>" +
            "<br>" +
            "5.\tContinuous infinitive<br>" +
            "Past and present continuous infinitives are also used.<br>" +
            "[Mary <b>is thought to be</b> living in Scotland.]<br>" +
            "[The driver <b>is thought to have been</b> doing a U-turn.]<br><br>" +
            "<b><u>Verbs with prepositions</u></b><br>" +
            "1.\tEnding a sentence with a preposition<br>" +
            "It is possible to end a sentence with a preposition in a sentence where a prepositional verb is made passive.<br>" +
            "[Somebody broke into our house.]<br>" +
            "[Our house <b>was broken into</b>.]<br>" +
            "<br>" +
            "2.\t“By” and “with”<br>" +
            "“With” is used after participles such as “filled”, “packed”, “crowded”, “crammed”.<br>" +
            "[The train <b>was packed with</b> commuters.]<br>" +
            "<br>" +
            "The difference between “by” and “with” may involve the presence of a person:<br>" +
            "[Dave <b>was hit by</b> a branch.] (an accident)<br>" +
            "[Dave <b>was hit with</b> a branch.] (a person hit him with one)<br>" +
            "<br>" +
            "3.\t“Make” is followed by “to” when used in the passive.<br>" +
            "[My boss made me work hard.]<br>" +
            "[I <b>was made to</b> work hard by my boss.]<br>" +
            "<br>" +
            "4.\t“Cover” and verbs which involve similar ideas, such as “surround”, “decorate”, can use “with” or “by”. “Cover” can also be followed by “in”.<br>" +
            "[The furniture <b>was covered in</b> dust.]<br>" +
            "[The living room <b>had been decorated with</b> flowery wallpaper.]";

    private String conditionalsLessonContent = "<b><u>Basic contrasts</u></b><br>" +
            "1.\tWhat is always true: present + present<br>" +
            "[If I <b>work</b> late, I <b>get</b> tired.]<br>" +
            "[If the water <b>is</b> boiling, it means the food <b>is</b> nearly ready.]<br>" +
            "<br>" +
            "2.\tWhat was always true: past + past<br>" +
            "[We <b>went</b> home early if it <b>was</b> foggy.]<br>" +
            "[If it <b>was</b> snowing, we <b>stayed</b> at home.]<br>" +
            "<br>" +
            "3.\tReal situations: present + future<br>" +
            "Here we think that the outcome is really possible.<br>" +
            "[If you <b>keep</b> driving like that, you <b>are going to have</b> an accident.]<br>" +
            "[If you <b>see</b> Mark, tell him I <b>will</b> ring him tomorrow.]<br>" +
            "<br>" +
            "4.\tHypothetical situations: past + “would”<br>" +
            "These are unreal or imaginary situations.<br>" +
            "[If I <b>knew</b> the answer, I''<b>d</b> tell you.]<br>" +
            "[If I <b>was</b> having a party, I <b>wouldn''t</b> invite Marcia.]<br>" +
            "<br>" +
            "The verb “be” usually takes the form were for all persons in these sentences, though “was” is used in everyday speech. Note that in the first person it is possible to use “should” instead of “would”.<br>" +
            "[If I <b>left</b> home, I think I <b>should</b> be lonely.]<br>" +
            "<br>" +
            "5.\tHypothetical past situations: past perfect + “would have”<br>" +
            "These refer to past events.<br>" +
            "[If I <b>had</b> known you were coming, I <b>would have</b> met you at the station.]<br>" +
            "<br>" +
            "6.\tWith modals<br>" +
            "Possible situations in the present<br>" +
            "[If you <b>get</b> wet, you <b>should</b> change your clothes immediately.]<br>" +
            "[If you <b>come</b> early, we <b>can</b> discuss the problem together.]<br>" +
            "<br>" +
            "Hypothetical situations<br>" +
            "[If I <b>had</b> the money, I <b>could</b> help you.]<br>" +
            "<br>" +
            "Hypothetical past situations<br>" +
            "[If you <b>hadn''t</b> reminded me, I <b>might have</b> forgotten.]<br>" +
            "<br>" +
            "<b><u>Variations</u></b><br>" +
            "1.\t“If only”<br>" +
            "This adds emphasis to hypothetical situations. With past events it adds a sense of regret. The second part of the sentence is often left out.<br>" +
            "<b>[If only</b> I <b>had</b> enough time.]<br>" +
            "[<b>If only<//b> I <b>hadn''t</b> drunk too much, this <b>wouldn''t have</b> happened!]<br>" +
            "<br>" +
            "2.\t“Unless” and other alternatives to “if”<br>" +
            "“Unless” means “only if not”.<br>" +
            "[I''<b>ll</b> go ahead and get the tickets <b>unless</b> you <b>call</b> me this afternoon.] (This means if you call me this afternoon, I won''t get the tickets.)<br>" +
            "<br>" +
            "This means if one situation depends on another, “if” can be replaced by “as/so long as”, “provided” or “only if”.<br>" +
            "[I''<b>ll</b> do what you say <b>provided</b> the police <b>are not</b> informed.]<br>" +
            "<br>" +
            "“Even if” describes how something will happen whatever the condition.<br>" +
            "[<b>Even if</b> it rains, we''<b>ll</b> still go for a picnic.]<br>" +
            "<br>" +
            "3.\tPast events with results in the present: past perfect + “would”<br>" +
            "[If Jim <b>hadn''t</b> missed the plane, he <b>would be</b> here by now.]<br>" +
            "<br>" +
            "4.\t“Should”<br>" +
            "After “if”, this makes the possibility of an event seem unlikely.<br>" +
            "[<b>If</b> you <b>should</b> see Ann, <b>could</b> you ask her to call me?] (This implies that I do not expect you to see Ann.)<br>" +
            "<br>" +
            "5.\t“Were to”<br>" +
            "This also makes an event seem more hypothetical.<br>" +
            "[<b>If</b> I <b>were to</b> ask you to marry me, what <b>would</b> you say?]<br>" +
            "<br>" +
            "6.\t“Happen to”<br>" +
            "This emphasizes chance possibilities. It is often used with “should”.<br>" +
            "[<b>If</b> you <b>happen to</b> see Helen, <b>could</b> you ask her to call me?]<br>" +
            "[<b>If</b> you <b>should happen to</b> be passing, <b>drop in</b> for a cup of tea.]<br>" +
            "<br>" +
            "7.\t“If it were not for”/”if it hadn ''t been for”<br>" +
            "This describes how one event depends on another.<br>" +
            "[<b>If it weren''t for</b> Jim, this company <b>would be</b> in a mess.]<br>" +
            "[<b>If it hadn''t been for</b> their goalkeeper, United <b>would have</b> lost.]<br>" +
            "<br>" +
            "8.\t“Will” and “would”: politeness and emphasis<br>" +
            "These can be used as polite forms.<br>" +
            "[<b>If</b> you <b>will/would</b> wait here, I''<b>ll</b> see if Mrs. Green is free.]<br>" +
            "<br>" +
            "“Will” can also be used for emphasis, meaning “insist on doing”.<br>" +
            "[<b>If</b> you <b>will</b> stay out late, no wonder you <b>are</b> tired.] (insist on staying out)";

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

    private String articlesLessonContent = "<b><u>Definite article</u></b><br>" +
            "1.\tClasses<br>" +
            "This is one way to refer to classes, and is perhaps more formal than using a plural.<br>" +
            "[<b>The tiger</b> is threatened with extinction.]<br>" +
            "<br>" +
            "2.\tNational groups<br>" +
            "Groups as a whole.<br>" +
            "[<b>The French</b> eat in restaurants more than <b>the English</b>.]<br>" +
            "<br>" +
            "Single examples are not formed in the same way:<br>" +
            "[<b>A Frenchman/woman</b>, <b>an Englishman/woman</b>.]<br>" +
            "<br>" +
            "3.\tOther groups<br>" +
            "If these are clearly plural.<br>" +
            "[<b>the Social Democrats</b>], [<b>The Rolling Stones</b>]<br>" +
            "<br>" +
            "Note the difference:<br>" +
            "[<b>Pink Floyd</b>], [<b>Queen</b>] (no article)<br>" +
            "<br>" +
            "4.\tUnique objects<br>" +
            "[<b>the moon</b>], [<b>the sun</b>]<br>" +
            "<br>" +
            "Note that there are other suns and moons in the universe.<br>" +
            "[This planet has <b>a</b> small <b>moon</b>.]<br>" +
            "<br>" +
            "5.\tTitles<br>" +
            "These tend to be ''unique''.<br>" +
            "[<b>The director</b> of studies]<br>" +
            "<br>" +
            "If the title is post-modified (has a description coming after the noun), the is more likely, but not essential. Compare:<br>" +
            "[She became President in 1998.] [She became <b>(the) President</b> of the United States in 1998.]<br>" +
            "<br>" +
            "6.\tOther titles<br>" +
            "The may be part of the title, and so is capitalized.<br>" +
            "[Newspapers: <b>The Independent</b>, <b>The Sunday Times</b>]<br>" +
            "<br>" +
            "7.\tMusical instruments<br>" +
            "[Jane plays <b>the flute</b>.]<br>" +
            "[<b>The guitar</b> is my favourite instrument.]<br>" +
            "It is, of course, still possible to use a where it would naturally be used.<br>" +
            "[There was <b>a</b> small brown <b>flute</b> in the window of <b>the shop</b>.]<br>" +
            "<br>" +
            "8.\tEmphatic use<br>" +
            "This is heavily stressed and emphasises the following noun.<br>" +
            "[<b>This hotel</b> is <b>the place</b> to stay.]<br>" +
            "<br>" +
            "9.\tPlace names<br>" +
            "Post-modification, especially with “… of ….” plays a role in place names.<br>" +
            "Compare:<br>" +
            "[<b>Leeds University/The University of Leeds</b>], [<b>London Bridge/The Tower of London</b>]<br>" +
            "<br>" +
            "If the first part of a place-name is another name, then normal rules about zero article apply.<br>" +
            "[<b>Brown''s Restaurant</b>], [<b>The Garden House Hotel</b>]<br>" +
            "<br>" +
            "The same applies in geographical names:<br>" +
            "[<b>Canvey Island</b>], [<b>The Isle of Man</b>]<br>" +
            "<br>" +
            "10.\tMost and the most<br>" +
            "[<b>Most hotels</b> in England are very expensive.] (making a generalisation)<br>" +
            "[This is <b>the most expensive hotel</b> in town.] (talking about a specific hotel)<br>" +
            "<br>" +
            "11.\tImportance of context<br>" +
            "The definite article refers to already mentioned items, and so its use depends on context.<br>" +
            "[<b>The Smiths</b> had <b>a son</b> and <b>a daughter</b>. <b>The son</b> was in <b>the Army</b> and <b>the daughter</b> was training to be <b>a doctor</b>.]<br>" +
            "<br>" +
            "[On <b>the Saturday</b>, there was <b>a</b> terrible <b>storm</b>.]<br>" +
            "Here, “the Saturday” refers to a day in an area of time already mentioned.<br>" +
            "[On <b>the Saturday</b> of <b>that week</b> ...]<br><br>" +
            "<b><u>Indefinite article</u></b><br>" +
            "1.\tJobs<br>" +
            "Compare: Tony is <b>a</b> builder. Tony was <b>the builder</b> of that house.<br>" +
            "<br>" +
            "2.\tIn measuring<br>" +
            "Three times <b>a</b> week. Fifty kilometres <b>an</b> hour.<br>" +
            "£3.50 <b>a</b> kilo. £15,000 <b>a</b> year.<br>" +
            "Formally, “per” can replace “a/an”.<br>" +
            "<br>" +
            "3.\tUnknown people<br>" +
            "Use of “a/an” emphasises that a person is unknown.<br>" +
            "<b>A</b> Mr. Jones called while you were out.<br>";

    private String prepositionsLessonContent = "<b><u>Prepositions of place</u></b><br>" +
            "1.\t“In”<br>" +
            "Use “in” before buildings, towns, cities, regions, provinces, countries, and continents.<br>" +
            "[Eduardo is <b>in</b> the <b>library</b>.]<br>" +
            "[Palermo is a city <b>in Italy</b>.]<br>" +
            "<br>" +
            "2.\t“On”<br>" +
            "Use “on” before streets and bodies of water.<br>" +
            "[I live <b>on</b> a beautiful <b>street</b>.]<br>" +
            "[The boat is sailing <b>on</b> the <b>river</b>.]<br>" +
            "<br>" +
            "3.\t“At”<br>" +
            "Use “at” with street addresses and many specific locations.<br>" +
            "[Jen lives <b>at 17 Bow Street</b>.]<br>" +
            "[I will meet you <b>at</b> the <b>corner</b> of Main Street and Elm Street.]<br>" +
            "<br>" +
            "4.\t“Between”<br>" +
            "“Between” describes a location between two points.<br>" +
            "[The video store is <b>between</b> the <b>bank</b> and the <b>post office</b>.]<br>" +
            "[The house is <b>between</b> two big <b>trees</b>.]<br>" +
            "<br>" +
            "5.\t“Near”<br>" +
            "“Near” describes something close in distance.<br>" +
            "[I hope there is a cash machine <b>near</b> the <b>movie theatre</b>.]<br>" +
            "[The professor’s office is <b>near</b> the <b>chemistry laboratory</b>.]<br>" +
            "<br>" +
            "6.\t“Far from”<br>" +
            "“Far from” describes something far in distance.<br>" +
            "[Your house is too <b>far from school</b> to walk.]<br>" +
            "[The hospital is <b>far from town</b>.]<br>" +
            "<br>" +
            "7.\t“Next to”<br>" +
            "“Next to” describes something beside something else.<br>" +
            "[Her house is <b>next to yours</b>.]<br>" +
            "[The restaurant is <b>next to</b> the <b>movie theatre</b>.]<br>" +
            "<br>" +
            "8.\t“Across from”<br>" +
            "“Across from” describes something opposite something else.<br>" +
            "[The post office is across from the police station.]<br>" +
            "[Their house is a<b>cross from</b> a <b>bookstore</b>.]<br>" +
            "<br>" +
            "9.\t“Under”<br>" +
            "“Under” describes something that is below something else.<br>" +
            "[The boats pass <b>under</b> the <b>bridge</b>.]<br>" +
            "[The ball is rolling <b>under</b> the <b>car</b>.]<br>" +
            "<br>" +
            "10.\t“Over”<br>" +
            "“Over” describes something that is above something else.<br>" +
            "[The airplane is flying <b>over</b> the <b>ocean</b>.]<br>" +
            "[Her office is <b>over</b> a <b>café</b>.]<br>" +
            "<br>" +
            "<b><u>Prepositions of time</u></b><br>" +
            "1.\t“In”<br>" +
            "Use “in” before years, seasons, months, and parts of the day.<br>" +
            "[The new post office will open <b>in January</b>.]<br>" +
            "[Paris is beautiful <b>in</b> the <b>springtime</b>.]<br>" +
            "<br>" +
            "2.\t“On”<br>" +
            "Use “on” before days of the week and dates.<br>" +
            "[Some stores are closed on Sunday.]<br>" +
            "[We’ll have a St. Patrick’s Day parade on March 17th.]<br>" +
            "<br>" +
            "3.\t“At”<br>" +
            "Use “at” before a specific time of day and with the nouns noon, night, and midnight.<br>" +
            "[The Laundromat opens <b>at 9:00</b>.]<br>" +
            "[I love to walk around the city <b>at night</b>.]<br>" +
            "<br>" +
            "4.\t“From … to”<br>" +
            "Use “from … to” with beginning and ending times.<br>" +
            "[The library is open <b>from 9:30 a.m. to 5:00 p.m.</b>]<br>" +
            "[The parade will last <b>from late morning to early afternoon</b>.]<br>" +
            "<br>" +
            "5.\t“During”<br>" +
            "Use “during” with periods of time.<br>" +
            "[The supermarket is open late <b>during</b> the <b>week</b>.]<br>" +
            "[My town is usually covered in snow <b>during</b> the <b>winter</b>.]<br>" +
            "<br>" +
            "6.\t“Until”<br>" +
            "Use “until” with periods of time.<br>" +
            "[The coffee shop is open <b>until 9:00 p.m.</b>]<br>" +
            "[I am going to live here <b>until</b> I <b>graduate</b>.]<br>" +
            "<br>" +
            "7.\t“Before”<br>" +
            "Use “before” to express an earlier event or time.<br>" +
            "[I want to go to the mountains <b>before</b> summer is <b>over</b>.]<br>" +
            "[Run to the store <b>before</b> it <b>closes</b>!]<br>" +
            "<br>" +
            "8.\t“After”<br>" +
            "Use ‘after” to express a later event or time.<br>" +
            "[Let’s get a bite after the movie.]<br>" +
            "[I like to meet my friends in town after class.]<br>";

    //Insert lesson values
    private String SQL_INSERT_LESSON = "INSERT INTO LESSON " +
            "VALUES ('1', 'Tense Consolidation', '"+tenseConsolidationLessonContent+"'), ('2', 'Passive', '"+passiveLessonContent+"'), ('3', 'Conditionals and if-sentences', '"+conditionalsLessonContent+"'), ('4', 'Present / Future Modals','"+presentFutureModalsLessonContent+ "'), ('5', 'Past Modals', '"+pastModalsLessonContent+"'), ('6', 'Articles', '"+articlesLessonContent+"'), ('7', 'Prepositions', '"+prepositionsLessonContent+"')";

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
            "questionID TEXT," +
            "tag TEXT," +
            "question TEXT," +
            "answer TEXT," +
            "opta TEXT," +
            "optb TEXT," +
            "optc TEXT," +
            "optd TEXT)";

    private String SQL_INSERT_QUESTION = "INSERT INTO QUESTION " +
            "VALUES ('4.1.1', 'Present / Future Modals', '_______ it be weird to see Cristiano Ronaldo dribble the ball wearing cowboy boots?', 'Wouldn''t', 'Wouldn''t', 'Won''t', 'Shouldn''t', 'Can''t'), ('4.1.2', 'Present / Future Modals', 'Only by piecing together fragments of his past with clues he discovers in the maze _______ Thomas hope to uncover his true purpose and a way to escape.', 'can', 'will', 'shall', 'may', 'can'), ('4.1.3', 'Present / Future Modals', 'We _______ help but have these hauntingly beautiful songs stuck in our heads.', 'can''t', 'won''t', 'can''t', 'needn''t', 'mustn''t'), ('4.1.4', 'Present / Future Modals', 'Being able to show that you’ve had work experience _______ gain them the confidence that you’re more prepared than the candidates who haven’t worked a single day in their lives.', 'will', 'could', 'can', 'will', 'might'), ('4.1.5', 'Present / Future Modals', 'I once had the roommate that _______ probably be anyone’s worst nightmare.', 'would', 'would', 'might', 'shall', 'could'), ('4.1.6', 'Present / Future Modals', 'I _______ say the game _______ become rather addictive.', 'must, can', 'should, will', 'must, can', 'need to, should', 'shall, may'), ('4.1.7', 'Present / Future Modals', 'You _______ also like to try soured cream, lemon juice, flaked almonds or ground cloves.', 'might', 'may', 'might', 'ought to', 'would')";

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
        // Create tables again
        onCreate(db);
    }
}

