/*
 * Copyright 2015 chenupt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package github.chenupt.sample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import github.chenupt.multiplemodel.recycler.ModelRecyclerAdapter;
import github.chenupt.sample.CommonService;
import github.chenupt.sample.CommonService_;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 1/12/15.
 * Description :
 */
public class RecyclerViewActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        CommonService commonService = CommonService_.getInstance_(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // init recycler view
        ModelRecyclerAdapter adapter = new ModelRecyclerAdapter(this, commonService.getModelManager());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        // set data source
        adapter.setList(commonService.getTestList());
        adapter.notifyDataSetChanged();
    }
}
