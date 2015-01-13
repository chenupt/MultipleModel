package github.chenupt.sample.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import github.chenupt.multiplemodel.BaseItemModel;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
public class CustomLargeView extends BaseItemModel {

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
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "view position is : " + viewPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void bindView() {
        textView.setText("viewPosition: " + viewPosition
                + "\ncontent: " + model.getContent()
                + "\ntype: " + model.getModelType());
    }
}
