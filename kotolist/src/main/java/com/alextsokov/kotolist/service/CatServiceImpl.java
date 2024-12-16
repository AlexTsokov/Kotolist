package com.alextsokov.kotolist.service;

import com.alextsokov.kotolist.models.PostCat;
import com.alextsokov.kotolist.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public PostCat addCat(PostCat postCat) {
        postRepo.save(postCat);
        return postCat;
    }

    @Override
    public void deleteById(long id) {
        PostCat postCat = postRepo.findById(id).orElseThrow();
        postRepo.delete(postCat);
    }

    @Override
    public PostCat findById(long id) {
        PostCat postCat = postRepo.findById(id).orElseThrow();
        postCat.setViews(postCat.getViews() + 1);
        postRepo.save(postCat);
        return postCat;
    }

    @Override
    public Iterable<PostCat> findAllCats() {
        return postRepo.findAllByOrderByViewsDesc();
    }
}
