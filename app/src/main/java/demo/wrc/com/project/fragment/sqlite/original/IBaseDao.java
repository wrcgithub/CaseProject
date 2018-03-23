package demo.wrc.com.project.fragment.sqlite.original;

/**
 * Created by wrc on 2018/3/22/022.
 */

public interface IBaseDao<T> {
    
    /**
     * 插入数据库
     * @param entity 对象
     * @return
     */
    Long insert(T entity);
    int update(T entity,T where);
}
