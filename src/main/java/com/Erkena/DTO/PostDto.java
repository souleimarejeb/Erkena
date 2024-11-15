package com.Erkena.DTO;


import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    int postId ;
    private String title;

    private String content;

    private LocalDate updateAt;

    @PreUpdate
    void beforeUpdate() {
        updateAt = LocalDate.now();
    }

}
