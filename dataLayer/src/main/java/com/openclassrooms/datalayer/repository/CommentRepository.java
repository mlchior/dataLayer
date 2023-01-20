package com.openclassrooms.datalayer.repository;

import com.openclassrooms.datalayer.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
