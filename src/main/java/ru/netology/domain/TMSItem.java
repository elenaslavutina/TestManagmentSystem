package ru.netology.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class TMSItem {

    private int     id;
    private String  author;
    private String  title;

    private TreeSet<String>  tags;
    private TreeSet<String>  assignees;
    private LocalDateTime    created;
    private LocalDateTime    updated;

    private  ArrayList<String> comments;

    private  boolean isOpen;

    public TMSItem(int id, String author, String title,
                   TreeSet<String> tags, TreeSet<String> assignees,
                   ArrayList<String> comments) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.tags = tags;
        this.assignees = assignees;
        this.comments = comments;

        this.isOpen = true;
        this.created = LocalDateTime.now();
        this.updated = this.created;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public TreeSet<String> getTags() {
        return tags;
    }

    public TreeSet<String> getAssignees() {
        return assignees;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getTitle() {
        return title;
    }

    public void close() {
        isOpen  = false;
        updated = LocalDateTime.now();
        comments.add("Automatic message: Issue is closed");
    }

    public void reOpen() {
        isOpen  = true;
        updated = LocalDateTime.now();
        comments.add("Automatic message: Issue is reopened");
    }

    public void addComment(String s) {
        comments.add(s);
        updated = LocalDateTime.now();
    }

    public void addTag(String tag) {
        tags.add(tag);
        updated = LocalDateTime.now();
    }
}
