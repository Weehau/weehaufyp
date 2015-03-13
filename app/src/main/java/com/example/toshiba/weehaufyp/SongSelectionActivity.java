package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

    List<String> titles = new ArrayList<String>();
    List<String> artists = new ArrayList<String>();
    List<String> albums = new ArrayList<String>();
    List<String> songIDs = new ArrayList<String>();
    List<Integer> images = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R. layout.activity_song_selection);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("tag");

        //get song db data
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
                //Toast.makeText(SongSelectionActivity.this, titles[position] + " is clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SongSelectionActivity.this, AudioPlayerActivity.class);
                intent.putExtra("songIDs", songIDs.get(position));
                startActivity(intent);

                //int [] songResource = {R.raw.sam_smith_stay_with_me, R.raw.beyonce_haunted, R.raw.justin_timberlake_mirrors, R.raw.taylor_swift_blank_space, R.raw.lana_del_rey_summertime_sadness, R.raw.bruno_mars_locked_out_of_heaven, R.raw.lorde_royals, R.raw.maroon_5_maps, R.raw.pharrell_williams_happy, R.raw.sia_chandelier};
                //MediaPlayer mediaPlayer = MediaPlayer.create(SongSelectionActivity.this, songResource[position]);
                //mediaPlayer.start();
            }
        });

        SongSelectionAdapter adapter = new SongSelectionAdapter(this, titles, artists, albums, images);
        list.setAdapter(adapter);
    }
}

class SongSelectionAdapter extends ArrayAdapter<String>{
    Context context;
    List<String> titles = new ArrayList<String>();
    List<String> artists = new ArrayList<String>();
    List<String> albums = new ArrayList<String>();
    List<Integer> images = new ArrayList<Integer>();

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

        //final String mySongID = IDs[position];

        myCoverArt.setImageResource(images.get(position));
        myTitle.setText((position + 1) + ". " + titles.get(position));
        myArtist.setText("Artist: " + artists.get(position));
        myAlbum.setText("Album: " + albums.get(position));

        return row;
    }
}