package github.chenupt.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.multiplemodel.ItemEntityCreator;
import github.chenupt.multiplemodel.ModelListAdapter;
import github.chenupt.multiplemodel.ModelManager;
import github.chenupt.multiplemodel.ModelManagerBuilder;


public class MainActivity extends ActionBarActivity {

    ListView listView;

    private ModelListAdapter adapter;
    private ModelManager modelManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        modelManager = ModelManagerBuilder.begin().addModel(CustomView.class).build(ModelManager.class);
        adapter = new ModelListAdapter(this, modelManager);

        listView.setAdapter(adapter);

        List<ItemEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemEntityCreator.create("").setModelView(CustomView.class).setTag("tag1").attach(list);
        }

        for (int i = 0; i < 1; i++) {
            ItemEntityCreator.create("").setModelView(CustomView.class).setTag("tag2").attach(list);
        }

        for (int i = 0; i < 5; i++) {
            ItemEntityCreator.create("").setModelView(CustomView.class).setTag("tag3").attach(list);
        }

        adapter.addList(list);
        adapter.notifyDataSetChanged();

        testStartGetByTag();
        testEndGetByTag();
    }


    private void testStartGetByTag(){
        ItemEntity entity = modelManager.getStartItemByTag(adapter.getList(), "tag2");
        Log.d("test", "tagName:" + entity.getTag() + ", tagSPosition:" + adapter.getList().indexOf(entity));
    }
    private void testEndGetByTag(){
        ItemEntity entity = modelManager.getEndItemByTag(adapter.getList(), "tag2");
        Log.d("test", "tagName:" + entity.getTag() + ", tagEPosition:" + adapter.getList().indexOf(entity));
    }

}
