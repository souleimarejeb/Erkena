package com.Erkena.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int CommentId ;

    String content;

    LocalDate createdAt;

    LocalDate updateAt;

    @ManyToOne
    Users user;
    @ManyToOne
    Posts post;

    @PrePersist
    void beforeInsert(){
        createdAt = LocalDate.now();
        updateAt= LocalDate.now();
    }
    @PreUpdate
    void beforeUpdate() {
        updateAt = LocalDate.now();
    }

}
