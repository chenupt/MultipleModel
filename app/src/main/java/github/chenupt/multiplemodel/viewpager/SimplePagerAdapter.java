package github.chenupt.multiplemodel.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class SimplePagerAdapter extends FragmentStatePagerAdapter {

    protected PagerModelFactory pagerModelFactory;

    public SimplePagerAdapter(FragmentManager fm, PagerModelFactory pagerModelFactory) {
        super(fm);
        this.pagerModelFactory = pagerModelFactory;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerModelFactory.getItem(position);
    }

    @Override
    public int getCount() {
        return pagerModelFactory.getFragmentCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(pagerModelFactory.hasTitles()){
            return pagerModelFactory.getTitle(position);
        }
        return super.getPageTitle(position);
    }
}
