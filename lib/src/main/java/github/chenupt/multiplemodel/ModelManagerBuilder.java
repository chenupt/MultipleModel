package github.chenupt.multiplemodel;

import java.util.HashMap;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description :
 */
public class ModelManagerBuilder {

    public static ModelManagerBuilder begin(){
        return new ModelManagerBuilder();
    }

    public HashMap<String, Class<?>> viewMap;  // 模板类型 -> 模板展示View
    public HashMap<String, Integer> indexMap;  // 模板类型 -> 模板指针
    public HashMap<Integer, Boolean> pinnedMap;// 模板指针 -> View是否固定

    public ModelManagerBuilder() {
        viewMap = new HashMap<String, Class<?>>();
        indexMap = new HashMap<String, Integer>();
        pinnedMap = new HashMap<Integer, Boolean>();
    }


    public <T> T build(Class<T> modelManager){
        try {
            return modelManager.getConstructor(ModelManagerBuilder.class).newInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ModelManagerBuilder addModel(Class<?> viewClass) {
        return addModel(viewClass, false);
    }

    public ModelManagerBuilder addModel(Class<?> viewClass, boolean isPinned) {
        return addToMap(getModelTypeName(viewClass), viewClass, isPinned);
    }

    public ModelManagerBuilder addModel(String modelType, Class<?> viewClass) {
        return addModel(modelType, viewClass, false);
    }

    public ModelManagerBuilder addModel(String modelType, Class<?> viewClass, boolean isPinned) {
        return addToMap(modelType, viewClass, isPinned);
    }

    private ModelManagerBuilder addToMap(String modelType, Class<?> viewClass, boolean isPinned) {
        if (!viewMap.containsKey(modelType)) {
            viewMap.put(modelType, viewClass);
            int viewType = viewMap.size() - 1;
            indexMap.put(modelType, viewType);
            pinnedMap.put(viewType, isPinned);
        }
        return this;
    }

    private String getModelTypeName(Class<?> modelView) {
        return modelView.getName();
    }
}
