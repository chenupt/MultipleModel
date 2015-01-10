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
