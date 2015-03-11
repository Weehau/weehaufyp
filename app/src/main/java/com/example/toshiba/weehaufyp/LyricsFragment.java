package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LyricsFragment extends Fragment {

    private static Activity activity;
    private static Bundle bundle;

    private TextView lyrics_view;

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
        return inflater.inflate(R.layout.fragment_lyrics, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*GradientDrawable gd = new GradientDrawable();
        gd.setColor(0x00000000); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(5);
        gd.setStroke(5, 0xFF000000);*/

        lyrics_view = (TextView) activity.findViewById(R.id.lyrics_view);
        String actual_lyrics;
        actual_lyrics = "Kiss me hard before you go\n" +
                "Summertime sadness\n" +
                "I just wanted you to know\n" +
                "That, baby, you're the best\n" +
                "\n" +
                "I got my red dress on tonight\n" +
                "Dancing in the dark in the pale moonlight\n" +
                "Done my hair up real big beauty queen style\n" +
                "High heels off, I'm feeling alive\n" +
                "\n" +
                "Oh, my God, I feel it in the air\n" +
                "Telephone wires above are sizzling like a snare\n" +
                "Honey, I'm on fire, I feel it everywhere\n" +
                "Nothing scares me anymore\n" +
                "\n" +
                "(1, 2, 3, 4)\n" +
                "\n" +
                "Kiss me hard before you go\n" +
                "Summertime sadness\n" +
                "I just wanted you to know\n" +
                "That, baby, you're the best\n" +
                "\n" +
                "I got that summertime, summertime sadness\n" +
                "S-s-summertime, summertime sadness\n" +
                "Got that summertime, summertime sadness\n" +
                "Oh, oh, oh, oh, oh\n" +
                "\n" +
                "I'm feelin' electric tonight\n" +
                "Cruising down the coast goin' 'bout 99\n" +
                "Got my bad baby by my heavenly side\n" +
                "I know if I go, I'll die happy tonight\n" +
                "\n" +
                "Oh, my God, I feel it in the air\n" +
                "Telephone wires above are sizzling like a snare\n" +
                "Honey, I'm on fire, I feel it everywhere\n" +
                "Nothing scares me anymore\n" +
                "\n" +
                "(1, 2, 3, 4)\n" +
                "\n" +
                "Kiss me hard before you go\n" +
                "Summertime sadness\n" +
                "I just wanted you to know\n" +
                "That, baby, you're the best\n" +
                "\n" +
                "I got that summertime, summertime sadness\n" +
                "S-s-summertime, summertime sadness\n" +
                "Got that summertime, summertime sadness\n" +
                "Oh, oh, oh, oh, oh\n" +
                "\n" +
                "Think I'll miss you forever\n" +
                "Like the stars miss the sun in the morning sky\n" +
                "Later's better than never\n" +
                "Even if you're gone I'm gonna drive (drive, drive)\n" +
                "\n" +
                "I got that summertime, summertime sadness\n" +
                "S-s-summertime, summertime sadness\n" +
                "Got that summertime, summertime sadness\n" +
                "Oh, oh, oh, oh, oh\n" +
                "\n" +
                "Kiss me hard before you go\n" +
                "Summertime sadness\n" +
                "I just wanted you to know\n" +
                "That, baby, you're the best\n" +
                "\n" +
                "I got that summertime, summertime sadness\n" +
                "S-s-summertime, summertime sadness\n" +
                "Got that summertime, summertime sadness\n" +
                "Oh, oh, oh, oh, oh";
        //lyrics_view.setBackgroundDrawable(gd);
        lyrics_view.setText(actual_lyrics);
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
