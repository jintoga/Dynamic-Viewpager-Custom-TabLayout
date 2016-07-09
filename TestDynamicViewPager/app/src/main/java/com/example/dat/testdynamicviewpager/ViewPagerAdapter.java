package com.example.dat.testdynamicviewpager;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;

/**
 * Created by DAT on 8/16/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private final ArrayList<String> mFragmentTitleList = new ArrayList<>();
    Context context;
    ViewPager viewPager;
    TabLayout tabLayout;

    public ViewPagerAdapter(FragmentManager manager, Context context, ViewPager viewPager,
        TabLayout tabLayout) {
        super(manager);
        this.context = context;
        this.viewPager = viewPager;
        this.tabLayout = tabLayout;
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

    public void removeFrag(int position) {
        removeTab(position);
        Fragment fragment = mFragmentList.get(position);
        mFragmentList.remove(fragment);
        mFragmentTitleList.remove(position);
        destroyFragmentView(viewPager, position, fragment);
        notifyDataSetChanged();
    }

    public View getTabView(final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab_item, null);
        TextView tabItemName = (TextView) view.findViewById(R.id.textViewTabItemName);
        CircleImageView tabItemAvatar =
            (CircleImageView) view.findViewById(R.id.imageViewTabItemAvatar);
        ImageButton remove = (ImageButton) view.findViewById(R.id.imageButtonRemove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Remove", "Remove");
                removeFrag(position);
            }
        });

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

    public void destroyFragmentView(ViewGroup container, int position, Object object) {
        FragmentManager manager = ((Fragment) object).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) object);
        trans.commit();
    }

    public void removeTab(int position) {
        if (tabLayout.getChildCount() > 0) {
            tabLayout.removeTabAt(position);
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
