package com.gutotech.narutogame.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.MenuGroup;
import com.gutotech.narutogame.ui.SectionFragment;

import java.util.HashMap;
import java.util.List;

public class ExpandableLoggedinAdapter extends BaseExpandableListAdapter {
    private List<MenuGroup> menuGroups;

    @Override
    public int getGroupCount() {
        return menuGroups != null ? menuGroups.size() : 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return menuGroups.get(groupPosition).sections.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return menuGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return menuGroups.get(groupPosition).sections.get(childPosition);
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.expandable_logado_list_group, null, false);
        }

        if (menuGroups != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView = convertView.findViewById(R.id.textView);

            MenuGroup menuGroup = (MenuGroup) getGroup(groupPosition);

            imageView.setImageResource(menuGroup.resId);
            textView.setText(menuGroup.name);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.expandable_list_child, null, false);
        }

        if (menuGroups != null) {
            TextView textView = convertView.findViewById(R.id.itemTextView);
            textView.setText(((SectionFragment) getChild(groupPosition, childPosition)).getDescription());
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setMenuGroups(List<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
        notifyDataSetChanged();
    }
}
