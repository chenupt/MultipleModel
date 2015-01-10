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

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description : Interface new a model.
 */
public interface IModelManager {

    public BaseItemModel createModel(Context context, String modelType);
    public BaseItemModel modelNewInstance(Context context, Class<?> owner) throws Exception;
    public int getViewType(String modelType);
    public int getViewTypeCount();
    public boolean isItemViewTypePinned(int type);
}
