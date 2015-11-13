package github.chenupt.sample.views;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import github.chenupt.multiplemodel.BaseViewHolder;
import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
public class CustomLargeViewHolder extends BaseViewHolder{

    private TextView textView;
    private Button button;

    public CustomLargeViewHolder(Context context) {
        super(context);
    }

    @Override
    public void bindView(ItemEntity model) {
        textView.setText("\ncontent: " + model.getContent()
                + "\ntype: " + model.getModelType());
    }

    @Override
    public void bindView() {

    }

    @Override
    public int createView() {
        return R.layout.view_item_custom_large;
    }

    @Override
    public void afterViewCreated() {
        textView = (TextView) getView().findViewById(R.id.text_view);
        button = (Button) getView().findViewById(R.id.btn);
    }
}
