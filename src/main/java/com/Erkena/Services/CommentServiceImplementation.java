package com.Erkena.Services;

import com.Erkena.DTO.CommentDto;
import com.Erkena.DTO.CommentMapperDto;
import com.Erkena.Entities.Comments;
import com.Erkena.Entities.Posts;
import com.Erkena.Entities.Users;
import com.Erkena.Interfaces.ICommentService;
import com.Erkena.Repositories.CommentsRepository;
import com.Erkena.Repositories.PostsRepository;
import com.Erkena.Repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class CommentServiceImplementation implements ICommentService {

    private final CommentsRepository commentsRepository;
    private final CommentMapperDto commentMapperDto;
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    @Override
    public CommentDto addComment(Comments comments, int idUser, int idPost) {
        Posts posts =postsRepository.findById(idPost).get();
        Users user = usersRepository.findById(idUser).orElseThrow();
        comments.setUser(user);
        comments.setPost(posts);
        Comments savedComments = commentsRepository.save(comments);
        return commentMapperDto.toDTO(savedComments);
    }

    @Override
    public void deleteComment(int idComment) {
        Comments comment = commentsRepository.findById(idComment).orElse(null);
        commentsRepository.delete(comment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {
        Comments updateEntity = commentMapperDto.toEntity(commentDto);
        Comments comment = commentsRepository.save(updateEntity);
        return commentMapperDto.toDTO(comment);
    }


}
