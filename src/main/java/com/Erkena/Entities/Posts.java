package com.Erkena.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int postId ;

    String title;

    String content;

    LocalDate createdAt;

    LocalDate updateAt;

    @ManyToOne
    Users user;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    List<Comments> comments;

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
