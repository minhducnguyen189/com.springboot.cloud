package com.application.adapter.functions;

import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.models.env.PageEnv;
import com.application.adapter.models.request.Filter;
import com.application.adapter.models.request.SortOrder;
import com.application.adapter.repositories.PostPagingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FilterPostsTest {


    @InjectMocks
    private FilterPosts filterPosts;

    @Mock
    private PostPagingRepository pagingRepository;

    @InjectMocks
    private GetPosts getPosts;

    @Mock
    private ApplicationContext context;

    @Mock
    private PageEnv pageEnv;

    @Mock
    private Pageable pageable;

    @Mock
    private Page<PostEntity> page;


    @Test
    public void testApply() {
        Filter filter = new Filter();
        filter.setPage(1);
        filter.setPageSize(1);
        filter.setSortField("AAA");

        List<PostEntity> entityList = Collections.singletonList(new PostEntity());
        Pageable pageable = PageRequest.of(1, 1, Sort.by("AAA").descending());
        Mockito.when(pagingRepository.findAll(pageable)).thenReturn(page);
        Mockito.when(page.getContent()).thenReturn(entityList);
        Assertions.assertEquals(1, filterPosts.apply(filter).size());
    }

    @Test
    public void testApplyWithNullSortField() {
        Filter filter = new Filter();
        filter.setPage(1);
        filter.setPageSize(1);

        List<PostEntity> entityList = Collections.singletonList(new PostEntity());
        ReflectionTestUtils.setField(filterPosts, "defaultSortField","createdDate");
        Pageable pageable = PageRequest.of(1, 1, Sort.by("createdDate").descending());
        Mockito.when(pagingRepository.findAll(pageable)).thenReturn(page);
        Mockito.when(page.getContent()).thenReturn(entityList);
        Assertions.assertEquals(1, filterPosts.apply(filter).size());
    }

    @Test
    public void testApplyWithFullFilter() {
        Filter filter = new Filter();
        filter.setPage(1);
        filter.setPageSize(1);
        filter.setSortField("AAA");
        filter.setSortOrder(SortOrder.DESC);

        List<PostEntity> entityList = Collections.singletonList(new PostEntity());
        Pageable pageable = PageRequest.of(1, 1, Sort.by(Sort.Direction.valueOf(filter.getSortOrder().name()), filter.getSortField()));
        Mockito.when(pagingRepository.findAll(pageable)).thenReturn(page);
        Mockito.when(page.getContent()).thenReturn(entityList);
        Assertions.assertEquals(1, filterPosts.apply(filter).size());
    }

}