package net.syarihu.android.scrollsyncsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MyPagerAdapter extends ScrollSyncFragmentPagerAdapter {

    /**
     * @param  viewResId Fragmentに乗ってるスクロールを持ったViewのResourceId
     * */
    public MyPagerAdapter(FragmentManager fm, ViewPager pager, int viewResId) {
        super(fm, pager, viewResId);
    }

    @Override
    public Fragment getItem(int position) {
        String value = "";
        switch (position) {
            case 0: value = "a"; break;
            case 1: value = "b"; break;
            case 2: value = "c"; break;
            case 3: value = "d"; break;
            case 4: value = "e"; break;
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            arrayList.add(
                    value + i + " " +
                    value + i + " " +
                    value + i + " " +
                    value + i + " " +
                    value + i + " " +
                    value + i + " " +
                    value + i + " " +
                    value + i + " " +
                    value + i
            );
        }

        return TestFragment.newInstance(arrayList);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "a";
            case 1: return "b";
            case 2: return "c";
            case 3: return "d";
            case 4: return "e";
            default: return "a";
        }
    }
}
