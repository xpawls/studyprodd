package com.study.bookmgr.inf;

import java.util.List;

import com.study.bookmgr.model.ModelComments;

public interface IDaoComments {
    List<ModelComments> getComment(int bno);

    ModelComments getCommentOne(int commentno);
    int insertComment(ModelComments comment);
    int updateComment(String memo, int commentno);
    int deleteComment(int commentno);
}
