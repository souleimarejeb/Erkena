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
        public List<PostDto> getPosts() {
            List<Posts> posts = postsRepository.findAll();

            // Log the Posts data to ensure it is correctly fetched from the DB
            posts.forEach(post -> {
                System.out.println("Post: " + post.getPostId() + ", Title: " + post.getTitle());
            });
            List<PostDto> postDtos = postMapperDto.toDTO(posts);

            // Log the result after mapping
            postDtos.forEach(postDto -> {
                System.out.println("Mapped PostDto - Post ID: " + postDto.getPostId() + ", Title: " + postDto.getTitle() + ", Content: " + postDto.getContent());
            });
            return postDtos;
        }

        @Override
        public PostDto findPostById(int idPost) {

           Optional<Posts> post= postsRepository.findById(idPost);
            System.out.println(post.get());
            return postMapperDto.toDTO(post.get());
        }
    }
