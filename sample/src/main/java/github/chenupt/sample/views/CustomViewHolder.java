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

package github.chenupt.sample.views;

import android.content.Context;
import android.widget.TextView;

import github.chenupt.multiplemodel.BaseViewHolder;
import github.chenupt.sample.R;

public class CustomViewHolder extends BaseViewHolder<String> {

    private TextView textView;

    public CustomViewHolder(Context context) {
        super(context);
    }

    @Override
    public void bindView() {
        textView.setText(model.getContent());
    }

    @Override
    public int createView() {
        return R.layout.view_holder_custom;
    }

    @Override
    public void afterViewCreated() {
       textView = (TextView) getView().findViewById(R.id.text_view);
    }


}
