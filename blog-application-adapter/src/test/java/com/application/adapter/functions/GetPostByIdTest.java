package com.application.adapter.functions;

import com.application.adapter.repositories.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetPostByIdTest {


    @InjectMocks
    private GetPostById getPostById;

    @Mock
    private PostRepository repository;

    private static final String TEXT = "TEXT";

    @Test
    void apply_test() {
        Assertions.assertNotNull(getPostById.apply(TEXT));
    }

}
