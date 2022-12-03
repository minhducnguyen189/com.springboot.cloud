package com.application.adapter.functions;

import com.application.adapter.models.request.Post;
import com.application.adapter.repositories.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreatePostTest {

    @InjectMocks
    private CreatePost createPost;

    @Mock
    private PostRepository repository;

    @Test
    void apply_test() {
        Assertions.assertNotNull(createPost.apply(new Post()));
    }
}
