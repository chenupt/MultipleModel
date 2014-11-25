package github.chenupt.multiplemodel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Simple base adapter for getting multiple item views in list.
 */
public class SimpleModelAdapter extends BaseListAdapter<SimpleItemEntity> {

    public static final String TAG = "SimpleModelAdapter";

    protected ModelFactory modelFactory;

    public SimpleModelAdapter(Context context, ModelFactory modelFactory) {
        super(context);
        this.modelFactory = modelFactory;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d(TAG, "getView:" + i);
        if(view == null){
            view = modelFactory.createModel(getContext(), getItem(i).getModelType());
        }
        ((BaseItemModel)view).setViewPosition(i);
        ((BaseItemModel)view).setModel(getItem(i), getList());
        ((BaseItemModel)view).setAdapter(this);
        return view;
    }


    @Override
    public int getItemViewType(int position) {
        String type = getItem(position).getModelType();
        return modelFactory.getViewType(type);
    }

    @Override
    public int getViewTypeCount() {
        return modelFactory.getViewTypeCount();
    }
}
