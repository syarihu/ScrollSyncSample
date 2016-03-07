package net.syarihu.android.scrollsyncsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.List;

public class ScrollSyncFragmentPagerAdapter extends FragmentPagerAdapter
        implements ViewPager.OnPageChangeListener {
    ViewPager mViewPager;
    FragmentManager mFragmentManager;
    int mViewResId;

    public ScrollSyncFragmentPagerAdapter(FragmentManager fm, ViewPager pager, int viewResId) {
        super(fm);
        mViewPager = pager;
        mFragmentManager = fm;
        mViewResId = viewResId;
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // ドラッグ以外は何もしない
        if (state != ViewPager.SCROLL_STATE_DRAGGING) {
            return;
        }
        try {
            int size = mFragmentManager.getFragments().size();
            // FragmentManagerに乗っているFragmentを取得
            List<Fragment> fragmentList = mFragmentManager.getFragments();
            // 現在表示しているFragmentのViewを取得
            View currentView = fragmentList.get(mViewPager.getCurrentItem()).getView();
            // ViewPager上のFragmentのViewのスクロール位置を1つずつ合わせる
            for (int i = size - 1; i >= mViewPager.getCurrentItem() - 1; i--) {
                // iが0より下になったら何もしない
                if (i < 0) break;
                View rootView = fragmentList.get(i).getView();
                if (i != mViewPager.getCurrentItem() && fragmentList.get(i) != null &&
                        rootView != null && currentView != null) {
                    // ScrollViewの場合
                    if (rootView.findViewById(mViewResId) instanceof ScrollView) {
                        rootView.findViewById(mViewResId).setScrollY(currentView.findViewById(mViewResId).getScrollY());
                    }
                    // ListViewの場合
                    else if (rootView.findViewById(mViewResId) instanceof ListView) {
                        ListView listView = ((ListView) currentView.findViewById(mViewResId));
                        int position = listView.getFirstVisiblePosition();
                        int y = listView.getChildAt(0).getTop();
                        ((ListView) rootView.findViewById(mViewResId)).setSelectionFromTop(position, y);
                    }
                    // RecyclerViewの場合（これスクロール位置がちょっとずれる）
                    else if (rootView.findViewById(mViewResId) instanceof RecyclerView) {
                        RecyclerView recyclerView = ((RecyclerView) currentView.findViewById(mViewResId));
                        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        int position = manager.findLastCompletelyVisibleItemPosition();
                        ((RecyclerView) rootView.findViewById(mViewResId)).scrollToPosition(position);
                    }
                }
            }
        } catch (NullPointerException e) {
            Log.e("MainActivity", "Message: ", e);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
