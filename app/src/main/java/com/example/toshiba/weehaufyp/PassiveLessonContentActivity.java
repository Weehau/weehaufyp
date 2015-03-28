package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PassiveLessonContentActivity extends Activity implements View.OnClickListener{

    TextView songListHeader, lessonContentScrollableView;
    TextView partOneButton, partTwoButton, partThreeButton, partFourButton, partFiveButton;

    //variables for db
    String partOneLessonContent, partTwoLessonContent, partThreeLessonContent, partFourLessonContent, partFiveLessonContent;
    String sectionNames, partOneName, partTwoName, partThreeName, partFourName, partFiveName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passive_lesson_content);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        partOneLessonContent = "<b><u>Basic uses of the passive</u></b><br>" +
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

        partTwoLessonContent = "<b><u>Using and not mentioning the agent</u></b><br>" +
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

        partThreeLessonContent = "<b><u>“Have” and “get something done”, “need doing”</u></b><br>" +
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

        partFourLessonContent = "<b><u>Reporting verbs</u></b><br>" +
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

        partFiveLessonContent = "<b><u>Verbs with prepositions</u></b><br>" +
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

        partOneName = "Basic uses of the passive";
        partTwoName = "The agent";
        partThreeName = "Get something done";
        partFourName = "Reporting verbs";
        partFiveName = "Verbs with prepositions";

        sectionNames = partOneName + "\n2.\t" + partTwoName + "\n3.\t" + partThreeName + "\n4.\t" + partFourName + "\n5.\t" + partFiveName;
        lessonContentScrollableView = (TextView)findViewById(R.id.lesson_content_view);
        lessonContentScrollableView.setText("This lesson contains 5 sections:\n1.\t" + sectionNames + "\n\nChoose any one of them to get started");

        partOneButton.setText(partOneName);
        partTwoButton.setText(partTwoName);
        partThreeButton.setText(partThreeName);
        partFourButton.setText(partFourName);
        partFiveButton.setText(partFiveName);
    }

    //switch between 4 tense buttons
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.part_one_button :
                partOneButton.setTextColor(Color.WHITE);
                partOneButton.setBackgroundColor(Color.rgb(153, 0, 0));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));
                lessonContentScrollableView.setText(Html.fromHtml(partOneLessonContent));
                break;

            case R.id.part_two_button :
                partTwoButton.setTextColor(Color.WHITE);
                partTwoButton.setBackgroundColor(Color.rgb(153, 0, 0));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));
                lessonContentScrollableView.setText(Html.fromHtml(partTwoLessonContent));
                break;

            case R.id.part_three_button :
                partThreeButton.setTextColor(Color.WHITE);
                partThreeButton.setBackgroundColor(Color.rgb(153, 0, 0));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));
                lessonContentScrollableView.setText(Html.fromHtml(partThreeLessonContent));
                break;

            case R.id.part_four_button :
                partFourButton.setTextColor(Color.WHITE);
                partFourButton.setBackgroundColor(Color.rgb(153, 0, 0));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                partFiveButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFiveButton.setBackgroundColor(Color.parseColor("#404040"));
                lessonContentScrollableView.setText(Html.fromHtml(partFourLessonContent));
                break;

            case R.id.part_five_button :
                partFiveButton.setTextColor(Color.WHITE);
                partFiveButton.setBackgroundColor(Color.rgb(153, 0, 0));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                partThreeButton.setTextColor(Color.parseColor("#e5e5e5"));
                partThreeButton.setBackgroundColor(Color.parseColor("#404040"));
                partFourButton.setTextColor(Color.parseColor("#e5e5e5"));
                partFourButton.setBackgroundColor(Color.parseColor("#404040"));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                lessonContentScrollableView.setText(Html.fromHtml(partFiveLessonContent));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_passive_lesson_content, menu);
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
