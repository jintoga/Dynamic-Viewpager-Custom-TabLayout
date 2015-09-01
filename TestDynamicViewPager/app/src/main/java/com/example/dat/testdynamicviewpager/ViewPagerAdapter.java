package com.example.dat.testdynamicviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by DAT on 8/16/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private final ArrayList<String> mFragmentTitleList = new ArrayList<>();
    Context context;

    public ViewPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);

    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab_item, null);
        TextView tabItemName = (TextView) view.findViewById(R.id.textViewTabItemName);
        CircleImageView tabItemAvatar = (CircleImageView) view.findViewById(R.id.imageViewTabItemAvatar);


        tabItemName.setText(mFragmentTitleList.get(position));
        tabItemName.setTextColor(context.getResources().getColor(android.R.color.background_light));

        switch (mFragmentTitleList.get(position)) {
            case "Gaiduk":
                tabItemAvatar.setImageResource(R.drawable.gaiduk);
                break;
            case "Nguyen":
                tabItemAvatar.setImageResource(R.drawable.avatar);
                break;
            case "Balakin":
                tabItemAvatar.setImageResource(R.drawable.balakin);
                break;
            case "Golovin":
                tabItemAvatar.setImageResource(R.drawable.golovin);
                break;
            case "Ovcharov":
                tabItemAvatar.setImageResource(R.drawable.ovcharov);
                break;
            case "Solovienko":
                tabItemAvatar.setImageResource(R.drawable.solovei);
                break;
            default:
                tabItemAvatar.setImageResource(R.drawable.boy);
                break;
        }

        return view;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

}
