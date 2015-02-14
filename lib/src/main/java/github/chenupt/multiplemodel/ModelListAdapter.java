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
 *
 *
 */
public class ModelListAdapter extends BaseListAdapter<ItemEntity> {

    public ViewManager viewManager;

    public ModelListAdapter(Context context, ViewManager manager) {
        super(context);
        this.viewManager = manager;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            Class<?> owner = viewManager.viewMap.get(getItem(i).getModelType());
            try {
                view = modelNewInstance(context, owner);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("The view:" + getItem(i).getModelView().getName() + " is null. Please check your layout");
            }
        }
        if (view instanceof IPosition){
            ((IPosition)view).bindViewPosition(i);
        }
        if (view instanceof IItemView){
            ((IItemView)view).bindView(getItem(i));
        }
        return view;
    }

    public View modelNewInstance(Context context, Class<?> owner) throws Exception {
        return (View) owner.getConstructor(Context.class).newInstance(context);
    }

    @Override
    public int getItemViewType(int position) {
        String modelType = getItem(position).getModelType();
        if( !viewManager.indexMap.containsKey(modelType)){
            throw new RuntimeException("The list does not contain the modelView:'" + modelType + "'. Please check the ModelBuilder.");
        }
        return viewManager.indexMap.get(modelType);
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
    public ItemEntity getStartItemByTag(List<ItemEntity> list, String tag){
        for (ItemEntity entity : list) {
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
    public ItemEntity getEndItemByTag(List<ItemEntity> list, String tag){
        Collections.reverse(list);
        for (ItemEntity entity : list) {
            if (entity.getTag().equals(tag)){
                Collections.reverse(list);
                return entity;
            }
        }
        return null;
    }
}
