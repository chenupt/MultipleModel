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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import github.chenupt.multiplemodel.IModelManager;
import github.chenupt.multiplemodel.ItemEntity;

/**
 * Created by chenupt@gmail.com on 1/12/15.
 * Description :
 */
public class ModelRecyclerAdapter extends BaseRecyclerAdapter<ItemEntity> {

    private static final String TAG = "ModelRecyclerAdapter";

    private IModelManager modelFactory;

    public ModelRecyclerAdapter(Context context, IModelManager modelManager) {
        super(context);
        this.modelFactory = modelManager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = modelFactory.createModel(getContext(), modelFactory.getViewClass(viewType), this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ModelViewHolder)viewHolder).getView().setViewPosition(position);
        ((ModelViewHolder)viewHolder).getView().setModel(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        String type = getItem(position).getModelType();
        return modelFactory.getViewType(type);
    }


}
