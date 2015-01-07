package github.chenupt.multiplemodel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Simple base adapter for getting multiple item views in list.
 */
public class ModelListAdapter extends BaseListAdapter<ItemEntity> {

    protected IModelManager modelManager;

    public ModelListAdapter(Context context, IModelManager modelManager) {
        super(context);
        this.modelManager = modelManager;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = modelManager.createModel(getContext(), getItem(i).getModelType());
        }
        ((BaseItemModel)view).setViewPosition(i);
        ((BaseItemModel)view).setModel(getItem(i), getList());
        ((BaseItemModel)view).setAdapter(this);
        return view;
    }


    @Override
    public int getItemViewType(int position) {
        String type = getItem(position).getModelType();
        return modelManager.getViewType(type);
    }

    @Override
    public int getViewTypeCount() {
        return modelManager.getViewTypeCount();
    }
}
