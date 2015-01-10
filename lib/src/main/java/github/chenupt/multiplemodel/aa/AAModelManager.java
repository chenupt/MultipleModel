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
