package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class LessonContentActivity extends Activity {

    TextView songListHeader, lessonContentScrollableView;

    //variables for db
    String lessonContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_content);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        //DB for lesson
        final LessonDBClass lessonDB = new LessonDBClass(this);
        lessonDB.open();
        Cursor c = lessonDB.getLessonContentByLesson(tag);
        if (c.moveToFirst())
        {
            do {
                lessonContent = c.getString(0);
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getBaseContext(), "No lesson content found", Toast.LENGTH_SHORT).show();
        }
        lessonDB.close();

        songListHeader = (TextView)findViewById(R.id.song__list_header);
        songListHeader.setText(tag + " Lesson");

        lessonContentScrollableView = (TextView)findViewById(R.id.lesson_content_view);
        //lessonContentScrollableView.setText(lessonContent);
        lessonContentScrollableView.setText(Html.fromHtml(lessonContent));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lesson_content, menu);
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
