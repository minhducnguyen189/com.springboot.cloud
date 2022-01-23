package com.application.adapter.repositories;

import com.application.adapter.models.entities.PostEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostPagingRepository extends PagingAndSortingRepository<PostEntity, Long> {
}
