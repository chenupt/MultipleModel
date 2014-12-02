package github.chenupt.sample;

import android.content.Context;
import android.view.LayoutInflater;

import github.chenupt.multiplemodel.BaseItemModel;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
public class CustomView extends BaseItemModel {

    public CustomView(Context context) {
        super(context);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.activity_custom, this, true);
    }

    @Override
    public void bindView() {

    }
}
