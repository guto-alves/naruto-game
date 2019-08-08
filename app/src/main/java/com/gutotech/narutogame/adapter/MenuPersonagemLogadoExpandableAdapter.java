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

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class MenuPersonagemLogadoExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> groupListText;
    private List<Integer> groupListImage;
    private HashMap<String, List<String>> itemList;

    public MenuPersonagemLogadoExpandableAdapter(Context context, List<String> groupListText, List<Integer> groupListImage, HashMap<String, List<String>> itemList) {
        this.context = context;
        this.groupListText = groupListText;
        this.groupListImage = groupListImage;
        this.itemList = itemList;
    }

    @Override
    public int getGroupCount() {
        return groupListText.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return itemList.get(groupListText.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupListText.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itemList.get(groupListText.get(groupPosition)).get(childPosition);
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
            convertView = layoutInflater.inflate(R.layout.expandable_logado_list_group, null, false);
        }

        ImageView categoriaImageView = convertView.findViewById(R.id.categoriaImageView);
        TextView categoriaTextView = convertView.findViewById(R.id.categoriaTextView);

        categoriaTextView.setText(groupListText.get(groupPosition));
        categoriaImageView.setImageResource(groupListImage.get(groupPosition));

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

    // colocar alguma condição e retornar false para não ouvir o clique
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
