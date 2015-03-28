package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SongSelectionActivity extends Activity {
    ListView list;
    TextView songListHeader, lessonContentButton;
    String tag;

    List<String> titles = new ArrayList<>();
    List<String> artists = new ArrayList<>();
    List<String> albums = new ArrayList<>();
    List<String> songIDs = new ArrayList<>();
    List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R. layout.activity_song_selection);

        Intent intent = getIntent();
        tag = intent.getStringExtra("tag");

        songListHeader = (TextView)findViewById(R.id.song__list_header);
        songListHeader.setText(tag + " Playlist");

        lessonContentButton = (TextView)findViewById(R.id.lessonContent);
        lessonContentButton.setText("Click here to learn about " + tag);

        //DB for song
        final SongDBClass songDB = new SongDBClass(this);
        songDB.open();
        Cursor c = songDB.getSongListByLesson(tag);
        if (c.moveToFirst())
        {
            do {
                titles.add(c.getString(0));
                artists.add(c.getString(1));
                albums.add(c.getString(2));
                images.add(c.getInt(3));
                songIDs.add(c.getString(4));
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getBaseContext(), "No song found", Toast.LENGTH_SHORT).show();
        }
        songDB.close();

        list = (ListView) findViewById(R.id.songListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String selectedItem = (String) list.getItemAtPosition(position);
                Intent intent = new Intent(SongSelectionActivity.this, AudioPlayerActivity.class);
                intent.putExtra("songIDs", songIDs.get(position));
                startActivity(intent);
            }
        });

        SongSelectionAdapter adapter = new SongSelectionAdapter(this, titles, artists, albums, images);
        list.setAdapter(adapter);
    }

    public void lessonContent(View view){
        if(tag.equals("Tense Consolidation")){
            Intent lessonContentIntentForTense = new Intent(SongSelectionActivity.this, TenseLessonContentActivity.class);
            lessonContentIntentForTense.putExtra("tag", tag);
            startActivity(lessonContentIntentForTense);
        }
        else{
            Intent lessonContentIntent = new Intent(SongSelectionActivity.this, LessonContentActivity.class);
            lessonContentIntent.putExtra("tag", tag);
            startActivity(lessonContentIntent);
        }
    }
}

class SongSelectionAdapter extends ArrayAdapter<String>{
    Context context;
    List<String> titles = new ArrayList<>();
    List<String> artists = new ArrayList<>();
    List<String> albums = new ArrayList<>();
    List<Integer> images = new ArrayList<>();

    SongSelectionAdapter(Context c, List<String> titles, List<String> artists, List<String> albums, List<Integer> images)
    {
        super(c, R.layout.song_single_row, R.id.songTitleTextView, titles);
        this.context = c;
        this.images = images;
        this.titles = titles;
        this.artists = artists;
        this.albums = albums;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.song_single_row, parent, false);
        ImageView myCoverArt = (ImageView) row.findViewById(R.id.coverArtImageView);
        TextView myTitle = (TextView) row.findViewById(R.id.songTitleTextView);
        TextView myArtist = (TextView) row.findViewById(R.id.artistTextView);
        TextView myAlbum = (TextView) row.findViewById(R.id.albumTextView);

        myCoverArt.setImageResource(images.get(position));
        myTitle.setText((position + 1) + ". " + titles.get(position));
        myArtist.setText("Artist: " + artists.get(position));
        myAlbum.setText("Album: " + albums.get(position));

        return row;
    }
}