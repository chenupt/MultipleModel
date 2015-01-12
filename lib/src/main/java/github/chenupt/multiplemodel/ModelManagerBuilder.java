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

import java.util.HashMap;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description : Collect all model view and build a target model manager.
 */
public class ModelManagerBuilder {

    public static ModelManagerBuilder begin(){
        return new ModelManagerBuilder();
    }

    public HashMap<String, Class<?>> viewMap;  // 模板类型 -> 模板展示View
    public HashMap<String, Integer> indexMap;  // 模板类型 -> 模板指针
    public HashMap<Integer, Boolean> pinnedMap;// 模板指针 -> View是否固定
    public HashMap<Integer, Class<?>> iViewMap;// 模板指针 -> 模板展示View

    public ModelManagerBuilder() {
        viewMap = new HashMap<String, Class<?>>();
        indexMap = new HashMap<String, Integer>();
        pinnedMap = new HashMap<Integer, Boolean>();
        iViewMap = new HashMap<Integer, Class<?>>();
    }


    public <T> T build(Class<T> modelManager){
        try {
            return modelManager.getConstructor(ModelManagerBuilder.class).newInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ModelManagerBuilder addModel(Class<?> viewClass) {
        return addModel(viewClass, false);
    }

    public ModelManagerBuilder addModel(Class<?> viewClass, boolean isPinned) {
        return addToMap(getModelTypeName(viewClass), viewClass, isPinned);
    }

    public ModelManagerBuilder addModel(String modelType, Class<?> viewClass) {
        return addModel(modelType, viewClass, false);
    }

    public ModelManagerBuilder addModel(String modelType, Class<?> viewClass, boolean isPinned) {
        return addToMap(modelType, viewClass, isPinned);
    }

    private ModelManagerBuilder addToMap(String modelType, Class<?> viewClass, boolean isPinned) {
        if (!viewMap.containsKey(modelType)) {
            viewMap.put(modelType, viewClass);
            int viewType = viewMap.size() - 1;
            indexMap.put(modelType, viewType);
            pinnedMap.put(viewType, isPinned);
            iViewMap.put(viewType, viewClass);
        }
        return this;
    }

    private String getModelTypeName(Class<?> modelView) {
        return modelView.getName();
    }
}
