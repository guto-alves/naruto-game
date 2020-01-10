package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.util.StorageUtil;

import java.util.List;

public class CharactersRecyclerViewAdapter extends RecyclerView.Adapter<CharactersRecyclerViewAdapter.ViewHolder> {

    public interface CharacterSelecetedListener {
        void onCharacterSelected(Character position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
        }
    }

    private Context mContext;
    private List<Character> mCharactersList;
    private CharacterSelecetedListener mListener;

    public CharactersRecyclerViewAdapter(Context context, CharacterSelecetedListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_profile_pequena, null, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mCharactersList != null) {
            Character character = mCharactersList.get(position);
            StorageUtil.downloadSmallProfile(mContext, holder.profileImageView, character.getIdProfile());

            holder.profileImageView.setOnClickListener(v -> {
                mListener.onCharacterSelected(character);
            });
        }
    }

    @Override
    public int getItemCount() {
        return mCharactersList != null ? mCharactersList.size() : 0;
    }

    public void setCharactersList(List<Character> charactersList) {
        this.mCharactersList = charactersList;
    }
}
