package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.toshiba.weehaufyp.R.*;

public class MainActivity extends Activity implements View.OnClickListener {

    Button menu_help_button, menu_credits_button, menu_start_button, menu_settings_button, menu_feedback_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        menu_start_button = (Button) findViewById(id.menu_start_button);
        menu_help_button = (Button) findViewById(id.menu_help_button);
        menu_credits_button = (Button) findViewById(id.menu_credits_button);
        menu_settings_button = (Button) findViewById(id.menu_settings_button);
        menu_feedback_button = (Button) findViewById(id.menu_feedback_button);

        menu_start_button.setOnClickListener(this);
        menu_help_button.setOnClickListener(this);
        menu_credits_button.setOnClickListener(this);
        menu_settings_button.setOnClickListener(this);
        menu_feedback_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case id.menu_start_button :
                Intent lessonIntent = new Intent(this, LessonActivity.class);
                startActivity(lessonIntent);
                break;
                //same as
                //startActivity(new Intent(this, LessonActivity.class));

            case id.menu_credits_button :
                Intent creditsIntent = new Intent(this, CreditsActivity.class);
                startActivity(creditsIntent);
                break;

            case id.menu_settings_button :
                //Toast.makeText(MainActivity.this, "You've just tapped Settings", Toast.LENGTH_SHORT).show();
                Intent audioPlayerIntent = new Intent(this, AudioPlayerActivity.class);
                startActivity(audioPlayerIntent);
                break;

            case id.menu_feedback_button :
                //Toast.makeText(MainActivity.this, "You've just tapped Feedback", Toast.LENGTH_SHORT).show();
                Intent songListIntent = new Intent(this, SongListActivity.class);
                startActivity(songListIntent);
                break;

            case id.menu_help_button :
                Toast.makeText(MainActivity.this, "You've just tapped Help", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
