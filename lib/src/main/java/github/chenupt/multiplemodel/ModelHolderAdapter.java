package github.chenupt.multiplemodel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author hzchenjianfeng
 * @since 2015/4/3
 * Copyright 2015 NetEase. All rights reserved.
 */
public class ModelHolderAdapter extends ModelListAdapter {

    public ModelHolderAdapter(Context context, ViewManager manager) {
        super(context, manager);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Object viewHolder = null;
        if(view == null){
            Class<?> owner = viewManager.viewMap.get(getItem(i).getModelType());
            try {
                viewHolder = owner.getConstructor(Context.class).newInstance(context);
                if (viewHolder instanceof IViewHolder) {
                    view = ((IViewHolder) viewHolder).onCreateView(viewGroup);
                }else{
                    throw new RuntimeException("viewHolder have not implemented IViewHolder interface");
                }
                view.setTag(viewHolder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            viewHolder = view.getTag();
        }
        if (viewHolder instanceof IPosition){
            ((IPosition)viewHolder).bindViewPosition(i);
        }
        if (viewHolder instanceof IItemView){
            ((IItemView)viewHolder).bindView(getItem(i));
        }
        return view;
    }
}
