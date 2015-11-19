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
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

public abstract class BaseViewHolder<T> implements Serializable {

    protected Context context;
    protected Fragment fragment;
    protected int viewPosition;
    protected View view;

    private long id;
    /**
     * The content you want to set for item.
     */
    private T content;
    /**
     * Item check message.
     */
    private boolean isCheck;
    /**
     * Current status for item
     */
    private int status;
    /**
     * The type name of your item view. Default is the item view class name.
     */
    private String modelType;

    /**
     * Be used for cache.
     */
    private long timestamp;

    /**
     * Set true the item view will be bind only once.You could reset the timestamp for updating.
     */
    private boolean isSingleton;

    /**
     * Tag for item.
     */
    private String tag = "";

    public long getId() {
        return id;
    }

    public BaseViewHolder setId(long id) {
        this.id = id;
        return this;
    }

    public T getContent() {
        return content;
    }

    public BaseViewHolder setContent(T content) {
        this.content = content;
        return this;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public BaseViewHolder setCheck(boolean isCheck) {
        this.isCheck = isCheck;
        return this;
    }

    public BaseViewHolder setStatus(int status){
        this.status = status;
        return this;
    }

    public int getStatus(){
        return this.status;
    }

    public String getModelType() {
        return modelType;
    }

    public BaseViewHolder setModelType(String modelType) {
        this.modelType = modelType;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    /**
     * You could set the timestamp from your net or db if you set singleton true for this item,
     * or ItemEntity would set the current time for its cache timestamp.
     * @param timestamp
     */
    public BaseViewHolder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    /**
     * It would call bindView only once if set it true.
     * Just like a poster in your ListView.
     * @param isSingleton
     */
    public BaseViewHolder setSingleton(boolean isSingleton) {
        this.isSingleton = isSingleton;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public BaseViewHolder setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public BaseViewHolder(T t) {
        this.content = t;
        this.tag = "";
        this.timestamp = System.currentTimeMillis();
    }

    public BaseViewHolder setFragment(Fragment fragment) {
        this.fragment = fragment;
        return this;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void bindView(BaseViewHolder<T> model) {
        // Singleton depends on view's model saved last time.
        // If your item view does not extend from BaseItemView, you should check the cache timestamp if you need.
        if(!ItemEntityUtil.checkCache(this, model)){
            setModel(model.content);
            bindView();
        }
    }

    public void bindViewPosition(int viewPosition) {
        this.viewPosition = viewPosition;
    }

    public void setModel(T t){
        content = t;
    }

    public abstract void bindView();

    public View onCreateView(Context context, ViewGroup root){
        this.context = context;
        this.view = createItemView(root);
        afterViewCreated();
        return this.view;
    }

    public abstract int createView();
    public View createItemView(ViewGroup root) {
       return LayoutInflater.from(context).inflate(createView(), root, false);
    }
    public abstract void afterViewCreated();

    public final View getView(){
        return view;
    }
    public void attach(List<BaseViewHolder> list){
        list.add(this);
    }
}
