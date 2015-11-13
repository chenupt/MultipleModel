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
 * Description : Collect all model view and build a target view manager.
 */
public class ViewExpandableManager {

    public static ViewExpandableManager begin(){
        return new ViewExpandableManager();
    }

    public HashMap<String, Class<?>> groupViewMap;
    public HashMap<String, Class<?>> childViewMap;
    public HashMap<Integer, Class<?>> iGroupMap;
    public HashMap<Integer, Class<?>> iChildMap;
    public HashMap<String, Integer> indexGroupMap;
    public HashMap<String, Integer> indexChildMap;

    public ViewExpandableManager() {
        groupViewMap = new HashMap<>();
        childViewMap = new HashMap<>();
        iGroupMap = new HashMap<>();
        iChildMap = new HashMap<>();
        indexGroupMap = new HashMap<>();
        indexChildMap = new HashMap<>();
    }

    public ViewExpandableManager addGroupModel(Class<?> viewClass) {
        return addGroupToMap(getModelTypeName(viewClass), viewClass);
    }

    public ViewExpandableManager addChildModel(Class<?> viewClass) {
        return addChildToMap(getModelTypeName(viewClass), viewClass);
    }

    private ViewExpandableManager addGroupToMap(String modelType, Class<?> viewClass) {
        if (!groupViewMap.containsKey(modelType)) {
            groupViewMap.put(modelType, viewClass);
            int viewType = groupViewMap.size() - 1;
            indexGroupMap.put(modelType, viewType);
            iGroupMap.put(viewType, viewClass);
        }
        return this;
    }

    private ViewExpandableManager addChildToMap(String modelType, Class<?> viewClass) {
        if (!childViewMap.containsKey(modelType)) {
            childViewMap.put(modelType, viewClass);
            int viewType = childViewMap.size() - 1;
            indexChildMap.put(modelType, viewType);
            iChildMap.put(viewType, viewClass);
        }
        return this;
    }

    private String getModelTypeName(Class<?> modelView) {
        return modelView.getName();
    }
}
