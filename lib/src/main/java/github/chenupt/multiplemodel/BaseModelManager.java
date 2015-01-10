package github.chenupt.multiplemodel;

import android.content.Context;
import android.util.Log;

import java.util.Collections;
import java.util.List;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description :
 */
public abstract class BaseModelManager implements IModelManager {

    public static final String TAG = "BaseModelManager";

    public ModelManagerBuilder builder;

    public BaseModelManager(ModelManagerBuilder builder) {
        this.builder = builder;
    }

    @Override
    public final BaseItemModel createModel(Context context, String modelType){
        Log.d(TAG, "createModel: " + modelType);
        BaseItemModel baseItemModel = null;
        Class<?> owner = builder.viewMap.get(modelType);
        try {
            baseItemModel = modelNewInstance(context, owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseItemModel;
    }

    /**
     * 通过模板类型获取模板指针
     * @param modelType
     * @return
     */
    @Override
    public int getViewType(String modelType){
        if( !builder.indexMap.containsKey(modelType)){
            Log.d(TAG, builder.indexMap.toString());
            throw new RuntimeException("The list does not contain the modelView:'" + modelType + "'. Please check the ModelBuilder.");
        }
        return builder.indexMap.get(modelType);
    }

    /**
     * 获取模板数量
     * @return
     */
    @Override
    public int getViewTypeCount(){
        return builder.viewMap.size();
    }

    /**
     * 当前模板是否可以固定头部
     * @param type
     * @return
     */
    @Override
    public boolean isItemViewTypePinned(int type){
        return builder.pinnedMap.get(type);
    }


    // ================================


    /**
     * get the tag item at the start.
     * @param list  list data
     * @param tag   tag value
     * @return      item model
     */
    public ItemEntity getStartItemByTag(List<ItemEntity> list, String tag){
        for (ItemEntity entity : list) {
            if (entity.getTag().equals(tag)){
                return entity;
            }
        }
        return null;
    }

    /**
     * get the tag item at the end.
     * @param list  list data
     * @param tag   tag value
     * @return      item model
     */
    public ItemEntity getEndItemByTag(List<ItemEntity> list, String tag){
        Collections.reverse(list);
        for (ItemEntity entity : list) {
            if (entity.getTag().equals(tag)){
                Collections.reverse(list);
                return entity;
            }
        }
        return null;
    }

}
