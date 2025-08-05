package com.programming.pratya.springredditclone.repository;

import com.programming.pratya.springredditclone.model.Comment;
import com.programming.pratya.springredditclone.model.Post;
import com.programming.pratya.springredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
