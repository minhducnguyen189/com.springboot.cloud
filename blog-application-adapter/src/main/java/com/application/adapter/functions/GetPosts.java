package com.application.adapter.functions;

import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.models.env.PageEnv;
import com.application.adapter.models.response.PostResponse;
import com.application.adapter.repositories.PostPagingRepository;
import com.application.adapter.repositories.PostRepository;
import com.application.adapter.utilities.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Component
public class GetPosts implements BiFunction<Integer, String, List<PostResponse>> {

    private ApplicationContext context;
    private PostPagingRepository pagingRepository;

    @Autowired
    public GetPosts(ApplicationContext context, PostPagingRepository pagingRepository) {
        this.context = context;
        this.pagingRepository = pagingRepository;
    }

    @Override
    public List<PostResponse> apply(Integer startNumber, String sortKey) {
        PageEnv pageEnv = context.getBean(PageEnv.class);
        Pageable pageable;
        if(Optional.ofNullable(sortKey).isPresent()) {
            pageable = PageRequest.of(startNumber, pageEnv.getSize(), Sort.by(sortKey).descending());
        } else {
            pageable = PageRequest.of(startNumber, pageEnv.getSize(), Sort.by(pageEnv.getDefaultKey()).descending());
        }
        Page<PostEntity> page = pagingRepository.findAll(pageable);
        List<PostEntity> entities = page.getContent();
        return entities.stream().map(e -> MapperUtil.mappingObject(e, new PostResponse())).collect(Collectors.toList());
    }
}
