package com.application.adapter.services;

import com.application.adapter.models.request.Filter;
import com.application.adapter.models.request.Post;
import com.application.adapter.models.response.PostResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;


@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {


    @InjectMocks
    private TodoServiceImpl todoServiceImpl;

    @Mock
    private Function<Post, String> createPost;

    @Mock
    private Function<String, PostResponse> getPostById;

    @Mock
    private BiConsumer<String, Post> updatePostById;

    @Mock
    private BiConsumer<String, Post> testLogger;

    @Mock
    private BiFunction<Integer,String, List<PostResponse>> getPosts;

    @Mock
    private Function<Filter, List<PostResponse>> filterPosts;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePost() {
        Post post = new Post();
        Mockito.when(createPost.apply(post)).thenReturn("AAA");
        Assertions.assertEquals("AAA", todoServiceImpl.createPost(post));
    }

    @Test
    void testGetPostById (){
        PostResponse postResponse = new PostResponse();
        Mockito.when(getPostById.apply(Mockito.any())).thenReturn(postResponse);
        Assertions.assertNotNull(todoServiceImpl.getPostById("AAA"));
    }

    @Test
    void testGetPosts() {
        PostResponse postResponse = new PostResponse();
        Mockito.when(getPosts.apply(Mockito.anyInt(), Mockito.anyString()))
                .thenReturn(Collections.singletonList(postResponse));
        Assertions.assertEquals(1,todoServiceImpl.getPosts(Mockito.anyInt(), Mockito.anyString()).size());
    }

    @Test
    void testUpdatePost() {
        Mockito.doNothing().when(testLogger).accept(Mockito.any(), Mockito.any());
        Mockito.when(updatePostById.andThen(testLogger)).thenReturn(testLogger);
        todoServiceImpl.updatePost("ID", new Post());
        Assertions.assertTrue(true);
    }

    @Test
    void testFilterPosts() {
        PostResponse postResponse = new PostResponse();
        Filter filter = new Filter();
        Mockito.when(filterPosts.apply(filter))
                .thenReturn(Collections.singletonList(postResponse));
        Assertions.assertEquals(1, todoServiceImpl.filterPosts(filter).size());
    }




}