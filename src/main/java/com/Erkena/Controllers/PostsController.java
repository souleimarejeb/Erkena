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
    public List<Posts> GetPosts()
    {
        List<Posts> newPost= postService.getPosts();
        return newPost;
    }
    @GetMapping("/one-post/{postId}")
    public ResponseEntity<Posts> findPostById(@PathVariable("postId")int postId)
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
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PatchMapping ("/update-post")
    public Posts updatePost(@RequestBody PostDto payload)
    {
        return postService.updatePosts(payload);
    }
}
