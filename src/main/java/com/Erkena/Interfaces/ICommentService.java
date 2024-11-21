package com.Erkena.Interfaces;

import com.Erkena.DTO.CommentDto;
import com.Erkena.Entities.Comments;

import java.util.List;

public interface ICommentService {
    CommentDto addComment(Comments comments, int idUser , int idPost);

    void deleteComment(int idComment);

    CommentDto updateComment(CommentDto commentDto);


}
