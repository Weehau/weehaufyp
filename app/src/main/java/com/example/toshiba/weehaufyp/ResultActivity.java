package com.example.toshiba.weehaufyp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating((float)(score/2));
        switch (score)
        {
            case 0: t.setText("You've got it all wrong.. :(");
                break;
            case 1: t.setText("1 correct");
                break;
            case 2: t.setText("2 correct");
                break;
            case 3: t.setText("3 correct");
                break;
            case 4: t.setText("4 correct");
                break;
            case 5: t.setText("5 correct");
                break;
            case 6: t.setText("6 correct");
                break;
            case 7: t.setText("7 correct");
                break;
            case 8: t.setText("8 correct");
                break;
            case 9: t.setText("9 correct");
                break;
            case 10: t.setText("10 correct. ALL correct.");
                break;
            default: t.setText("Default. None correct.");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }
}
