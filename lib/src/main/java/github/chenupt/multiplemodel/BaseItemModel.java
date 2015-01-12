/*
 * Copyright [2015] chenupt
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
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.List;

import github.chenupt.multiplemodel.recycler.BaseRecyclerAdapter;

/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Base model view can be extended to show different item views.
 *
 * Model View 基类，自定义实现的view需继承此类
 */
public abstract class BaseItemModel<T> extends FrameLayout {

    protected ItemEntity<T> model;
    protected List<ItemEntity<T>> modelList;
    protected int viewPosition;
    protected ItemEntity<T> groupModel;
    protected int groupPosition;
    protected BaseListAdapter adapter;
    protected BaseRecyclerAdapter recyclerAdapter;
    protected RecyclerView.ViewHolder viewHolder;

    public BaseItemModel(Context context){
        this(context, null);
    }

    public BaseItemModel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public abstract void bindView();


    public void setModel(ItemEntity<T> model, List<ItemEntity<T>> modelList){
        if(this.model != null){
            // 判断数据是否唯一项，如果数据未过期则不进行bindView，显示缓存的view
            if (this.model.isSingleton() && this.model.getTimestamp() == model.getTimestamp()) {
                return ;
            }
        }
        this.model = model;
        this.modelList =  modelList;
        bindView();
    };

    public void setModel(ItemEntity<T> model){
        setModel(model, null);
    };

    public void setViewPosition(int position){
        this.viewPosition = position;
    }

    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public void setGroupModel(ItemEntity<T> groupModel) {
        this.groupModel = groupModel;
    }

    public BaseListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(BaseListAdapter adapter) {
        this.adapter = adapter;
    }

    public void notifyDataSetChanged(){
        adapter.notifyDataSetChanged();
    }

    public List<ItemEntity<T>> getModelList() {
        return modelList;
    }

    public void setModelList(List<ItemEntity<T>> modelList) {
        this.modelList = modelList;
    }

    public BaseRecyclerAdapter getRecyclerAdapter() {
        return recyclerAdapter;
    }

    public void setRecyclerAdapter(BaseRecyclerAdapter recyclerAdapter) {
        this.recyclerAdapter = recyclerAdapter;
    }

    public RecyclerView.ViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setViewHolder(RecyclerView.ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }
}
