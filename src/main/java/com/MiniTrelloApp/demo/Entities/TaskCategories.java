package com.MiniTrelloApp.demo.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "task_categories")
public class TaskCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<Folders> folders;

    public TaskCategories() {}

    public TaskCategories(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Folders> getFolders() {
        return folders;
    }

    public void setFolders(List<Folders> folders) {
        this.folders = folders;
    }
}
