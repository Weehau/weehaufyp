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


public class TenseLessonContentActivity extends Activity implements View.OnClickListener{

    TextView songListHeader, lessonContentScrollableView;
    Button presentTimeButton, futureTimeButton, pastTimeButton, presentPerfectButton;

    //variables for db
    private String presentTimeConsolidationLessonContent = "<b><u>Basic contrasts: present simple and present continuous</u></b><br>" +
            "1.\t<u>Present simple generally refers to:</u><br><br>" +
            "Facts that are always true:<br>[Water <b>boils</b> at 100 degrees Celsius.]<br><br>" +
            "Habits:<br>[British people <b>drink</b> a lot of tea.]<br><br>" +
            "States:<br>[I <b>don’t like</b> gangster films.]<br>" +
            "<br>" +
            "2.\t<u>Present continuous (progressive)</u> generally refers to actions which are in progress at the moment.<br>These can be temporary:<br>[I’<b>m staying</b> in a hotel until I find a flat.]<br><br>" +
            "They can be actually in progress:<br>[The dog <b>is sleeping</b> on our bed.]<br><br>" +
            "Or they can be generally in progress but not actually happening at the moment:<br>[I’<b>m learning</b> to drive.]<br><br><br>" +
            "<b><u>State verbs and event (action or dynamic) verbs</u></b><br>" +
            "1.\t<u>State verbs describe a continuing state</u>, so do not usually have a continuous form. Typical examples are:<br>" +
            "“believe”, “belong”, “consist”, “contain”, “doubt”, “fit”, “have”, “know”, “like”, “love”, “matter”, “mean”, “own”, “prefer”, “understand”, “seem”, “suppose”, “suspect”, “want”, “wish”<br>" +
            "<br>" +
            "2.\t<u>Some verbs have a stative meaning and a different active meaning.</u><br>Typical examples are:<br>" +
            "“be”, “depend”, “feel”, “have”, “measure”, “see”, “taste”, “think”, “weigh”<br><br><br>" +
            "<b><u>Other uses of present continuous</u></b><br>" +
            "1.\t<u>Temporary situations</u><br>" +
            "[<b>Are</b> you <b>enjoying</b> your stay here?]<br>" +
            "<br>" +
            "2.\t<u>Repeated actions</u><br>" +
            "[My car has broken down, so I <b>am walking</b> to work these days.]<br>" +
            "<br>" +
            "3.\t<u>Complaints about annoying habits</u><br>" +
            "[You <b>are</b> always <b>making snide remarks</b> about my cooking.]<br>" +
            "<br>" +
            "4.\t<u>With verbs describing change and development:</u><br>" +
            "[The weather <b>is getting</b> worse.]<br>" +
            "[More and more people <b>are giving up</b> smoking.]<br><br><br>" +
            "<b><u>Other uses of present simple</u></b><br>" +
            "1.\t<u>Making declarations</u><br>" +
            "Verbs describing opinions and feelings tend to be state verbs.<br>" +
            "[I <b>hope</b> you'll come to my party.]<br>" +
            "[I <b>bet</b> you don't know the answer.]<br>" +
            "<br>" +
            "2.\t<u>Headlines</u><br>" +
            "These are written in a 'telegram' style, and references to the past are usually simplified to present simple.<br>" +
            "[Ship <b>sinks</b> in midnight collision.]<br>" +
            "<br>" +
            "3.\t<u>Instructions and itineraries</u><br>" +
            "Instructions and recipes can be written in present simple instead of in imperative forms. This style is more personal.<br><br>" +
            "[First you <b>roll out</b> the pastry.]<br>" +
            "<br>" +
            "Itineraries are descriptions of travel arrangements.<br>" +
            "[On day three we <b>visit</b> Stratford-upon-Avon.]<br>" +
            "<br>" +
            "4.\t<u>Summaries of events</u><br>" +
            "Plots of stories, films etc., and summaries of historical events use present (and present perfect) verb forms.<br><br>" +
            "[May 1945: The war in Europe <b>comes</b> to an end.]<br><br>" +
            "[At the end of the play both families <b>realize</b> that their hatred caused the deaths of the lovers.]<br>" +
            "<br>" +
            "5.\t<u>‘Historic present’ in narrative and funny stories<br></u>" +
            "In informal speech, it is possible to use what we call the 'historic present' to describe past events, especially to make the narration seem more immediate and dramatic.<br><br>" +
            "[So then the second man <b>asks</b> the first one why he <b>has</b> a banana in his ear and the first one says ...]";

