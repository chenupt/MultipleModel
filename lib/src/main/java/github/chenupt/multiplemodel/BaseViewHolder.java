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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewHolder<T> implements IItemView<T>, IPosition, IViewHolder{

    protected Context context;

    protected ItemEntity<T> model;
    protected int viewPosition;
    protected View view;

    public BaseViewHolder(Context context) {
        this.context = context;
    }

    @Override
    public void bindView(ItemEntity<T> model) {
        // Singleton depends on view's model saved last time.
        // If your item view does not extend from BaseItemView, you should check the cache timestamp if you need.
        if(!ItemEntityUtil.checkCache(this.model, model)){
            setModel(model);
            bindView();
        }
    }

    @Override
    public void bindViewPosition(int viewPosition) {
        this.viewPosition = viewPosition;
    }

    public void setModel(ItemEntity<T> entity){
        model = entity;
    }

    public abstract void bindView();

    @Override
    public View onCreateView(ViewGroup root){
        this.view = LayoutInflater.from(context).inflate(createView(), root, false);
        afterViewCreated();
        return this.view;
    }

    public abstract int createView();
    public abstract void afterViewCreated();

    public final View getView(){
        return view;
    }

}
