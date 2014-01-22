package slidingmenu.activity;

import android.net.VpnService;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import com.huibinfeng0810.Sample.R;
import slidingmenu.FirstFragment;
import slidingmenu.MenuFragment;
import slidingmenu.SecondFragment;
import slidingmenu.lib.CustomViewAbove;
import slidingmenu.lib.SlidingMenu;
import slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.ArrayList;

/**
 * Created by huibin on 1/16/14.
 */
public class SlidingTestActivity extends SlidingFragmentActivity implements CustomViewAbove.OnPageChangeListener {
    private ViewPager mViewPager;
    private MenuFragment mMenuFragment;
    private static final int  VP_ID = 0x0001;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the Behind View
        setBehindContentView(R.layout.menu_frame);
        if (savedInstanceState == null) {
            FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
            mMenuFragment = new MenuFragment();
            t.replace(R.id.menu_frame, mMenuFragment);
            t.commit();
        } else {
            mMenuFragment = (MenuFragment) this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
        }

        // customize the SlidingMenu
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidthRes(R.dimen.shadow_width);
//		sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);

        mViewPager = new ViewPager(this);
        mViewPager.setId(VP_ID);
        mViewPager.setAdapter(new IMPagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(3);
        setContentView(mViewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        switch (position) {
            case 0:
                touchMode(false);
                break;
            case 1:
                touchMode(true);
                break;
            default:
                touchMode(false);
                break;
        }
    }

    public void touchMode(boolean touchMode) {
        getSlidingMenu().setMode(SlidingMenu.LEFT);
        getSlidingMenu().setTouchModeAbove(touchMode ? SlidingMenu.TOUCHMODE_MARGIN : SlidingMenu.TOUCHMODE_NONE);
    }

    public class IMPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> mFragments;
        public IMPagerAdapter(FragmentManager fm) {
            super(fm);
            mFragments = new ArrayList<Fragment>();
            FirstFragment firstFragment = new FirstFragment();
            SecondFragment secondFragment = new SecondFragment();
            mFragments.add(firstFragment);
            mFragments.add(secondFragment);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
