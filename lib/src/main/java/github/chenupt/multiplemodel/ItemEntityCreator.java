package github.chenupt.multiplemodel;


/**
 * Created by chenupt@gmail.com on 2014/8/13.
 * Description : ItemEntityCreator creator to create SimpleItemEntity
 */
public class ItemEntityCreator {

    public static <T> SimpleItemEntity<T> create(T content){
        return new SimpleItemEntity<T>(content);
    }

}
