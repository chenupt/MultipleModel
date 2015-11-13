package github.chenupt.multiplemodel;

/**
 * @author chenupt create on 2015/11/13
 */
public interface IExpandable {

    void bindViewGroupPosition(int groupPosition);
    void bindViewChildPosition(int childPosition);
    void bindViewIsExpanded(boolean isExpanded);
    void bindViewIsLastChild(boolean isLastChild);
}
