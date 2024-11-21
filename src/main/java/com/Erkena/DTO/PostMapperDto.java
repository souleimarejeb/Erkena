package com.Erkena.DTO;

import com.Erkena.Entities.Posts;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PostDto.class})
public interface PostMapperDto {
    PostDto toDTO(Posts post);
    Posts toEntity(PostDto postDto);
    List<PostDto> toDTO(List<Posts> posts);
}
