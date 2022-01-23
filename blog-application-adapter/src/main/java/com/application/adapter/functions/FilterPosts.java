package com.application.adapter.functions;

import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.models.request.Filter;
import com.application.adapter.models.response.PostResponse;
import com.application.adapter.repositories.PostPagingRepository;
import com.application.adapter.utilities.MapperUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component("FilterPosts")
public class FilterPosts implements Function<Filter, List<PostResponse>> {

    @Autowired
    private PostPagingRepository pagingRepository;

    @Value("${post.page.defaultKey}")
    private String defaultSortField;

    @Override
    public List<PostResponse> apply(Filter filter) {

        Pageable pageable;
        if(StringUtils.isEmpty(filter.getSortField())) {
            pageable = PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(defaultSortField).descending());
        } else if(!StringUtils.isEmpty(filter.getSortField()) && filter.getSortOrder() == null) {
            pageable = PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(filter.getSortField()).descending());
        } else {
            pageable = PageRequest.of(filter.getPage(), filter.getPageSize(), Sort
                    .by(Sort.Direction.valueOf(filter.getSortOrder().name()), filter.getSortField()));
        }
        Page<PostEntity> page = pagingRepository.findAll(pageable);
        List<PostEntity> entities = page.getContent();
        return entities.stream().map(e -> MapperUtil.mappingObject(e, new PostResponse())).collect(Collectors.toList());
    }
}
