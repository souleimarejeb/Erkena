package com.Erkena.Repositories;

import com.Erkena.Entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
}
