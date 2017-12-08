package demo.wrc.com.project.model;

/**
 * Created by wrc_urovo on 2017/12/7/007.
 */

public class TestInfo {
    
    private String name;
    private boolean isTrue;
    
    
    public String getName() {
        
        return name;
    }
    
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    
    public boolean isTrue() {
        
        return isTrue;
    }
    
    
    public void setTrue(boolean aTrue) {
        
        isTrue = aTrue;
    }
    
    
    @Override
    public String toString() {
        
        return "TestInfo{" +
                "name='" + name + '\'' +
                ", isTrue=" + isTrue +
                '}';
    }
}
