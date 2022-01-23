package com.application.adapter.services;

import com.application.adapter.models.request.Filter;
import com.application.adapter.models.request.Post;
import com.application.adapter.models.response.PostResponse;

import java.util.List;

public interface TodoService {
    String createPost(Post post);
    PostResponse getPostById(String id);
    void updatePost(String id, Post post);
    List<PostResponse> getPosts(int page, String key);
    List<PostResponse> filterPosts(Filter filter);
}
