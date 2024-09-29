package com.alextsokov.kotolist.repo;

import com.alextsokov.kotolist.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