    private String futureTimeConsolidationLessonContent = "<b><u>Basic contrasts: will, going to, present continuous</u></b><br>" +
            "1.\t“Will” is normally known as the predictive future, and describes known facts, or what we suppose is true.<br>" +
            "[I'<b>ll</b> be late home this evening.]<br>" +
            "[The company <b>will</b> make a profit next year.]<br>" +
            "<br>" +
            "This can also take the form of an assumption.<br>" +
            "[That'<b>ll</b> be Jim at the door.] (This means that I suppose it is Jim.)<br>" +
            "<br>" +
            "2.\t“Will” is also used to express an immediate decision.<br>" +
            "[I’<b>ll</b> take this one.]<br>" +
            "<br>" +
            "3.\t“Be going to” describes intentions or plans. At the moment of speaking the plans have already been made.<br>" +
            "[I'<b>m going to</b> wait here until Carol gets back.]<br>" +
            "<br>" +
            "“Going to” is also used to describe an event whose cause is present or evident.<br>" +
            "[Look at that tree! It'<b>s going to</b> fall.]<br>" +
            "<br>" +
            "Decisions expressed with going to refer to a more distant point in the future.<br>" +
            "<br>" +
            "4.\tPresent continuous describes fixed arrangements, especially social and travel arrangements. A time reference is usually included. Note the strong similarity to the “going to” future.<br>" +
            "[I <b>am having</b> a party next week]<br>and<br>[I <b>am going to have</b> a party next week]<br>are communicating the same message.<br><br>" +
            "<b><u>Future continuous</u></b><br>" +
            "1.\tThis describes an event which will be happening at a future point.<br>" +
            "[Come round in the morning. I'<b>ll be painting</b> in the kitchen.]<br>" +
            "<br>" +
            "2.\tIt can also describe events which are going to happen anyway, rather than events which we choose to make happen.<br>" +
            "[I won't bother to fix a time to see you, because I'<b>ll be calling</b> into the office anyway several times next week.]<br>" +
            "<br>" +
            "3.\tIn some contexts future continuous also sounds more polite than “will”.<br>" +
            "[<b>Will</b> you <b>be going</b> to the shops later? If you go, could you get me some milk?]<br>" +
            "<br>" +
            "4.\tIt can also be used to refer to fixed arrangements and plans.<br>" +
            "[The band <b>will be performing</b> live in Paris this summer.]<br><br>" +
            "<b><u>Future perfect</u></b><br>" +
            "1.\tThis has both simple and continuous forms, and refers to time which we look back at from a future point.<br>" +
            "[In two years’ time I'<b>ll have finished</b> the book.]<br><br>" +
            "[By the end of the month, I'<b>ll have been working</b> for this firm for a year.]<br>" +
            "<br>" +
            "2.\tIt can also be used to express an assumption on the part of the speaker.<br><br>" +
            "[You <b>won't have heard</b> the news, of course.] (This means that I assume you have not heard the news.)";

    private String pastTimeConsolidationLessonContent = "<b><u>Basic contrasts: past simple and past continuous</u></b><br>" +
            "1.\tPast simple generally refers to:<br><br>" +
            "Completed actions:<br>[I <b>got</b> up, <b>switched</b> off the radio, and <b>sat</b> down again.]<br><br>" +
            "Habits:<br>[Every day I <b>went</b> to the park.]<br><br>" +
            "States:<br>[In those days, I <b>didn't like</b> reading.]<br>" +
            "<br>" +
            "2.\tPast continuous (progressive) generally refers to:<br>" +
            "Actions in progress (often interrupted by events)<br>" +
            "[I <b>was drinking</b> my coffee at the time.]<br>" +
            "[While I <b>was opening</b> the letter, the phone rang.]<br>" +
            "<br>" +
            "Background description in narrative<br>" +
            "[I entered the office and looked around. Most people <b>were working</b> at their desks, but Jane <b>was staring</b> out of the window and <b>pretending</b> to write something at the same time.]<br>" +
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
            "1.\tWe use the past perfect when we are already talking about the past, and we want to go back to an earlier past time ('double past').<br>" +
            "[By the time I got to the station, the train <b>had left</b>.]<br>" +
            "<br>" +
            "2.\tPast perfect continuous (progressive)<br>" +
            "The same contrasts between past simple and past continuous (see previous section) can be made in past perfect verb forms for events further back in the past.<br>" +
            "<br>" +
            "[I <b>had been living</b> in a bed-sitter up to then.]<br><br>" +
            "[While I <b>had been talking</b> on the phone, Jimmy <b>had escaped</b>.]<br><br>" +
            "[The whole place was deserted, but it was obvious that someone <b>had been living</b> there. They'<b>d been cooking</b> in the kitchen for a start, and they <b>hadn't bothered</b> to clear up the mess.]<br><br>" +
            "<b><u>“Used to” and “would”</u></b><br>" +
            "1.\t“Used to”<br>" +
            "This often contrasts with the present. The contrast may be stated or understood.<br><br>" +
            "[I <b>used to go</b> swimming a lot.] (but I don't now)<br>" +
            "<br>" +
            "2.\t“Would”<br>" +
            "This is used to describe repeated actions, not states. It describes a habitual activity which was typical of a person.<br><br>" +
            "[Every week he'<b>d buy</b> his mother a bunch of flowers.]<br><br>" +
            "<b><u>Unfulfilled past events</u></b><br>" +
            "1.\tThese describe events intended to take place, but which did not happen.<br><br>" +
            "[I <b>was going to</b> phone you, but I forgot.]<br><br>" +
            "[I <b>was thinking of going</b> to Italy this year, but I haven't decided.]<br><br>" +
            "[I <b>was about to</b> do it, but I started doing something else.]<br><br>" +
            "[Jack <b>was to have taken</b> part, but he fell ill.]<br>" +
            "<br>" +
            "2.\tThe contrasting past event is often understood, but not stated.<br><br>" +
            "[How are you? I <b>was going to</b> phone you.] (but I didn't).<br>" +
            "<br>" +
            "3.\tPolite forms<br>" +
            "These are common with “wonder”.<br><br>" +
            "[I <b>was wondering</b> if you wanted to come to the cinema.]";

