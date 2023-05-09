package ru.itmo.wp.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.exception.ValidationException;
import ru.itmo.wp.form.PostForm;
import ru.itmo.wp.service.PostService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/1")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("posts")
    public List<Post> findPosts() {
        return postService.findAll();
    }

    @PostMapping("posts/create")
    public void register(@RequestBody @Valid PostForm postForm,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        postService.register(postForm);
    }
}
