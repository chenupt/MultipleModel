package github.chenupt.multiplemodel.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by chenupt@gmail.com on 11/25/14.
 * Description :
 */
public class PagerModelAdapter extends FragmentStatePagerAdapter {

    public PagerModelAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
