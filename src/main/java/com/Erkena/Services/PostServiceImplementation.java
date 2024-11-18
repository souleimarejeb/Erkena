package com.Erkena.Services;

import com.Erkena.DTO.PostDto;
import com.Erkena.Entities.Posts;
import com.Erkena.Entities.Users;
import com.Erkena.Exceptions.NotFoundException;
import com.Erkena.Interfaces.IPostService;
import com.Erkena.Repositories.PostsRepository;
import com.Erkena.Repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImplementation implements IPostService {
    PostsRepository postsRepository;
    UsersRepository usersRepository;

    @Override
    public Posts addPost(Posts posts , int idUser) {
        Users user = usersRepository.findById(idUser)
                .orElseThrow(() -> new NotFoundException("Requested User Not Found"));
        posts.setUser(user);
        return postsRepository.save(posts);
        }

    @Override
    public void deletePost(int idPost) {

        postsRepository.deleteById(idPost);
    }

    @Override
    public Posts updatePosts(PostDto postDto ) {
        Posts foundPost = postsRepository.findById(postDto.getPostId()).get();
        foundPost.setTitle(postDto.getTitle());
        foundPost.setContent(postDto.getContent());
        foundPost.setUpdateAt(postDto.getUpdateAt());

        return postsRepository.save(foundPost);
    }
    @Override
    public List<Posts> getPosts() {
        return postsRepository.findAll();
    }

    @Override
    public Posts findPostById(int idPost) {
        return postsRepository.findById(idPost).get();
    }
}
