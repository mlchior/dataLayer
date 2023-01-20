package com.openclassrooms.datalayer.service;

import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.repository.CommentRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }
    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }
}
