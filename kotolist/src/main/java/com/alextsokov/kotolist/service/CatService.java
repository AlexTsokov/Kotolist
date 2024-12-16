package com.alextsokov.kotolist.service;

import com.alextsokov.kotolist.models.PostCat;


public interface CatService {

    PostCat addCat(PostCat postCat);

    void deleteById(long id);

    PostCat findById(long id);

    Iterable<PostCat> findAllCats();


}
