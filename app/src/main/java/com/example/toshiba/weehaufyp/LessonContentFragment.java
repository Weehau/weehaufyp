package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LessonContentFragment extends Fragment {

    private static Activity activity;
    private static Bundle bundle;

    private TextView lesson_content_view;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics_fragment);
    }*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bundle = this.getArguments();
        return inflater.inflate(R.layout.fragment_lesson_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lesson_content_view = (TextView) activity.findViewById(R.id.lesson_content_view);
        String lesson_name, actual_content;
        lesson_name = "Present Continuous";
        actual_content = "The present continuous is used to talk about present situations which we see as short-term or temporary. We use the present simple to talk about present situations which we see as long-term or permanent.<br>" +
                "<br>" +
                "In these examples, the action is taking place at the time of speaking.<br>" +
                "<br>" +
                "- It's raining.<br>" +
                "- Who is Kate talking to on the phone?<br>" +
                "- Look, somebody is trying to steal that man's wallet.<br>" +
                "- I'm not looking. My eyes are closed tightly.<br>" +
                "<br>" +
                "In these examples, the action is true at the present time but we don't think it will be true in the long term.<br>" +
                "<br>" +
                "- I'm looking for a new apartment.<br>" +
                "- He's thinking about leaving his job.<br>" +
                "- They're considering making an appeal against the judgment.<br>" +
                "- Are you getting enough sleep?<br>" +
                "<br>" +
                "In these examples, the action is at a definite point in the future and it has already been arranged.<br>" +
                "<br>" +
                "- I'm meeting her at 6.30.<br>" +
                "- They aren't arriving until Tuesday.<br>" +
                "- We are having a special dinner at a top restaurant for all the senior managers.<br>" +
                "- Isn't he coming to the dinner?<br>";
        lesson_content_view.setText(Html.fromHtml("<h1><b><u>" + lesson_name + "</u></b></h1>" + actual_content));
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lyrics, menu);
        return true;
    }*/

    /*@Override
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
    }*/
}
