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

package github.chenupt.multiplemodel.aa;

import android.content.Context;

import github.chenupt.multiplemodel.BaseItemModel;
import github.chenupt.multiplemodel.BaseModelManager;
import github.chenupt.multiplemodel.ModelManagerBuilder;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description : 适用AndroidAnnotations框架，使用build方法实例化view
 */
public class AAModelManager extends BaseModelManager {

    public AAModelManager(ModelManagerBuilder builder) {
        super(builder);
    }

    @Override
    public BaseItemModel modelNewInstance(Context context, Class<?> owner) throws Exception {
        return (BaseItemModel) owner.getMethod("build", new Class[]{Context.class}).invoke(owner, context);
    }
}
