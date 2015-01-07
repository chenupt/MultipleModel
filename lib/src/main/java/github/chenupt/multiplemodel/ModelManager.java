package github.chenupt.multiplemodel;

import android.content.Context;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description :
 */
public class ModelManager extends BaseModelManager {

    public ModelManager(ModelManagerBuilder builder) {
        super(builder);
    }

    @Override
    public BaseItemModel modelNewInstance(Context context, Class<?> owner) throws Exception {
        return (BaseItemModel) owner.getConstructor(Context.class).newInstance(context);
    }
}
