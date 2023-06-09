package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.form.PostForm;
import ru.itmo.wp.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAllByOrderByCreationTimeDesc();
    }

    @Transactional
    public void register(PostForm postForm) {
        postRepository.save(toPost(postForm));
    }

    private Post toPost(PostForm postForm) {
        Post post = new Post();

        post.setTitle(postForm.getTitle());
        post.setText(postForm.getText());
        post.setUser(postForm.getUser());

        return post;
    }

}
