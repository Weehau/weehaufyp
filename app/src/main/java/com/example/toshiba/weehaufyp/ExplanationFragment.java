package com.example.toshiba.weehaufyp;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ExplanationFragment extends Fragment {

    private static Activity activity;
    private static Bundle bundle;
    private TextView lesson_content_view;

    //variables for db
    String songIDs, explanation;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bundle = this.getArguments();
        Log.d("=========", "SONG ID is " + bundle.getString("songIDs"));
        songIDs = bundle.getString("songIDs");
        return inflater.inflate(R.layout.fragment_explanation, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //DB for song=================================================================
        final SongDBClass songDB = new SongDBClass(getActivity());
        songDB.open();
        Cursor c = songDB.showExplanationByID(songIDs);
        if (c.moveToFirst())
        {
            do {
                explanation = c.getString(0);
            } while (c.moveToNext());
        }
        else{
            Toast.makeText(getActivity(), "No explanation found", Toast.LENGTH_SHORT).show();
        }
        songDB.close();

        lesson_content_view = (TextView) activity.findViewById(R.id.lesson_content_view);
        lesson_content_view.setText(explanation);

        //lesson_content_view.setText(Html.fromHtml("<h1><b><u>" + lesson_name + "</u></b></h1>" + actual_content));
    }
}