    private String presentPerfectConsolidationLessonContent = "<b><u>Present perfect simple</u></b><br>" +
            "1.\tPresent perfect simple refers to:<br>" +
            "Recent events, without a definite time given. The recentness may be indicated by “just”.<br>" +
            "[We'<b>ve missed</b> the turning.]<br>" +
            "[I'<b>ve just</b> seen a ghost!]<br>" +
            "<br>" +
            "Indefinite events, which happened at an unknown time in the past. No definite time is given.<br>" +
            "[Jim <b>has had</b> three car accidents.] (up to the present)<br>" +
            "<br>" +
            "Indefinite events which may have an obvious result in the present:<br>[I'<b>ve twisted</b> my ankle] (that's why I'm limping)<br><br>" +
            "With state verbs, a state which lasts up to the present:<br>[I'<b>ve lived</b> here for the past ten years.]<br><br>" +
            "A habitual action in a period of time up to the present:<br>[I'<b>ve been jogging</b> every morning for the last month.]<br>" +
            "<br>" +
            "2.\tContrast with past simple<br>" +
            "Past simple is used with time expressions which refer to definite times. The time may be stated or understood.<br>Compare:<br>" +
            "[I'<b>ve bought</b> a new car.] (indefinite)<br>" +
            "[I <b>bought</b> a new car <b>last week</b>.] (definite)<br>" +
            "[I <b>bought</b> the car after all.] (implied definite: the car we talked about)<br>" +
            "<br>" +
            "Choice between past simple and present perfect for recent events may depend on the attitude of the speaker.<br>This in turn may depend on whether the speaker feels distant in time or place from the event.<br>" +
            "<br>" +
            "[I'<b>ve left</b> my wallet in the car. I'm going back to get it.]<br>" +
            "Here the speaker may be about to return, and feels that the event is connected with the present.<br>" +
            "<br>" +
            "[I <b>left</b> my wallet in the car. I'm going back to get it.]<br>" +
            "The speaker may feel separated in time from the event, or be further away.<br><br>" +
            "<b><u>Present perfect continuous</u></b><br>" +
            "1.\tPresent perfect continuous (progressive) can refer to a range of meanings, depending on the time expression used and the context.<br>" +
            "<br>" +
            "A state which lasts up to the present moment:<br>[I'<b>ve been waiting</b> for you for three hours.]<br><br>" +
            "An incomplete activity:<br>[I'<b>ve been cleaning</b> the house but I still haven't finished.]<br><br>" +
            "To emphasize duration:<br>[I'<b>ve been writing</b> letters all morning.]<br><br>" +
            "A recently finished activity:<br>[I'<b>ve been running</b>. That's why I look hot.]<br><br>" +
            "A repeated activity:<br>[I'<b>ve been taking</b> French lessons this year]<br>" +
            "<br>" +
            "2.\tContrasts with present perfect simple<br>" +
            "There may be little contrast when some state verbs are used.<br>" +
            "[How long <b>have</b> you <b>lived</b> here?]<br>" +
            "[How long <b>have</b> you <b>been living</b> here?]<br>" +
            "<br>" +
            "Some verbs (especially “sit”, “lie”, “wait” and “stay”) prefer the continuous form.<br>" +
            "There may be a contrast between completion and incompletion, especially if the number of items completed is mentioned.<br><br>" +
            "Completed: emphasis on achievement. [I'<b>ve ironed</b> five shirts this morning.]<br><br>" +
            "Incomplete, or recently completed: emphasis on duration.<br>[I'<b>ve been ironing</b> my shirts this morning.]<br><br>" +
            "<b><u>Time expressions with present perfect</u></b><br>" +
            "1.\tMeaning with present perfect verb forms is associated with certain time expressions.<br>" +
            "Contrast with past simple may depend on the choice of time expression.<br>" +
            "<br>" +
            "Past simple: referring to a specific finished time: “yesterday”, “last week”, “on Sunday”<br><br>" +
            "Present perfect: with 'indefinite' time expressions meaning 'up to now': “since 1968”, “already”<br>" +
            "<br>" +
            "Many time expressions are not associated with a specific verb form, since they refer both to finished time or time up to the present, depending on the speaker's perspective.<br>" +
            "[I <b>haven't seen</b> Helen <b>recently</b>.]<br>" +
            "[I <b>saw</b> Jim <b>recently</b>.]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tense_lesson_content);

