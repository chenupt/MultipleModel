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
