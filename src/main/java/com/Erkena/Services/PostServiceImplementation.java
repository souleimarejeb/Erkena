    package com.Erkena.Services;

    import com.Erkena.DTO.PostDto;
    import com.Erkena.DTO.PostMapperDto;
    import com.Erkena.Entities.Posts;
    import com.Erkena.Entities.Users;
    import com.Erkena.Exceptions.NotFoundException;
    import com.Erkena.Interfaces.IPostService;
    import com.Erkena.Repositories.PostsRepository;
    import com.Erkena.Repositories.UsersRepository;
    import lombok.AllArgsConstructor;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    @AllArgsConstructor
    public class PostServiceImplementation implements IPostService {
        private final PostsRepository postsRepository;
        private final UsersRepository usersRepository;
        private final PostMapperDto postMapperDto;

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
        public PostDto updatePosts(PostDto postDto ) {

            Posts updateEntity = postMapperDto.toEntity(postDto);
            Posts post = postsRepository.save(updateEntity);
            return postMapperDto.toDTO(post);
        }
        @Override
        public List<PostDto> getPosts() {
            List<Posts> posts= postsRepository.findAll();

            return postMapperDto.toDTO(posts);
        }

        @Override
        public PostDto findPostById(int idPost) {

           Optional<Posts> post= postsRepository.findById(idPost);
            return postMapperDto.toDTO(post.get());
        }
    }
