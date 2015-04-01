package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class CreditsActivity extends Activity {
    TextView creditsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        creditsTextView = (TextView)findViewById(R.id.credits_text);
        creditsTextView.setText("L.E.T.S. is the development effort of Undergraduate Final Year Project of student Ng Wee Hau, with assistance from project supervisor Michelle Beh Hooi Ching and lecturer Dr. Swagata Sinha Roy.\n\n" +
                "The audio, images, lyrics, and teaching materials used within the system are solely for education purposes and non-proprietary use.\n\n" +
                "No copyright infringement is intended.");
    }
}
