package com.application.adapter.functions;

import com.application.adapter.models.entities.PostEntity;
import com.application.adapter.models.env.PageEnv;
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

import java.util.Collections;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class GetPostsTest {

    @InjectMocks
    private GetPosts getPosts;

    @Mock
    private ApplicationContext context;

    @Mock
    private PostPagingRepository pagingRepository;

    @Mock
    private PageEnv pageEnv;

    @Mock
    private Pageable pageable;

    @Mock
    private Page<PostEntity> page;


    @Test
    void testApply() {
        Pageable pageable = PageRequest.of(1, 1, Sort.by("AAA").descending());
        List<PostEntity> entityList = Collections.singletonList(new PostEntity());
        Mockito.when(context.getBean(PageEnv.class)).thenReturn(pageEnv);
        Mockito.when(pageEnv.getSize()).thenReturn(1);
        Mockito.when(pagingRepository.findAll(pageable)).thenReturn(page);
        Mockito.when(page.getContent()).thenReturn(entityList);
        Assertions.assertEquals(1, getPosts.apply(1, "AAA").size());
    }

    @Test
    void testApplyWithNullSortKey() {
        List<PostEntity> entityList = Collections.singletonList(new PostEntity());
        Mockito.when(context.getBean(PageEnv.class)).thenReturn(pageEnv);
        Mockito.when(pageEnv.getSize()).thenReturn(1);
        Mockito.when(pageEnv.getDefaultKey()).thenReturn("AAA");
        Pageable pageable = PageRequest.of(1, 1, Sort.by("AAA").descending());
        Mockito.when(pagingRepository.findAll(pageable)).thenReturn(page);
        Mockito.when(page.getContent()).thenReturn(entityList);
        Assertions.assertEquals(1, getPosts.apply(1, null).size());
    }

}