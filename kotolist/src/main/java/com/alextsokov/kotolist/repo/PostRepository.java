package com.alextsokov.kotolist.repo;

import com.alextsokov.kotolist.models.PostCat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostCat, Long> {
    List<PostCat> findAllByOrderByViewsDesc();
}
