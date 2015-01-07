package github.chenupt.sample.views;

import android.content.Context;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import github.chenupt.multiplemodel.BaseItemModel;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
@EViewGroup(R.layout.view_item_custom)
public class AACustomView extends BaseItemModel<String> {

    @ViewById(R.id.text_view)
    TextView textView;

    public AACustomView(Context context) {
        super(context);
    }


    @Override
    public void bindView() {
        textView.setText(viewPosition + ". " + model.getContent());
    }
}
