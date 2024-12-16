package com.alextsokov.kotolist.controllers;

import com.alextsokov.kotolist.models.CatBreed;
import com.alextsokov.kotolist.models.PostCat;
import com.alextsokov.kotolist.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;


@Controller
public class BlogController {

    @Autowired
    private CatService catService;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<PostCat> posts = catService.findAllCats();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String newCatAdd(@RequestParam String tittle, @RequestParam String anons, @RequestParam String full_text,
                            @RequestParam String catBreed, Model model) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        PostCat postCat = new PostCat(tittle, anons, full_text, 0, date, catBreed);
        catService.addCat(postCat);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String catDetails(@PathVariable(value = "id") long id, Model model) {
        PostCat res = catService.findById(id);
        model.addAttribute("postCat", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String catEdit(@PathVariable(value = "id") long id, Model model) {
        PostCat res = catService.findById(id);
        model.addAttribute("postCat", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String catUpdate(@PathVariable(value = "id") long id, @RequestParam String tittle,
                            @RequestParam String anons, @RequestParam String full_text, Model model) {
        PostCat postCat = catService.findById(id);
        postCat.setTittle(tittle);
        postCat.setAnons(anons);
        postCat.setFulltext(full_text);
        postCat.setCreationtime(new Timestamp(System.currentTimeMillis()));
        catService.addCat(postCat);
        return "redirect:/blog/{id}";
    }

    @PostMapping("/blog/{id}/delete")
    public String catDelete(@PathVariable(value = "id") long id, Model model) {
        if (catService.findById(id) == null) {
            return "redirect:/blog";
        }
        catService.deleteById(id);
        return "redirect:/blog";
    }

}
