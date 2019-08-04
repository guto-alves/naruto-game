package com.gutotech.narutogame.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.publicentities.MenuTitles;

import java.util.HashMap;
import java.util.List;

public class MenuLogadoExpandableLisViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Integer> groupList;
    private HashMap<Integer, List<String>> itemList;

    public MenuLogadoExpandableLisViewAdapter(Context context, List<Integer> groupList, HashMap<Integer, List<String>> itemList) {
        this.context = context;
        this.groupList = groupList;
        this.itemList = itemList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return itemList.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itemList.get(groupList.get(groupPosition)).get(childPosition);
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
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_list_group, null, false);
        }

        ImageView imageView = convertView.findViewById(R.id.categoriaImageView);

        int groupId = (int) getGroup(groupPosition);

        if (groupList.size() == 1)
            imageView.setImageResource(R.drawable.layout_principal);
        else {
            if (MenuTitles.GROUP_USUARIO == groupId)
                imageView.setImageResource(R.drawable.layout_usuario);
            else if (MenuTitles.GROUP_PERSONAGEM == groupId)
                imageView.setImageResource(R.drawable.layout_personagem);
            else if (MenuTitles.GROUP_PRINCIPAL == groupId)
                imageView.setImageResource(R.drawable.layout_principal);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_list_child, null, false);
        }

        TextView textView = convertView.findViewById(R.id.itemTextView);
        textView.setText(child);

        return convertView;
    }

    // colocar alguam condição e retornar false para não ouvir o clique
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
