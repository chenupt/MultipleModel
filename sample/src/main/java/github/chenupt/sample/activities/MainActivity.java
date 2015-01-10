package github.chenupt.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import github.chenupt.sample.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toNormalActivity(View view) {
        startActivity(new Intent(this, NormalListActivity.class));
    }

    public void toAnnotationActivity(View view) {
        startActivity(new Intent(this, AAListActivity_.class));
    }
}
