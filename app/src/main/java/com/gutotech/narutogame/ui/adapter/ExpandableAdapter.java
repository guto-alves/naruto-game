package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;

import java.util.List;
import java.util.Map;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Integer> groups; // each element store a @DrawableRes
    private Map<Integer, List<Integer>> items;

    public ExpandableAdapter(Context context, List<Integer> groups, Map<Integer, List<Integer>> items) {
        this.context = context;
        this.groups = groups;
        this.items = items;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expandable_list_group, null, false);
        }

        ImageView menuTitleImageView = convertView.findViewById(R.id.menuTitleImageView);
        menuTitleImageView.setImageResource((Integer) getGroup(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expandable_list_child, null, false);
        }

        TextView itemTextView = convertView.findViewById(R.id.itemTextView);
        itemTextView.setText((Integer) getChild(groupPosition, childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
