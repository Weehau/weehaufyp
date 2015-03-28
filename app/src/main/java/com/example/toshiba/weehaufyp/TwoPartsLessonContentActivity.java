package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class TwoPartsLessonContentActivity extends Activity implements View.OnClickListener{

    TextView songListHeader, lessonContentScrollableView;
    TextView partOneButton, partTwoButton;

    //variables for db
    String partOneLessonContent, partTwoLessonContent;
    String sectionNames, partOneName, partTwoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_parts_lesson_content);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        //DB for lesson
        final LessonDBClass lessonDB = new LessonDBClass(this);
        lessonDB.open();
        Cursor c = lessonDB.getTwoPartsLessonContentByLesson(tag);
        if (c.moveToFirst())
        {
            do {
                partOneLessonContent = c.getString(0);
                partTwoLessonContent = c.getString(1);
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getBaseContext(), "No lesson content found", Toast.LENGTH_SHORT).show();
        }
        lessonDB.close();

        partOneButton = (TextView)findViewById(R.id.part_one_button);
        partTwoButton = (TextView)findViewById(R.id.part_two_button);

        partOneButton.setOnClickListener(this);
        partTwoButton.setOnClickListener(this);

        songListHeader = (TextView)findViewById(R.id.song__list_header);
        songListHeader.setText(tag + " Lesson");

        if(tag.equals("Conditionals and if-sentences")){
            partOneName = "Basic contrasts";
            partTwoName = "Variations";
        }
        else if(tag.equals("Articles")){
            partOneName = "Definite article";
            partTwoName = "Indefinite article";
        }
        else if(tag.equals("Prepositions")){
            partOneName = "Prepositions of place";
            partTwoName = "Prepositions of time";
        }

        sectionNames = partOneName + "\n2.\t" + partTwoName;
        lessonContentScrollableView = (TextView)findViewById(R.id.lesson_content_view);
        lessonContentScrollableView.setText("This lesson contains 2 sections:\n\n1.\t" + sectionNames + "\n\nChoose any one of them to get started");

        partOneButton.setText(partOneName);
        partTwoButton.setText(partTwoName);
    }

    //switch between 4 tense tabs
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.part_one_button :
                partOneButton.setTextColor(Color.WHITE);
                partOneButton.setBackgroundColor(Color.rgb(153, 0, 0));
                partTwoButton.setTextColor(Color.parseColor("#e5e5e5"));
                partTwoButton.setBackgroundColor(Color.parseColor("#404040"));
                lessonContentScrollableView.setText(Html.fromHtml(partOneLessonContent));
                break;

            case R.id.part_two_button :
                partTwoButton.setTextColor(Color.WHITE);
                partTwoButton.setBackgroundColor(Color.rgb(153, 0, 0));
                partOneButton.setTextColor(Color.parseColor("#e5e5e5"));
                partOneButton.setBackgroundColor(Color.parseColor("#404040"));
                lessonContentScrollableView.setText(Html.fromHtml(partTwoLessonContent));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_parts_lesson_content, menu);
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
}
