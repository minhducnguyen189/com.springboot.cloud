package com.application.adapter.services;

import com.application.adapter.models.request.Filter;
import com.application.adapter.models.request.Post;
import com.application.adapter.models.response.PostResponse;
import com.application.adapter.repositories.PostPagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class TodoServiceImpl implements TodoService{

    //Using functional interfaces of Java 8
    Function<Post, String> createPost;
    Function<String, PostResponse> getPostById;
    BiConsumer<String, Post> updatePostById;

    @Autowired
    @Qualifier("TestLogger")
    BiConsumer<String, Post> testLogger;
    BiFunction<Integer,String, List<PostResponse>> getPosts;
    @Autowired
    @Qualifier("FilterPosts")
    Function<Filter, List<PostResponse>> filterPosts;

    @Value("${post.page.defaultKey}")
    private String defaultSortField;

    @Autowired
    public TodoServiceImpl(Function<Post, String> createPost,
                           Function<String, PostResponse> getPostById,
                           BiConsumer<String, Post> updatePostById, BiFunction<Integer, String,
                            List<PostResponse>> getPosts) {
        this.createPost = createPost;
        this.getPostById = getPostById;
        this.updatePostById = updatePostById;
        this.getPosts = getPosts;
    }

    @Override
    public String createPost(Post post) {
        return createPost.apply(post);
    }

    @Override
    public PostResponse getPostById(String id) {
        return getPostById.apply(id);
    }

    @Override
    public void updatePost(String id, Post post) {
        updatePostById.andThen(testLogger).accept(id, post);
    }

    @Override
    public List<PostResponse> getPosts(int page, String key) {
        return getPosts.apply(page, key);
    }

    @Override
    public List<PostResponse> filterPosts(Filter filter) {
        return filterPosts.apply(filter);
    }
}
