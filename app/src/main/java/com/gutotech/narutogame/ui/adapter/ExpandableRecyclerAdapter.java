package com.gutotech.narutogame.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.gutotech.narutogame.R;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;

public class ExpandableRecyclerAdapter extends AbstractExpandableItemAdapter<
        ExpandableRecyclerAdapter.MyGroupViewHolder, ExpandableRecyclerAdapter.MyChildViewHolder> {

    public static abstract class MyBaseViewHolder extends AbstractExpandableItemViewHolder {
        public FrameLayout mContainer;
        public TextView mTextView;

        public MyBaseViewHolder(View v) {
            super(v);
            mContainer = v.findViewById(R.id.container);
            mTextView = v.findViewById(android.R.id.text1);
        }
    }

    public static class MyGroupViewHolder extends MyBaseViewHolder {

        public MyGroupViewHolder(View v) {
            super(v);
        }
    }

    public static class MyChildViewHolder extends MyBaseViewHolder {
        public MyChildViewHolder(View v) {
            super(v);
        }
    }

    public ExpandableRecyclerAdapter() {
        setHasStableIds(true);
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildCount(int groupPosition) {
        return 0;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @NonNull
    @Override
    public MyGroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @NonNull
    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindGroupViewHolder(@NonNull MyGroupViewHolder holder, int groupPosition, int viewType) {

    }

    @Override
    public void onBindChildViewHolder(@NonNull MyChildViewHolder holder, int groupPosition, int childPosition, int viewType) {

    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(@NonNull MyGroupViewHolder holder, int groupPosition, int x, int y, boolean expand) {
        return true;
    }
}
