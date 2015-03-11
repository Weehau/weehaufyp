package com.example.toshiba.weehaufyp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        //Bundle songIntent = getIntent().getExtras();
        //int songNameAtPlayer = songIntent.getInt("song_position");

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

        // Initialize fragments
        LyricsFragment f_lyrics = new LyricsFragment();
      //  f_lyrics.setArguments(bundle);
        f_manager = getFragmentManager();
        f_transaction = f_manager.beginTransaction();
        f_transaction.add(R.id.fragment_place, f_lyrics);
        f_transaction.commit();

        songName.setText("Summertime Sadness what if the song name is way way longer than normal song names??");
        //songName.setText(String.valueOf(songNameAtPlayer));
        //Song title ? song lyrics ? Singers ?

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

        //Song path
        int [] songResource = {R.raw.sam_smith_stay_with_me, R.raw.beyonce_haunted, R.raw.justin_timberlake_mirrors, R.raw.taylor_swift_blank_space, R.raw.lana_del_rey_summertime_sadness, R.raw.bruno_mars_locked_out_of_heaven, R.raw.lorde_royals, R.raw.maroon_5_maps, R.raw.pharrell_williams_happy, R.raw.sia_chandelier};
        //int [] songReousrce2 = {...song...};

        //mediaPlayer = MediaPlayer.create(this, songResource[songNameAtPlayer]);
        mediaPlayer = MediaPlayer.create(this, R.raw.lana_del_rey_summertime_sadness);
        seekbar.setClickable(true);
        //pauseButton.setEnabled(false);
    }

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

    public void exercise (View view){
        Intent exerciseIntent = new Intent(this, ExerciseActivity.class);
        startActivity(exerciseIntent);
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
            myHandler.postDelayed(UpdateSongTime,100);
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
            Toast.makeText(getApplicationContext(),
                    "Repeat mode: OFF",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            mediaPlayer.setLooping(true);
            //repeatButton.clearColorFilter();
            repeatButton.setColorFilter((Color.rgb(153, 0, 0)));
            Toast.makeText(getApplicationContext(),
                    "Repeat mode: ON",
                    Toast.LENGTH_SHORT).show();
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
        if(fromUser){
            mediaPlayer.seekTo(progress);
            startTimeField.setText(String.format("%d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) startTime)))
            );
        }
    }
    //When user starts moving the progress handler
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    //When user stops moving the progress handler
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}