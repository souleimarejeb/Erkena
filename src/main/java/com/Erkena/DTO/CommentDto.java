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
public class CommentDto {
    int CommentId ;

    String content;

    LocalDate updateAt;

    @PreUpdate
    void beforeUpdate() {
        updateAt = LocalDate.now();
    }
}
