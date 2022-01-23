package com.application.adapter.functions;

import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.repositories.PostRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetPostByIdTest {


    @InjectMocks
    private GetPostById getPostById;

    @Mock
    private PostRepository repository;

    private static final String TEXT = "TEXT";

    @Test
    public void apply_test() {
        PostEntity entity = new PostEntity();
        entity.setId(TEXT);
        Mockito.when(repository.getOne(Mockito.anyString())).thenReturn(entity);
        Assertions.assertNotNull(getPostById.apply(TEXT));
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void apply_exception_test() {
        Mockito.when(repository.getOne(Mockito.anyString())).thenReturn(new PostEntity());
        Assertions.assertNotNull(getPostById.apply(TEXT));
    }
}
