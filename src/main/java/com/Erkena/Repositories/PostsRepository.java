package com.Erkena.Repositories;

import com.Erkena.Entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository  extends JpaRepository<Posts,Integer> {

 Posts findById(int id );
}
