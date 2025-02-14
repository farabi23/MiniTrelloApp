package com.MiniTrelloApp.demo.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title",  length = 100)
    private String title;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Folders folder;


    public Tasks() {

    }

    public Tasks(Long id, String title, String description, int status, Folders folder) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.folder = folder;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Folders getFolder() {
        return folder;
    }

    public void setFolder(Folders folder) {
        this.folder = folder;
    }
}
