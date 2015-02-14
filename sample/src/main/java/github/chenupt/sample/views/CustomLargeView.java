package github.chenupt.sample.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import github.chenupt.multiplemodel.IItemView;
import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
public class CustomLargeView extends FrameLayout implements IItemView<String> {

    private TextView textView;
    private Button button;

    public CustomLargeView(Context context) {
        super(context);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.view_item_custom_large, this, true);
        textView = (TextView) findViewById(R.id.text_view);
        button = (Button) findViewById(R.id.btn);
    }

    @Override
    public void bindView(ItemEntity model) {
        textView.setText("\ncontent: " + model.getContent()
                + "\ntype: " + model.getModelType());
    }
}
