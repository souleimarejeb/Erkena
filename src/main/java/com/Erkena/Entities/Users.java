package com.Erkena.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int userId ;

        String username;

        String email;

        String role;

        String password;

        LocalDate createdAt;

        LocalDate updateAt;

        @OneToMany(mappedBy = "user")
        List<Posts> posts;

        @OneToMany(mappedBy = "user")
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
