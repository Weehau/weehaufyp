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

        TextView textView = (TextView)rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.coverArtImageView);

        textView.setText(values[position]);

        String str = values[position];

        if(str.equalsIgnoreCase("Song 1")){
            imageView.setImageResource(R.drawable.beyonce_beyonce);
        }
        else if(str.equalsIgnoreCase("Song 2")){
            imageView.setImageResource(R.drawable.justin_timberlake_the_20_20_experience_2_of_2);
        }
        else if(str.equalsIgnoreCase("Song 3")){
            imageView.setImageResource(R.drawable.lana_del_rey_born_to_die);
        }
        else if(str.equalsIgnoreCase("Song 4")){
            imageView.setImageResource(R.drawable.lorde_royals);
        }
        else if(str.equalsIgnoreCase("Song 5")){
            imageView.setImageResource(R.drawable.maroon_5_v);
        }
        else if(str.equalsIgnoreCase("Song 6")){
            imageView.setImageResource(R.drawable.pharrell_williams_girl);
        }
        else if(str.equalsIgnoreCase("Song 7")){
            imageView.setImageResource(R.drawable.sam_smith_in_the_lonely_hour);
        }
        else if(str.equalsIgnoreCase("Song 8")){
            imageView.setImageResource(R.drawable.sia_1000_forms_of_fear);
        }
        else if(str.equalsIgnoreCase("Song 9")){
            imageView.setImageResource(R.drawable.taylor_swift_1989);
        }

        return rowView;
    }
}
