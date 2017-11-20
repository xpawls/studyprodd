package java24.mybatis.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelAuth {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer authid = null;    //`authid` INT(11) NOT NULL,
    private String  name   = ""  ;    //`name`  VARCHAR(50) NULL DEFAULT NULL,
    private String  birth  = ""  ;    //`birth` VARCHAR(10) NULL DEFAULT NULL,
    
    //getset
    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public Integer getAuthid() {
        return authid;
    }
    public void setAuthid(Integer authid) {
        this.authid = authid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    
    //toS
    @Override
    public String toString() {
        return "ModelAuth [authid=" + authid + ", name=" + name + ", birth="
                + birth + "]";
    }
    
    //const
    public ModelAuth(Integer authid, String name, String birth) {
        super();
        this.authid = authid;
        this.name = name;
        this.birth = birth;
    }
    
    public ModelAuth() {
        super();
    }
    
    
    
}
