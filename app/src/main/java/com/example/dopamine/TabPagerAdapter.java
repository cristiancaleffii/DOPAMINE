package com.example.dopamine;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1: return new Search();
            case 2: return new Favourites();
            case 3: return new Game();
            case 4: return new AccountSettings();
            default: return new Home();
        }
    }

    public int getItemCount() {
        return 5;
    }
}
