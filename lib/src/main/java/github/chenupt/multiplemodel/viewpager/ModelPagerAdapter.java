/*
 * Copyright 2015 chenupt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.chenupt.multiplemodel.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by chenupt@gmail.com on 2014/8/9.
 * Description : ViewPager adapter extends FragmentPagerAdapter
 */
public class ModelPagerAdapter extends FragmentPagerAdapter {

    protected PagerManager pagerManager;

    public ModelPagerAdapter(FragmentManager fm, PagerManager pagerManager) {
        super(fm);
        this.pagerManager = pagerManager;
    }

    @Override
    public Fragment getItem(int position) {
        return pagerManager.getItem(position);
    }

    @Override
    public int getCount() {
        return pagerManager.getFragmentCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(pagerManager.hasTitles()){
            return pagerManager.getTitle(position);
        }
        return super.getPageTitle(position);
    }
}
