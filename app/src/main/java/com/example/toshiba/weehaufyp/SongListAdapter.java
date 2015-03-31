package com.example.toshiba.weehaufyp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Toshiba on 29-Jan-15.
 */
public class SongListAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] values;

    public SongListAdapter(Context context, String[] values) {
        super(context, R.layout.activity_song_selection, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflator.inflate(R.layout.activity_song_selection, parent, false);

        TextView textView = (TextView)rowView.findViewById(R.id.song__list_header);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.coverArtImageView);

        textView.setText(values[position]);

        String str = values[position];

        if(str.equalsIgnoreCase("Song 3")){
            imageView.setImageResource(R.drawable.lana_del_rey_born_to_die);
        }
        else {
            imageView.setImageResource(R.drawable.lorde_royals);
        }

        return rowView;
    }
}
