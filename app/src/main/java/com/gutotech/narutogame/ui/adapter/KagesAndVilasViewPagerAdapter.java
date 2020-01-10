package com.gutotech.narutogame.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gutotech.narutogame.R;
import com.gutotech.narutogame.data.model.KageAndVila;

import java.util.List;

public class KagesAndVilasViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<KageAndVila> kagesAndVilasList;

    public KagesAndVilasViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return kagesAndVilasList != null ? kagesAndVilasList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        KageAndVila kageAndVila = kagesAndVilasList.get(position);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.viewpager_kage_vila_item, null);

        ImageView vilaImageView = view.findViewById(R.id.vilaImageView);
        TextView nomeKageTextView = view.findViewById(R.id.nameKageTextView);
        TextView levelKageTextView = view.findViewById(R.id.levelKageTextView);

        nomeKageTextView.setText(kageAndVila.getKageName());
        levelKageTextView.setText(String.valueOf(kageAndVila.getKageLevel()));

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }

    public void setKagesAndVilasList(List<KageAndVila> kagesAndVilasList) {
        this.kagesAndVilasList = kagesAndVilasList;
        notifyDataSetChanged();
    }
}
