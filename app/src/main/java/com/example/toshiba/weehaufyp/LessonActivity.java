package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;


public class LessonActivity extends Activity {

    ExpandableListView exv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        exv = (ExpandableListView) findViewById(R.id.expandableListView1);
        exv.setAdapter(new LessonAdapter(this));

        exv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //String itemClicked = LessonAdapter.childList[groupPosition][childPosition];
                //Toast.makeText(LessonActivity.this, itemClicked + " is clicked\n" + "Supposed to show " + (groupPosition + 1) + "." + (childPosition + 1)+ " song list.", Toast.LENGTH_SHORT).show();
                //return false;

                Intent songSelectionIntent = new Intent(LessonActivity.this, SongSelectionActivity.class);
                startActivity(songSelectionIntent);

                return false;
            }
        });
    }
}
