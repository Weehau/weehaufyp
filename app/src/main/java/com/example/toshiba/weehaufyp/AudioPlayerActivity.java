package com.example.toshiba.weehaufyp;

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

public class AudioPlayerActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    public TextView songName,startTimeField,endTimeField;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private ImageButton playButton, repeatButton;
    private Button lyricsTab, lessonTab;
    //private ImageButton pauseButton;
    public static int oneTimeOnly = 0;

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
        repeatButton = (ImageButton)findViewById(R.id.repeat_button);
        lyricsTab = (Button)findViewById(R.id.lyrics_tab_button);
        lessonTab = (Button)findViewById(R.id.lesson_tab_button);
        //pauseButton = (ImageButton)findViewById(R.id.pause_button);

        songName.setText("Summertime Sadness what if the song name is way way longer than normal song names??");
        //songName.setText(String.valueOf(songNameAtPlayer));
        //Song title ? song lyrics ? Singers ?

        repeatButton.setColorFilter(Color.argb(204, 204, 204, 204)); // Grey Tint

        //Song path
        int [] songResource = {R.raw.sam_smith_stay_with_me, R.raw.beyonce_haunted, R.raw.justin_timberlake_mirrors, R.raw.taylor_swift_blank_space, R.raw.lana_del_rey_summertime_sadness, R.raw.bruno_mars_locked_out_of_heaven, R.raw.lorde_royals, R.raw.maroon_5_maps, R.raw.pharrell_williams_happy, R.raw.sia_chandelier};
        //int [] songReousrce2 = {...song...};

        //mediaPlayer = MediaPlayer.create(this, songResource[songNameAtPlayer]);
        mediaPlayer = MediaPlayer.create(this, R.raw.lana_del_rey_summertime_sadness);
        seekbar.setClickable(true);
        //pauseButton.setEnabled(false);
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
    /*public void pause(View view){
        Toast.makeText(getApplicationContext(), "Pausing sound",
                Toast.LENGTH_SHORT).show();

        mediaPlayer.pause();
        pauseButton.setEnabled(false);
        playButton.setEnabled(true);
    }*/
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
            repeatButton.clearColorFilter();
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

    public void lyricsTabOnClick(View view){
        Toast.makeText(getApplicationContext(),
                "Lyrics tab shows by default",
                Toast.LENGTH_SHORT).show();
    }
    public void lessonTabOnClick(View view){
        Toast.makeText(getApplicationContext(),
                "Lesson tab shows when clicked",
                Toast.LENGTH_SHORT).show();
    }
}