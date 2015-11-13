package github.chenupt.multiplemodel;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenupt create on 2015/11/13
 */
public class ModelExpandAdapter extends BaseExpandableListAdapter {

    private List<ItemEntity> groupList = new ArrayList<>();
    private SparseArray<List<ItemEntity>> childArray = new SparseArray<>();

    private ViewExpandableManager viewManager;

    public ModelExpandAdapter(ViewExpandableManager viewManager) {
        this.viewManager = viewManager;
    }

    public void addGroupList(List<ItemEntity> groupList) {
        this.groupList.addAll(groupList);
    }

    public void addChildArray(int groupPosition, List<ItemEntity> childArray) {
        this.childArray.put(groupPosition, childArray);
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childArray.get(groupPosition).size();
    }

    @Override
    public ItemEntity getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public ItemEntity getChild(int groupPosition, int childPosition) {
        return childArray.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Object viewHolder = null;
        if(convertView == null){
            Class<?> owner = viewManager.iGroupMap.get(getGroupType(groupPosition));
            try {
                viewHolder = owner.getConstructor(Context.class).newInstance(parent.getContext());
                if (viewHolder instanceof IViewHolder) {
                    convertView = ((IViewHolder) viewHolder).onCreateView(parent);
                }else{
                    throw new RuntimeException("viewHolder have not implemented IViewHolder interface");
                }
                convertView.setTag(viewHolder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            viewHolder = convertView.getTag();
        }
        if (viewHolder instanceof IExpandable){
            ((IExpandable)viewHolder).bindViewGroupPosition(groupPosition);
            ((IExpandable)viewHolder).bindViewIsExpanded(isExpanded);
        }
        if (viewHolder instanceof IItemView){
            ((IItemView)viewHolder).bindView(getGroup(groupPosition));
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Object viewHolder = null;
        if(convertView == null){
            Class<?> owner = viewManager.iChildMap.get(getChildType(groupPosition, childPosition));
            try {
                viewHolder = owner.getConstructor(Context.class).newInstance(parent.getContext());
                if (viewHolder instanceof IViewHolder) {
                    convertView = ((IViewHolder) viewHolder).onCreateView(parent);
                }else{
                    throw new RuntimeException("viewHolder have not implemented IViewHolder interface");
                }
                convertView.setTag(viewHolder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            viewHolder = convertView.getTag();
        }
        if (viewHolder instanceof IExpandable){
            ((IExpandable)viewHolder).bindViewGroupPosition(groupPosition);
            ((IExpandable)viewHolder).bindViewChildPosition(childPosition);
            ((IExpandable)viewHolder).bindViewIsLastChild(true);
        }
        if (viewHolder instanceof IItemView){
            ((IItemView)viewHolder).bindView(getChild(groupPosition, childPosition));
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public int getGroupType(int groupPosition) {
        String modelType = getGroup(groupPosition).getModelType();
        return viewManager.indexGroupMap.get(modelType);
    }

    @Override
    public int getGroupTypeCount() {
        return viewManager.groupViewMap.size();
    }

    @Override
    public int getChildType(int groupPosition, int childPosition) {
        String modelType = getChild(groupPosition, childPosition).getModelType();
        return viewManager.indexChildMap.get(modelType);
    }

    @Override
    public int getChildTypeCount() {
        return viewManager.childViewMap.size();
    }


}
