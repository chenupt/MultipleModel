package github.chenupt.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.ItemEntityCreator;
import github.chenupt.multiplemodel.ModelFactory;
import github.chenupt.multiplemodel.SimpleItemEntity;
import github.chenupt.multiplemodel.SimpleModelAdapter;
import github.chenupt.multiplemodel.aa.AAModelFactory;


public class MainActivity extends ActionBarActivity {

    ListView listView;

    private SimpleModelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        ModelFactory modelFactory = new AAModelFactory.Builder().addModel(CustomView.class).build();
        adapter = new SimpleModelAdapter(this, modelFactory);
        listView.setAdapter(adapter);

        List<SimpleItemEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            ItemEntityCreator.create("").setModelView(CustomView.class).attach(list);
        }

        adapter.addList(list);
        adapter.notifyDataSetChanged();


    }



}
