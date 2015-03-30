package com.example.toshiba.weehaufyp;

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
    private String actual_lyrics_style = "style by taylor swift from 1989\nlyrics will be shown here";

    //Song lyrics for passive
    private String lyrics_passive_demons = "When the days are cold<br>" +
            "And the cards all fold<br>" +
            "And the <b>saints</b> we see<br>" +
            "<b>Are</b> all <b>made of</b> gold<br>" +
            "<br>" +
            "When your dreams all fail<br>" +
            "And the ones we hail<br>" +
            "Are the worst of all<br>" +
            "And the blood’s run stale<br>" +
            "<br>" +
            "I wanna hide the truth<br>" +
            "I wanna shelter you<br>" +
            "But with the beast inside<br>" +
            "There’s nowhere we can hide<br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\tNo matter what we breed<br>" +
            "•\t<b>We</b> still <b>are made of</b> greed<br>" +
            "•\tThis is my kingdom come<br>" +
            "•\tThis is my kingdom come<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\tWhen you feel my heat<br>" +
            "•\tLook into my eyes<br>" +
            "•\tIt’s where my demons hide<br>" +
            "•\tIt’s where my demons hide<br>" +
            "•\tDon’t get too close<br>" +
            "•\tIt’s dark inside<br>" +
            "•\tIt’s where my demons hide<br>" +
            "•\tIt’s where my demons hide<br>" +
            "<br>" +
            "At the curtain’s call<br>" +
            "It''s the last of all<br>" +
            "When the lights fade out<br>" +
            "All the sinners crawl<br>" +
            "<br>" +
            "So they dug your grave<br>" +
            "And the masquerade<br>" +
            "Will come calling out<br>" +
            "At the mess you made<br>" +
            "<br>" +
            "Don''t wanna let you down<br>" +
            "But <b>I am hell bound</b><br>" +
            "Though this is all for you<br>" +
            "Don''t wanna hide the truth<br>" +
            "<br>" +
            "[Pre-chorus] + [Chorus]<br>" +
            "<br>" +
            "They say it''s what you make<br>" +
            "I say it''s up to fate<br>" +
            "<b>It''s woven</b> in my soul<br>" +
            "I need to let you go<br>" +
            "<br>" +
            "Your eyes, they shine so bright<br>" +
            "I wanna save that light<br>" +
            "I can''t escape this now<br>" +
            "Unless you show me how<br>" +
            "<br>" +
            "[Chorus]<br>";

    private String lyrics_passive_someone_like_you = "I heard that <b>you''re settled down</b><br>" +
            "That you found a girl and <b>you''re married</b> now.<br>" +
            "I heard that your dreams came true.<br>" +
            "Guess she gave you things I didn''t give to you.<br>" +
            "<br>" +
            "Old friend, why are you so shy?<br>" +
            "Ain''t like you to hold back or hide from the light.<br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\tI hate to turn up out of the blue uninvited<br>" +
            "•\tBut I couldn''t stay away, I couldn''t fight it.<br>" +
            "•\tI had hoped you''d see my face and that <b>you''d be reminded</b><br>" +
            "•\tThat for me it isn''t over.<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\tNever mind, I''ll find someone like you<br>" +
            "•\tI wish nothing but the best for you too<br>" +
            "•\tDon''t forget me, I beg<br>" +
            "•\tI''ll remember you said,<br>" +
            "•\t\"Sometimes it lasts in love but sometimes it hurts instead,<br>" +
            "•\tSometimes it lasts in love but sometimes it hurts instead\"<br>" +
            "<br>" +
            "You know how the time flies<br>" +
            "Only yesterday was the time of our lives<br>" +
            "<b>We were born and raised</b><br>" +
            "In a summer haze<br>" +
            "<b>Bound by</b> the surprise of our glory days<br>" +
            "<br>" +
            "[Chorus] + [Pre-chorus]<br>" +
            "<br>" +
            "Nothing compares<br>" +
            "No worries or cares<br>" +
            "<b>Regrets and mistakes</b><br>" +
            "<b>They are memories made</b>.<br>" +
            "Who would have known how bittersweet this would taste?<br>" +
            "<br>" +
            "2x [Chorus]<br>";

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
    private String actual_explanation_style = "explanation for style will be displayed here";

    //Song explanation for passive
    private String explanation_passive_demons = "explanation for demons passive";
    private String explanation_passive_someone_like_you = "explanation for someone like you passive";

    //Insert song values
    private String SQL_INSERT_SONG = "INSERT INTO SONG" +
            " VALUES ('1', 'Tense Consolidation','Summertime Sadness', 'Lana Del Rey', 'Born To Die', '"+R.drawable.lana_del_rey_born_to_die+"', '"+R.raw.lana_del_rey_summertime_sadness+"','"+actual_lyrics_summertime_sadness+"', '"+actual_explanation_summertime_sadness+"'), ('2', 'Passive', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"', '"+actual_explanation_locked_out_of_heaven_abstract_nouns+"'), ('3', 'Conditionals and if-sentences', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"', '"+actual_explanation_stay_with_me_abstract_nouns+"'), ('4', 'Present / Future Modals', 'Chandelier', 'Sia', '1000 Forms of Fears', '"+R.drawable.sia_1000_forms_of_fear+"', '"+R.raw.sia_chandelier+"', '"+actual_lyrics_chandelier+"', '"+actual_explanation_chandelier+"'), ('5', 'Past Modals', 'Shake It Off', 'Taylor Swift', '1989', '"+R.drawable.taylor_swift_1989+"', '"+R.raw.taylor_swift_blank_space+"', '"+actual_lyrics_shake_it_off+"', '"+actual_explanation_shake_it_off+"'), ('6', 'Articles', 'Maps', 'Maroon 5', 'V', '"+R.drawable.maroon_5_v+"', '"+R.raw.maroon_5_maps+"', '"+actual_lyrics_maps+"', '"+actual_explanation_maps+"'), ('7', 'Prepositions', 'Happy', 'Pharrell Williams', 'G I R L', '"+R.drawable.pharrell_williams_girl+"', '"+R.raw.pharrell_williams_happy+"', '"+actual_lyrics_happy+"', '"+actual_explanation_happy+"'), ('8', 'Tense Consolidation', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"', '"+actual_explanation_royals_collective_nouns+"'), ('9', 'Passive', 'Drunk In Love', 'Beyonce', 'Beyonce', '"+R.drawable.beyonce_beyonce+"', '"+R.raw.beyonce_haunted+"', '"+actual_lyrics_drunk_in_love+"', '"+actual_explanation_drunk_in_love+"'), ('10', 'Conditionals and if-sentences', 'Mirror', 'Justin Timberlake', '20/20 Experience', '"+R.drawable.justin_timberlake_the_20_20_experience_2_of_2+"', '"+R.raw.justin_timberlake_mirrors+"', '"+actual_lyrics_mirror+"', '"+actual_explanation_mirror+"'), ('11', 'Present / Future Modals', 'Stay With Me', 'Sam Smith', 'In The Lonely Hours', '"+R.drawable.sam_smith_in_the_lonely_hour+"', '"+R.raw.sam_smith_stay_with_me+"', '"+actual_lyrics_stay_with_me+"', '"+actual_explanation_stay_with_me_collective_nouns+"'), ('12', 'Past Modals', 'Locked out of Heaven', 'Bruno Mars', 'Unorthodox Jukebox', '"+R.drawable.bruno_mars_unorthodox_jukebox+"', '"+R.raw.bruno_mars_locked_out_of_heaven+"', '"+actual_lyrics_locked_out_of_heaven+"', '"+actual_explanation_locked_out_of_heaven_collective_nouns+"'), ('13', 'Articles', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_royals+"', '"+R.raw.lorde_royals+"', '"+actual_lyrics_royals+"', '"+actual_explanation_royals_abstract_nouns+"'), ('14', 'Articles', 'Style', 'Taylor Swift', '1989', '"+R.drawable.taylor_swift_1989+"', '"+R.raw.taylor_swift_style+"', '"+actual_lyrics_style+"', '"+actual_explanation_style+"'), ('2.1', 'Passive', 'Demons', 'Imagine Dragons', 'Night Visions', '"+R.drawable.imagine_dragons_night_visions+"', '"+R.raw.imagine_dragons_demons+"', '"+lyrics_passive_demons+"', '"+explanation_passive_demons+"'), ('2.2', 'Passive', 'Someone Like You', 'Adele', '21', '"+R.drawable.adele_21+"', '"+R.raw.adele_someone_like_you+"', '"+lyrics_passive_someone_like_you+"', '"+explanation_passive_someone_like_you+"')";

    //LESSON table ===================================================================================================================================
    private String SQL_CREATE_LESSON = "CREATE TABLE LESSON (" +
            "LessonID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tag TEXT," +
            "lessonContentPartOne TEXT," +
            "lessonContentPartTwo TEXT)";

    private String tenseConsolidationLessonContent = "Tense Consolidation lesson contains 4 sections: present time, future time, past time, and present perfect<br>";

    private String passiveLessonContent = "Passive lesson contains 5 sections.";

    private String conditionalsPartOneLessonContent = "1.\t<u>What is always true: present + present</u><br>" +
            "[If I <b>work</b> late, I <b>get</b> tired.]<br>" +
            "[If the water <b>is</b> boiling, it means the food <b>is</b> nearly ready.]<br>" +
            "<br>" +
            "2.\t<u>What was always true: past + past</u><br>" +
            "[We <b>went</b> home early if it <b>was</b> foggy.]<br>" +
            "[If it <b>was</b> snowing, we <b>stayed</b> at home.]<br>" +
            "<br>" +
            "3.\t<u>Real situations: present + future</u><br>" +
            "Here we think that the outcome is really possible.<br><br>" +
            "[If you <b>keep</b> driving like that, you <b>are going to have</b> an accident.]<br>" +
            "[If you <b>see</b> Mark, tell him I <b>will</b> ring him tomorrow.]<br>" +
            "<br>" +
            "4.\t<u>Hypothetical situations: past + “would”</u><br>" +
            "These are unreal or imaginary situations.<br>" +
            "[If I <b>knew</b> the answer, I''<b>d</b> tell you.]<br>" +
            "[If I <b>was</b> having a party, I <b>wouldn''t</b> invite Marcia.]<br>" +
            "<br>" +
            "The verb “be” usually takes the form were for all persons in these sentences, though “was” is used in everyday speech.<br><br>Note that in the first person it is possible to use “should” instead of “would”.<br>" +
            "[If I <b>left</b> home, I think I <b>should</b> be lonely.]<br>" +
            "<br>" +
            "5.\t<u>Hypothetical past situations: past perfect + “would have”</u><br>" +
            "These refer to past events.<br>" +
            "[If I <b>had</b> known you were coming, I <b>would have</b> met you at the station.]<br>" +
            "<br>" +
            "6.\t<u>With modals</u><br>" +
            "Possible situations in the present<br>" +
            "[If you <b>get</b> wet, you <b>should</b> change your clothes immediately.]<br>" +
            "[If you <b>come</b> early, we <b>can</b> discuss the problem together.]<br>" +
            "<br>" +
            "Hypothetical situations<br>" +
            "[If I <b>had</b> the money, I <b>could</b> help you.]<br>" +
            "<br>" +
            "Hypothetical past situations<br>" +
            "[If you <b>hadn''t</b> reminded me, I <b>might have</b> forgotten.]";

    private String conditionalsPartTwoLessonContent = "1.\t<u>“If only”</u><br>" +
            "This adds emphasis to hypothetical situations.<br><br>With past events it adds a sense of regret.<br>The second part of the sentence is often left out.<br><br>" +
            "[<b>If only</b> I <b>had</b> enough time.]<br>" +
            "[<b>If only<//b> I <b>hadn''t</b> drunk too much, this <b>wouldn''t have</b> happened!]<br>" +
            "<br>" +
            "2.\t<u>“Unless” and other alternatives to “if”</u><br>" +
            "“Unless” means “only if not”.<br><br>" +
            "[I''<b>ll</b> go ahead and get the tickets <b>unless</b> you <b>call</b> me this afternoon.] (This means if you call me this afternoon, I won''t get the tickets.)<br>" +
            "<br>" +
            "This means if one situation depends on another, “if” can be replaced by “as/so long as”, “provided” or “only if”.<br>" +
            "[I''<b>ll</b> do what you say <b>provided</b> the police <b>are not</b> informed.]<br>" +
            "<br>" +
            "“Even if” describes how something will happen whatever the condition.<br>" +
            "[<b>Even if</b> it rains, we''<b>ll</b> still go for a picnic.]<br>" +
            "<br>" +
            "3.\t<u>Past events with results in the present: past perfect + “would”</u><br>" +
            "[If Jim <b>hadn''t</b> missed the plane, he <b>would be</b> here by now.]<br>" +
            "<br>" +
            "4.\t<u>“Should”</u><br>" +
            "After “if”, this makes the possibility of an event seem unlikely.<br><br>" +
            "[<b>If</b> you <b>should</b> see Ann, <b>could</b> you ask her to call me?] (This implies that I do not expect you to see Ann.)<br>" +
            "<br>" +
            "5.\t<u>“Were to”</u><br>" +
            "This also makes an event seem more hypothetical.<br><br>" +
            "[<b>If</b> I <b>were to</b> ask you to marry me, what <b>would</b> you say?]<br>" +
            "<br>" +
            "6.\t<u>“Happen to”</u><br>" +
            "This emphasizes chance possibilities. It is often used with “should”.<br><br>" +
            "[<b>If</b> you <b>happen to</b> see Helen, <b>could</b> you ask her to call me?]<br><br>" +
            "[<b>If</b> you <b>should happen to</b> be passing, <b>drop in</b> for a cup of tea.]<br>" +
            "<br>" +
            "7.\t<u>“If it were not for”/”if it hadn ''t been for”</u><br>" +
            "This describes how one event depends on another.<br><br>" +
            "[<b>If it weren''t for</b> Jim, this company <b>would be</b> in a mess.]<br><br>" +
            "[<b>If it hadn''t been for</b> their goalkeeper, United <b>would have</b> lost.]<br>" +
            "<br>" +
            "8.\t<u>“Will” and “would”: politeness and emphasis</u><br>" +
            "These can be used as polite forms.<br>" +
            "[<b>If</b> you <b>will/would</b> wait here, I''<b>ll</b> see if Mrs. Green is free.]<br>" +
            "<br>" +
            "“Will” can also be used for emphasis, meaning “insist on doing”.<br><br>" +
            "[<b>If</b> you <b>will</b> stay out late, no wonder you <b>are</b> tired.] (insist on staying out)";

    private String presentFutureModalsLessonContent = "Present / Future Modals lesson contains 5 sections.";

    private String pastModalsLessonContent = "Past Modals lesson contains 5 sections.";

    private String articlesPartOneLessonContent = "1.\t<u>Classes</u><br>" +
            "This is one way to refer to classes, and is perhaps more formal than using a plural.<br>" +
            "[<b>The tiger</b> is threatened with extinction.]<br>" +
            "<br>" +
            "2.\t<u>National groups</u><br>" +
            "Groups as a whole.<br>" +
            "[<b>The French</b> eat in restaurants more than <b>the English</b>.]<br>" +
            "<br>" +
            "Single examples are not formed in the same way:<br>" +
            "[<b>A Frenchman/woman</b>, <b>an Englishman/woman</b>.]<br>" +
            "<br>" +
            "3.\t<u>Other groups</u><br>" +
            "If these are clearly plural.<br>" +
            "[<b>the Social Democrats</b>], [<b>The Rolling Stones</b>]<br>" +
            "<br>" +
            "Note the difference:<br>" +
            "[<b>Pink Floyd</b>], [<b>Queen</b>] (no article)<br>" +
            "<br>" +
            "4.\t<u>Unique objects</u><br>" +
            "[<b>the moon</b>], [<b>the sun</b>]<br>" +
            "<br>" +
            "Note that there are other suns and moons in the universe.<br>" +
            "[This planet has <b>a</b> small <b>moon</b>.]<br>" +
            "<br>" +
            "5.\t<u>Titles</u><br>" +
            "These tend to be ''unique''.<br>" +
            "[<b>The director</b> of studies]<br>" +
            "<br>" +
            "If the title is post-modified (has a description coming after the noun), the is more likely, but not essential.<br><br>Compare:<br>" +
            "[She became President in 1998.]<br>[She became <b>(the) President</b> of the United States in 1998.]<br>" +
            "<br>" +
            "6.\t<u>Other titles</u><br>" +
            "The may be part of the title, and so is capitalized.<br>" +
            "[Newspapers: <b>The Independent</b>, <b>The Sunday Times</b>]<br>" +
            "<br>" +
            "7.\t<u>Musical instruments</u><br>" +
            "[Jane plays <b>the flute</b>.]<br>" +
            "[<b>The guitar</b> is my favourite instrument.]<br><br>" +
            "It is, of course, still possible to use a where it would naturally be used.<br>" +
            "[There was <b>a</b> small brown <b>flute</b> in the window of <b>the shop</b>.]<br>" +
            "<br>" +
            "8.\t<u>Emphatic use</u><br>" +
            "This is heavily stressed and emphasises the following noun.<br>" +
            "[<b>This hotel</b> is <b>the place</b> to stay.]<br>" +
            "<br>" +
            "9.\t<u>Place names</u><br>" +
            "Post-modification, especially with “… of ….” plays a role in place names.<br><br>" +
            "Compare:<br>" +
            "[<b>Leeds University/The University of Leeds</b>],<br>[<b>London Bridge/The Tower of London</b>]<br>" +
            "<br>" +
            "If the first part of a place-name is another name, then normal rules about zero article apply.<br>" +
            "[<b>Brown''s Restaurant</b>], [<b>The Garden House Hotel</b>]<br>" +
            "<br>" +
            "The same applies in geographical names:<br>" +
            "[<b>Canvey Island</b>], [<b>The Isle of Man</b>]<br>" +
            "<br>" +
            "10.\t<u>Most and the most</u><br>" +
            "[<b>Most hotels</b> in England are very expensive.] (making a generalisation)<br><br>" +
            "[This is <b>the most expensive hotel</b> in town.] (talking about a specific hotel)<br>" +
            "<br>" +
            "11.\t<u>Importance of context</u><br>" +
            "The definite article refers to already mentioned items, and so its use depends on context.<br><br>" +
            "[<b>The Smiths</b> had <b>a son</b> and <b>a daughter</b>. <b>The son</b> was in <b>the Army</b> and <b>the daughter</b> was training to be <b>a doctor</b>.]<br>" +
            "<br>" +
            "[On <b>the Saturday</b>, there was <b>a</b> terrible <b>storm</b>.]<br><br>" +
            "Here, “the Saturday” refers to a day in an area of time already mentioned.<br><br>" +
            "[On <b>the Saturday</b> of <b>that week</b> ...]";

    private String articlesPartTwoLessonContent = "1.\t<u>Jobs</u><br>" +
            "Compare:<br>[Tony is <b>a</b> builder.]<br>[Tony was <b>the builder</b> of that house.]<br>" +
            "<br>" +
            "2.\t<u>In measuring</u><br>" +
            "[Three times <b>a</b> week.]<br>[Fifty kilometres <b>an</b> hour.]<br><br>" +
            "[£3.50 <b>a</b> kilo.]<br>[£15,000 <b>a</b> year.]<br><br>" +
            "Formally, “per” can replace “a/an”.<br>" +
            "<br>" +
            "3.\t<u>Unknown people</u><br>" +
            "Use of “a/an” emphasises that a person is unknown.<br>" +
            "[<b>A Mr. Jones</b> called while you were out.]";

    private String prepositionsPartOneLessonContent = "1.\t<u>“In”</u><br>" +
            "Use “in” before buildings, towns, cities, regions, provinces, countries, and continents.<br>" +
            "[Eduardo is <b>in</b> the <b>library</b>.]<br>" +
            "[Palermo is a city <b>in Italy</b>.]<br>" +
            "<br>" +
            "2.\t<u>“On”</u><br>" +
            "Use “on” before streets and bodies of water.<br>" +
            "[I live <b>on</b> a beautiful <b>street</b>.]<br>" +
            "[The boat is sailing <b>on</b> the <b>river</b>.]<br>" +
            "<br>" +
            "3.\t<u>“At”</u><br>" +
            "Use “at” with street addresses and many specific locations.<br>" +
            "[Jen lives <b>at 17 Bow Street</b>.]<br>" +
            "[I will meet you <b>at</b> the <b>corner</b> of Main Street and Elm Street.]<br>" +
            "<br>" +
            "4.\t<u>“Between”</u><br>" +
            "“Between” describes a location between two points.<br>" +
            "[The video store is <b>between</b> the <b>bank</b> and the <b>post office</b>.]<br>" +
            "[The house is <b>between</b> two big <b>trees</b>.]<br>" +
            "<br>" +
            "5.\t<u>“Near”</u><br>" +
            "“Near” describes something close in distance.<br>" +
            "[I hope there is a cash machine <b>near</b> the <b>movie theatre</b>.]<br>" +
            "[The professor’s office is <b>near</b> the <b>chemistry laboratory</b>.]<br>" +
            "<br>" +
            "6.\t<u>“Far from”</u><br>" +
            "“Far from” describes something far in distance.<br>" +
            "[Your house is too <b>far from school</b> to walk.]<br>" +
            "[The hospital is <b>far from town</b>.]<br>" +
            "<br>" +
            "7.\t<u>“Next to”</u><br>" +
            "“Next to” describes something beside something else.<br>" +
            "[Her house is <b>next to yours</b>.]<br>" +
            "[The restaurant is <b>next to</b> the <b>movie theatre</b>.]<br>" +
            "<br>" +
            "8.\t<u>“Across from”</u><br>" +
            "“Across from” describes something opposite something else.<br>" +
            "[The post office is <b>across from</b> the <b>police station</b>.]<br>" +
            "[Their house is a<b>cross from</b> a <b>bookstore</b>.]<br>" +
            "<br>" +
            "9.\t<u>“Under”</u><br>" +
            "“Under” describes something that is below something else.<br>" +
            "[The boats pass <b>under</b> the <b>bridge</b>.]<br>" +
            "[The ball is rolling <b>under</b> the <b>car</b>.]<br>" +
            "<br>" +
            "10.\t<u>“Over”</u><br>" +
            "“Over” describes something that is above something else.<br>" +
            "[The airplane is flying <b>over</b> the <b>ocean</b>.]<br>" +
            "[Her office is <b>over</b> a <b>café</b>.]";

    private String prepositionsPartTwoLessonContent = "1.\t<u>“In”</u><br>" +
            "Use “in” before years, seasons, months, and parts of the day.<br>" +
            "[The new post office will open <b>in January</b>.]<br>" +
            "[Paris is beautiful <b>in</b> the <b>springtime</b>.]<br>" +
            "<br>" +
            "2.\t<u>“On”</u><br>" +
            "Use “on” before days of the week and dates.<br>" +
            "[Some stores are closed <b>on Sunday</b>.]<br>" +
            "[We’ll have a St. Patrick’s Day parade <b>on March 17th</b>.]<br>" +
            "<br>" +
            "3.\t<u>“At”</u><br>" +
            "Use “at” before a specific time of day and with the nouns noon, night, and midnight.<br>" +
            "[The Laundromat opens <b>at 9:00</b>.]<br>" +
            "[I love to walk around the city <b>at night</b>.]<br>" +
            "<br>" +
            "4.\t<u>“From … to”</u><br>" +
            "Use “from … to” with beginning and ending times.<br>" +
            "[The library is open <b>from 9:30 a.m. to 5:00 p.m.</b>]<br>" +
            "[The parade will last <b>from late morning to early afternoon</b>.]<br>" +
            "<br>" +
            "5.\t<u>“During”</u><br>" +
            "Use “during” with periods of time.<br>" +
            "[The supermarket is open late <b>during</b> the <b>week</b>.]<br>" +
            "[My town is usually covered in snow <b>during</b> the <b>winter</b>.]<br>" +
            "<br>" +
            "6.\t<u>“Until”</u><br>" +
            "Use “until” with periods of time.<br>" +
            "[The coffee shop is open <b>until 9:00 p.m.</b>]<br>" +
            "[I am going to live here <b>until</b> I <b>graduate</b>.]<br>" +
            "<br>" +
            "7.\t<u>“Before”</u><br>" +
            "Use “before” to express an earlier event or time.<br>" +
            "[I want to go to the mountains <b>before</b> summer is <b>over</b>.]<br>" +
            "[Run to the store <b>before</b> it <b>closes</b>!]<br>" +
            "<br>" +
            "8.\t<u>“After”</u><br>" +
            "Use ‘after” to express a later event or time.<br>" +
            "[Let’s get a bite <b>after</b> the <b>movie</b>.]<br>" +
            "[I like to meet my friends in town <b>after class</b>.]<br>";

    //Insert lesson values
    private String SQL_INSERT_LESSON = "INSERT INTO LESSON " +
            "VALUES ('1', 'Tense Consolidation', '"+tenseConsolidationLessonContent+"', 'There is no second part for tenses'), ('2', 'Passive', '"+passiveLessonContent+"', 'There is no second part for passive'), ('3', 'Conditionals and if-sentences', '"+conditionalsPartOneLessonContent+"', '"+conditionalsPartTwoLessonContent+"'), ('4', 'Present / Future Modals','"+presentFutureModalsLessonContent+ "', 'There is no second part for present / future modals'), ('5', 'Past Modals', '"+pastModalsLessonContent+"', 'There is no second part for past modals'), ('6', 'Articles', '"+articlesPartOneLessonContent+"', '"+articlesPartTwoLessonContent+"'), ('7', 'Prepositions', '"+prepositionsPartOneLessonContent+"', '"+prepositionsPartTwoLessonContent+"')";

    //EXERCISE table ===================================================================================================================================
    //tag identifies the lesson name
    private String SQL_CREATE_EXERCISE = "CREATE TABLE EXERCISE (" +
            "exerciseID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tag TEXT," +
            "questions TEXT," +
            "pastResult TEXT," +
            "currentResult TEXT)";

    //Insert quiz values
    private String SQL_INSERT_EXERCISE = "INSERT INTO EXERCISE " +
            "VALUES ('1', 'Abstract Nouns','this is a question.','0,1','2')";
    //"VALUES ('1', 'Abstract Nouns','1,2','0,1','2')";

    private String SQL_INSERT_QUESTION = "INSERT INTO QUESTION " +
            "VALUES ('1.1', 'Tense Consolidation', '91% of Malaysian Gen Y _______ the actual population of Malaysia. A shocking survey done on 180 University students, with only 16 able to answer correctly within (+/- 1 million).', 'do not know', 'have not known', 'are not known with', 'do not know', 'are not knowing'), ('1.2', 'Tense Consolidation', 'Ed Sheeran _______ his 24th birthday today.', 'celebrates', 'celebrates', 'has been celebrating', 'celebrated', 'is celebrating'), ('1.3', 'Tense Consolidation', 'The _______ Australian naturalist, Steve “Crocodile Hunter” Irwin, was born today in 1962.', 'beloved', 'beloving', 'belove', 'loved', 'beloved'), ('1.4', 'Tense Consolidation', 'Kingsman: The Secret Service _______ the story of a super-secret spy organization that recruits an unrefined but promising street kid into the agency’s ultra-competitive training program.', 'tells', 'tells', 'is telling', 'has told', 'has been telling'), ('1.5', 'Tense Consolidation', 'Pure Heroine _______ young generation and critiques of mainstream culture.', 'discusses', 'discussed', 'is discussing', 'was discussed', 'discusses'), ('1.6', 'Tense Consolidation', 'Living in PJ areas _______ high living expenditure.', 'requires', 'require', 'requires', 'is requiring', 'has been requiring'), ('1.7', 'Tense Consolidation', 'I am driving a Perodua Myvi with 1.5L engine. I _______ petrol at least once a week.', 'pump', 'am pumping', 'pumped', 'pump', 'have pumped'), ('1.8', 'Tense Consolidation', '_______ a road trip to Penang with friends to sightsee, photo-explore and eat good food.', 'Have', 'Having', 'Have', 'Had', 'Has'), ('1.9', 'Tense Consolidation', 'Students from four Japanese universities visited University of Tunku Abdul Rahman (UTAR) Perak for a two-week English Immersion Programme which took place between August to mid September, and _______ with the outcome.', 'were pleased', 'has pleased', 'are pleasing', 'were pleased', 'were pleasing'), ('1.10', 'Tense Consolidation', 'The popular hairstyle for men now _______ around the top with short sides.', 'goes', 'is going', 'goes', 'has gone', 'went'), ('1.11', 'Tense Consolidation', 'Depression _______ from eating disorders is becoming increasingly common amongst students.', 'resulting', 'resulted', 'results', 'result', 'resulting'), ('1.12', 'Tense Consolidation', 'The #1 New York Times bestselling novel Divergent _______ into a movie.', 'has been adapted and made', 'is adapting and making', 'adapts and makes', 'adapted and made', 'has been adapted and made'), ('2.1', 'Passive', 'Oscar-winning movie star Sandra Bullock was the _______ actress in Hollywood over the past year, according to Forbes magazine.', 'best paid', 'best pays', 'best paying', 'best pay', 'best paid'), ('2.2', 'Passive', 'When she _______ a devastating diagnosis, Alice and her family find their bonds tested.', 'receives', 'receives', 'is receiving', 'had received', 'has received'), ('2.3', 'Passive', 'Beloved Hollywood veteran, king of comedy, and Oscar-winning actor Robin Williams _______ at the age of 63.', 'has died', 'has been dead', 'has died', 'died', 'has dead'), ('2.4', 'Passive', 'X is the second studio album released by Ed Sheeran, who _______ in popularity in recent months.', 'has exploded', 'has been exploding', 'has exploded', 'exploded', 'explodes'), ('2.5', 'Passive', 'Aside from being good for the eyes, carrots _______ with disease-fighting nutrients.', 'are packed', 'are packing', 'pack', 'are packed', 'have been packing'), ('2.6', 'Passive', 'Pure Heroine _______ for Best Pop Vocal Album at the 56th Annual Grammy Awards.', 'was nominated', 'was nominated', 'had been nominating', 'nominates', 'is nominating'), ('2.7', 'Passive', 'You know how your mom _______ you to finish the broccoli on your plate because it’s good for you? Well, it turns out that your mom was right all along.', 'used to tell', 'would tell', 'told', 'has been telling', 'used to tell'), ('2.8', 'Passive', 'Each time I pump petrol, it _______ me approximately RM65 to fill up an empty tank.', 'costs', 'cost', 'costs', 'is costing', 'will cost'), ('2.9', 'Passive', '_______ the hottest tropical paradise in Malaysia, Langkawi Island is currently rated as one of the top-notch destinations in Malaysia.', 'Deemed', 'Deem', 'Deeming', 'Deemed', 'Being deemed'), ('2.10', 'Passive', 'The job market _______ since pre-GE13 last year and even after; vacancies are still on a decline.', 'has been slow', 'will be slow', 'is slowing', 'was slow', 'has been slow'), ('2.11', 'Passive', 'Four members of SEAL Team 10 _______ with the mission to capture or kill notorious Taliban leader, Ahmad Shahd.', 'were tasked', 'were tasking', 'were tasked', 'has tasked', 'task'), ('3.1', 'Conditionals and if-sentences', 'If fresh graduate can’t even get past preliminary rounds of interviews, how _______ they expect to secure a job?', 'do', 'would', 'should', 'do', 'should'), ('3.2', 'Conditionals and if-sentences', 'Unless your name is Ebeneezer, surname Scrooge, you _______ guaranteed to leave the store with a smile on your face.', 'will be', 'are', 'must be', 'will be', 'should be'), ('3.3', 'Conditionals and if-sentences', 'If you’re into old school Eminem songs, then “W.T.P” _______ the song for you.', 'is', 'must be', 'was', 'should be', 'is'), ('3.4', 'Conditionals and if-sentences', 'I would not have failed the exam if I _______.', 'had studied', 'had studied', 'have studied', 'studied', 'was studying'), ('3.5', 'Conditionals and if-sentences', 'You could travel around the world if you _______ your job.', 'left', 'leave', 'left', 'are leaving', 'could leave'), ('3.6', 'Conditionals and if-sentences', 'If you had told me there was a problem, I _______.', 'could have helped', 'could have helped', 'would have helped', 'have had helped', 'should have helped'), ('3.7', 'Conditionals and if-sentences', 'I _______ call you if I _______ late.', 'will, am', 'shall, will be', 'will, am', 'will, will be', 'shall, am'), ('3.8', 'Conditionals and if-sentences', 'What _______ if our achievement award entry did not arrive before the closing date?', 'happens', 'happen', 'happens', 'happened', 'will happen'), ('3.9', 'Conditionals and if-sentences', 'I never _______ hitch hiked to Birmingham if it hadn’t been for love.', 'would’ve', 'could’ve', 'might’ve', 'should’ve', 'would’ve'), ('3.10', 'Conditionals and if-sentences', 'If I _______ a boy, I think I _______ understand how it _______ to love a girl.', 'were, could, feels', 'am, would, felt', 'was, could, would be feeling', 'were, could, feels', 'was, would, is feeling'), ('4.1.1', 'Present / Future Modals', '_______ it be weird to see Cristiano Ronaldo dribble the ball wearing cowboy boots?', 'Wouldn''t', 'Wouldn''t', 'Won''t', 'Shouldn''t', 'Can''t'), ('4.1.2', 'Present / Future Modals', 'Only by piecing together fragments of his past with clues he discovers in the maze _______ Thomas hope to uncover his true purpose and a way to escape.', 'can', 'will', 'shall', 'may', 'can'), ('4.1.3', 'Present / Future Modals', 'We _______ help but have these hauntingly beautiful songs stuck in our heads.', 'can''t', 'won''t', 'can''t', 'needn''t', 'mustn''t'), ('4.1.4', 'Present / Future Modals', 'Being able to show that you’ve had work experience _______ gain them the confidence that you’re more prepared than the candidates who haven’t worked a single day in their lives.', 'will', 'could', 'can', 'will', 'might'), ('4.1.5', 'Present / Future Modals', 'I once had the roommate that _______ probably be anyone’s worst nightmare.', 'would', 'would', 'might', 'shall', 'could'), ('4.1.6', 'Present / Future Modals', 'I _______ say the game _______ become rather addictive.', 'must, can', 'should, will', 'must, can', 'need to, should', 'shall, may'), ('4.1.7', 'Present / Future Modals', 'You _______ also like to try soured cream, lemon juice, flaked almonds or ground cloves.', 'might', 'may', 'might', 'ought to', 'would'), ('4.1.8', 'Present / Future Modals', 'You _______ be tired after working for the entire day.', 'must', 'must', 'may', 'could', 'would'), ('4.1.9', 'Present / Future Modals', 'No paper or other materials _______ be derived from high conservation value forests or other illegal sources.', 'shall', 'can', 'shall', 'must', 'need to'), ('4.1.10', 'Present / Future Modals', 'I came here to see if there was something I _______ do to help, but there doesn’t seem to be anything for me to do.', 'could', 'would', 'should', 'could', 'might'), ('4.1.11', 'Present / Future Modals', 'Money _______ be short when you’re a college kid, but remember to budget your spendings and save some for a rainy day.', 'may', 'could', 'should', 'will', 'may'), ('4.2.1', 'Past Modals', 'I’ve been thinking that I _______ been too critical.', 'may have', 'may have', 'might have', 'could have', 'must have'), ('4.2.2', 'Past Modals', 'I had trouble mixing with other students on campus because I’m not from around here. I wish I _______ done more in terms of blending in with the crowd here.', 'would have', 'could have', 'would have', 'should have', 'might have'), ('4.2.3', 'Past Modals', 'I _______ yelled at you. I''m sorry.', 'should not have', 'might not have', 'could not have', 'would not have', 'should not have'), ('4.2.4', 'Past Modals', 'We _______ had it all rolling in the deep.', 'could''ve', 'must''ve', 'ought to have', 'could''ve', 'might''ve'), ('4.2.5', 'Past Modals', 'Jessica is not in the classroom. She _______ left earlier.', 'must have', 'could have', 'must have', 'should have', 'might have'), ('4.2.6', 'Past Modals', 'Where’s my money? You said you _______ pay today.', 'would', 'would', 'could', 'might', 'had to'), ('4.2.7', 'Past Modals', 'I _______ go out last night because I _______ do my homework.', 'couldn’t, had to', 'shouldn’t, should', 'mustn’t, would’ve to', 'needn’t, need to', 'couldn’t, had to'), ('4.2.8', 'Past Modals', 'Tom _______ write by the age of 4.', 'could', 'might', 'would', 'had to', 'could'), ('4.2.9', 'Past Modals', 'They _______ arrived hours ago.', 'may have', 'should have', 'may have', 'must have', 'could have'), ('4.2.10', 'Past Modals', 'I _______ achieved so much if it wasn’t for you.', 'couldn’t have', 'may not have', 'wouldn’t have', 'couldn’t have', 'shouldn’t have'), ('5.1', 'Articles', 'Singapore has fined _______ smoker S$19,800 ($15,000) for throwing _______ cigarette butts out of his flat window.', 'a, -', 'the, -', 'a, the', 'a, -', 'the, the'), ('5.2', 'Articles', 'Dumplings are _______ classic Chinese food, it is _______ traditional dish eaten on Chinese New Year’s Eve among Chinese around the world.', 'a, a', 'a, a', 'a, the', 'the, a', '-, a'), ('5.3', 'Articles', 'Food has always been important; some even declare _______ romantic relationship with _______ food.', 'a, -', '-, -', 'a, -', 'a, the', 'the, -'), ('5.4', 'Articles', 'The Imitation Game is based on _______ real-life story of Alan Turing, who is credited with cracking _______ German Enigma code.', 'the, the', 'the, the', 'a, a', 'a, the', 'the, a'), ('5.5', 'Articles', '_______ team of archaeologists discovers and then explores _______ ancient pyramid buried under _______ Egyptian desert.', 'A, an, the', 'A, an, the', 'A, an, an', 'The, an, the', 'The, the, an'), ('5.6', 'Articles', '_______ Magic Tablet, _______ Egyptian artifact that keeps everything in _______ museum alive is beginning to die out.', 'The, an, the', '-, the, a', '-, an, a', 'The, the, the', 'The, an, the'), ('5.7', 'Articles', 'Technically, oatmeal is _______ form of grass seed, but can be classified as _______ vegetable.', 'a, a', 'a, a', 'the, the', 'a, -', '-, a'), ('5.8', 'Articles', 'Besides _______ locals, _______ foreign students doing their studies in Malaysia also celebrate _______ Malaysia Day together with their local friends and course mates.', 'the, -, -', 'the, -, -', 'the, the, -', '-, -, the', '-, the, the'), ('5.9', 'Articles', 'Bright-eyed fresh grads that haven’t had any working experience often leave their higher education armed with _______ degree and _______ burning drive to accomplish just about _______ million things.', 'a, a, a', 'a, a, -', 'a, a, a', 'a, the, -', '-, -, -'), ('5.10', 'Articles', 'Carrie is _______ story of _______ high school misfit Carrie White, who gradually discovers that she has _______ telekinetic powers.', 'the, a, -', 'a, a, -', 'the, a, -', 'a, the, a', 'the, the, the'), ('6.1', 'Prepositions', 'Malaysia was formed _______ the 16th of September.', 'on', 'in', 'at', 'by', 'on'), ('6.2', 'Prepositions','Spinach is rich _______ lutein and zeaxanthin, which are carotenoids that remove unstable molecules called free radicals from your body before they damage it.', 'in', 'with', 'on', 'in', 'at'), ('6.3', 'Prepositions', 'Consistently ranked _______ the top ten for best island resorts _______ Malaysia, Langkawi boasts of unmatched sun, sand, and sea experience for beach lovers.', 'in, in', 'on, at', 'in, in', 'at, at', 'at, on'), ('6.4', 'Prepositions', 'The cassette tape was popular for decades because it was compact, weight little, and small _______ size.', 'in', 'of', 'on', 'at', 'in'), ('6.5', 'Prepositions', 'MP3 is an intangible file that can be transferred _______ the internet without compromising great quality sound.', 'over','over', 'to', 'across from', 'on'), ('6.6', 'Prepositions', 'Since the l940s, plastic has been _______ a full-on, mass production mode because of its wide range of unique properties.', 'on', 'over', 'under', 'on', 'between'), ('6.7', 'Prepositions', 'Two albums _______ one year is something of a rarity _______ modern music, yet Justin Timberlake’s fans have received this treat with “20/20 Experience Part 2 of 2”.', 'in, in', 'with, on', 'in, in', 'with, in', 'in, on'), ('6.8', 'Prepositions', 'Michael Jackson died _______ the age of 50.', 'at', 'on', 'in', 'at', 'with'), ('6.9', 'Prepositions', 'He denied driving _______ 110 miles per hour.', 'at', 'with', 'until', 'after', 'at'), ('6.10', 'Prepositions', 'I dropped my bags _______ the floor.', 'on', 'on', 'to', 'at', 'over')";

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

