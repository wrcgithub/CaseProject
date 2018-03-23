package demo.wrc.com.project.fragment.sqlite.original;

import android.database.sqlite.SQLiteDatabase;


/**
 * Created by wrc on 2018/3/22/022.
 */

public class BaseDao<T> implements IBaseDao<T> {
    
    private SQLiteDatabase database;
    protected void init(Class<T> entity, SQLiteDatabase sqLiteDatabase){
    
        database = sqLiteDatabase;
    
    }
    
    @Override
    public Long insert(T entity) {
        
        return null;
    }
    
    
    @Override
    public int update(T entity, T where) {
        
        return 0;
    }
}
