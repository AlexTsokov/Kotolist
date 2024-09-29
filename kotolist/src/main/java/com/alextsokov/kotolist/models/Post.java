package com.alextsokov.kotolist.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, anons, fulltext;
    private int views;
}
