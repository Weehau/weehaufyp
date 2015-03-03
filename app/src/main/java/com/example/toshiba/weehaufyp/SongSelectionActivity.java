package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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


public class SongSelectionActivity extends Activity {
    ListView list;

    //String[] songList = {"Song 1", "Song 2", "Song 3", "Song 4", "Song 5", "Song 6", "Song 7", "Song 8", "Song 9"};
    String[] titles;
    String[] artists;
    String[] albums;
    int[] images = {R.drawable.sam_smith_in_the_lonely_hour, R.drawable.beyonce_beyonce, R.drawable.justin_timberlake_the_20_20_experience_2_of_2, R.drawable.taylor_swift_1989,
            R.drawable.lana_del_rey_born_to_die, R.drawable.bruno_mars_unorthodox_jukebox, R.drawable.lorde_royals, R.drawable.maroon_5_v, R.drawable.pharrell_williams_girl, R.drawable.sia_1000_forms_of_fear};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R. layout.activity_song_selection);
        //setListAdapter(new SongSelectionAdapter(this, songList));

        Resources res = getResources();
        titles = res.getStringArray(R.array.main1_sub1_songs);
        artists = res.getStringArray(R.array.main1_sub1_artists);
        albums = res.getStringArray(R.array.main1_sub1_albums);

        list = (ListView) findViewById(R.id.songListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String selectedItem = (String) list.getItemAtPosition(position);
                //String itemClicked = LessonAdapter.childList[groupPosition][childPosition];
                //Toast.makeText(SongSelectionActivity.this, "Song "+ (position + 1)  + " is clicked\n" + "Supposed to play " + "\"" + titles[position] + "\"", Toast.LENGTH_SHORT).show();

                // selected item
                //String product = ((TextView) view).getText().toString();

                /*Intent i = new Intent();
                i.putExtra("song_position", position);
                startActivity(i);*/

                //int [] songResource = {R.raw.sam_smith_stay_with_me, R.raw.beyonce_haunted, R.raw.justin_timberlake_mirrors, R.raw.taylor_swift_blank_space, R.raw.lana_del_rey_summertime_sadness, R.raw.bruno_mars_locked_out_of_heaven, R.raw.lorde_royals, R.raw.maroon_5_maps, R.raw.pharrell_williams_happy, R.raw.sia_chandelier};
                //MediaPlayer mediaPlayer = MediaPlayer.create(SongSelectionActivity.this, songResource[position]);

                //mediaPlayer.start();
                // sending data to new activity
            }
        });

        SongSelectionAdapter adapter = new SongSelectionAdapter(this, titles, images, artists, albums);
        list.setAdapter(adapter);
    }
}

class SongSelectionAdapter extends ArrayAdapter<String>{
    Context context;
    String[] titles;
    int[] images;
    String[] artists;
    String[] albums;

    SongSelectionAdapter(Context c, String[] titles, int images[], String[] artists, String[] albums)
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

        myCoverArt.setImageResource(images[position]);
        myTitle.setText((position + 1) + ". " + titles[position]);
        myArtist.setText(artists[position]);
        myAlbum.setText(albums[position]);

        /*convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AudioPlayerActivity.class);
                intent.putExtra("song_name", myTitle);
                startActivity(intent);
            }
        });*/

        return row;
    }
}