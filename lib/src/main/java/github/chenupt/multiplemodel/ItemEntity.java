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

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenupt@gmail.com on 2014/8/13.
 * Description : SimpleEntity for list item
 *
 * 列表实体类，包含每个item项所需要的内容
 *
 */
public class ItemEntity<T> implements Serializable{

    private long id;
    /**
     * 模板显示内容数据
     */
    private T content;
    /**
     * 当前项是否选中
     */
    private boolean isCheck;
    /**
     * 当前状态
     */
    private int status;
    /**
     * 模板类型，默认使用类名
     */
    private String modelType;
    /**
     * 模板显示view
     */
    private Class<?> modelView;
    /**
     * 数据缓存时间戳
     */
    private long timestamp;

    /**
     * 该数据是否在列表中只有一条
     * 设置true时，列表只进行一次bingView，从而提高列表滑动效率
     */
    private boolean isSingleton;

    /**
     * 设置单一项的tag，方便寻找到特定的item
     */
    private String tag = "";

    /**
     * extra data
     */
    private Map<String, Object> attrs;

    public ItemEntity() {
        this(null);
    }

    public ItemEntity(T t) {
        this.content = t;
        // set the default cache timestamp
        setTimestamp(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public ItemEntity setId(long id) {
        this.id = id;
        return this;
    }

    public T getContent() {
        return content;
    }

    public ItemEntity setContent(T content) {
        this.content = content;
        return this;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public ItemEntity setCheck(boolean isCheck) {
        this.isCheck = isCheck;
        return this;
    }

    public ItemEntity setStatus(int status){
        this.status = status;
        return this;
    }

    public int getStatus(){
        return this.status;
    }

    public String getModelType() {
        return modelType;
    }

    public ItemEntity setModelType(String modelType) {
        this.modelType = modelType;
        return this;
    }

    public Class<?> getModelView() {
        return modelView;
    }

    public ItemEntity setModelView(Class<?> modelView) {
        // 未设置模板类型时
        if(modelType == null){
            // 默认使用类名做modelType
            setModelType(modelView.getName());
        }
        this.modelView = modelView;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    /**
     * 当数据为singleton时，可传递从服务端获取而来的timestamp，可不传
     * @param timestamp
     */
    public ItemEntity setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    /**
     * 设置该数据显示的view是否在列表中唯一，例如海报位
     * @param isSingleton
     */
    public ItemEntity setSingleton(boolean isSingleton) {
        this.isSingleton = isSingleton;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public ItemEntity setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Map<String, Object> getAttrs() {
        return attrs;
    }

    public ItemEntity<T> setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
        return this;
    }

    public ItemEntity<T> addAttr(String key, Object value){
        if(attrs == null){
            attrs = new HashMap<String, Object>();
        }
        attrs.put(key, value);
        return this;
    }

    public <T> T  getAttr(String key, Class<T> c){
        if(attrs == null) {
            return null;
        }
        return (T) attrs.get(key);
    }

    public boolean hasAttr(String key){
        if(attrs == null){
            return false;
        }
        if(attrs.get(key) == null){
            return false;
        }
        return true;
    }

    public void removeAttr(String key){
        if(attrs.get(key) != null){
            attrs.remove(key);
        }
    }

    public void attach(List<ItemEntity> list){
        list.add(this);
    }

}
