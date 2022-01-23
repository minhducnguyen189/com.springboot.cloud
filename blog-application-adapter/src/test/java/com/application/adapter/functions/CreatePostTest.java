package com.application.adapter.functions;

import com.application.adapter.models.request.Post;
import com.application.adapter.repositories.PostRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreatePostTest {

    @InjectMocks
    private CreatePost createPost;

    @Mock
    private PostRepository repository;

    @Test
    public void apply_test() {
        Assertions.assertNotNull(createPost.apply(new Post()));
    }
}
