package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        exv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener(){
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(groupPosition != 3){
                    String tag = LessonAdapter.parentList[groupPosition];
                    Toast.makeText(getApplicationContext(), "Select a song to play", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(LessonActivity.this, SongSelectionActivity.class);
                    intent.putExtra("tag", tag);
                    startActivity(intent);

                    return true;
                }
                else{
                    exv.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){

                        @Override
                        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                            String tag = LessonAdapter.childList[groupPosition][childPosition];
                            Toast.makeText(getApplicationContext(), "Select a song to play", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(LessonActivity.this, SongSelectionActivity.class);
                            intent.putExtra("tag", tag);
                            startActivity(intent);

                            return false;
                        }
                    });
                    return false;
                }
            }
        });
    }
}