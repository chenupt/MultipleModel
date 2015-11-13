package github.chenupt.sample;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringArrayRes;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.multiplemodel.ItemEntityUtil;
import github.chenupt.multiplemodel.ViewExpandableManager;
import github.chenupt.multiplemodel.ViewManager;
import github.chenupt.sample.views.AACustomLargeView_;
import github.chenupt.sample.views.AACustomView_;
import github.chenupt.sample.views.CustomLargeView;
import github.chenupt.sample.views.CustomLargeViewHolder;
import github.chenupt.sample.views.CustomView;
import github.chenupt.sample.views.CustomViewHolder;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description :
 */
@EBean
public class CommonService {

    @StringArrayRes(R.array.test_strings)
    String[] testStrings;


    public ViewManager getModelManagerBuilder(){
        return ViewManager
                .begin()
                .addModel(CustomView.class)
                .addModel(CustomLargeView.class);
    }

    public ViewManager getAAModelManagerBuilder(){
        return ViewManager
                .begin()
                .addModel(AACustomView_.class)
                .addModel(AACustomLargeView_.class);
    }

    public ViewManager getHolderManagerBuilder(){
        return ViewManager
                .begin()
                .addModel(CustomViewHolder.class);
    }

    public ViewExpandableManager getExpandableModelManagerBuilder(){
        return ViewExpandableManager
                .begin()
                .addGroupModel(CustomViewHolder.class)
                .addChildModel(CustomViewHolder.class)
                .addGroupModel(CustomLargeViewHolder.class)
                .addChildModel(CustomLargeViewHolder.class);
    }

    public List<ItemEntity> getTestList(){
        List<ItemEntity> resultList = new ArrayList<ItemEntity>();
        for (int i = 0; i < testStrings.length; i++) {
            ItemEntityUtil.create(testStrings[i]).setModelView(CustomView.class).attach(resultList);
            ItemEntityUtil.create(testStrings[i]).setModelView(CustomLargeView.class).attach(resultList);
        }
        return resultList;
    }

    public List<ItemEntity> getAATestList(){
        List<ItemEntity> resultList = new ArrayList<ItemEntity>();
        for (int i = 0; i < testStrings.length; i++) {
            ItemEntityUtil.create(testStrings[i]).setModelView(AACustomView_.class).attach(resultList);
            ItemEntityUtil.create(testStrings[i]).setModelView(AACustomLargeView_.class).attach(resultList);
        }
        return resultList;
    }

    public List<ItemEntity> getHolderTestList(){
        List<ItemEntity> resultList = new ArrayList<ItemEntity>();
        for (int i = 0; i < testStrings.length; i++) {
            ItemEntityUtil.create(testStrings[i]).setModelView(CustomViewHolder.class).attach(resultList);
        }
        return resultList;
    }
}
