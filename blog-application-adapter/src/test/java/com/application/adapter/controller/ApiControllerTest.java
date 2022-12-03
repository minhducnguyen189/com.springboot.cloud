package com.application.adapter.controller;

import com.application.adapter.models.request.Post;
import com.application.adapter.models.response.PostResponse;
import com.application.adapter.services.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ApiControllerTest {

    @InjectMocks
    private ApiController apiController;

    @Mock
    private TodoService todoService;


    private static final String MOCK_ID = "aa3615e5-29b5-4626-9079-af7eefd0e800";
    private static final String MOCK_KEY = "lastModifiedDate";
    private static final int MOCK_PAGE = 0;


    private PostResponse postResponse;
    private Post post;
    private List<PostResponse> postResponses;

    @BeforeEach
    void initMock() {
        postResponses = new ArrayList<>();
        postResponse = new PostResponse();
        postResponses.add(postResponse);
        post = new Post();

    }


    @Test
    void test_getPostById() {
        Mockito.when(todoService.getPostById(Mockito.anyString())).thenReturn(postResponse);
        Assertions.assertEquals(HttpStatus.OK, apiController.getPostById(MOCK_ID).getStatusCode());
    }

    @Test
    void test_createPost() {
        Assertions.assertEquals(HttpStatus.CREATED, apiController.createPost(post).getStatusCode());
    }

    @Test
    void test_updatePost() {
        Mockito.doNothing().when(todoService).updatePost(Mockito.any(), Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, apiController.updatePost(MOCK_ID, post).getStatusCode());
    }

    @Test
    void test_getPosts() {
        Mockito.when(todoService.getPosts(Mockito.anyInt(), Mockito.any())).thenReturn(postResponses);
        Assertions.assertEquals(HttpStatus.OK, apiController.getPosts(MOCK_PAGE, MOCK_KEY).getStatusCode());
    }

    @Test
    void test_filterPosts() {
        Mockito.when(todoService.filterPosts(Mockito.any())).thenReturn(postResponses);
        Assertions.assertEquals(HttpStatus.OK, apiController.filterPosts(Mockito.any()).getStatusCode());
    }

}
