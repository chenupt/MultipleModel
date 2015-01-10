package github.chenupt.multiplemodel;


/**
 * Created by chenupt@gmail.com on 2014/8/13.
 * Description : ItemEntityCreator creator to create SimpleItemEntity
 */
public class ItemEntityCreator {

    public static <T> ItemEntity<T> create(T content){
        return new ItemEntity<T>(content);
    }

}
