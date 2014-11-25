package github.chenupt.multiplemodel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.List;

/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description : Base model view can be extended to show different item views.
 */
public abstract class BaseItemModel<T> extends FrameLayout {

    protected SimpleItemEntity<T> model;
    protected List<SimpleItemEntity<T>> modelList;
    protected int viewPosition;
    protected SimpleItemEntity<T> groupModel;
    protected int groupPosition;
    protected BaseListAdapter adapter;

    public BaseItemModel(Context context){
        this(context, null);
    }

    public BaseItemModel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public abstract void bindView();


    public void setModel(SimpleItemEntity<T> model, List<SimpleItemEntity<T>> modelList){
        if(this.model != null){
            // 判断数据是否唯一项，如果数据未过期则不进行bindView，显示缓存的view
            if (this.model.isSingleton() && this.model.getTimestamp() == model.getTimestamp()) {
                return ;
            }
        }
        this.model = model;
        this.modelList =  modelList;
        bindView();
    };

    public void setModel(SimpleItemEntity<T> model){
        setModel(model, null);
    };

    public void setViewPosition(int position){
        this.viewPosition = position;
    }

    public void setGroupPosition(int groupPosition) {
        this.groupPosition = groupPosition;
    }

    public void setGroupModel(SimpleItemEntity<T> groupModel) {
        this.groupModel = groupModel;
    }

    public BaseListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(BaseListAdapter adapter) {
        this.adapter = adapter;
    }

    public void notifyDataSetChanged(){
        adapter.notifyDataSetChanged();
    }
}
