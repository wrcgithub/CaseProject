package demo.wrc.com.project.fragment.sqlite.original;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;


/**
 * Created by wrc on 2018/3/22/022.
 */

public class BaseDaoFactory {
    
    /***/
    private String sqliteDatabasePath;
    
    private SQLiteDatabase sqLiteDatabase;
    
    public BaseDaoFactory(){
        
        sqliteDatabasePath = Environment.getDataDirectory().getAbsolutePath()+"caseproject.db";
    }
    
    public synchronized <T extends BaseDao<M>,M> T getDataHelper(Class<T> clazz,Class<M> entityClass){
        BaseDao baseDao = null;
    
        try {
            baseDao = clazz.newInstance();
            
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    
    }
    
    
    private void openDatabase(){
        
        this.sqLiteDatabase =SQLiteDatabase.openOrCreateDatabase(sqliteDatabasePath,null);
    }
}
