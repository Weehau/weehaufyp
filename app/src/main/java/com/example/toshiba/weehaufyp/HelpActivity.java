package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class HelpActivity extends Activity {
    List<Integer> tipImage = new ArrayList<>();
    List<String> tipDescription = new ArrayList<>();

    ImageView tipImageView;
    TextView tipDescriptionTextView, nextTipButton, previousTipButton;
    String tag = "Help";
    int currentHelpIndex, totalHelpCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //DB for help
        final HelpDBClass helpDB = new HelpDBClass(this);
        helpDB.open();
        Cursor c = helpDB.getHelpByTag(tag);
        if (c.moveToFirst())
        {
            do {
                tipImage.add(c.getInt(0));
                tipDescription.add(c.getString(1));
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getBaseContext(), "No help found", Toast.LENGTH_SHORT).show();
        }
        helpDB.close();

        currentHelpIndex = 0;
        totalHelpCount = tipImage.size();

        tipImageView = (ImageView)findViewById(R.id.tip_image);
        tipDescriptionTextView = (TextView)findViewById(R.id.tip_description);
        nextTipButton = (TextView)findViewById(R.id.next_tip_button);
        previousTipButton = (TextView)findViewById(R.id.previous_tip_button);
        previousTipButton.setEnabled(false);
        previousTipButton.setTextColor(Color.parseColor("#515151"));

        setHelpView();
    }

    public void nextTip(View view){
        if(currentHelpIndex == 5){
            Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }
        else if(currentHelpIndex == 4){
            nextTipButton.setText("OK");
            currentHelpIndex++;
            setHelpView();
        }
        else if(currentHelpIndex >= 0 || currentHelpIndex <= 3){
            currentHelpIndex++;
            setHelpView();
            previousTipButton.setEnabled(true);
            previousTipButton.setTextColor(Color.parseColor("#e5e5e5"));
        }
    }

    public void previousTip(View view){
        if(currentHelpIndex == 0){
            previousTipButton.setEnabled(false);
            previousTipButton.setTextColor(Color.parseColor("#515151"));
        }
        else if(currentHelpIndex == 1){
            previousTipButton.setEnabled(false);
            previousTipButton.setTextColor(Color.parseColor("#515151"));
            currentHelpIndex--;
            setHelpView();
        }
        else if(currentHelpIndex >= 2 && currentHelpIndex <= 4){
            currentHelpIndex--;
            setHelpView();
        }
        else if(currentHelpIndex == 5){
            nextTipButton.setText("Next Tip");
            currentHelpIndex--;
            setHelpView();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
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
    }

    public void setHelpView(){
        tipImageView.setImageResource(tipImage.get(currentHelpIndex));
        tipDescriptionTextView.setText(Html.fromHtml((currentHelpIndex + 1) + "/" + totalHelpCount + "<br>" + tipDescription.get(currentHelpIndex)));
    }
}
