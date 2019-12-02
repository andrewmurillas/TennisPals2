package com.example.tennispals;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class SignUpActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;

    private ViewPager2 mPager;
    private FragmentStateAdapter mAdapter;

    private Fragment[] fragments = {new SignupNameAgeFragment(), new SignupUserNamePasswordFragment(), new SignupLevelFragment()};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mPager = findViewById(R.id.viewPager2);
        mAdapter = new ScreenSlidePagerAdapter(this);
        mPager.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa){
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return fragments[position];
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

}
