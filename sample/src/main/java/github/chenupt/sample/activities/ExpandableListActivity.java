package github.chenupt.sample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ExpandableListView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.res.StringArrayRes;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.multiplemodel.ItemEntityUtil;
import github.chenupt.multiplemodel.ModelExpandAdapter;
import github.chenupt.sample.CommonService;
import github.chenupt.sample.CommonService_;
import github.chenupt.sample.R;
import github.chenupt.sample.views.CustomLargeViewHolder;
import github.chenupt.sample.views.CustomViewHolder;

/**
 * @author chenupt create on 2015/11/13
 */
@EActivity
public class ExpandableListActivity extends ActionBarActivity {

    private ExpandableListView listView;
    private CommonService service;

    @StringArrayRes(R.array.test_strings)
    String[] testStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        listView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        service = CommonService_.getInstance_(this);

        ModelExpandAdapter adapter = new ModelExpandAdapter(service.getExpandableModelManagerBuilder());
        listView.setAdapter(adapter);

        adapter.addGroupList(service.getHolderTestList());
        for (int i = 0; i < service.getHolderTestList().size(); i++) {
            List<ItemEntity> resultList = new ArrayList<>();
            for (int j = 0; j < testStrings.length; j++) {
                ItemEntityUtil.create(testStrings[j]).setModelView(CustomViewHolder.class).attach(resultList);
                ItemEntityUtil.create(testStrings[j]).setModelView(CustomLargeViewHolder.class).attach(resultList);
            }
            adapter.addChildArray(i, resultList);
        }
        adapter.notifyDataSetChanged();
    }
}
