package github.chenupt.multiplemodel.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description TODO
 */
public class SimplePagerAdapter extends FragmentStatePagerAdapter {

    protected PagerModelManager pagerModelManager;

    public SimplePagerAdapter(FragmentManager fm, PagerModelManager pagerModelManager) {
        super(fm);
        this.pagerModelManager = pagerModelManager;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerModelManager.getItem(position);
    }

    @Override
    public int getCount() {
        return pagerModelManager.getFragmentCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(pagerModelManager.hasTitles()){
            return pagerModelManager.getTitle(position);
        }
        return super.getPageTitle(position);
    }
}
