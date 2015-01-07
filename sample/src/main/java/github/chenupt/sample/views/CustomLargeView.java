package github.chenupt.sample.views;

import android.content.Context;
import android.view.LayoutInflater;

import github.chenupt.multiplemodel.BaseItemModel;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
public class CustomLargeView extends BaseItemModel {

    public CustomLargeView(Context context) {
        super(context);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_large, this, true);
    }

    @Override
    public void bindView() {

    }
}
