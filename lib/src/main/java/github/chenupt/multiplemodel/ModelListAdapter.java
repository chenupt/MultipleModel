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

package github.chenupt.multiplemodel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;


/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Simple base list adapter for getting multiple item views in list.
 */
public class ModelListAdapter extends BaseListAdapter<BaseViewHolder> {

    public ViewManager viewManager;

    public ModelListAdapter(Context context, ViewManager manager) {
        super(context);
        this.viewManager = manager;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseViewHolder viewHolder = null;
        if(view == null) {
            viewHolder = getItem(i);
            view = viewHolder.onCreateView(context, viewGroup);
            view.setTag(viewHolder);
        }else{
            viewHolder = (BaseViewHolder)view.getTag();
        }
        viewHolder.bindViewPosition(i);
        viewHolder.bindView(getItem(i));
        return view;
    }

    public View modelNewInstance(Context context, Class<?> owner) throws Exception {
        return (View) owner.getConstructor(Context.class).newInstance(context);
    }

    @Override
    public int getItemViewType(int position) {
        if( !viewManager.viewMap.containsKey(getItem(position).getClass())){
            throw new RuntimeException("The list does not contain the modelView:'" + getItem(position).getClass().getName() + "'. Please check the ModelBuilder.");
        }
        return viewManager.viewMap.get(getItem(position).getClass());
    }

    @Override
    public int getViewTypeCount() {
        return viewManager.viewMap.size();
    }



    /**
     * get the tag item at the start.
     * @param list  list data
     * @param tag   tag value
     * @return      item model
     */
    public BaseViewHolder getStartItemByTag(List<BaseViewHolder> list, String tag){
        for (BaseViewHolder entity : list) {
            if (entity.getTag().equals(tag)){
                return entity;
            }
        }
        return null;
    }

    /**
     * get the tag item at the end.
     * @param list  list data
     * @param tag   tag value
     * @return      item model
     */
    public BaseViewHolder getEndItemByTag(List<BaseViewHolder> list, String tag){
        Collections.reverse(list);
        for (BaseViewHolder entity : list) {
            if (entity.getTag().equals(tag)){
                Collections.reverse(list);
                return entity;
            }
        }
        return null;
    }
}
