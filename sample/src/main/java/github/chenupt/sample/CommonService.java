package github.chenupt.sample;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringArrayRes;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.multiplemodel.ItemEntityCreator;
import github.chenupt.multiplemodel.ViewManager;
import github.chenupt.sample.views.AACustomLargeView_;
import github.chenupt.sample.views.AACustomView_;
import github.chenupt.sample.views.CustomLargeView;
import github.chenupt.sample.views.CustomView;

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

    public List<ItemEntity> getTestList(){
        List<ItemEntity> resultList = new ArrayList<ItemEntity>();
        for (int i = 0; i < testStrings.length; i++) {
            ItemEntityCreator.create(testStrings[i]).setModelView(CustomView.class).attach(resultList);
            ItemEntityCreator.create(testStrings[i]).setModelView(CustomLargeView.class).attach(resultList);
        }
        return resultList;
    }

    public List<ItemEntity> getAATestList(){
        List<ItemEntity> resultList = new ArrayList<ItemEntity>();
        for (int i = 0; i < testStrings.length; i++) {
            ItemEntityCreator.create(testStrings[i]).setModelView(AACustomView_.class).attach(resultList);
            ItemEntityCreator.create(testStrings[i]).setModelView(AACustomLargeView_.class).attach(resultList);
        }
        return resultList;
    }
}