        presentTimeButton = (Button)findViewById(R.id.present_time_button);
        futureTimeButton = (Button)findViewById(R.id.future_time_button);
        pastTimeButton = (Button)findViewById(R.id.past_time_button);
        presentPerfectButton = (Button)findViewById(R.id.present_perfect_button);

        presentTimeButton.setOnClickListener(this);
        futureTimeButton.setOnClickListener(this);
        pastTimeButton.setOnClickListener(this);
        presentPerfectButton.setOnClickListener(this);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        songListHeader = (TextView)findViewById(R.id.song__list_header);
        songListHeader.setText(tag + " Lesson");

        lessonContentScrollableView = (TextView)findViewById(R.id.lesson_content_view);
        lessonContentScrollableView.setText("This lesson contains 4 sections:\n1.\tPresent time\n2.\tFuture time\n3.\tPast time\n4.\tPresent perfect\n\nChoose any one of them to get started");

        presentTimeButton.setTextColor(Color.BLACK);
        presentTimeButton.setBackgroundResource(android.R.drawable.btn_default);
        futureTimeButton.setTextColor(Color.BLACK);
        futureTimeButton.setBackgroundResource(android.R.drawable.btn_default);
        pastTimeButton.setTextColor(Color.BLACK);
        pastTimeButton.setBackgroundResource(android.R.drawable.btn_default);
        presentPerfectButton.setTextColor(Color.BLACK);
        presentPerfectButton.setBackgroundResource(android.R.drawable.btn_default);
    }

    //switch between 4 tense buttons
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.present_time_button :
                presentTimeButton.setTextColor(Color.WHITE);
                presentTimeButton.setBackgroundColor(Color.parseColor("#B20000"));
                futureTimeButton.setTextColor(Color.BLACK);
                futureTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                pastTimeButton.setTextColor(Color.BLACK);
                pastTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                presentPerfectButton.setTextColor(Color.BLACK);
                presentPerfectButton.setBackgroundResource(android.R.drawable.btn_default);
                lessonContentScrollableView.setText(Html.fromHtml(presentTimeConsolidationLessonContent));
                break;

            case R.id.future_time_button :
                futureTimeButton.setTextColor(Color.WHITE);
                futureTimeButton.setBackgroundColor(Color.parseColor("#B20000"));
                presentTimeButton.setTextColor(Color.BLACK);
                presentTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                pastTimeButton.setTextColor(Color.BLACK);
                pastTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                presentPerfectButton.setTextColor(Color.BLACK);
                presentPerfectButton.setBackgroundResource(android.R.drawable.btn_default);
                lessonContentScrollableView.setText(Html.fromHtml(futureTimeConsolidationLessonContent));
                break;

            case R.id.past_time_button :
                pastTimeButton.setTextColor(Color.WHITE);
                pastTimeButton.setBackgroundColor(Color.parseColor("#B20000"));
                presentTimeButton.setTextColor(Color.BLACK);
                presentTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                futureTimeButton.setTextColor(Color.BLACK);
                futureTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                presentPerfectButton.setTextColor(Color.BLACK);
                presentPerfectButton.setBackgroundResource(android.R.drawable.btn_default);
                lessonContentScrollableView.setText(Html.fromHtml(pastTimeConsolidationLessonContent));
                break;

            case R.id.present_perfect_button :
                presentPerfectButton.setTextColor(Color.WHITE);
                presentPerfectButton.setBackgroundColor(Color.parseColor("#B20000"));
                presentTimeButton.setTextColor(Color.BLACK);
                presentTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                futureTimeButton.setTextColor(Color.BLACK);
                futureTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                pastTimeButton.setTextColor(Color.BLACK);
                pastTimeButton.setBackgroundResource(android.R.drawable.btn_default);
                lessonContentScrollableView.setText(Html.fromHtml(presentPerfectConsolidationLessonContent));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tense_lesson_content, menu);
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
