package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TMSItem;

import javax.swing.tree.TreeSelectionModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TMSRepositoryTest {

    private TMSRepository repository;

    private TMSItem first = new TMSItem(1,
            "Elena Slavutina",
            "Issue with java version",
            new TreeSet<String>(Collections.singleton("version1")),
            new TreeSet<String>(Collections.singleton("Ivan Penov")),
            new ArrayList<String>(Collections.singleton("Some initial comments")));
    private TMSItem second = new TMSItem(2,
            "Viktor Ivanov",
            "Issue with python version",
            new TreeSet<String>(Collections.singleton("release 20.1")),
            new TreeSet<String>(Collections.singleton("Ilya Grigoriev")),
            new ArrayList<String>(Collections.singleton("Something wrong with ver 20.1")));

    private TMSItem third = new TMSItem(3,
            "Dmitry Dubinin",
            "Issue with build on Mac OS",
            new TreeSet<String>(Collections.singleton("release 20.1")),
            new TreeSet<String>(Collections.singleton("Ilya Grigoriev")),
            new ArrayList<String>(Collections.singleton("Something wrong with ver 20.1 on Mac OS")));

    private TMSItem fourth = new TMSItem(4,
            "Elena Slavitina",
            "Crash on Windows 10",
            new TreeSet<String>(Collections.singleton("release 20.1")),
            new TreeSet<String>(Collections.singleton("Vasily Malov")),
            new ArrayList<String>(Collections.singleton("Something wrong with ver 20.1 on Win10")));

    @BeforeEach
    public void populateData() {
        repository = new TMSRepository();
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
    }

    @Test
    void shouldAddCommentById() {
        TMSItem item = repository.getById(1);
        assertEquals(first, item);
    }

    @Test
    void shouldCloseIssueById() {


    }

    @Test
    void shouldOpenIssueById() {


    }

}