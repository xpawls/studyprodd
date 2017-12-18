package testg.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelPlayUser {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String  name  = "";             // `name` VARCHAR(50) NULL DEFAULT NULL,
    private Integer level = null;             //  `level` INT(11) NULL DEFAULT NULL,
    private Integer atk   = null;             // `atk` INT(11) NULL DEFAULT NULL,
    private Integer def   = null;             // `def` INT(11) NULL DEFAULT NULL,
    private Integer agl   = null;             // `agl` INT(11) NULL DEFAULT NULL,
    private Integer hp    = null;             // `hp`  INT(11) NULL DEFAULT NULL
    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public Integer getAtk() {
        return atk;
    }
    public void setAtk(Integer atk) {
        this.atk = atk;
    }
    public Integer getDef() {
        return def;
    }
    public void setDef(Integer def) {
        this.def = def;
    }
    public Integer getAgl() {
        return agl;
    }
    public void setAgl(Integer agl) {
        this.agl = agl;
    }
    public Integer getHp() {
        return hp;
    }
    public void setHp(Integer hp) {
        this.hp = hp;
    }
    public ModelPlayUser() {
        super();
    }
    public ModelPlayUser(String name, Integer level, Integer atk, Integer def,
            Integer agl, Integer hp) {
        super();
        this.name = name;
        this.level = level;
        this.atk = atk;
        this.def = def;
        this.agl = agl;
        this.hp = hp;
    }
    
    
}
