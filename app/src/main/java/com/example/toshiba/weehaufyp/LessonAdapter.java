package com.example.toshiba.weehaufyp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by Toshiba on 28-Jan-15.
 */
public class LessonAdapter extends BaseExpandableListAdapter {

    private Context context;
    static String [] parentList = {"Tense Consolidation", "Passive", "Conditionals and if-sentences", "Modal Auxiliaries", "Articles", "Prepositions"};
    static String [][] childList = {
            {},
            {},
            {},
            {"Present / Future Modals", "Past Modals"},
            {},
            {}
    };

    //A constructor for adapter
    public LessonAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return parentList.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText((groupPosition + 1) + ". " + parentList[groupPosition]);
        tv.setPadding(80, 10, 10, 10);
        tv.setTextSize(25);
        //tv.setTextColor(Color.RED);

        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText((groupPosition + 1) + "." + (childPosition + 1) + " " + childList[groupPosition][childPosition]);
        //tv.setTag(groupPosition);
        tv.setPadding(120, 10, 10, 10);
        tv.setTextSize(20);

        return tv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}