package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.model.GraduationUtils;
import com.gutotech.narutogame.utils.StorageUtil;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class KagesSliderAdapter extends SliderViewAdapter<KagesSliderAdapter.SliderAdapterVH> {
    private Context mContext;
    private List<Character> mKages;

    public KagesSliderAdapter(Context context) {
        mContext = context;
    }

    public void renewItems(List<Character> kages) {
        mKages = kages;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        mKages.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(Character kage) {
        mKages.add(kage);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_kage_slider_item, null);
        return new SliderAdapterVH(itemView);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        if (mKages != null) {
            Character kage = mKages.get(position);

            viewHolder.villageImageView.setImageResource(kage.getVillage().homeResId);
            StorageUtil.downloadKageImage(viewHolder.profileImageView.getContext(),
                    viewHolder.profileImageView, kage.getNinja().getId());
            viewHolder.nameTextView.setText(kage.getNick());
            viewHolder.descriptionTextView.setText(mContext.getString(
                    R.string.label_graduation_and_lvl,
                    mContext.getString(GraduationUtils.getName(kage.getGraduationId(), kage.getVillage())),
                    kage.getLevel()));
        }
    }

    @Override
    public int getCount() {
        return mKages != null ? mKages.size() : 0;
    }

    static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        private ImageView villageImageView;
        private ImageView profileImageView;
        private TextView nameTextView;
        private TextView descriptionTextView;

        SliderAdapterVH(View itemView) {
            super(itemView);
            villageImageView = itemView.findViewById(R.id.villageImageView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
