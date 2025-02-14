package com.MiniTrelloApp.demo.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "folders")
public class Folders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<TaskCategories> categories;

    public Folders() {

    }

    public Folders(Long id, String name, List<TaskCategories> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskCategories> getCategories() {
        return categories;
    }

    public void setCategories(List<TaskCategories> categories) {
        this.categories = categories;
    }
}
