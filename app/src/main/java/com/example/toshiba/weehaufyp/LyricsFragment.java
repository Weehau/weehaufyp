package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LyricsFragment extends Fragment {

    private static Activity activity;
    private static Bundle bundle;
    private TextView lyrics_view;

    //variables for db
    String songIDs, lyrics;

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
        Log.d("=========", "SONG ID is " + bundle.getString("songIDs"));
        songIDs = bundle.getString("songIDs");
        return inflater.inflate(R.layout.fragment_lyrics, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //DB for song=================================================================
        final SongDBClass songDB = new SongDBClass(getActivity());
        songDB.open();
        Cursor c = songDB.showLyricsByID(songIDs);
        if (c.moveToFirst())
        {
            do {
                lyrics = c.getString(0);
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getActivity(), "No lyrics found", Toast.LENGTH_SHORT).show();
        }
        songDB.close();

        /*GradientDrawable gd = new GradientDrawable();
        gd.setColor(0x00000000); // Changes this drawable to use a single color instead of a gradient
        gd.setCornerRadius(5);
        gd.setStroke(5, 0xFF000000);*/
        //lyrics_view.setBackgroundDrawable(gd);

        lyrics_view = (TextView) activity.findViewById(R.id.lyrics_view);
        lyrics_view.setText(lyrics);
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
