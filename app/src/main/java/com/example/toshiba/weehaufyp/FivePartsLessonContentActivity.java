package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class FivePartsLessonContentActivity extends Activity implements View.OnClickListener{

    TextView songListHeader, lessonContentScrollableView;
    TextView partOneButton, partTwoButton, partThreeButton, partFourButton, partFiveButton;
    String tag;

    //variables for db
    String partOnePassiveLessonContent, partTwoPassiveLessonContent, partThreePassiveLessonContent, partFourPassiveLessonContent, partFivePassiveLessonContent;
    String partOnePresentFutureModalsLessonContent, partTwoPresentFutureModalsLessonContent, partThreePresentFutureModalsLessonContent, partFourPresentFutureModalsLessonContent, partFivePresentFutureModalsLessonContent;
    String partOnePastModalsLessonContent, partTwoPastModalsLessonContent, partThreePastModalsLessonContent, partFourPastModalsLessonContent, partFivePastModalsLessonContent;
    String sectionNames, partOneName, partTwoName, partThreeName, partFourName, partFiveName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_parts_lesson_content);

        Intent intent = getIntent();
        tag = intent.getStringExtra("tag");

        partOnePassiveLessonContent = "<b><u>Basic uses of the passive</u></b><br>" +
                "1.\t<u>Agent and instrument</u><br>" +
                "The person who performs an action in a passive sentence is called the <b>agent</b>, introduced by “by”.<br><br>The agent may or may not be mentioned.<br>" +
                "[My purse was found by <b>one of the cleaners</b>.]<br>" +
                "<br>" +
                "An object which causes something to happen is called an <b>instrument</b>, introduced by “with”.<br>" +
                "[He was hit on the head with a <b>hammer</b>.]<br>" +
                "<br>" +
                "2.\t<u>Verbs with two objects</u><br>" +
                "Verbs which have two objects can be made passive in two ways.<br><br>" +
                "[<b>I</b> was handed a <b>note</b>.]<br>[A <b>note</b> was handed to <b>me</b>.]<br>" +
                "<br>" +
                "Other common verbs of this type are:<br>" +
                "“bring”, “give”, “lend”, “pass”, “pay”, “promise”, “sell”, “send”, “show”, “tell”<br>" +
                "<br>" +
                "3.\t<u>Verbs with object and complement</u><br>" +
                "Some verbs have a noun or adjective which describes their object.<br><br>" +
                "[We elected Jim <b>class representative</b>.]<br>" +
                "[Everyone considered him a <b>failure</b>.]<br>" +
                "<br>" +
                "When these are made passive, the complement goes directly after the verb.<br><br>" +
                "[Jim was elected class representative.]<br>" +
                "[He was considered a failure.]";

        partTwoPassiveLessonContent = "<b><u>Using and not mentioning the agent</u></b><br>" +
                "1.\t<u>Change of focus</u><br>" +
                "The passive can change the emphasis of a sentence.<br><br>" +
                "[<b>Jack</b> won the prize.] (focus on Jack)<br>" +
                "[The <b>prize</b> was won by Jack.] (focus on the prize)<br>" +
                "<br>" +
                "2.\t<u>Unknown agent</u><br>" +
                "The agent is not mentioned if unknown.<br><br>" +
                "[My wallet <b>has been taken</b>.]<br>" +
                "In this case, there is no point in adding an agent: 'by somebody'.<br>" +
                "<br>" +
                "3.\t<u>Generalized agent</u><br>" +
                "If the subject is 'people in general' or 'you' the agent is not mentioned.<br><br>" +
                "[Bicycles <b>are</b> widely <b>used</b> in the city instead of public transport.]<br>" +
                "<br>" +
                "4.\t<u>Obvious agent</u><br>" +
                "If the agent is obvious or has already been referred to, it is not mentioned.<br><br>" +
                "[Linda <b>has been arrested</b>.] (we assume by the police)<br>" +
                "[The company agreed to our request and a new car park <b>was opened</b>.]<br>" +
                "<br>" +
                "5.\t<u>Unimportant agent</u><br>" +
                "If the agent is not important to the meaning of the sentence it is not mentioned.<br><br>" +
                "[I <b>was advised</b> to obtain a visa in advance.]<br>" +
                "<br>" +
                "6.\t<u>Impersonality</u><br>" +
                "Using the passive is a way of avoiding the naming of a specific person who is responsible for an action.<br><br>" +
                "[It <b>has been decided</b> to reduce all salaries by 10%.]<br>" +
                "<br>" +
                "In descriptions of processes, there is emphasis on the actions performed rather than on the people who perform them.<br><br>" +
                "[Then the packets <b>are packed</b> into boxes of twenty-four.]";

        partThreePassiveLessonContent = "<b><u>“Have” and “get something done”, “need doing”</u></b><br>" +
                "1.\t<u>“Have”/”get something done”</u><br>" +
                "This typically describes a service performed for us by someone else.<br>" +
                "[I've just <b>had/got</b> my car <b>serviced</b>. I <b>have/get</b> it <b>done</b> every winter.]<br>" +
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
                "2.\t<u>The need to have a service done can be described with “need doing”.</u><br>" +
                "[Your hair <b>needs cutting</b>.]<br><br><br>" +
                "<b><u>Passive “get”</u></b><br>" +
                "“Get” can be used instead of be to form the passive in spoken language.<br>" +
                "[Martin <b>got arrested</b> at a football match.]";

        partFourPassiveLessonContent = "<b><u>Reporting verbs</u></b><br>" +
                "1.\t<u>Present reference</u><br>" +
                "With verbs such as “believe”, “know”, “say”, “think”, which report people's opinions, a passive construction is often used to avoid a weak subject, and to give a generalized opinion.<br><br>" +
                "With present reference, the passive is followed by the present infinitive.<br><br>" +
                "[The criminal <b>is thought to be</b> in hiding in the London area.]<br>" +
                "[Vitamin C <b>is known to be</b> good for treating colds.]<br>" +
                "<br>" +
                "2.\t<u>Past reference</u><br>" +
                "With past reference, the passive is followed by the past infinitive.<br><br>" +
                "[Smith <b>is believed to have left</b> England last week.]<br>" +
                "<br>" +
                "3.\t<u>Past reporting verb</u><br>" +
                "If the reporting verb is in the past, the past infinitive tends to follow, though not always if the verb “be” is used.<br><br>" +
                "[People thought Sue had paid too much.]<br>" +
                "[Sue <b>was thought to have paid</b> too much.]<br>" +
                "<br>" +
                "[The police thought that the thief was still in the house.]<br>" +
                "[The thief <b>was thought to</b> still <b>be</b> in the house.]<br>" +
                "<br>" +
                "4.\t<u>Past reference with two objects</u><br>" +
                "In this case there are two ways of making a passive sentence.<br><br>" +
                "[Everyone knows the portrait was painted by an Italian.]<br>" +
                "[The portrait <b>is known to have been painted</b> by an Italian.]<br>" +
                "<br>" +
                "5.\t<u>Continuous infinitive</u><br>" +
                "Past and present continuous infinitives are also used.<br><br>" +
                "[Mary <b>is thought to be</b> living in Scotland.]<br>" +
                "[The driver <b>is thought to have been</b> doing a U-turn.]";

        partFivePassiveLessonContent = "<b><u>Verbs with prepositions</u></b><br>" +
                "1.\t<u>Ending a sentence with a preposition</u><br>" +
                "It is possible to end a sentence with a preposition in a sentence where a prepositional verb is made passive.<br><br>" +
                "[Somebody broke into our house.]<br>" +
                "[Our house <b>was broken into</b>.]<br>" +
                "<br>" +
                "2.\t<u>“By” and “with”</u><br>" +
                "“With” is used after participles such as “filled”, “packed”, “crowded”, “crammed”.<br><br>" +
                "[The train <b>was packed with</b> commuters.]<br>" +
                "<br>" +
                "The difference between “by” and “with” may involve the presence of a person:<br>" +
                "[Dave <b>was hit by</b> a branch.] (an accident)<br>" +
                "[Dave <b>was hit with</b> a branch.] (a person hit him with one)<br>" +
                "<br>" +
                "3.\t<u>“Make” is followed by “to” when used in the passive.</u><br>" +
                "[My boss made me work hard.]<br>" +
                "[I <b>was made to</b> work hard by my boss.]<br>" +
                "<br>" +
                "4.\t<u>“Cover” and verbs which involve similar ideas</u>, such as “surround”, “decorate”, can use “with” or “by”.<br>“Cover” can also be followed by “in”.<br><br>" +
                "[The furniture <b>was covered in</b> dust.]<br>" +
                "[The living room <b>had been decorated with</b> flowery wallpaper.]";

        partOnePresentFutureModalsLessonContent = "<b><u>“Don’t have to” and “must not”</u></b><br>" +
                "1.\t<u>“Don’t have to” refers to an absence of obligation.</u><br>" +
                "[You <b>don’t have to</b> work tomorrow.]<br>" +
                "\t<br>" +
                "2.\t<u>“Must not” refers to an obligation not to do something.</u><br>" +
                "[You <b>must not</b> leave the room before the end of the test.]\t<br><br><br>" +
                "<b><u>“Must” and “can’t”</u></b><br>" +
                "These refer to present time only. In expressing certainty, they are opposites.<br>" +
                "[This <b>must</b> be our stop.] (I’m sure it is.)<br>" +
                "[This <b>can’t</b> be our stop.] (I’m sure it isn’t.)<br><br><br>" +
                "<b><u>“Need”</u></b><br>" +
                "1.\t<u>“Need to” is a modal auxiliary, and behaves like a normal verb.</u><br>" +
                "[Do you <b>need to</b> use the photocopier?]<br>" +
                "<br>" +
                "2.\t<u>“Need” is a modal auxiliary, but mainly in question and negative forms.</u><br>" +
                "[<b>Need</b> you make so much noise?]";

        partTwoPresentFutureModalsLessonContent = "<b><u>“Should”</u></b><br>" +
                "1.\t<u>Where “*should” appears, “ought to” can also be used.</u><br>" +
                "Expectation<br>" +
                "[This film *<b>should</b> be really good.]<br>" +
                "<br>" +
                "2.\t<u>Recommendation</u><br>" +
                "[I think you *<b>should</b> talk it over with your parents.]<br><br>" +
                "In writing, “should” can be used to express a strong obligation politely.<br><br>" +
                "[Guests <b>should</b> vacate their rooms by midday.]<br>" +
                "<br>" +
                "3.\t<u>Criticism of an action</u><br>" +
                "[You *<b>shouldn’t</b> eat so much late at night.]<br>" +
                "<br>" +
                "4.\t<u>Uncertainty</u><br>" +
                "[<b>Should</b> I leave these papers on your desk?]<br>" +
                "<br>" +
                "5.\t<u>“Should” and verbs of thinking</u><br>" +
                "“Should” is often used with verbs of thinking, to make an opinion less direct.<br><br>" +
                "[I <b>should</b> think that model would sell quite well.]<br>" +
                "<br>" +
                "6.\t<u>With “be” and adjectives describing chance</u><br>" +
                "This group of adjectives includes “odd”, “strange”, “funny” (odd), and the expression “what a coincidence”.<br><br>" +
                "[It’s strange that you <b>should</b> be staying in the same hotel.]<br>" +
                "<br>" +
                "7.\t<u>After “in case” to emphasize unlikelihood</u><br>" +
                "[I’m taking an umbrella in case it <b>should</b> rain.]<br><br><br>" +
                "<b><u>“Shall”</u></b><br>" +
                "1.\t<u>“Shall” can be used with all persons to emphasize something which the speaker feels is certain to happen or wants to happen.</u><br>" +
                "[I <b>shall</b> definitely give up smoking this year.]<br>" +
                "[We <b>shall</b> win!] (“shall” is stressed in this sentence)<br>" +
                "<br>" +
                "2.\t<u>Similarly, “shall” is used in formal rules and regulations.</u><br>" +
                "[No player <b>shall</b> knowingly pick up or move the ball of another player.]";

        partThreePresentFutureModalsLessonContent = "<b><u>“Can”</u></b><br>" +
                "1.\t<u>“Can” with “be” is used to make criticisms.</u><br>" +
                "[You <b>can be</b> really annoying, you know!]<br>" +
                "<br>" +
                "2.\t<u>“Can” is also used with “be” to refer to capability.</u><br>" +
                "[Winter here <b>can be</b> really cold.]<br><br><br>" +
                "<b><u>“Could”</u></b><br>" +
                "1.\t<u>“Could” is used to express possibility or uncertainty.</u><br>" +
                "[This <b>could</b> be the house.]<br>" +
                "<br>" +
                "2.\t<u>“Could” is used with comparative adjectives to express possibility or impossibility.</u><br>" +
                "[The situation <b>couldn’t</b> be worse.]<br>" +
                "[It <b>could</b> be better.]<br>" +
                "<br>" +
                "3.\t<u>“Could” is used to make suggestions.</u><br>" +
                "[We <b>could</b> go to that new restaurant opposite the cinema.]<br>" +
                "<br>" +
                "4.\t<u>“Could” is used to express unwillingness.</u><br>" +
                "[I <b>couldn’t</b> possibly leave Tim here on his own.]";

        partFourPresentFutureModalsLessonContent = "<b><u>“May” and “might”</u></b><br>" +
                "1.\t<u>“May” can be used to express “although” clauses.</u><br>" +
                "[She <b>may</b> be the boss, <b>but</b> that is no excuse for shouting like that.]<br>" +
                "<br>" +
                "2.\t<u>“May/might as well”</u><br>" +
                "This describes the only thing left to do, something which the speaker is not enthusiastic about.<br><br>" +
                "[Nobody else is going to turn up now for the lesson, so you <b>may/might as well</b> go home.<br>" +
                "<br>" +
                "3.\t<u>“May” and “might” both express possibility or uncertainty.</u><br>“May” is more common in formal language.<br><br>" +
                "[The peace conference <b>may</b> find a solution to the problem.]<br>" +
                "<br>" +
                "4.\t<u>There is an idiomatic expression with “try”, using “may” for present reference, and “might” for past reference.</u><br>" +
                "[<b>Try</b> as I <b>might</b>, I could not pass my driving test.] (This means although I tried hard, I could not pass my driving test.)";

        partFivePresentFutureModalsLessonContent = "<b><u>“Will”</u></b><br>" +
                "1.\t<u>“Will” can be used to express an assumption.</u><br>" +
                "[A: The phone is ringing. B: That <b>will</b> be for me.]<br>" +
                "<br>" +
                "2.\t<u>“Will”/”won’t” can be used emphatically to tell someone of the speaker’s intention, or to forbid an action, in response to a “will” expression.</u><br><br>" +
                "[I <b>will</b> take the money anyway, so there!]<br>" +
                "[You <b>won’t</b>!]<br>" +
                "[I <b>will</b>!]<br>" +
                "<br>" +
                "Similarly “I won’t” can mean “I refuse”, and “I will” can mean “I insist”.<br>" +
                "[A: I <b>won’t</b> do it! B: Yes, you <b>will</b>!]<br><br><br>" +
                "<b><u>“Would”</u></b><br>" +
                "1.\t<u>“Would” is often used in situations where a conditional sense is understood but not stated.</u><br><br>" +
                "[Nobody <b>would</b> agree with that idea.] (if we asked them)<br><br>" +
                "[Life <b>wouldn’t</b> be worth living without you.] (if you weren’t there)<br><br>" +
                "[I think Jim <b>would</b> be the best candidate.] (if he was under consideration for the job)<br><br>" +
                "[Sue <b>wouldn’t</b> do that, surely!] (if you think she’s capable of doing that).";

        partOnePastModalsLessonContent = "<b><u>“Had to” and “must have”</u></b><br>" +
                "1.\t<u>“Had to” is the past form of “must” and refers to a past obligation.</u><br>" +
                "[Sorry I'm late, I <b>had to</b> post some letters.]<br>" +
                "<br>" +
                "The negative form is “didn't have to” and refers to an absence of obligation.<br><br>" +
                "“Must have” refers to past certainty. (see below)<br><br><br>" +
                "<b><u>“Must have” and “can’t have”</u></b><br>" +
                "1.\t<u>These refer to the speaker's certainty about a past action.</u><br>" +
                "[Someone <b>must have</b> taken it.] (I am sure they did)<br>" +
                "[You <b>can't have</b> lost it.] (I am sure you didn't)<br>" +
                "<br>" +
                "2.\t<u>Both can also be used with surely in exclamations.</u><br>" +
                "[Surely you <b>can't have</b> eaten all of it.]<br>" +
                "[Surely you <b>must have</b> noticed it.]<br><br><br>" +
                "<b><u>“Needn’t have and didn’t need to”</u></b><br>" +
                "1.\t<u>“Needn't have done” refers to an unnecessary action which was actually done.</u><br>" +
                "[You <b>needn't have paid</b> all at once.] (you did pay)<br>" +
                "<br>" +
                "2.\t<u>“Didn't need to” refers to an unnecessary action which was not done.</u><br>" +
                "[I <b>didn't need to</b> go to the dentist again, luckily.]";

        partTwoPastModalsLessonContent = "<b><u>“Should have” and “ought to have”</u></b><br>" +
                "Where “*should” appears, “ought to” is also possible.<br>" +
                "1.\t<u>Expectation</u><br>" +
                "“Should have” refers to something which was supposed to happen.<br>" +
                "[The parcel I sent you *<b>should have</b> arrived by now.]<br>" +
                "<br>" +
                "2.\t<u>Criticism of an action</u><br>" +
                "[You *<b>shouldn't have</b> eaten so much last night.]<br>" +
                "<br>" +
                "3.\t<u>“Should have” and verbs of thinking</u><br>" +
                "The past form “knew” in the example is an unreal verb form, and the “should have” form is used according to “sequence of verb forms”.<br><br>" +
                "[I <b>should have</b> thought you knew.]<br>" +
                "<br>" +
                "4.\t<u>With “be” and adjectives describing chance</u><br>" +
                "[It was strange that you <b>should have been</b> staying in the same hotel last year.]<br>" +
                "<br>" +
                "5.\t<u>As a polite expression of thanks on receiving a gift or a favour</u><br>" +
                "[I've done the washing up for you. - Oh, you really <b>shouldn't have</b>.]<br><br>" +
                "The intonation should be friendly, as this is not a criticism.";

        partThreePastModalsLessonContent = "<b><u>“Could”</u></b><br>" +
                "1.\t<u>“Could” refers to past permission or past ability.</u><br>" +
                "[When I was sixteen I <b>could</b> stay out till 11.00.” (I was allowed to)<br><br>" +
                "[Mary <b>could</b> swim when she was three.] (she actually did)<br>" +
                "<br>" +
                "2.\t<u>Compare:</u><br>" +
                "[Mary <b>could have</b> swum when she was three.] (but she didn't)<br><br><br>" +
                "<b><u>“Could have”</u></b><br>" +
                "1.\t<u>“Could have” refers to past possibility or uncertainty.</u><br>" +
                "[David <b>could have</b> won the race if he had tried.] (possibility/ability)<br><br>" +
                "[It <b>could have</b> been Sue, I suppose.] (uncertainty)<br>" +
                "<br>" +
                "2.\t<u>“Couldn't have” is also possible for both meanings.</u><br>" +
                "<br>" +
                "3.\t<u>“Couldn't have” can be used with comparative adjectives.</u><br>" +
                "[We <b>couldn't have</b> been happier in those days.]<br>" +
                "<br>" +
                "4.\t<u>“Could have” can also express unwillingness.</u><br>" +
                "[She <b>could have</b> gone to the party with her friends.] (but she didn't)<br><br>" +
                "[We couldn't have left the dog on its own.] (so we didn't)";

        partFourPastModalsLessonContent = "<b><u>“May have” and “might have”</u></b><br>" +
                "1.\t<u>“Might have” refers to past possibility which did not happen.</u><br>" +
                "[You <b>might have</b> drowned!]<br>" +
                "<br>" +
                "2.\t<u>“Might have” and “may have” refer to uncertainty.</u><br>" +
                "[I suppose I <b>may have</b> been rather critical.]<br>" +
                "<br>" +
                "3.\t<u>Both can be used in the negative to express uncertainty.</u><br>" +
                "[They <b>might not have</b> received our letter yet.]<br>" +
                "<br>" +
                "4.\t<u>“Might have” is used to express annoyance at someone's failure to do something.</u><br>There is strong stress on the words underlined.<br>" +
                "[You <b>might have</b> <u>told</u> me my trousers were split!]<br>" +
                "<br>" +
                "5.\t<u>“I might have known” + “would” is an idiom</u> by which the speaker expresses ironically that an action was typical of someone else.<br>" +
                "[<b>I might have known</b> that he <b>would</b> be late.]<br><br>" +
                "[A: It was Jack who broke the vase. B: <b>I might have known</b>!]";

        partFivePastModalsLessonContent = "<b><u>“Would not”</u></b><br>" +
                "This expresses an unwillingness in the past.<br>" +
                "[Everyone was angry because Sam <b>wouldn't</b> turn off the television.]<br><br><br>" +
                "<b><u>“Would have”</u></b><br>" +
                "1.\t<u>“Would have” can refer to events in the past which did not actually happen.</u><br>" +
                "[I <b>would have</b> accepted this job, but I didn't want to move house.]<br>" +
                "<br>" +
                "2.\t<u>Assumptions about the past are also possible with “would have”.</u><br>" +
                "[A: Someone called after you left but didn't leave a message.]<br>" +
                "[B: That <b>would have</b> been Cathy, probably.]";

        partOneButton = (TextView)findViewById(R.id.part_one_button);
        partTwoButton = (TextView)findViewById(R.id.part_two_button);
        partThreeButton = (TextView)findViewById(R.id.part_three_button);
        partFourButton = (TextView)findViewById(R.id.part_four_button);
        partFiveButton = (TextView)findViewById(R.id.part_five_button);

        partOneButton.setOnClickListener(this);
        partTwoButton.setOnClickListener(this);
        partThreeButton.setOnClickListener(this);
        partFourButton.setOnClickListener(this);
        partFiveButton.setOnClickListener(this);

        songListHeader = (TextView)findViewById(R.id.song__list_header);
        songListHeader.setText(tag + " Lesson");

        if(tag.equals("Passive")){
            partOneName = "Basic uses of the passive";
            partTwoName = "The agent";
            partThreeName = "Get something done";
            partFourName = "Reporting verbs";
            partFiveName = "Verbs with prepositions";
        }
        else if(tag.equals("Present / Future Modals")){
            partOneName = "Obligation & Need";
            partTwoName = "Should & Shall";
            partThreeName = "Can & Could";
            partFourName = "May & Might";
            partFiveName = "Will & Would";
        }
        else if(tag.equals("Past Modals")){
            partOneName = "Obligation & Need";
            partTwoName = "Should have & Ought to have";
            partThreeName = "Could & Could have";
            partFourName = "May have & Might have";
            partFiveName = "Would & Would have";
        }

        sectionNames = partOneName + "\n2.\t" + partTwoName + "\n3.\t" + partThreeName + "\n4.\t" + partFourName + "\n5.\t" + partFiveName;
        lessonContentScrollableView = (TextView)findViewById(R.id.lesson_content_view);
        lessonContentScrollableView.setText("This lesson contains 5 sections:\n\n1.\t" + sectionNames + "\n\nChoose any one of them to get started");

        partOneButton.setText(partOneName);
        partTwoButton.setText(partTwoName);
        partThreeButton.setText(partThreeName);
        partFourButton.setText(partFourName);
        partFiveButton.setText(partFiveName);
    }

    //switch between 5 passive tabs
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.part_one_button :
                partOneButton.setTextColor(Color.WHITE);
                partOneButton.setBackgroundColor(Color.parseColor("#cc0000"));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));

                if(tag.equals("Passive")){
                    lessonContentScrollableView.setText(Html.fromHtml(partOnePassiveLessonContent));
                }
                else if(tag.equals("Present / Future Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partOnePresentFutureModalsLessonContent));
                }
                else if(tag.equals("Past Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partOnePastModalsLessonContent));
                }
                break;

            case R.id.part_two_button :
                partTwoButton.setTextColor(Color.WHITE);
                partTwoButton.setBackgroundColor(Color.parseColor("#cc0000"));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));

                if(tag.equals("Passive")){
                    lessonContentScrollableView.setText(Html.fromHtml(partTwoPassiveLessonContent));
                }
                else if(tag.equals("Present / Future Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partTwoPresentFutureModalsLessonContent));
                }
                else if(tag.equals("Past Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partTwoPastModalsLessonContent));
                }
                break;

            case R.id.part_three_button :
                partThreeButton.setTextColor(Color.WHITE);
                partThreeButton.setBackgroundColor(Color.parseColor("#cc0000"));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));

                if(tag.equals("Passive")){
                    lessonContentScrollableView.setText(Html.fromHtml(partThreePassiveLessonContent));
                }
                else if(tag.equals("Present / Future Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partThreePresentFutureModalsLessonContent));
                }
                else if(tag.equals("Past Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partThreePastModalsLessonContent));
                }
                break;

            case R.id.part_four_button :
                partFourButton.setTextColor(Color.WHITE);
                partFourButton.setBackgroundColor(Color.parseColor("#cc0000"));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));

                if(tag.equals("Passive")){
                    lessonContentScrollableView.setText(Html.fromHtml(partFourPassiveLessonContent));
                }
                else if(tag.equals("Present / Future Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partFourPresentFutureModalsLessonContent));
                }
                else if(tag.equals("Past Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partFourPastModalsLessonContent));
                }
                break;

            case R.id.part_five_button :
                partFiveButton.setTextColor(Color.WHITE);
                partFiveButton.setBackgroundColor(Color.parseColor("#cc0000"));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));

                if(tag.equals("Passive")){
                    lessonContentScrollableView.setText(Html.fromHtml(partFivePassiveLessonContent));
                }
                else if(tag.equals("Present / Future Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partFivePresentFutureModalsLessonContent));
                }
                else if(tag.equals("Past Modals")){
                    lessonContentScrollableView.setText(Html.fromHtml(partFivePastModalsLessonContent));
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_five_parts_lesson_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
