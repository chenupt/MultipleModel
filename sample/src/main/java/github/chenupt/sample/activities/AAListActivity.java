package github.chenupt.sample.activities;

import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import github.chenupt.multiplemodel.aa.AAModelListAdapter;
import github.chenupt.sample.CommonService;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description : List activity with AndroidAnnotation.
 */

@EActivity(R.layout.activity_list)
public class AAListActivity extends ActionBarActivity {

    @ViewById(R.id.list_view)
    ListView listView;

    @Bean
    CommonService service;

    @AfterViews
    void afterViews(){
        AAModelListAdapter adapter = new AAModelListAdapter(this, service.getAAModelManagerBuilder());
        listView.setAdapter(adapter);

        adapter.addList(service.getAATestList());
        adapter.notifyDataSetChanged();
    }

}
