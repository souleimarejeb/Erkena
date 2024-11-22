package com.Erkena.Controllers;

import com.Erkena.DTO.PostDto;
import com.Erkena.Entities.Posts;
import com.Erkena.Interfaces.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostsController {

    public final IPostService postService;
    @GetMapping("/allposts")
    public ResponseEntity<List<PostDto>> GetPosts()
    {
        return ResponseEntity.ok(postService.getPosts());
    }
    @GetMapping("/one-post/{postId}")
    public ResponseEntity<PostDto> findPostById(@PathVariable("postId")int postId)
    {
        return ResponseEntity.ok(postService.findPostById(postId));
    }
//Request entity ( record)  instead of Pathvariable -
    @PostMapping("/add-post/{idUser}")
    public ResponseEntity<Posts> addPost(
            @RequestBody Posts payload,
            @PathVariable("idUser")int idUser)
    {
        Posts newPost= postService.addPost(payload,idUser);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-post/{idPost}")
    public ResponseEntity<Posts> deletePost(@PathVariable("idPost")int idPost)
    {
         postService.deletePost(idPost);
        return ResponseEntity.ok().build();
    }

    @PatchMapping ("/update-post")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto payload)
    {
        return ResponseEntity.ok(postService.updatePosts(payload));
    }
}
