package board.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private String         boardcd   = "";        //`boardcd`  VARCHAR(20) NOT NULL,
    private String         boardnm   = "";        //`boardnm`  VARCHAR(40) NOT NULL,
    private Integer        UseYN     = null;      //`UseYN`    TINYINT(1) NULL DEFAULT '1',
    private String         InsertUID = "";        //`InsertUID` VARCHAR(40) NULL DEFAULT NULL,
    private java.util.Date InsertDT  = null;      //`InsertDT` DATETIME NULL DEFAULT NULL,
    private String         UpdateUID = "";        //`UpdateUID` VARCHAR(40) NULL DEFAULT NULL,
    private java.util.Date UpdateDT  = null;      //`UpdateDT` DATETIME NULL DEFAULT NULL,
    public String getBoardcd() {
        return boardcd;
    }
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    public String getBoardnm() {
        return boardnm;
    }
    public void setBoardnm(String boardnm) {
        this.boardnm = boardnm;
    }
    public Integer getUseYN() {
        return UseYN;
    }
    public void setUseYN(Integer useYN) {
        UseYN = useYN;
    }
    public String getInsertUID() {
        return InsertUID;
    }
    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }
    public java.util.Date getInsertDT() {
        return InsertDT;
    }
    public void setInsertDT(java.util.Date insertDT) {
        InsertDT = insertDT;
    }
    public String getUpdateUID() {
        return UpdateUID;
    }
    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }
    public java.util.Date getUpdateDT() {
        return UpdateDT;
    }
    public void setUpdateDT(java.util.Date updateDT) {
        UpdateDT = updateDT;
    }
    
    @Override
    public String toString() {
        return "ModelBoard [boardcd=" + boardcd + ", boardnm=" + boardnm
                + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID
                + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID
                + ", UpdateDT=" + UpdateDT + "]";
    }
    
    public ModelBoard(String boardcd, String boardnm, Integer useYN,
            String insertUID, Date insertDT, String updateUID, Date updateDT) {
        super();
        this.boardcd = boardcd;
        this.boardnm = boardnm;
        UseYN = useYN;
        InsertUID = insertUID;
        InsertDT = insertDT;
        UpdateUID = updateUID;
        UpdateDT = updateDT;
    }
    
    public ModelBoard() {
        super();
    }
    
    
}
