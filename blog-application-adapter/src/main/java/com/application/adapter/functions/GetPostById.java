package com.application.adapter.functions;

import com.application.adapter.exception.ApiException;
import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.models.response.PostResponse;
import com.application.adapter.repositories.PostRepository;
import com.application.adapter.utilities.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class GetPostById implements Function<String, PostResponse> {

    @Autowired
    private PostRepository repository;


    @Override
    public PostResponse apply(String id) {
        try {
            Optional<PostEntity> entity = repository.findById(id);
            PostResponse response = new PostResponse();
            entity.ifPresent(postEntity -> MapperUtil.convertObject(postEntity, response));
            return response;
        } catch (RuntimeException ex) {
            throw new ApiException("Not found, the id is not existed!", ex);
        }
    }
}
