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

    //Song lyrics for passive
    private String lyrics_passive_demons = "<u>When the days are cold</u><br>" +
            "<u>And the cards all fold</u><br>" +
            "<u>And the <b>saints</b> we see<br>" +
            "<b>Are</b> all <b>made of</b> gold</u><br>" +
            "<br>" +
            "<u>When your dreams all fail<br>" +
            "And the ones we hail<br>" +
            "Are the worst of all</u><br>" +
            "<u>And the blood’s run stale</u><br>" +
            "<br>" +
            "<u>I wanna hide the truth<br>" +
            "I wanna shelter you</u><br>" +
            "<u>But with the beast inside<br>" +
            "There’s nowhere we can hide</u><br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\t<u>No matter what we breed<br>" +
            "•\t<b>We</b> still <b>are made of</b> greed</u><br>" +
            "•\t<u>This is my kingdom come<br>" +
            "•\tThis is my kingdom come</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\t<u>When you feel my heat</u><br>" +
            "•\t<u>Look into my eyes<br>" +
            "•\tIt’s where my demons hide<br>" +
            "•\tIt’s where my demons hide</u><br>" +
            "•\t<u>Don’t get too close<br>" +
            "•\tIt’s dark inside</u><br>" +
            "•\tIt’s where my demons hide<br>" +
            "•\tIt’s where my demons hide<br>" +
            "<br>" +
            "<u>At the curtain’s call<br>" +
            "It''s the last of all<br>" +
            "When the lights fade out<br>" +
            "All the sinners crawl</u><br>" +
            "<br>" +
            "<u>So they dug your grave<br>" +
            "And the masquerade<br>" +
            "Will come calling out<br>" +
            "At the mess you made</u><br>" +
            "<br>" +
            "<u>Don''t wanna let you down<br>" +
            "But <b>I am hell bound</b></u><br>" +
            "Though this is all for you<br>" +
            "Don''t wanna hide the truth<br>" +
            "<br>" +
            "[Pre-chorus] + [Chorus]<br>" +
            "<br>" +
            "<u>They say it''s what you make<br>" +
            "I say it''s up to fate<br>" +
            "<b>It''s woven</b> in my soul<br>" +
            "I need to let you go</u><br>" +
            "<br>" +
            "<u>Your eyes, they shine so bright<br>" +
            "I wanna save that light<br>" +
            "I can''t escape this now<br>" +
            "Unless you show me how</u><br>" +
            "<br>" +
            "[Chorus]";

    private String lyrics_passive_someone_like_you = "I heard that <b>you''re settled down</b><br>" +
            "That you found a girl and <b>you''re married</b> now<br>" +
            "I heard that your dreams came true<br>" +
            "Guess she gave you things I didn''t give to you<br>" +
            "<br>" +
            "<u>Old friend, why are you so shy?<br>" +
            "Ain''t like you to hold back or hide from the light</u><br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\t<u>I hate to turn up out of the blue uninvited</u><br>" +
            "•\tBut I couldn''t stay away, I couldn''t fight it<br>" +
            "•\t<u>I had hoped you''d see my face and that <b>you''d be reminded</b><br>" +
            "•\tThat for me it isn''t over</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\tNever mind, I''ll find someone like you<br>" +
            "•\tI wish nothing but the best for you too<br>" +
            "•\tDon''t forget me, I beg<br>" +
            "•\tI''ll remember you said,<br>" +
            "•\t\"<u>Sometimes it lasts in love but sometimes it hurts instead,<br>" +
            "•\tSometimes it lasts in love but sometimes it hurts instead</u>\"<br>" +
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
            "2x [Chorus]";

    private String lyrics_passive_you_lost_me = "<b>I am done</b>, <u>smoking gun</u><br>" +
            "We''ve lost it all, the <b>love is gone</b><br>" +
            "<u>She has won, now it''s no fun<br>" +
            "We''ve lost it all, the <b>love is gone</b></u><br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\t<u>And we had magic</u><br>" +
            "•\tAnd this is tragic<br>" +
            "•\t<u>You couldn''t keep your hands to yourself</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\t<u>I feel like <b>our world''s been infected</b><br>" +
            "•\tAnd somehow <b>you left me neglected</b><br>" +
            "•\t<b>We''ve found our lives been changed</b><br>" +
            "•\tBabe, you lost me</u><br>" +
            "<br>" +
            "<u>And we tried</u>, oh how we cried<br>" +
            "We lost ourselves, the love has died<br>" +
            "And though we tried you can''t deny<br>" +
            "<b>We''re left as shells</b>, we lost the fight<br>" +
            "<br>" +
            "[Pre-chorus] + [Chorus]<br>" +
            "<br>" +
            "Now I know you''re sorry and we were sweet<br>" +
            "But you chose lust when you deceived me<br>" +
            "And you''ll regret it, but it''s too late<br>" +
            "How can I ever trust you again?<br>" +
            "<br>" +
            "[Chorus]";

    //Song lyrics for conditionals
    private String lyrics_conditionals_happy = "It might seem crazy what I''m about to say<br>" +
            "<u>Sunshine, she''s here, you can take a break</u><br>" +
            "<u>I''m a hot air balloon that could go to space</u><br>" +
            "<u>With the air, like I don''t care baby by the way</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\tBecause I''m happy<br>" +
            "•\t<u><b>Clap</b> along <b>if</b> you <b>feel</b> like a room without a roof</u><br>" +
            "•\tBecause I''m happy<br>" +
            "•\t<u><b>Clap</b> along <b>if</b> you <b>feel</b> like happiness is the truth</u><br>" +
            "•\tBecause I''m happy<br>" +
            "•\t<b>Clap</b> along <b>if</b> you <b>know</b> what happiness is to you<br>" +
            "•\tBecause I''m happy<br>" +
            "•\t<b>Clap</b> along <b>if</b> you <b>feel</b> like that''s what you wanna do<br>" +
            "<br>" +
            "<u>Here come bad news talking this and that, yeah</u><br>" +
            "<u>Well, give me all you got, and don''t hold it back, yeah</u><br>" +
            "Well, I should probably warn you I''ll be just fine, yea,<br>" +
            "No offense to you, don''t waste your time<br>" +
            "Here''s why<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "<br>" +
            "[Bridge]<br>" +
            "(Happy)<br>" +
            "<u>Bring me down<br>" +
            "Can''t nothing, bring me down<br>" +
            "My level''s too high</u><br>" +
            "Bring me down<br>" +
            "Can''t nothing, bring me down<br>" +
            "I said (let me tell you now)<br>" +
            "Bring me down<br>" +
            "Can''t nothing, bring me down<br>" +
            "My level''s too high<br>" +
            "Bring me down<br>" +
            "Can''t nothing, bring me down<br>" +
            "I said<br>" +
            "<br>" +
            "2x [Chorus]<br>" +
            "<br>" +
            "[Bridge] + 2x [Chorus]<br>";

    private String lyrics_conditionals_if_i_were_a_boy = "<u><b>If I were</b> a boy<br>" +
            "Even just for a day<br>" +
            "<b>I’d roll</b> outta bed in the morning<br>" +
            "And throw on what I wanted and go</u><br>" +
            "<u>Drink beer with the guys<br>" +
            "And chase after girls<br>" +
            "<b>I’d kick</b> it with who I wanted<br>" +
            "And <b>I’d</b> never <b>get</b> confronted for it<br>" +
            "''Cause they’d stick up for me</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "<u><b>If I were</b> a boy<br>" +
            "<b>I think</b> I could understand<br>" +
            "How it feels to love a girl</u><br>" +
            "<u>I swear I’d be a better man</u><br>" +
            "<b>I’d listen</b> to her<br>" +
            "''Cause I know how it hurts<br>" +
            "When you lose the one you wanted<br>" +
            "''Cause he’s taken you for granted<br>" +
            "And everything you had got destroyed<br>" +
            "<br>" +
            "[Verse]<br>" +
            "<u><b>If I were</b> a boy<br>" +
            "<b>I would turn</b> off my phone<br>" +
            "Tell everyone it’s broken<br>" +
            "So they’d think that I was sleepin’ alone</u><br>" +
            "<u><b>I’d put</b> myself first<br>" +
            "And make the rules as I go<br>" +
            "''Cause I know that she’d be faithful<br>" +
            "Waitin’ for me to come home</u> (to come home)<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "<b>If I were</b> a boy<br>" +
            "<b>I think</b> I could understand<br>" +
            "How it feels to love a girl<br>" +
            "I swear I’d be a better man.<br>" +
            "<b>I’d listen</b> to her<br>" +
            "''Cause I know how it hurts<br>" +
            "When you lose the one you wanted (wanted)<br>" +
            "''Cause he’s taken you for granted (granted)<br>" +
            "And everything you had got destroyed<br>" +
            "<br>" +
            "[Bridge]<br>" +
            "It’s a little too late for you to come back<br>" +
            "Say it''s just a mistake<br>" +
            "Think I’d forgive you like that<br>" +
            "<b>If</b> you <b>thought</b> I <b>would wait</b> for you<br>" +
            "You thought wrong<br>" +
            "<br>" +
            "[Chorus 2]<br>" +
            "But you’re just a boy<br>" +
            "You don’t understand<br>" +
            "Yeah, you don’t understand, oh<br>" +
            "How it feels to love a girl someday<br>" +
            "You wish you were a better man<br>" +
            "You don’t listen to her<br>" +
            "You don’t care how it hurts<br>" +
            "Until you lose the one you wanted<br>" +
            "''Cause you’ve taken her for granted<br>" +
            "And everything you had got destroyed<br>" +
            "<br>" +
            "But you’re just a boy<br>";

    private String lyrics_conditionals_if_it_hadnt_been_for_love = "Never <b>would’ve hitch hiked</b> to Birmingham<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "Never <b>would’ve caught</b> the train to Louisiana<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "Never <b>would’ve run</b> through the blindin'' rain<br>" +
            "Without one dollar to my name<br>" +
            "<b>If it hadn''t been</b><br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "<br>" +
            "Never <b>would’ve seen</b> the trouble that I''m in<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "<b>Would’ve been</b> gone like a wayward wind<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "Nobody knows it better than me<br>" +
            "I <b>wouldn''t be wishing</b> I was free<br>" +
            "<b>If it hadn''t been</b><br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "<br>" +
            "Four cold walls against my will<br>" +
            "At least I know he''s lying still<br>" +
            "Four cold walls without parole<br>" +
            "Lord have mercy on my soul<br>" +
            "<br>" +
            "Never <b>would’ve gone</b> to that side of town<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "Never <b>would’ve took</b> a mind to track him down<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "Never <b>would’ve loaded up</b> a forty four<br>" +
            "<b>Put</b> myself behind a jail house door<br>" +
            "<b>If it hadn''t been</b><br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "<br>" +
            "Four cold walls against my will<br>" +
            "At least I know he''s lying still<br>" +
            "Four cold walls without parole<br>" +
            "Lord have mercy on my soul<br>" +
            "<br>" +
            "Never <b>would’ve hitch hiked</b> to Birmingham<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "Never <b>would’ve caught</b> the train to Louisiana<br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "Never <b>would’ve loaded up</b> a forty four<br>" +
            "<b>Put</b> myself behind a jail house door<br>" +
            "<b>If it hadn''t been</b><br>" +
            "<b>If it hadn''t been for love</b><br>" +
            "<b>If it hadn''t been</b><br>" +
            "<b>If it hadn''t been for</b> love<br>" +
            "<b>If it hadn''t been</b><br>" +
            "<b>If it hadn''t been for</b> love<br>";

    //Song lyrics for present / future modals
    private String lyrics_present_future_modals_blank_space = "Nice to meet you, where you been?<br>" +
            "I <b>could show</b> you incredible things<br>" +
            "<u>Magic, madness, heaven, sin</u><br>" +
            "Saw you there and I thought<br>" +
            "Oh my God, look at that face<br>" +
            "<u>You look like my next mistake</u><br>" +
            "Love''s a game, wanna play?<br>" +
            "<br>" +
            "<u>New money, suit and tie<br>" +
            "I <b>can read</b> you like a magazine</u><br>" +
            "Ain''t it funny, rumors fly<br>" +
            "And I know you heard about me<br>" +
            "So hey, let''s be friends<br>" +
            "<u>I''m dying to see how this one ends</u><br>" +
            "<u>Grab your passport and my hand<br>" +
            "I <b>can make</b> the bad guys good for a weekend</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\t<u>So it''s gonna be forever<br>" +
            "•\tOr it''s gonna go down in flames</u><br>" +
            "•\t<u>You <b>can tell</b> me when it''s over<br>" +
            "•\tIf the high was worth the pain</u><br>" +
            "•\tGot a long list of ex-lovers<br>" +
            "•\t<u><b>They''ll tell</b> you I''m insane</u><br>" +
            "•\t<u>''Cause you know I love the players<br>" +
            "•\tAnd you love the game<br>" +
            "<br>" +
            "•\t''Cause we''re young and we''re reckless<br>" +
            "•\t<b>We''ll take</b> this way too far<br>" +
            "•\t<b>It''ll leave</b> you breathless<br>" +
            "•\tOr with a nasty scar</u><br>" +
            "•\tGot a long list of ex-lovers<br>" +
            "•\t<b>They''ll tell</b> you I''m insane<br>" +
            "•\t<u>But I''ve got a blank space, baby<br>" +
            "•\tAnd <b>''ll write</b> your name</u><br>" +
            "<br>" +
            "<u>Cherry lips, crystal skies<br>" +
            "I <b>could show</b> you incredible things<br>" +
            "Stolen kisses, pretty lies<br>" +
            "You''re the King, baby, I''m your Queen</u><br>" +
            "Find out what you want, Be that girl for a month<br>" +
            "Wait, the worst is yet to come, oh no<br>" +
            "<br>" +
            "<u>Screaming, crying, perfect storms<br>" +
            "I <b>can make</b> all the tables turn<br>" +
            "Rose garden filled with thorns</u><br>" +
            "Keep you second guessing like<br>" +
            "<u>\"Oh my God, who is she?\"<br>" +
            "I get drunk on jealousy</u><br>" +
            "<u>But <b>you''ll come</b> back each time you leave<br>" +
            "''Cause, darling, I''m a nightmare dressed like a daydream</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "<br>" +
            "2x [Bridge]<br>" +
            "•\t<u>Boys only want love if it''s torture<br>" +
            "•\tDon''t say I didn''t say, I didn''t warn ya</u><br>" +
            "<br>" +
            "[Chorus]";

    private String lyrics_present_future_modals_elastic_heart = "<u>And another one bites the dust<br>" +
            "Oh why <b>can I not conquer</b> love?</u><br>" +
            "<u>And I might have thought that we were one<br>" +
            "Wanted to fight this war without weapons</u><br>" +
            "<br>" +
            "And I wanted it, I wanted it bad<br>" +
            "<u>But there were so many red flags</u><br>" +
            "Now another one bites the dust<br>" +
            "Yeah, let''s be clear, <b>I''ll trust</b> no one<br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\tYou did not break me<br>" +
            "•\tI''m still fighting for peace<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\t<u>Well, I''ve got thick skin and an elastic heart</u><br>" +
            "•\tBut your blade—it <b>might be too sharp</b><br>" +
            "•\tI''m like a rubber band until you pull too hard<br>" +
            "•\tYeah, I <b>may snap</b> and I move fast<br>" +
            "•\t<u>But you <b>won''t see me fall apart</b></u><br>" +
            "•\t''Cause I''ve got an elastic heart<br>" +
            "<br>" +
            "I''ve got an elastic heart<br>" +
            "Yeah, I''ve got an elastic heart<br>" +
            "<br>" +
            "And I <b>will stay up</b> through the night<br>" +
            "Let''s be clear, <b>won''t close my eyes</b><br>" +
            "And I know that <b>I can survive</b><br>" +
            "<b>I''ll walk through</b> fire to save my life<br>" +
            "<br>" +
            "<u>And I want it, I want my life so bad<br>" +
            "I''m doing everything <b>I can</b></u><br>" +
            "Then another one bites the dust<br>" +
            "It''s hard to lose a chosen one<br>" +
            "<br>" +
            " [Pre-chorus] + 3x [Chorus]<br>" +
            "<br>" +
            "I''ve got an elastic heart";

    private String lyrics_present_future_modals_make_you_feel_my_love = "<u>When the rain is blowing in your face</u><br>" +
            "<u>And the whole world is on your case<br>" +
            "I <b>could offer</b> you a warm embrace<br>" +
            "To make you feel my love</u><br>" +
            "<br>" +
            "When the evening shadows and the stars appear<br>" +
            "And there is no one there to dry your tears<br>" +
            "I <b>could hold</b> you for a million years<br>" +
            "To make you feel my love<br>" +
            "<br>" +
            "<u>I know you haven''t made your mind up yet</u><br>" +
            "But I <b>will never do</b> you wrong<br>" +
            "I''ve known it from the moment that we met<br>" +
            "No doubt in my mind where you belong<br>" +
            "<br>" +
            "<b>I''d go hungry; I''d go black and blue</b><br>" +
            "And <b>I''d go crawling</b> down the avenue<br>" +
            "No, there''s nothing that <b>I wouldn''t do</b><br>" +
            "To make you feel my love<br>" +
            "<br>" +
            "The storms are raging on the rolling sea<br>" +
            "And on the highway of regret<br>" +
            "The winds of change are blowing wild and free<br>" +
            "You ain''t seen nothing like me yet<br>" +
            "<br>" +
            "I <b>could make</b> you happy, make your dreams come true<br>" +
            "Nothing that I <b>wouldn''t do</b><br>" +
            "Go to the ends of the Earth for you<br>" +
            "To make you feel my love<br>" +
            "To make you feel my love";

    //Song lyrics for past modals
    private String lyrics_past_modals_if_it_hadnt_been_for_love = "Never <b>would’ve hitch hiked</b> to Birmingham<br>" +
            "If it hadn''t been for love<br>" +
            "Never <b>would’ve caught</b> the train to Louisiana<br>" +
            "If it hadn''t been for love<br>" +
            "Never <b>would’ve run</b> through the blindin'' rain<br>" +
            "Without one dollar to my name<br>" +
            "If it hadn''t been<br>" +
            "If it hadn''t been for love<br>" +
            "<br>" +
            "Never <b>would’ve seen</b> the trouble that I''m in<br>" +
            "If it hadn''t been for love<br>" +
            "<b>Would’ve been gone</b> like a wayward wind<br>" +
            "If it hadn''t been for love<br>" +
            "Nobody knows it better than me<br>" +
            "I <b>wouldn''t be wishing</b> I was free<br>" +
            "If it hadn''t been<br>" +
            "If it hadn''t been for love<br>" +
            "<br>" +
            "Four cold walls against my will<br>" +
            "At least I know he''s lying still<br>" +
            "Four cold walls without parole<br>" +
            "Lord have mercy on my soul<br>" +
            "<br>" +
            "Never <b>would’ve gone</b> to that side of town<br>" +
            "If it hadn''t been for love<br>" +
            "Never <b>would’ve took</b> a mind to track him down<br>" +
            "If it hadn''t been for love<br>" +
            "Never <b>would’ve loaded up</b> a forty four<br>" +
            "<b>Put</b> myself behind a jail house door<br>" +
            "If it hadn''t been<br>" +
            "If it hadn''t been for love<br>" +
            "<br>" +
            "Four cold walls against my will<br>" +
            "At least I know he''s lying still<br>" +
            "Four cold walls without parole<br>" +
            "Lord have mercy on my soul<br>" +
            "<br>" +
            "Never <b>would’ve hitch hiked</b> to Birmingham<br>" +
            "If it hadn''t been for love<br>" +
            "Never <b>would’ve caught</b> the train to Louisiana<br>" +
            "If it hadn''t been for love<br>" +
            "Never <b>would’ve loaded up</b> a forty four<br>" +
            "<b>Put</b> myself behind a jail house door<br>" +
            "If it hadn''t been<br>" +
            "If it hadn''t been for love<br>" +
            "If it hadn''t been<br>" +
            "If it hadn''t been for love<br>" +
            "If it hadn''t been<br>" +
            "If it hadn''t been for love<br>";

    private String lyrics_past_modals_the_one_that_got_away = "<u>Summer after high school when we first met</u><br>" +
            "<b>We''d make out</b> in your Mustang to Radiohead<br>" +
            "And on my 18th Birthday<br>" +
            "We got matching tattoos<br>" +
            "<br>" +
            "Used to steal your parents'' liquor<br>" +
            "And climb to the roof<br>" +
            "<u>Talk about our future<br>" +
            "Like we had a clue<br>" +
            "Never planned that one day<br>" +
            "<b>I''d be losing</b> you</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\t<u>In another life<br>" +
            "•\tI <b>would be</b> your girl<br>" +
            "•\t<b>We''d keep</b> all our promises<br>" +
            "•\tBe us against the world<br>" +
            "<br>" +
            "•\tIn another life<br>" +
            "•\tI <b>would make</b> you stay<br>" +
            "•\tSo I don''t have to say<br>" +
            "•\tYou were the one that got away<br>" +
            "•\tThe one that got away</u><br>" +
            "<br>" +
            "<u>I was June and you were my Johnny Cash</u><br>" +
            "Never one without the other, we made a pact<br>" +
            "Sometimes when I miss you<br>" +
            "I put those records on (Whoa)<br>" +
            "<br>" +
            "<u>Someone said you had your tattoo removed</u><br>" +
            "Saw you downtown singing the Blues<br>" +
            "<u>It''s time to face the music</u><br>" +
            "I''m no longer your muse<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "The o-o-o-o-o-one [x3]<br>" +
            "The one that got away<br>" +
            "<br>" +
            "[Bridge:]<br>" +
            "All this money can''t buy me a time machine (Nooooo)<br>" +
            "Can''t replace you with a million rings (Nooooo)<br>" +
            "<u>I <b>should''ve told</b> you what you meant to me (Whoa)<br>" +
            "''Cause now I pay the price</u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "The o-o-o-o-o-one [x3]<br>" +
            "<br>" +
            "In another life<br>" +
            "I <b>would make</b> you stay<br>" +
            "So I don''t have to say<br>" +
            "You were the one that got away<br>" +
            "The one that got away<br>";

    //Song lyrics for articles


    //Song lyrics for prepositions
    private String lyrics_prepositions_royals = "<u>I''ve never seen a diamond <b>in the flesh</b></u><br>" +
            "<u>I cut my teeth <b>on wedding rings</b> <b>in the movies</b></u><br>" +
            "<u>And I''m not <b>proud of my address</b><br>" +
            "<b>In a torn-up town</b>, no postcode envy</u><br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\t<u>But every song''s like gold teeth, grey goose, trippin'' <b>in the bathroom</b><br>" +
            "•\tBlood stains, ball gowns, trashin'' the hotel room</u><br>" +
            "•\t<u>We don''t care, we''re driving Cadillacs <b>in our dreams</b></u><br>" +
            "•\t<u>But everybody''s like Cristal, Maybach, diamonds <b>on your timepiece</b><br>" +
            "•\tJet planes, islands, tigers <b>on a gold leash</b></u><br>" +
            "•\t<u>We don''t care, we aren''t caught up <b>in your love affair</b></u><br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\t<u>And we''ll never be royals (royals)<br>" +
            "•\tIt don''t run <b>in our blood</b><br>" +
            "•\tThat kind of luxe just ain''t for us<br>" +
            "•\tWe crave a different kind of buzz</u><br>" +
            "•\t<u>Let me be your ruler (ruler)<br>" +
            "•\tYou can call me queen Bee<br>" +
            "•\tAnd baby I''ll rule, I''ll rule, I''ll rule, I''ll rule<br>" +
            "•\tLet me live that fantasy</u><br>" +
            "<br>" +
            "<u>My friends and I, we''ve cracked the code.<br>" +
            "We count our dollars <b>on the train</b> <b>to the party</b><br>" +
            "And everyone who knows us knows that we''re fine with this<br>" +
            "We didn''t <b>come from money</b></u><br>" +
            "<br>" +
            "[Pre-chorus] + [Chorus]<br>" +
            "<br>" +
            "Ooh ooh oh<br>" +
            "<u>We''re bigger than we ever dreamed<br>" +
            "And I''m <b>in love</b> with being queen</u><br>" +
            "Ooh ooh oh<br>" +
            "<u>Life is great without a care</u><br>" +
            "We aren''t caught up <b>in your love affair</b><br>" +
            "<br>" +
            "[Chorus]";

    private String lyrics_prepositions_summertime_sadness = "[Chorus]<br>" +
            "•\t<u>Kiss me hard before you go</u><br>" +
            "•\t<u>Summertime sadness</u><br>" +
            "•\t<u>I just wanted you to know<br>" +
            "•\tThat, baby, you''re the best</u><br>" +
            "<br>" +
            "I <b>got my red dress on</b> tonight<br>" +
            "Dancing <b>in the dark</b> <b>in the pale moonlight</b><br>" +
            "Done my hair up real big beauty queen style<br>" +
            "<u>High heels off, I''m feeling alive</u><br>" +
            "<br>" +
            "[Pre-chorus]<br>" +
            "•\t<u>Oh, my God, I feel it <b>in the air</u></b><br>" +
            "•\t<u><b>Telephone wires above</b> are sizzling like a snare</u><br>" +
            "•\t<u>Honey, I''m <b>on fire</b>, I feel it everywhere<br>" +
            "•\tNothing scares me anymore</u><br>" +
            "•\t(1, 2, 3, 4)<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "<br>" +
            "[Post-chorus]<br>" +
            "•\tI got that summertime, summertime sadness<br>" +
            "•\tS-s-summertime, summertime sadness<br>" +
            "•\tGot that summertime, summertime sadness<br>" +
            "•\tOh, oh, oh, oh, oh<br>" +
            "<br>" +
            "<u>I''m feelin'' electric tonight</u><br>" +
            "<u>Cruising down the coast goin'' ''bout 99</u><br>" +
            "<u>Got my bad baby <b>by my heavenly side</b><br>" +
            "I know if I go, I''ll die happy tonight</u><br>" +
            "<br>" +
            "[Pre-chorus] + [Chorus] + [Post-chorus]<br>" +
            "<br>" +
            "Think I''ll miss you forever<br>" +
            "<u>Like the stars miss the sun <b>in the morning sky</b></u><br>" +
            "<u>Later''s better than never<br>" +
            "Even if you''re gone I''m gonna drive (drive, drive)</u><br>" +
            "<br>" +
            "[Post-chorus] + [Chorus] + [Post-chorus]";

    private String lyrics_prepositions_thinking_out_loud = "<u>When your legs don''t work like they used to before<br>" +
            "And I can''t <b>sweep you off of your feet</b><br>" +
            "Will your mouth still remember the taste of my love?<br>" +
            "Will your eyes still smile from your cheeks?</u><br>" +
            "<br>" +
            "<u>And, darling, I will be loving you ''til we''re 70<br>" +
            "And, baby, my heart could still fall as hard <b>at 23</b><br>" +
            "And I''m thinking ''bout how</u><br>" +
            "<br>" +
            "<u>People <b>fall in love in mysterious ways</b><br>" +
            "Maybe just the touch of a hand<br>" +
            "Well, me—I <b>fall in love</b> with you every single day</u><br>" +
            "And I just wanna tell you I am<br>" +
            "<br>" +
            "[Chorus]<br>" +
            "•\t<u>So honey now<br>" +
            "•\tTake me <b>into your loving arms</b><br>" +
            "•\tKiss me <b>under the light of a thousand stars</b><br>" +
            "•\tPlace your head <b>on my beating heart</b><br>" +
            "•\tI''m thinking out loud</u><br>" +
            "•\tThat maybe we found love right where we are<br>" +
            "<br>" +
            "<u>When my hair''s all but gone and my memory fades<br>" +
            "And the crowds don''t remember my name<br>" +
            "When my hands don''t play the strings the same way<br>" +
            "I know you will still love me the same</u><br>" +
            "<br>" +
            "<u>''Cause honey your soul could never grow old, it''s evergreen</u><br>" +
            "<u>And, baby, your smile''s forever <b>in my mind and memory</b></u><br>" +
            "I''m thinking ''bout how<br>" +
            "<br>" +
            "<u>People <b>fall in love in mysterious ways</b><br>" +
            "Maybe it''s all part of a plan</u><br>" +
            "<u>Well, I''ll just <b>keep on making the same mistakes</b><br>" +
            "Hoping that you''ll understand</u><br>" +
            "<br>" +
            "2x [Chorus]<br>" +
            "Oh, baby, we found love right where we are<br>" +
            "And we found love right where we are";

    //Song explanation for tense consolidation

    //Song explanation for passive
    private String explanation_passive_demons = "<u>When the days are cold</u><br>" +
            "Cold days symbolize sadness and rough times — when your demons are bogging you down.<br><br>" +
            "<u>And the cards all fold</u><br>" +
            "In poker, to fold your cards is to concede that round and end your turn. This is common when dealt a bad hand or under the impression that your opponent has better cards than you do. Metaphorically, life has its hard times where things don’t work out — similar to being dealt bad hand.<br><br>" +
            "<u>And the saints we see<br>" +
            "Are all made of gold<br></u>" +
            "This refers to the worshiping of false or “golden” idols. This implies that there is a current lack of good — or “saintly” — people, and the only saints left are the ones in pictures or golden statues.<br><br>" +
            "<u>When your dreams all fail<br>" +
            "And the ones we hail<br>" +
            "Are the worst of all</u><br>" +
            "When all your dreams fail, the people and ideas someone thinks are the best can actually be the worst ones that have been holding them back.<br><br>" +
            "<u>And the blood’s run stale</u><br>" +
            "If your heart stops beating, your blood becomes deoxygenated and you die. A beating heart is a metaphor for ambition or passion. Without that passion, why bother?<br><br>" +
            "<u>I wanna hide the truth<br>" +
            "I wanna shelter you</u><br>" +
            "The truth often hurts others in the short term, so it is hidden to protect or shelter their feelings.<br><br>" +
            "<u>But with the beast inside<br>" +
            "There’s nowhere we can hide</u><br>" +
            "Though he wants to hide who he really is, it is impossible to hide from something that is inside of him.<br><br>" +
            "<u>No matter what we breed<br>" +
            "We still are made of greed</u><br>" +
            "Everything we do, we do it for a specific reason which is driven by greed and our own selfishness.<br><br>" +
            "<u>This is my kingdom come<br></u>" +
            "<b>Kingdom come</b> usually means the end of the world. He is comparing his struggles with the apocalypse, specifically alluding to the end of his world.<br><br>" +
            "<u>When you feel my heat</u><br>" +
            "When the lover feels the “heat” (things start to get too intense to handle) they have gained the emotional trust needed to expose his demons, or conflicted inner-self.<br><br>" +
            "<u>Look into my eyes<br>" +
            "It’s where my demons hide</u><br>" +
            "Many people say the eyes are the window to the soul, so they would also be where your inner demons would be visible.<br><br>" +
            "<u>Don’t get too close<br>" +
            "It’s dark inside</u><br>" +
            "He asks the subject to look into his eyes so they can realize how dangerous he is, so they don’t get too emotionally close to him.<br><br>" +
            "<u>At the curtain’s call<br>" +
            "It''s the last of all<br>" +
            "When the lights fade out<br>" +
            "All the sinners crawl</u><br>" +
            "When the curtain is cast aside, all the horrible things are revealed.<br><br>" +
            "<u>So they dug your grave<br>" +
            "And the masquerade<br>" +
            "Will come calling out<br>" +
            "At the mess you made</u><br>" +
            "Everybody is just waiting for you to fail. They lead you into making your own bad actions, just to spit them back at your face afterwards.<br><br>" +
            "<u>Don''t wanna let you down<br>" +
            "But I am hell bound</u><br>" +
            "He doesn’t mean to disappoint anyone but he has a dark side — these “demons” destine him for Hell. He is making it appear as if everything is under control but these demons are always there.<br><br>" +
            "<u>They say it''s what you make<br>" +
            "I say it''s up to fate<br>" +
            "It''s woven in my soul<br>" +
            "I need to let you go</u><br>" +
            "He’s trying to place the blame for all his wrongdoings on fate/destiny. A man can try to cover up, appear to be good, try to be good, but at the end of the day true nature prevails. The “bad” that is in him is an inherent part of his soul.<br><br>" +
            "<u>Your eyes, they shine so bright<br>" +
            "I wanna save that light<br>" +
            "I can''t escape this now<br>" +
            "Unless you show me how</u><br>" +
            "He’s acknowledging the subject’s perfection, and he wants to save that. The subject is precious to him, and is a role model.";

    private String explanation_passive_someone_like_you = "<u>Old friend, why are you so shy?<br>" +
            "Ain''t like you to hold back or hide from the light</u><br>" +
            "He’s not talking to her the way he used to and she can tell he’s biting his tongue<br>" +
            "<b>Biting your tongue</b> means to stop yourself from saying something that you would really like to say.<br><br>" +
            "<u>I hate to turn up out of the blue uninvited</u><br>" +
            "She doesn’t want to seem annoying when she shows up at the boy’s house without being invited or telling him.<br><br>" +
            "<u>I had hoped you''d see my face and that you''d be reminded<br>" +
            "That for me it isn''t over</u><br>" +
            "All though he had already moved on, she hoped he understood that she had not moved on (by facial expressions.)<br><br>" +
            "<u>Sometimes it lasts in love but sometimes it hurts instead</u><br>" +
            "Sometimes people fall in love and stay there, other times it doesn’t work out and ends in pain.";

    private String explanation_passive_you_lost_me = "<b>Smoking gun</b> means something that serves as strong evidence or irrefutable proof.<br><br>" +
            "<u>She has won, now it''s no fun<br>" +
            "We''ve lost it all, the love is gone</u><br>" +
            "She has decided to end the relationship over a girl who got in between in it.<br><br>" +
            "<u>And we had magic</u><br>" +
            "They had something like no other relationship has.<br><br>" +
            "<u>You couldn''t keep your hands to yourself</u><br>" +
            "He couldn’t resist cheating on her.<br><br>" +
            "<u>I feel like our world''s been infected<br>" +
            "And somehow you left me neglected<br>" +
            "We''ve found our lives been changed<br>" +
            "Babe, you lost me</u><br>" +
            "She doesn’t understand how such thing happened their love was so strong so she thinks maybe it was infected. He lost her because of the mistake he has done.<br><br>" +
            "<u>And we tried</u><br>" +
            "They tried to keep the relationship going.";

    //Song explanation for conditionals
    private String explanation_conditionals_happy = "<u>Sunshine, she''s here, you can take a break</u><br>" +
            "The happiness she gives him can outshine the sun, that’s why he says the sun can take a break since there is already someone shinier than it.<br><br>" +
            "<u>I''m a hot air balloon that could go to space</u><br>" +
            "He is so full of happiness that he can rise to the outer space.<br><br>" +
            "<u>With the air, like I don''t care baby by the way</u><br>" +
            "No worries, cares, or stress.<br><br>" +
            "<u>Clap along if you feel like a room without a roof</u><br>" +
            "<b>A room without a roof</b> means one’s space without limit and barrier, implying that he’s limitlessly happy.<br><br>" +
            "<u>Clap along if you feel like happiness is the truth</u><br>" +
            "Being happy and in harmony with yourself and the universe is the ultimate truth of existence.<br><br>" +
            "<u>Here come bad news talking this and that, yeah</u><br>" +
            "He sees bad people and things go by in the world.<br><br>" +
            "<u>Well, give me all you got, and don''t hold it back, yeah</u><br>" +
            "He challenges and welcomes them to even try to bring him down from his high.<br><br>" +
            "<u>Bring me down<br>" +
            "Can''t nothing, Bring me down<br>" +
            "My level''s too high</u><br>" +
            "<b>Bring me down</b> means make me sad or unhappy. Nothing can bring him down because he’s too happy.";

    private String explanation_conditionals_if_it_hadnt_been_for_love = "The explanation for If It Hadn''t Been For Love is currently unavailable.<br>Please check back later.";

    private String explanation_conditionals_if_i_were_a_boy = "<u>If I were a boy<br>" +
            "Even just for a day<br>" +
            "I’d roll outta bed in the morning<br>" +
            "And throw on what I wanted and go</u><br>" +
            "If she were male she would not need to worry about her outward appearance.<br><br>" +
            "<u>Drink beer with the guys<br>" +
            "And chase after girls<br>" +
            "I’d kick it with who I wanted<br>" +
            "And I’d never get confronted for it<br>" +
            "''Cause they’d stick up for me</u><br>" +
            "She is explaining society’s double standard about men and women; the idea that certain types of behavior are “normal” for men and not women. In society’s eyes, men are naturally prone to behaving more unruly and women are naturally more reserved.<br><br>" +
            "<u>If I were a boy<br>" +
            "I think I could understand<br>" +
            "How it feels to love a girl</u><br>" +
            "If she were a boy she would recognize how a girl felt and understand how she feels, therefore knowing how to comfort her which most men are not very good at.<br><br>" +
            "<u>I swear I’d be a better man</u><br>" +
            "She knows that if she were a guy, she’d be much better to her girl than her guy is to her now.<br><br>" +
            "<u>If I were a boy<br>" +
            "I would turn off my phone<br>" +
            "Tell everyone it’s broken<br>" +
            "So they’d think that I was sleepin’ alone</u><br>" +
            "This implies men get away with obvious lies more so than women, echoes with the “they’d stick up for me” line.<br><br>" +
            "<u>I’d put myself first<br>" +
            "And make the rules as I go<br>" +
            "''Cause I know that she’d be faithful<br>" +
            "Waitin’ for me to come home</u><br>" +
            "Women excuse bad behavior in men because it’s expected that men will cheat and women will stay.";

    //Song explanation for present / future modals
    private String explanation_present_future_modals_blank_space = "<u>Magic, madness, heaven, sin</u><br>" +
            "She predicts that the relationship is bound to be an exciting one, and due to the chemistry between them the sparks will feel like magic. However, she knows the boy is trouble and as a result it is completely reckless and mad of her to pursue him. But, she will regardless.<br><br>" +
            "<u>You look like my next mistake</u><br>" +
            "This line epitomizes the theme of the song. She knows the boy is trouble and will break her heart and it will be a big mistake to pursue something with him.<br><br>" +
            "<u>New money, suit and tie<br>" +
            "I can read you like a magazine</u><br>" +
            "She focuses on materialistic things in these lines emphasizing how there is nothing true, deep or genuine about the relationship. It is purely for show and based on appearances.<br><br>" +
            "<u>I''m dying to see how this one ends</u><br>" +
            "She makes it clear that she doesn’t expect this relationship to go anywhere in the long-run, but she’s interested to pursue it anyway.<br><br>" +
            "<u>Grab your passport and my hand<br>" +
            "I can make the bad guys good for a weekend</u><br>" +
            "She wants to go on an adventure with her boy for the weekend. The fact that they can so quickly be whisked away indicates the whimsical, fast-paced nature of the relationship and also the lack of its solidity.<br><br>" +
            "<u>So it''s gonna be forever<br>" +
            "Or it''s gonna go down in flames</u><br>" +
            "Taylor presents only two options: the couple can end up getting married and spend forever together, or, more likely, they can have a heated fling followed by a volatile break-up.<br><br>" +
            "<u>You can tell me when it''s over<br>" +
            "If the high was worth the pain</u><br>" +
            "Many do drugs, something potentially destructive, to feel a “high” which only lasts for a small amount of time. After the high, they are left with the pain of reality.<br><br>" +
            "<u>They''ll tell you I''m insane</u><br>" +
            "It’s crazy for her to want to something that she knows will just end badly.<br><br>" +
            "<u>''Cause we''re young and we''re reckless<br>" +
            "We''ll take this way too far<br>" +
            "It''ll leave you breathless<br>" +
            "Or with a nasty scar</u><br>" +
            "She says that because they’re still young and imperfect, they will take their love to extreme lengths. They are also reckless with love, and often aren’t careful enough in relationships. They will allow themselves to fall for each other, further than what they should knowing the danger. This will potentially will leave them exhausted or scarred during that time.<br><br>" +
            "<u>But I''ve got a blank space, baby<br>" +
            "And I''ll write your name</u><br>" +
            "The blank space may be on her heart and she’s ready to carve his name on it.<br><br>" +
            "<u>Cherry lips, crystal skies<br>" +
            "I could show you incredible things<br>" +
            "Stolen kisses, pretty lies<br>" +
            "You''re the King, baby, I''m your Queen</u><br>" +
            "This highlights the fun, carefree nature of the relationship. The idea of a King and Queen is brought into play, to indicate the fairytale, storybook nature of the wonderful first stages of the relationship.<br><br>" +
            "<u>Screaming, crying, perfect storms<br>" +
            "I can make all the tables turn<br>" +
            "Rose garden filled with thorns</u><br>" +
            "She states that although she may seem pretty on the outside, like a rose garden, she is actually very dangerous and you will get hurt if you mess with her.<br><br>" +
            "<u>\"Oh my God, who is she?\"<br>" +
            "I get drunk on jealousy</u><br>" +
            "She is portrayed to be very paranoid about her boyfriends cheating.<br><br>" +
            "<u>But you''ll come back each time you leave<br>" +
            "''Cause, darling, I''m a nightmare dressed like a daydream</u><br>" +
            "She is portrayed to be someone who lures men in with her good looks but once they enter into a relationship with her she becomes crazy and obsessive — and it is like a nightmare rather than what her current significant other might have perceived her to be.<br>" +
            "As with the rest of the verse, these lines are meant to be viewed ironically.\n<br><br>" +
            "<u>Boys only want love if it''s torture<br>" +
            "Don''t say I didn''t say, I didn''t warn ya</u><br>" +
            "Boys are often intrigued by mystery and drama, they don’t want boring good girls. She is thus warning her potential lover that he mustn’t expect her to be sweet and the relationship to be easy. If he enters into something with her, he must be prepared for a crazy ride.";

    private String explanation_present_future_modals_elastic_heart = "<u>And another one bites the dust<br>" +
            "Oh why can I not conquer love?</u><br>" +
            "She uses the common metaphor of love as war. The opening phrase, “another one bites the dust,” borrows the title of a Queen song to suggest a recent relationship has failed, and that it feels like a death.<br><br>" +
            "<u>And I might have thought that we were one<br>" +
            "Wanted to fight this war without weapons</u><br>" +
            "In this context, “war” feels like allusion to the phrase “make love, not war.” She wants to fight for the peace of her relationship.<br><br>" +
            "<u>But there were so many red flags</u><br>" +
            "<b>Red flags</b> refer to warning indicators. Like flags used in motor racing. The red flag indicated conditions are too unsafe to continue.<br><br>" +
            "<u>Well, I''ve got thick skin and an elastic heart</u><br>" +
            "Having a <b>thick skin</b> means you don’t let what people do and say get to you.<br><br>" +
            "<u>But you won''t see me fall apart</u><br>" +
            "She doesn’t want or let anyone to see her vulnerable and broken apart.<br><br>" +
            "<u>And I want it, I want my life so bad<br>" +
            "I''m doing everything I can</u><br>" +
            "She’s doing anything that she is capable of in an attempt to get recognized or to be successful.";

    private String explanation_present_future_modals_make_you_feel_my_love = "<u>When the rain is blowing in your face</u><br>" +
            "Bad weather is a metaphor for adversity that reappears in this song. The message is that love is most felt in the midst of trails and tribulations.<br><br>" +
            "<u>And the whole world is on your case<br>" +
            "I could offer you a warm embrace<br>" +
            "To make you feel my love</u><br>" +
            "When everybody is against you and it feels like nobody is there for you, she is going to be there so you understand how much she loves you.<br><br>" +
            "<u>I know you haven''t made your mind up yet</u><br>" +
            "It’s known that her love has gone unrequited.";

    //Song explanation for past modals
    private String explanation_past_modals_if_it_hadnt_been_for_love = "The explanation for If It Hadn''t Been For Love is currently unavailable.<br>Please check back later.";

    private String explanation_past_modals_the_one_that_got_away = "<u>Summer after high school when we first met</u><br>" +
            "They met after high school when they had already graduated.<br><br>" +
            "<u>Talk about our future<br>" +
            "Like we had a clue<br>" +
            "Never planned that one day<br>" +
            "I''d be losing you</u><br>" +
            "They would talk about the future plans they made. She had ever thought about losing him.<br><br>" +
            "<u>In another life<br>" +
            "I would be your girl<br>" +
            "We''d keep all our promises<br>" +
            "Be us against the world<br>" +
            "In another life<br>" +
            "I would make you stay<br>" +
            "So I don''t have to say<br>" +
            "You were the one that got away<br>" +
            "The one that got away</u><br>" +
            "In a parallel universe, or in a different world, she would have stayed with him, and everything would be okay because she would still be with him, all their promises of loving each other forever would have been kept, and they wouldn’t have broken up as a result.<br><br>" +
            "<u>I was June and you were my Johnny Cash</u><br>" +
            "June was Johnny Cash’s wife. She compares her relationship with her lover to that of Johnny Cash and his wife’s.<br><br>" +
            "<u>Someone said you had your tattoo removed</u><br>" +
            "After their break up, he removed the tattoo that he had when he was with her, during the line “we got matching tattoos”.<br><br>" +
            "<u>It''s time to face the music</u><br>" +
            "<b>Face the music</b> means be confronted with the unpleasant consequences of one''s actions.<br><br>" +
            "<u>I should''ve told you what you meant to me (Whoa)<br>" +
            "''Cause now I pay the price</u><br>" +
            "Before the guy left her, she didn’t tell him how much she loved him. If she had, things would have been different, but since she did not, she’s suffering because of the decision she made.";

    //Song explanation for articles

    //Song explanation for prepositions
    private String explanation_prepositions_royals = "<u>I''ve never seen a diamond in the flesh</u><br>" +
            "She depicts her lifestyle as being very basic, as she has never seen luxurious items such as diamonds in real life. The only reason she knows about these things is because of their role in popular culture. Therefore, she has only seen these things through a silver screen.<br><br>" +
            "<u>I cut my teeth on wedding rings in the movies</u><br>" +
            "She has only been introduced to the ideas of materialism in the movies — without these she never would have known about diamonds and the greed they symbolize.<br>" +
            "<b>Cut your teeth on something</b> means to gain your first significant experience.<br><br>" +
            "<u>And I''m not proud of my address<br>" +
            "In a torn-up town, no postcode envy</u><br>" +
            "No one envies her hometown, mainly because very few people outside of it (New Zealand) even know about it.<br><br>" +
            "<u>But every song''s like gold teeth, grey goose, trippin'' in the bathroom<br>" +
            "Blood stains, ball gowns, trashin'' the hotel room</u><br>" +
            "She subtly criticises mainstream music of today. She feels that artists shouldn’t just follow what everyone else is doing. She is tired of all the things that have been discussed endlessly by these artists, topics such as expensive cars, clothes and alcohol.<br><br>" +
            "<u>We don''t care, we''re driving Cadillacs in our dreams</u><br>" +
            "People like her are perfectly content with having crazy dreams and fantasies that could never conceivably be achieved, simply keeping these material desires in her dreams.<br><br>" +
            "<u>But everybody''s like Cristal, Maybach, diamonds on your timepiece<br>" +
            "Jet planes, islands, tigers on a gold leash</u><br>" +
            "She lists some material things that signify wealth and describes how sole the aim of society nowadays is to become as rich as you can, even though it is not as satisfying as people may think.<br><br>" +
            "<u>We don''t care, we aren''t caught up in your love affair</u><br>" +
            "They don’t really care about the gossip going on in the mainstream media.<br><br>" +
            "<u>And we''ll never be royals (royals)<br>" +
            "It don''t run in our blood<br>" +
            "That kind of luxe just ain''t for us<br>" +
            "We crave a different kind of buzz</u><br>" +
            "She does not crave royal privileges such as being famous and celebrated, she wants the buzz of living a thrilling life.<br>" +
            "<b>Luxe</b> could be an abbreviation of the word luxury.<br><br>" +
            "<u>Let me be your ruler (ruler)<br>" +
            "You can call me queen Bee<br>" +
            "And baby I''ll rule, I''ll rule, I''ll rule, I''ll rule<br>" +
            "Let me live that fantasy</u><br>" +
            "She would rather be the “queen” of her own group, not the ruler of an entire country.<br><br>" +
            "<u>My friends and I, we''ve cracked the code<br>" +
            "We count our dollars on the train to the party<br>" +
            "And everyone who knows us knows that we''re fine with this<br>" +
            "We didn''t come from money</u><br>" +
            "She can still socialize and have a good time, she just keeps to a budget instead of blowing money needlessly like the “royals”.<br>" +
            "<b>Cracked the code</b> means  they’ve got a clear perspective on their place in the world.<br><br>" +
            "<u>We''re bigger than we ever dreamed<br>" +
            "And I''m in love with being queen</u><br>" +
            "She is only queen of her small group. However, this is enough to make her feel special.<br><br>" +
            "<u>Life is great without a care</u><br>" +
            "She’s happy with her carefree life.";

    private String explanation_prepositions_summertime_sadness = "<u>Kiss me hard before you go</u><br>" +
            "She wants her lover to give her one last kiss before her lover leaves.<br><br>" +
            "<u>Summertime sadness</u><br>" +
            "She has seasonal depression during summer as it brings back memories of her lover.<br><br>" +
            "<u>I just wanted you to know<br>" +
            "That, baby, you''re the best</u><br>" +
            "She thinks her lover is still the greatest despite the fact that her lover is leaving.<br><br>" +
            "<u>High heels off, I''m feeling alive</u><br>" +
            "She’s finally able to take her shoes off after a party event. High heels usually makes the wearer uncomfortable, so she feels great because she has already taken them off.<br><br>" +
            "<u>Oh, my God, I feel it in the air</u><br>" +
            "She is fully aware that something special is going to happen tonight.<br><br>" +
            "<u>Telephone wires above are sizzling like a snare</u><br>" +
            "Telephone lines hiss when they are wet. This makes a similar noise to a snare on a drum kit when it is played.<br><br>" +
            "<u>Honey, I''m on fire, I feel it everywhere<br>" +
            "Nothing scares me anymore</u><br>" +
            "She has become fearless.<br><br>" +
            "<u>I''m feelin'' electric tonight</u><br>" +
            "Similar to the telephone wires, she feels like there is electricity flowing through her.<br><br>" +
            "<u>Cruising down the coast goin'' ''bout 99</u><br>" +
            "She’s driving very fast at the speed of 99 miles per hour, which is equivalent to 160 km/h.<br><br>" +
            "<u>Got my bad baby by my heavenly side<br>" +
            "I know if I go, I''ll die happy tonight</u><br>" +
            "She feels like she her lover is there in spirit with her tonight, so she would be joyous even if she dies.<br><br>" +
            "<u>Like the stars miss the sun in the morning sky</u><br>" +
            "The stars are never out at the same time as the sun so they never see each other.<br><br>" +
            "<u>Later''s better than never<br>" +
            "Even if you''re gone I''m gonna drive (drive, drive)</u><br>" +
            "She knows she’ll never be able to meet with her lover again, but she is still going to try anyway.";

    private String explanation_prepositions_thinking_out_loud = "<u>When your legs don''t work like they used to before<br>" +
            "And I can''t sweep you off of your feet<br>" +
            "Will your mouth still remember the taste of my love?<br>" +
            "Will your eyes still smile from your cheeks?</u><br>" +
            "He wonders if she’ll still love him and remember him in old age. When he’s too frail to pick her up and she finds it difficult to walk, will she still be loving him? He isn’t the only one worried about being loved when he’s old.<br><br>" +
            "<u>And, darling, I will be loving you ''til we''re 70<br>" +
            "And, baby, my heart could still fall as hard at 23<br>" +
            "And I''m thinking ''bout how</u><br>" +
            "He is letting her know that he will be loyal to her for a very long time — a lifetime, and that he will love her as much as he loves her now (at the age of 23) forever. Age won’t affect their relationship.<br><br>" +
            "<u>People fall in love in mysterious ways<br>" +
            "Maybe just the touch of a hand<br>" +
            "Well, me—I fall in love with you every single day</u><br>" +
            "He points out one of the common ways two people fall in love. But when he’s with this girl, he falls in love with her in all possible ways, not once in his life, but everyday he sees her.<br><br>" +
            "<u>So honey now<br>" +
            "Take me into your loving arms<br>" +
            "Kiss me under the light of a thousand stars<br>" +
            "Place your head on my beating heart<br>" +
            "I''m thinking out loud</u><br>" +
            "He is imagining what could possibly happen if they were to be together. He has the thoughts of romance in his mind.<br><br>" +
            "<u>That maybe we found love right where we are</u><br>" +
            "He has found love in his imagination as he is hoping to have a relationship with a girl.<br><br>" +
            "<u>When my hair''s all but gone and my memory fades<br>" +
            "And the crowds don''t remember my name<br>" +
            "When my hands don''t play the strings the same way<br>" +
            "I know you will still love me the same</u><br>" +
            "In old age, he will go bald. Also, his fingers won’t be as strong and he probably won’t be performing — the crowds will be into someone else. However, he knows that she will forever love him.<br><br>" +
            "<u>''Cause honey your soul could never grow old, it''s evergreen</u><br>" +
            "Evergreen trees don’t turn brown and decrepit in the autumn and winter. He uses this metaphor to show that he knows that love is eternal when it’s with the right person and age won’t affect your feelings for someone.<br><br>" +
            "<u>And, baby, your smile''s forever in my mind and memory</u><br>" +
            "Referring back to the first line of the verse, even when Ed is losing his memory, he won’t forget even the smallest details about his girl.<br><br>" +
            "<u>People fall in love in mysterious ways<br>" +
            "Maybe it''s all part of a plan</u><br>" +
            "The circumstances under which people fall in love are so random and odd that sometimes you wonder if it is all planned. A simple change in someone’s day, like randomly deciding to take a walk, could mean that they meet the love of their life and change their world forever.<br><br>" +
            "<u>Well, I''ll just keep on making the same mistakes<br>" +
            "Hoping that you''ll understand</u><br>" +
            "He messes a lot up but he means well. He only makes these repetitive mistakes because he wants her to love him.";

    //Insert song values
    private String SQL_INSERT_SONG = "INSERT INTO SONG" +
            " VALUES ('2.1', 'Passive', 'Demons', 'Imagine Dragons', 'Night Visions', '"+R.drawable.imagine_dragons_night_visions+"', '"+R.raw.imagine_dragons_demons+"', '"+lyrics_passive_demons+"', '"+explanation_passive_demons+"'), ('2.2', 'Passive', 'Someone Like You', 'Adele', '21', '"+R.drawable.adele_21+"', '"+R.raw.adele_someone_like_you+"', '"+lyrics_passive_someone_like_you+"', '"+explanation_passive_someone_like_you+"'), ('2.3', 'Passive', 'You Lost Me', 'Christina Aguilera', 'Bionic', '"+R.drawable.christina_aguilera_bionic+"', '"+R.raw.christina_aguilera_you_lost_me+"', '"+lyrics_passive_you_lost_me+"', '"+explanation_passive_you_lost_me+"'), ('3.1', 'Conditionals and if-sentences', 'Happy', 'Pharrell Williams', 'G I R L', '"+R.drawable.pharrell_williams_girl+"', '"+R.raw.pharrell_williams_happy+"', '"+lyrics_conditionals_happy+"', '"+explanation_conditionals_happy+"'), ('3.2', 'Conditionals and if-sentences', 'If It Hadn''t Been For Love', 'Adele', '21', '"+R.drawable.adele_21+"', '"+R.raw.adele_if_it_hadnt_been_for_love+"', '"+lyrics_conditionals_if_it_hadnt_been_for_love+"', '"+explanation_conditionals_if_it_hadnt_been_for_love+"'), ('3.3', 'Conditionals and if-sentences', 'If I Were A Boy', 'Beyoncé', 'I Am... Sasha Fierce', '"+R.drawable.beyonce_i_am_sasha_fierce+"', '"+R.raw.beyonce_if_i_were_a_boy+"', '"+lyrics_conditionals_if_i_were_a_boy+"', '"+explanation_conditionals_if_i_were_a_boy+"'), ('4.1', 'Present / Future Modals', 'Blank Space', 'Taylor Swift', '1989', '"+R.drawable.taylor_swift_1989+"', '"+R.raw.taylor_swift_blank_space+"', '"+lyrics_present_future_modals_blank_space+"', '"+explanation_present_future_modals_blank_space+"'), ('4.2', 'Present / Future Modals', 'Elastic Heart', 'Sia', '1000 Forms Of Fear', '"+R.drawable.sia_1000_forms_of_fear+"', '"+R.raw.sia_elastic_heart+"', '"+lyrics_present_future_modals_elastic_heart+"', '"+explanation_present_future_modals_elastic_heart+"'), ('4.3', 'Present / Future Modals', 'Make You Feel My Love', 'Adele', '19', '"+R.drawable.adele_19+"', '"+R.raw.adele_make_you_feel_my_love+"', '"+lyrics_present_future_modals_make_you_feel_my_love+"', '"+explanation_present_future_modals_make_you_feel_my_love+"'), ('5.1', 'Past Modals', 'If It Hadn''t Been For Love', 'Adele', '21', '"+R.drawable.adele_21+"', '"+R.raw.adele_if_it_hadnt_been_for_love+"', '"+lyrics_past_modals_if_it_hadnt_been_for_love+"', '"+explanation_past_modals_if_it_hadnt_been_for_love+"'), ('5.2', 'Past Modals', 'The One That Got Away', 'Katy Perry', 'Teenage Dream', '"+R.drawable.katy_perry_teenage_dream+"', '"+R.raw.katy_perry_the_one_that_got_away+"', '"+lyrics_past_modals_the_one_that_got_away+"', '"+explanation_past_modals_the_one_that_got_away+"'), ('7.1', 'Prepositions', 'Royals', 'Lorde', 'Pure Heroine', '"+R.drawable.lorde_pure_heroine+"', '"+R.raw.lorde_royals+"', '"+lyrics_prepositions_royals+"', '"+explanation_prepositions_royals+"'), ('7.2', 'Prepositions', 'Summertime Sadness', 'Lana Del Rey', 'Born To Die', '"+R.drawable.lana_del_rey_born_to_die+"', '"+R.raw.lana_del_rey_summertime_sadness+"', '"+lyrics_prepositions_summertime_sadness+"', '"+explanation_prepositions_summertime_sadness+"'), ('7.3', 'Prepositions', 'Thinking Out Loud', 'Ed Sheeran', 'x', '"+R.drawable.ed_sheeran_x+"', '"+R.raw.ed_sheeran_thinking_out_loud+"', '"+lyrics_prepositions_thinking_out_loud+"', '"+explanation_prepositions_thinking_out_loud+"')";

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
            "VALUES ('1.1', 'Tense Consolidation', '91% of Malaysian Gen Y _______ the actual population of Malaysia. A shocking survey done on 180 University students, had only 16 who answered correctly within (+/- 1 million).', 'do not know', 'have not known', 'are not known with', 'do not know', 'are not knowing'), ('1.2', 'Tense Consolidation', 'Ed Sheeran _______ his 24th birthday today.', 'celebrates', 'celebrates', 'has been celebrating', 'celebrated', 'is celebrating'), ('1.3', 'Tense Consolidation', 'The _______ Australian naturalist, Steve “Crocodile Hunter” Irwin, was born today in 1962.', 'beloved', 'beloving', 'belove', 'loved', 'beloved'), ('1.4', 'Tense Consolidation', 'Kingsman: The Secret Service _______ the story of a super-secret spy organization that recruits an unrefined but promising street kid into the agency’s ultra-competitive training program.', 'tells', 'tells', 'is telling', 'has told', 'has been telling'), ('1.5', 'Tense Consolidation', 'Pure Heroine _______ young generation and critiques of mainstream culture.', 'discusses', 'discussed', 'is discussing', 'was discussed', 'discusses'), ('1.6', 'Tense Consolidation', 'Living in PJ areas _______ high living expenditure.', 'requires', 'require', 'requires', 'is requiring', 'has been requiring'), ('1.7', 'Tense Consolidation', 'I am driving a Perodua Myvi with 1.5L engine. I _______ petrol at least once a week.', 'pump', 'am pumping', 'pumped', 'pump', 'have pumped'), ('1.8', 'Tense Consolidation', '_______ a road trip to Penang with friends to sightsee, photo-explore and eat good food.', 'Have', 'Having', 'Have', 'Had', 'Has'), ('1.9', 'Tense Consolidation', 'Students from four Japanese universities visited University of Tunku Abdul Rahman (UTAR) Perak for a two-week English Immersion Programme which took place between August to mid September, and _______ with the outcome.', 'were pleased', 'has pleased', 'are pleasing', 'were pleased', 'were pleasing'), ('1.10', 'Tense Consolidation', 'The popular hairstyle for men now _______ around the top with short sides.', 'goes', 'is going', 'goes', 'has gone', 'went'), ('1.11', 'Tense Consolidation', 'Depression _______ from eating disorders is becoming increasingly common amongst students.', 'resulting', 'resulted', 'results', 'result', 'resulting'), ('1.12', 'Tense Consolidation', 'The #1 New York Times bestselling novel Divergent _______ into a movie.', 'has been adapted and made', 'is adapting and making', 'adapts and makes', 'adapted and made', 'has been adapted and made'), ('2.1', 'Passive', 'Oscar-winning movie star Sandra Bullock was the _______ actress in Hollywood over the past year, according to Forbes magazine.', 'best paid', 'best pays', 'best paying', 'best pay', 'best paid'), ('2.2', 'Passive', 'When she _______ a devastating diagnosis, Alice and her family find their bonds tested.', 'receives', 'receives', 'is receiving', 'had received', 'has received'), ('2.3', 'Passive', 'Beloved Hollywood veteran, king of comedy, and Oscar-winning actor Robin Williams _______ at the age of 63.', 'has died', 'has been dead', 'has died', 'died', 'has dead'), ('2.4', 'Passive', 'X is the second studio album released by Ed Sheeran, who _______ in popularity in recent months.', 'has exploded', 'has been exploding', 'has exploded', 'exploded', 'explodes'), ('2.5', 'Passive', 'Aside from being good for the eyes, carrots _______ with disease-fighting nutrients.', 'are packed', 'are packing', 'pack', 'are packed', 'have been packing'), ('2.6', 'Passive', 'Pure Heroine _______ for Best Pop Vocal Album at the 56th Annual Grammy Awards.', 'was nominated', 'was nominated', 'had been nominating', 'nominates', 'is nominating'), ('2.7', 'Passive', 'You know how your mom _______ you to finish the broccoli on your plate because it’s good for you? Well, it turns out that your mom was right all along.', 'used to tell', 'would tell', 'told', 'has been telling', 'used to tell'), ('2.8', 'Passive', 'Each time I pump petrol, it _______ me approximately RM65 to fill up an empty tank.', 'costs', 'cost', 'costs', 'is costing', 'will cost'), ('2.9', 'Passive', '_______ the hottest tropical paradise in Malaysia, Langkawi Island is currently rated as one of the top-notch destinations in Malaysia.', 'Deemed', 'Deem', 'Deeming', 'Deemed', 'Being deemed'), ('2.10', 'Passive', 'The job market _______ since pre-GE13 last year and even after; vacancies are still on a decline.', 'has been slow', 'will be slow', 'is slowing', 'was slow', 'has been slow'), ('2.11', 'Passive', 'Four members of SEAL Team 10 _______ with the mission to capture or kill notorious Taliban leader, Ahmad Shahd.', 'were tasked', 'were tasking', 'were tasked', 'has tasked', 'task'), ('3.1', 'Conditionals and if-sentences', 'If fresh graduates can’t even get past preliminary rounds of interviews, how _______ they expect to secure a job?', 'do', 'would', 'should', 'do', 'should'), ('3.2', 'Conditionals and if-sentences', 'Unless your name is Ebeneezer, surname Scrooge, you _______ guaranteed to leave the store with a smile on your face.', 'will be', 'are', 'must be', 'will be', 'should be'), ('3.3', 'Conditionals and if-sentences', 'If you’re into old school Eminem songs, then “W.T.P” _______ the song for you.', 'is', 'must be', 'was', 'should be', 'is'), ('3.4', 'Conditionals and if-sentences', 'I would not have failed the exam if I _______.', 'had studied', 'had studied', 'have studied', 'studied', 'was studying'), ('3.5', 'Conditionals and if-sentences', 'You could travel around the world if you _______ your job.', 'left', 'leave', 'left', 'are leaving', 'could leave'), ('3.6', 'Conditionals and if-sentences', 'If you had told me there was a problem, I _______.', 'could have helped', 'could have helped', 'would have helped', 'have had helped', 'should have helped'), ('3.7', 'Conditionals and if-sentences', 'I _______ call you if I _______ late.', 'will, am', 'shall, will be', 'will, am', 'will, will be', 'shall, am'), ('3.8', 'Conditionals and if-sentences', 'What _______ if our achievement award entry did not arrive before the closing date?', 'happens', 'happen', 'happens', 'happened', 'will happen'), ('3.9', 'Conditionals and if-sentences', 'I never _______ hitch hiked to Birmingham if it hadn’t been for love.', 'would’ve', 'could’ve', 'might’ve', 'should’ve', 'would’ve'), ('3.10', 'Conditionals and if-sentences', 'If I _______ a boy, I think I _______ understand how it _______ to love a girl.', 'were, could, feels', 'am, would, felt', 'was, could, would be feeling', 'were, could, feels', 'was, would, is feeling'), ('4.1.1', 'Present / Future Modals', '_______ it be weird to see Cristiano Ronaldo dribble the ball wearing cowboy boots?', 'Wouldn''t', 'Wouldn''t', 'Won''t', 'Shouldn''t', 'Can''t'), ('4.1.2', 'Present / Future Modals', 'Only by piecing together fragments of his past with clues he discovers in the maze _______ Thomas hope to uncover his true purpose and a way to escape.', 'can', 'will', 'shall', 'may', 'can'), ('4.1.3', 'Present / Future Modals', 'We _______ help but have these hauntingly beautiful songs stuck in our heads.', 'can''t', 'won''t', 'can''t', 'needn''t', 'mustn''t'), ('4.1.4', 'Present / Future Modals', 'Being able to show that you’ve had work experience _______ gain them the confidence that you’re more prepared than the candidates who haven’t worked a single day in their lives.', 'will', 'could', 'can', 'will', 'might'), ('4.1.5', 'Present / Future Modals', 'I once had the roommate that _______ probably be anyone’s worst nightmare.', 'would', 'would', 'might', 'shall', 'could'), ('4.1.6', 'Present / Future Modals', 'I _______ say the game _______ become rather addictive.', 'must, can', 'should, will', 'must, can', 'need to, should', 'shall, may'), ('4.1.7', 'Present / Future Modals', 'You _______ also like to try soured cream, lemon juice, flaked almonds or ground cloves.', 'might', 'may', 'might', 'ought to', 'would'), ('4.1.8', 'Present / Future Modals', 'You _______ be tired after working for the entire day.', 'must', 'must', 'may', 'could', 'would'), ('4.1.9', 'Present / Future Modals', 'No paper or other materials _______ be derived from high conservation value forests or other illegal sources.', 'shall', 'can', 'shall', 'must', 'need to'), ('4.1.10', 'Present / Future Modals', 'I came here to see if there was something I _______ do to help, but there doesn’t seem to be anything for me to do.', 'could', 'would', 'should', 'could', 'might'), ('4.1.11', 'Present / Future Modals', 'Money _______ be short when you’re a college kid, but remember to budget your spendings and save some for a rainy day.', 'may', 'could', 'should', 'will', 'may'), ('4.2.1', 'Past Modals', 'I’ve been thinking that I _______ been too critical.', 'may have', 'may have', 'might have', 'could have', 'must have'), ('4.2.2', 'Past Modals', 'I had trouble mixing with other students on campus because I’m not from around here. I wish I _______ done more in terms of blending in with the crowd here.', 'would have', 'could have', 'would have', 'should have', 'might have'), ('4.2.3', 'Past Modals', 'I _______ yelled at you. I''m sorry.', 'should not have', 'might not have', 'could not have', 'would not have', 'should not have'), ('4.2.4', 'Past Modals', 'We _______ had it all rolling in the deep.', 'could''ve', 'must''ve', 'ought to have', 'could''ve', 'might''ve'), ('4.2.5', 'Past Modals', 'Jessica is not in the classroom. She _______ left earlier.', 'must have', 'could have', 'must have', 'should have', 'might have'), ('4.2.6', 'Past Modals', 'Where’s my money? You said you _______ pay today.', 'would', 'would', 'could', 'might', 'had to'), ('4.2.7', 'Past Modals', 'I _______ go out last night because I _______ do my homework.', 'couldn’t, had to', 'shouldn’t, should', 'mustn’t, would’ve to', 'needn’t, need to', 'couldn’t, had to'), ('4.2.8', 'Past Modals', 'Tom _______ write by the age of 4.', 'could', 'might', 'would', 'had to', 'could'), ('4.2.9', 'Past Modals', 'They _______ arrived hours ago.', 'may have', 'should have', 'may have', 'must have', 'could have'), ('4.2.10', 'Past Modals', 'I _______ achieved so much if it wasn’t for you.', 'couldn’t have', 'may not have', 'wouldn’t have', 'couldn’t have', 'shouldn’t have'), ('5.1', 'Articles', 'Singapore has fined _______ smoker S$19,800 ($15,000) for throwing _______ cigarette butts out of his flat window.', 'a, -', 'the, -', 'a, the', 'a, -', 'the, the'), ('5.2', 'Articles', 'Dumplings are _______ classic Chinese food, it is _______ traditional dish eaten on Chinese New Year’s Eve among Chinese around the world.', 'a, a', 'a, a', 'a, the', 'the, a', '-, a'), ('5.3', 'Articles', 'Food has always been important; some even declare _______ romantic relationship with _______ food.', 'a, -', '-, -', 'a, -', 'a, the', 'the, -'), ('5.4', 'Articles', 'The Imitation Game is based on _______ real-life story of Alan Turing, who is credited with cracking _______ German Enigma code.', 'the, the', 'the, the', 'a, a', 'a, the', 'the, a'), ('5.5', 'Articles', '_______ team of archaeologists discovers and then explores _______ ancient pyramid buried under _______ Egyptian desert.', 'A, an, the', 'A, an, the', 'A, an, an', 'The, an, the', 'The, the, an'), ('5.6', 'Articles', '_______ Magic Tablet, _______ Egyptian artifact that keeps everything in _______ museum alive is beginning to die out.', 'The, an, the', '-, the, a', '-, an, a', 'The, the, the', 'The, an, the'), ('5.7', 'Articles', 'Technically, oatmeal is _______ form of grass seed, but can be classified as _______ vegetable.', 'a, a', 'a, a', 'the, the', 'a, -', '-, a'), ('5.8', 'Articles', 'Besides _______ locals, _______ foreign students doing their studies in Malaysia also celebrate _______ Malaysia Day together with their local friends and course mates.', 'the, -, -', 'the, -, -', 'the, the, -', '-, -, the', '-, the, the'), ('5.9', 'Articles', 'Bright-eyed fresh grads that haven’t had any working experience often leave their higher education armed with _______ degree and _______ burning drive to accomplish just about _______ million things.', 'a, a, a', 'a, a, -', 'a, a, a', 'a, the, -', '-, -, -'), ('5.10', 'Articles', 'Carrie is _______ story of _______ high school misfit Carrie White, who gradually discovers that she has _______ telekinetic powers.', 'the, a, -', 'a, a, -', 'the, a, -', 'a, the, a', 'the, the, the'), ('6.1', 'Prepositions', 'Malaysia was formed _______ the 16th of September.', 'on', 'in', 'at', 'by', 'on'), ('6.2', 'Prepositions','Spinach is rich _______ lutein and zeaxanthin, which are carotenoids that remove unstable molecules called free radicals from your body before they damage it.', 'in', 'with', 'on', 'in', 'at'), ('6.3', 'Prepositions', 'Consistently ranked _______ the top ten for best island resorts _______ Malaysia, Langkawi boasts of unmatched sun, sand, and sea experience for beach lovers.', 'in, in', 'on, at', 'in, in', 'at, at', 'at, on'), ('6.4', 'Prepositions', 'The cassette tape was popular for decades because it was compact, weight little, and small _______ size.', 'in', 'of', 'on', 'at', 'in'), ('6.5', 'Prepositions', 'MP3 is an intangible file that can be transferred _______ the internet without compromising great quality sound.', 'over','over', 'to', 'across from', 'on'), ('6.6', 'Prepositions', 'Since the l940s, plastic has been _______ a full-on, mass production mode because of its wide range of unique properties.', 'on', 'over', 'under', 'on', 'between'), ('6.7', 'Prepositions', 'Two albums _______ one year is something of a rarity _______ modern music, yet Justin Timberlake’s fans have received this treat with “20/20 Experience Part 2 of 2”.', 'in, in', 'with, on', 'in, in', 'with, in', 'in, on'), ('6.8', 'Prepositions', 'Michael Jackson died _______ the age of 50.', 'at', 'on', 'in', 'at', 'with'), ('6.9', 'Prepositions', 'He denied driving _______ 110 miles per hour.', 'at', 'with', 'until', 'after', 'at'), ('6.10', 'Prepositions', 'I dropped my bags _______ the floor.', 'on', 'on', 'to', 'at', 'over')";

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

    //HELP table ===================================================================================================================================
    private String SQL_CREATE_HELP = "CREATE TABLE HELP (" +
            "helpID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "tag TEXT," +
            "tipImage TEXT," +
            "tipDescription TEXT)";

    //Insert quiz values
    private String SQL_INSERT_HELP = "INSERT INTO HELP " +
            "VALUES ('1', 'Help', '"+R.drawable.playlist_up_1st_resize+"','After selecting a lesson, you may choose to learn about the lesson.'), ('2', 'Help', '"+R.drawable.playlist_down+"', 'Or you may directly play one of the songs'), ('3', 'Help', '"+R.drawable.audio_tab_row+"', 'At the audio player interface, you may choose to learn the lyrics, explanation, or directly go to the quiz.'), ('4', 'Help', '"+R.drawable.audio_now_playing_row+"', 'You may tap on the Now Playing bar to see the details of the currently playing song.'), ('5', 'Help', '"+R.drawable.audio_lyrics+"', 'For the lyrics, bold indicates the words that are related to the lesson, underlined indicates the phrases that are elaborated under the Explanation tab.'), ('6', 'Help', '"+R.drawable.quiz_up+"', 'At the quiz screen, you may tap on the above 2 areas to see the details of the quiz.')";

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
        db.execSQL(SQL_CREATE_HELP);
        db.execSQL(SQL_INSERT_HELP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Create tables again
        onCreate(db);
    }
}

