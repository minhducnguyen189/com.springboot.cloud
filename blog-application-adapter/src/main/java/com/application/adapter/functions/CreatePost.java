package com.application.adapter.functions;

import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.models.request.Post;
import com.application.adapter.repositories.PostRepository;
import com.application.adapter.utilities.DateUtil;
import com.application.adapter.utilities.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreatePost implements Function<Post, String> {

    @Autowired
    private PostRepository repository;

    @Override
    public String apply(Post post) {
        PostEntity entity = new PostEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatedDate(DateUtil.getRecentDate());
        entity.setLastModifiedDate(DateUtil.getRecentDate());
        MapperUtil.convertObject(post, entity);
        repository.save(entity);
        return entity.getId();
    }
}
