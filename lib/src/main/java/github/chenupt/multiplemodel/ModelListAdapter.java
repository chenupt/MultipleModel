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


/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Simple base recyclerAdapter for getting multiple item views in list.
 *
 * 继承BaseListAdapter，通过IModelManager来调用model view。
 */
public class ModelListAdapter extends BaseListAdapter<ItemEntity> {

    protected IModelManager iModelManager;

    public ModelListAdapter(Context context, IModelManager modelManager) {
        super(context);
        this.iModelManager = modelManager;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = iModelManager.createModel(getContext(), getItem(i).getModelType());
        }
        ((BaseItemModel)view).setViewPosition(i);
        ((BaseItemModel)view).setModel(getItem(i), getList());
        ((BaseItemModel)view).setAdapter(this);
        return view;
    }


    @Override
    public int getItemViewType(int position) {
        String type = getItem(position).getModelType();
        return iModelManager.getViewType(type);
    }

    @Override
    public int getViewTypeCount() {
        return iModelManager.getViewTypeCount();
    }
}
