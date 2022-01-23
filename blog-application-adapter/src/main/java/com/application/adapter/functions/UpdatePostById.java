package com.application.adapter.functions;

import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.models.request.Post;
import com.application.adapter.repositories.PostRepository;
import com.application.adapter.utilities.DateUtil;
import com.application.adapter.utilities.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component
public class UpdatePostById implements BiConsumer<String, Post> {

    @Autowired
    private PostRepository repository;

    @Override
    public void accept(String id, Post post) {
        PostEntity entity = repository.getOne(id);
        entity.setLastModifiedDate(DateUtil.getRecentDate());
        MapperUtil.convertObject(post, entity);
        repository.save(entity);
    }
}
