package com.alextsokov.kotolist.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
public class PostCat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
    @SequenceGenerator(name = "post_generator", sequenceName = "post_seq", allocationSize = 1)
    private Long id;
    private String tittle, anons, fulltext;
    private int views;
    private Timestamp creationtime;
    //@Enumerated(EnumType.STRING)
    private String catbreed; //Не работает с ENUM

    public PostCat(String title, String anons, String fulltext, int views, Timestamp creationtime, String catBreed) {
        this.tittle = title;
        this.anons = anons;
        this.fulltext = fulltext;
        this.views = views;
        this.creationtime = creationtime;
        this.catbreed = catBreed;
    }
}
