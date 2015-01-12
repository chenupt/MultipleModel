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

package github.chenupt.multiplemodel.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import github.chenupt.multiplemodel.BaseItemModel;

/**
 * Created by chenupt@gmail.com on 14/10/28.
 * Description : Simple model view holder
 */
public class ModelViewHolder extends RecyclerView.ViewHolder {

    private BaseItemModel baseItemModel;

    public ModelViewHolder(View itemView, BaseRecyclerAdapter adapter) {
        super(itemView);
        baseItemModel = (BaseItemModel) itemView;
        baseItemModel.setViewHolder(this);
        baseItemModel.setRecyclerAdapter(adapter);
    }


    public void bindView(){
        baseItemModel.bindView();
    }

    public BaseItemModel getView(){
        return baseItemModel;
    }


}
