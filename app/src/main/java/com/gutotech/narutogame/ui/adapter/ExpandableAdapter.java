package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.ui.SectionFragment;

import java.util.List;
import java.util.Map;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private List<Integer> groups; // each element store a @DrawableRes
    private Map<Integer, List<SectionFragment>> sections;

    public ExpandableAdapter(List<Integer> groups, Map<Integer, List<SectionFragment>> sections) {
        this.groups = groups;
        this.sections = sections;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sections.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sections.get(groupPosition).get(childPosition);
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
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expandable_list_group, null, false);
        }

        ImageView menuTitleImageView = convertView.findViewById(R.id.menuTitleImageView);
        menuTitleImageView.setImageResource((Integer) getGroup(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expandable_list_child, null, false);
        }

        TextView itemTextView = convertView.findViewById(R.id.itemTextView);

        itemTextView.setText(((SectionFragment) getChild(groupPosition, childPosition))
                .getDescription());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
