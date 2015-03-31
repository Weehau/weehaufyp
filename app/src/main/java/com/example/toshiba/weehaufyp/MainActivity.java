package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.toshiba.weehaufyp.R.*;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView welcomeText, menu_help_button, menu_credits_button, menu_start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        welcomeText = (TextView) findViewById(id.welcome_text);
        final String[] proper_noun = {"An investment in knowledge pays the best interest. - Benjamin Franklin", "Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time. - Thomas A. Edison", "Learning never exhausts the mind. - Leonardo da Vinci", "Where words fail, music speaks. - Hans Christian Andersen"};
        Random random = new Random();
        int index = random.nextInt(proper_noun.length);
        welcomeText.setText(proper_noun[index]);
        //System.out.println(proper_noun[index]);

        menu_start_button = (TextView) findViewById(id.menu_start_button);
        menu_help_button = (TextView) findViewById(id.menu_help_button);
        menu_credits_button = (TextView) findViewById(id.menu_credits_button);

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
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
        }
    }
}
