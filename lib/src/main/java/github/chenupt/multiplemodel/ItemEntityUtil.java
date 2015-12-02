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


import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.viewpager.PagerManager;

/**
 * Created by chenupt@gmail.com on 2014/8/13.
 *
 */
public class ItemEntityUtil {

    /**
     * Create a new ItemEntity.
     * @param content
     * @param <T>
     * @return
     */
    public static <T> ItemEntity<T> create(T content){
        return new ItemEntity<T>(content);
    }

    /**
     * Check the cache timestamp.
     * @param oldEntity
     * @param newEntity
     * @return true use the cache
     */
    public static boolean checkCache(ItemEntity oldEntity, ItemEntity newEntity){
        return oldEntity != null && newEntity.isSingleton() && oldEntity.getTimestamp() == newEntity.getTimestamp();
    }

    /**
     * Get default fragment arguments.
     * @param fragment
     * @return
     */
    public static ItemEntity getModelData(Fragment fragment){
        return (ItemEntity) fragment.getArguments().getSerializable(PagerManager.DATA);
    }

    /**
     * Get a test data list, default content is a empty string.
     * @param size
     * @param modelView
     * @return
     */
    public static List<ItemEntity> getTestList(int size, Class modelView) {
        List<ItemEntity> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ItemEntityUtil.create("").setModelView(modelView).attach(dataList);
        }
        return dataList;
    }

}
