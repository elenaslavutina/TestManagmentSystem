package ru.netology.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

public class TMSItem {

    int              id;
    String           author;
    String           title;

    TreeSet<String>  tags;
    TreeSet<String>  assignees;
    LocalDateTime    created;
    LocalDateTime    updated;

    ArrayList<String> comments;

    boolean          isOpen;

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

    public void closeItem() {
        isOpen = false;
    }

    public void addComment(String s) {
        comments.add(s);
    }

}
