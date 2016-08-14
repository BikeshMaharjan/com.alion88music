package alion88music.com.nfanlivestreaming.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alion88music.com.nfanlivestreaming.R;

/**
 * Created by Eliza on 14/08/2016.
 */
public class MainScreenFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.mainscreen_fragment,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tablayout);
        viewPager = (ViewPager) x.findViewById(R.id.pager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter1(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;

        /*TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tablayout);

        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);*/

       /* ViewPager viewpager;
        viewpager = (ViewPager) getActivity().findViewById(R.id.pager);
        FragmentManager fragmentManager=getFragmentManager();
        viewpager.setAdapter(new MyAdapter1(fragmentManager));

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //og.d("BIKI","page scrolled from position" + position + "with offset" + positionOffset + " with pixel of " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("BIKI", "page selected at " + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                    //  Log.d("BIKI","onPageScollstatechanged Dragging");
                }
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    // Log.d("BIKI","onPageScollstatechanged iDEL");
                }
                if (state == ViewPager.SCROLL_STATE_SETTLING) {
                    //Log.d("BIKI","onPageScollstatechanged settling");
                }
            }
        });*/
       /* tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("ELIZA", "tab selected at position " + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
//        return inflater.inflate(R.layout.activity_main,container,false);

    }


}

class MyAdapter1 extends FragmentPagerAdapter {

    public MyAdapter1(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch(position){
            case 0:
                fragment = new TopFragment();
                break;
            case 1:
                fragment = new BlogFragment();
                break;
            case 2:
                fragment = new ScheduleFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "Top";
            case 1 :
                return "Blog";
            case 2 :
                return "Schedule";
        }
        return null;
    }
}
