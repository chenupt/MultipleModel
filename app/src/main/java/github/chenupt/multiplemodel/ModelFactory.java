package github.chenupt.multiplemodel;

import android.content.Context;
import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenupt@gmail.com on 2014/8/7.
 * Description : A factory create multiple item views
 */
public class ModelFactory {

    public static final String TAG = "ModelFactory";

    public Builder builder;

    protected ModelFactory(Builder builder) {
        this.builder = builder;
    }

    public final BaseItemModel createModel(Context context, String modelType){
        Log.d(TAG, "createModel: " + modelType);
        BaseItemModel baseItemModel = null;
        Class<?> owner = builder.viewMap.get(modelType);
        try {
            // 抽出实例化方法让子类可覆盖
            baseItemModel = newInstance(context, owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseItemModel;
    }

    /**
     * 子类可复写此方法来实现不同的实例化
     * @param context
     * @param owner
     * @return
     * @throws Exception
     */
    protected BaseItemModel newInstance(Context context, Class<?> owner) throws Exception {
        return (BaseItemModel) owner.getConstructor(Context.class).newInstance(context);
    }

    /**
     * 通过模板类型获取模板指针
     * @param modelType
     * @return
     */
    public int getViewType(String modelType){
        if( !builder.indexMap.containsKey(modelType)){
            Log.d(TAG, builder.indexMap.toString());
            throw new RuntimeException("The list does not contain the modelView:'" + modelType + "'. Please check the ModelFactory.");
        }
        return builder.indexMap.get(modelType);
    }

    /**
     * 获取模板数量
     * @return
     */
    public int getViewTypeCount(){
        return builder.viewMap.size();
    }

    /**
     * 当前模板是否可以固定头部
     * @param type
     * @return
     */
    public boolean isItemViewTypePinned(int type){
        return builder.pinnedMap.get(type);
    }


    /**
     * get the tag item at the start.
     * @param list  list data
     * @param tag   tag value
     * @return      item model
     */
    public SimpleItemEntity getStartItemByTag(List<SimpleItemEntity> list, String tag){
        for (SimpleItemEntity entity : list) {
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
    public SimpleItemEntity getEndItemByTag(List<SimpleItemEntity> list, String tag){
        Collections.reverse(list);
        for (SimpleItemEntity entity : list) {
            if (entity.getTag().equals(tag)){
                Collections.reverse(list);
                return entity;
            }
        }
        return null;
    }

    //------------创建ModelFactory需添加Model---------

    public static class Builder{

        private HashMap<String, Class<?>> viewMap;  // 模板类型 -> 模板展示View
        private HashMap<String, Integer> indexMap;  // 模板类型 -> 模板指针
        private HashMap<Integer, Boolean> pinnedMap;// 模板指针 -> View是否固定

        public Builder() {
            viewMap = new HashMap<String, Class<?>>();
            indexMap = new HashMap<String, Integer>();
            pinnedMap = new HashMap<Integer, Boolean>();
        }

        public ModelFactory build(){
            return new ModelFactory(this);
        }

        public Builder addModel(Class<?> viewClass){
            return addModel(viewClass, false);
        }

        public Builder addModel(Class<?> viewClass, boolean isPinned){
            return addToMap(getModelTypeName(viewClass), viewClass, isPinned);
        }

        public Builder addModel(String modelType, Class<?> viewClass){
            return addModel(modelType, viewClass, false);
        }

        public Builder addModel(String modelType, Class<?> viewClass, boolean isPinned){
            return addToMap(modelType, viewClass, isPinned);
        }

        private Builder addToMap(String modelType, Class<?> viewClass, boolean isPinned){
            if(!viewMap.containsKey(modelType)){
                viewMap.put(modelType, viewClass);
                int viewType = viewMap.size() - 1;
                indexMap.put(modelType, viewType);
                pinnedMap.put(viewType , isPinned);
            }
            return this;
        }


        private String getModelTypeName(Class<?> modelView){
            return modelView.getName();
        }


        // FIXME 动态加载
//        private Builder addListToMap(List<SimpleItemEntity> entityList){
//            for(int i = 0; i < entityList.size(); i ++){
//                SimpleItemEntity entity = entityList.get(i);
//
//                String modelType = "default_model_type";
//                if(entity.getModelType() == null){
//                    modelType = modelType + modelTypeSuf;
//                    modelTypeSuf ++;
//                }else{
//                    modelType = entity.getModelType();
//                }
//                addModel(modelType, entity.getModelView(), entity.isPinned());
//            }
//            return this;
//        }
    }

}
