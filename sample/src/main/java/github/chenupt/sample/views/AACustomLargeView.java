package github.chenupt.sample.views;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import github.chenupt.multiplemodel.BaseItemView;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
@EViewGroup(R.layout.view_item_custom_large)
public class AACustomLargeView extends BaseItemView<String> {

    @ViewById(R.id.text_view)
    TextView textView;

    public AACustomLargeView(Context context) {
        super(context);
    }

    @Override
    public void bindView() {
        textView.setText("viewPosition: " + viewPosition
                + "\ncontent: " + model.getContent()
                + "\ntype: " + model.getModelType());
    }

    @Click(R.id.btn)
    void btnClick(){
        Toast.makeText(getContext(), "view position is : " + viewPosition, Toast.LENGTH_SHORT).show();
    }
}
