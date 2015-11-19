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
public class ViewManager {

    public static ViewManager begin(){
        return new ViewManager();
    }

    public HashMap<Class<? extends BaseViewHolder>, Integer> viewMap;  // view class - > view type

    public HashMap<Integer, Boolean> pinnedMap;// view type index - > pinned


    public ViewManager() {
        viewMap = new HashMap<Class<? extends BaseViewHolder>, Integer>();
        pinnedMap = new HashMap<Integer, Boolean>();
    }


    public ViewManager addModel(Class<? extends BaseViewHolder> viewClass) {
        return addModel(viewClass, false);
    }

    public ViewManager addModel(Class<? extends BaseViewHolder> viewClass, boolean isPinned) {
        return addToMap(viewClass, isPinned);
    }

    private ViewManager addToMap(Class<? extends BaseViewHolder> viewClass, boolean isPinned) {
        if (!viewMap.containsKey(viewClass)) {
            int viewType = viewMap.size() - 1;
            viewMap.put(viewClass, viewType);
            pinnedMap.put(viewType, isPinned);
        }
        return this;
    }

    private String getModelTypeName(Class<BaseViewHolder> modelView) {
        return modelView.getName();
    }
}
