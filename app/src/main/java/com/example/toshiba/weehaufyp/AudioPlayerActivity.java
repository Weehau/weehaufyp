package com.example.toshiba.weehaufyp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.concurrent.TimeUnit;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AudioPlayerActivity extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    public TextView songName,startTimeField,endTimeField;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private ImageButton playButton, repeatButton, forwardButton, rewindButton, nextButton, previousButton;
    private Button lyricsTabButton, lessonTabButton;
    private static Bundle bundle;
    public static int oneTimeOnly = 0;

    //for fragments
    private static FragmentManager f_manager;
    private static FragmentTransaction f_transaction;

    //variables for db
    String titles, artists, albums, tag;
    int songPath;
    public String songIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        Intent songIntent = getIntent();
        songIDs = songIntent.getStringExtra("songIDs");

        //DB for song=================================================================
        final SongDBClass songDB = new SongDBClass(this);
        songDB.open();
        Cursor c = songDB.playSongByID(songIDs);
        if (c.moveToFirst())
        {
            do {
                titles = c.getString(0);
                artists = c.getString(1);
                albums = c.getString(2);
                songPath = c.getInt(3);
                tag = c.getString(4);
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getBaseContext(), "No song found", Toast.LENGTH_SHORT).show();
        }
        songDB.close();

        /*//DB for lesson======================================================
        final LessonDBClass lessonDB = new LessonDBClass(this);

        String content = null;

        lessonDB.open();
        Cursor c = lessonDB.getContentByLesson(tag);
        if (c.moveToFirst())
        {
            do {
                content.add(c.getString(0));
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getBaseContext(), "No content found", Toast.LENGTH_SHORT).show();
        }
        lessonDB.close();*/

        songName = (TextView)findViewById(R.id.current_song_name);
        startTimeField =(TextView)findViewById(R.id.current_time);
        endTimeField =(TextView)findViewById(R.id.time_duration);
        seekbar = (SeekBar)findViewById(R.id.seekBar1);
        playButton = (ImageButton)findViewById(R.id.play_button);
        forwardButton = (ImageButton)findViewById(R.id.fast_forward_button);
        rewindButton  = (ImageButton)findViewById(R.id.rewind_button);
        nextButton = (ImageButton)findViewById(R.id.next_button);
        previousButton = (ImageButton)findViewById(R.id.previous_button);

        repeatButton = (ImageButton)findViewById(R.id.repeat_button);
        lyricsTabButton = (Button)findViewById(R.id.lyrics_tab_button);
        lessonTabButton = (Button)findViewById(R.id.lesson_tab_button);

        //Add on click listeners to tab buttons
        lyricsTabButton.setOnClickListener(this);
        lessonTabButton.setOnClickListener(this);

        //Initialize fragments
        LyricsFragment f_lyrics = new LyricsFragment();
        //f_lyrics.setArguments(bundle);
        f_manager = getFragmentManager();
        f_transaction = f_manager.beginTransaction();
        f_transaction.add(R.id.fragment_place, f_lyrics);
        f_transaction.commit();

        //Set colors of buttons
        repeatButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint
        lyricsTabButton.setTextColor(Color.WHITE);
        lyricsTabButton.setBackgroundColor(Color.parseColor("#B20000"));
        lessonTabButton.setTextColor(Color.BLACK);
        lessonTabButton.setBackgroundResource(android.R.drawable.btn_default);
        playButton.setColorFilter((Color.rgb(153, 0, 0)));
        forwardButton.setColorFilter((Color.rgb(153, 0, 0)));
        rewindButton.setColorFilter((Color.rgb(153, 0, 0)));
        nextButton.setColorFilter((Color.rgb(153, 0, 0)));
        previousButton.setColorFilter((Color.rgb(153, 0, 0)));

        //set data from db
        songName.setText(titles + " by " + artists);
        mediaPlayer = MediaPlayer.create(this, songPath);

        //play media
        mediaPlayer.start();
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        if(oneTimeOnly == 0){
            seekbar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }

        endTimeField.setText(String.format("%d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) finalTime)))
        );
        startTimeField.setText(String.format("%d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) startTime)))
        );
        seekbar.setProgress((int)startTime);
        myHandler.postDelayed(UpdateSongTime,100);
        seekbar.setClickable(true);
    }

    //switch between lyrics & lesson tabs
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.lyrics_tab_button :
                lyricsTabButton.setTextColor(Color.WHITE);
                lyricsTabButton.setBackgroundColor(Color.parseColor("#B20000"));
                lessonTabButton.setTextColor(Color.BLACK);
                lessonTabButton.setBackgroundResource(android.R.drawable.btn_default);
                LyricsFragment f_lyrics = new LyricsFragment();
                replaceFragmentView(R.id.fragment_place, f_lyrics, "");
                break;

            case R.id.lesson_tab_button :
                lessonTabButton.setTextColor(Color.WHITE);
                lessonTabButton.setBackgroundColor(Color.parseColor("#B20000"));
                lyricsTabButton.setTextColor(Color.BLACK);
                lyricsTabButton.setBackgroundResource(android.R.drawable.btn_default);
                replaceFragmentView(R.id.fragment_place, new LessonContentFragment(), "");
                break;
        }
    }
    public void nowPlayingInfo(View view){
        Toast.makeText(getApplicationContext(), "Now Playing " + titles + "\nArtist: " + artists + "\nAlbum: " + albums, Toast.LENGTH_LONG).show();
    }
    public void exercise (View view){
        //Intent exerciseIntent = new Intent(AudioPlayerActivity.this, ExerciseActivity.class);
        Intent quizIntent = new Intent(AudioPlayerActivity.this, QuizActivity.class);
        quizIntent.putExtra("tag", tag);
        startActivity(quizIntent);
    }
    public void replaceFragmentView(int viewToBeReplaced , Fragment fragmentToReplace, String fragment_tag) {
       // fragmentToReplace.setArguments(bundle);
        f_manager = getFragmentManager();
        f_transaction = f_manager.beginTransaction();
        f_transaction.replace(viewToBeReplaced, fragmentToReplace, fragment_tag);
        f_transaction.commit();
    }

    public void play(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            playButton.setImageResource(R.drawable.black_play_button);
        }
        else{
            mediaPlayer.start();
            playButton.setImageResource(R.drawable.black_pause_button);
            finalTime = mediaPlayer.getDuration();
            startTime = mediaPlayer.getCurrentPosition();
            if(oneTimeOnly == 0){
                seekbar.setMax((int) finalTime);
                oneTimeOnly = 1;
            }

            endTimeField.setText(String.format("%d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) finalTime)))
            );
            startTimeField.setText(String.format("%d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(UpdateSongTime,100); //update the time seen on screen
        }
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            startTimeField.setText(String.format("%d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
    public void forward(View view){
        int temp = (int)startTime;
        if((temp+forwardTime)<=finalTime){
            startTime = startTime + forwardTime;
            mediaPlayer.seekTo((int) startTime);
        }
        else{
            mediaPlayer.seekTo((int)finalTime);
        }
    }
    public void rewind(View view){
        int temp = (int)startTime;
        if((temp-backwardTime)>0){
            startTime = startTime - backwardTime;
            mediaPlayer.seekTo((int) startTime);
        }
        else{
            mediaPlayer.seekTo(0);
        }
    }
    public void previous(View view){
        //To do previous implementation
        Toast.makeText(getApplicationContext(),
                "Previous song will play",
                Toast.LENGTH_SHORT).show();
    }
    public void next(View view){
        //To do next implementation
        Toast.makeText(getApplicationContext(),
                "Next song will play",
                Toast.LENGTH_SHORT).show();
    }
    public void repeat(View view){
        //repeatButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint
        //repeatButton.setBackgroundColor(Color.argb(204, 204, 204, 204));
        if(mediaPlayer.isLooping()){
            mediaPlayer.setLooping(false);
            repeatButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint
            Toast.makeText(getApplicationContext(), "Repeat mode: OFF", Toast.LENGTH_SHORT).show();
        }
        else{
            mediaPlayer.setLooping(true);
            //repeatButton.clearColorFilter();
            repeatButton.setColorFilter((Color.rgb(153, 0, 0)));
            Toast.makeText(getApplicationContext(), "Repeat mode: ON", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            myHandler.removeCallbacks(UpdateSongTime);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_audio_player, menu);
        return true;
    }
    //Methods for seekbar
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        /*if(fromUser){
            mediaPlayer.seekTo(progress);
            startTimeField.setText(String.format("%d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) startTime)))
            );
        }*/
    }
    //When user starts moving the progress handler
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // remove message Handler from updating progress bar
        myHandler.removeCallbacks(UpdateSongTime);
    }
    //When user stops moving the progress handler
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        myHandler.removeCallbacks(UpdateSongTime);
        int totalDuration = mediaPlayer.getDuration();
        int currentPosition = mediaPlayer.getCurrentPosition();

        // forward or backward to certain seconds
        mediaPlayer.seekTo(currentPosition);

        // update timer progress again
        myHandler.postDelayed(UpdateSongTime,100);
    }
}