package com.Erkena.Controllers;

import com.Erkena.DTO.CommentDto;
import com.Erkena.Entities.Comments;
import com.Erkena.Interfaces.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentsController {
    private final ICommentService commentService;

    @PostMapping("/add-comment/{idPost}/{idUser}")
    public ResponseEntity<CommentDto> addComment(
            @RequestBody Comments payload,
            @PathVariable("idPost")int idPost,
            @PathVariable("idUser")int idUser
            )
    {
        return  ResponseEntity.ok(commentService.addComment(payload,idUser,idPost));
    }

    @DeleteMapping("/delete-comment/{idComment}")
    public ResponseEntity<CommentDto> deleteComment(
            @PathVariable("idComment")int idComment)
    {
        commentService.deleteComment(idComment);
        return  ResponseEntity.ok().build();
    }
    @PutMapping("/update-comment")
    public ResponseEntity<CommentDto> updateComment(
            @RequestBody CommentDto payload)
    {
        return  ResponseEntity.ok(commentService.updateComment(payload));
    }
}
