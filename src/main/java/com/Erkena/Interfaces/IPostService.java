package com.Erkena.Interfaces;

import com.Erkena.DTO.PostDto;
import com.Erkena.Entities.Posts;

import java.util.List;

public interface IPostService {
    Posts addPost(Posts posts, int idUser);

    void deletePost(int idPost);

    Posts updatePosts(PostDto post);

    List<Posts> getPosts();

    Posts findPostById(int idPost);
}
