package com.Erkena.DTO;

import com.Erkena.Entities.Comments;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CommentDto.class})
public interface CommentMapperDto {
    CommentDto toDTO(Comments comments);
    Comments toEntity(CommentDto commentDto);
    List<CommentDto> toDTO(List<Comments> comment);
}
