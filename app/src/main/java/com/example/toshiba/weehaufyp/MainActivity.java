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

    Button menu_help_button, menu_credits_button, menu_start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        menu_start_button = (Button) findViewById(id.menu_start_button);
        menu_help_button = (Button) findViewById(id.menu_help_button);
        menu_credits_button = (Button) findViewById(id.menu_credits_button);

        menu_start_button.setOnClickListener(this);
        menu_help_button.setOnClickListener(this);
        menu_credits_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case id.menu_start_button :
                Intent lessonIntent = new Intent(this, LessonActivity.class);
                startActivity(lessonIntent);
                Toast.makeText(getApplicationContext(), "Select a lesson", Toast.LENGTH_LONG).show();
                break;

            case id.menu_credits_button :
                Intent creditsIntent = new Intent(this, CreditsActivity.class);
                startActivity(creditsIntent);
                break;

            case id.menu_help_button :
                Toast.makeText(MainActivity.this, "You've just tapped Help", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
