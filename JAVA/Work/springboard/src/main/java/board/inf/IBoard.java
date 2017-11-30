package board.inf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import board.model.ModelArticle;
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;

public interface IBoard {
    String getBoardName(String boardcd);
    ModelBoard getBoardOne(String boardcd);
    List<ModelBoard> getBoardList();
    int insertBoard(ModelBoard board);
    int updateBoard(ModelBoard searchValue, ModelBoard updateValue);
    int deleteBoard(ModelBoard board);
    List<ModelBoard> getBoardSearch(ModelBoard board);
    int getBoardTotalRecord(String boardcd, String searchWord);
    List<ModelBoard> getBoardPaging(String boardcd, String searchWord, int start, int end);
    int insertBoardList(List<ModelBoard> list);
    int getArticleTotalRecord(String boardcd, String searchWord);
    List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end);
    List<ModelArticle> getArticle(int articleno);
    int insertArticle(ModelArticle article);
    int updateArticle(ModelArticle updateValue, ModelArticle searchValue);
    int deleteArticle(ModelArticle article);
    int increaseHit(int articleno);
    List<ModelArticle> getNextArticle(String boardcd, int articleno, String searchWord);
    List<ModelArticle> getPrevArticle(String boardcd, int articleno, String searchWord);
    List<ModelAttachFile> getAttachFile(int attachFileNo);
    List<ModelAttachFile> getAttachFileList(int articleno);
    int insertAttachFile(ModelAttachFile attachfile);
    int deleteAttachFile(ModelAttachFile attachfile);
    List<ModelComments> getComment(int commentNo);
    List<ModelComments> getCommentList(int articleno);
    int insertComment(ModelComments comments);
    int updateComment(ModelComments updateValue, ModelComments searchValue);
    int deleteComment(ModelComments comments);
    
    
    
    
    
}
