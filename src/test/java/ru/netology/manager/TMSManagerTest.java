package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TMSItem;
import ru.netology.repository.TMSRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;
import ru.netology.service.TMSPredicate;
class TMSManagerTest {
    private TMSRepository repository;
    private TMSManager    manager;

    private TMSItem first  = new TMSItem(1,
            "Elena Slavutina",
            "Issue with java version",
            new TreeSet<String>(Collections.singleton("version1")),
            new TreeSet<String>(Collections.singleton("Ivan Penov")),
            new ArrayList<String>(Collections.singleton("Some initial comments")));

    private TMSItem second  = new TMSItem(2,
            "Viktor Ivanov",
            "Issue with python version",
            new TreeSet<String>(Collections.singleton("release 20.1")),
            new TreeSet<String>(Collections.singleton("Ilya Grigoriev")),
            new ArrayList<String>(Collections.singleton("Something wrong with ver 20.1")));

    private TMSItem third  = new TMSItem(3,
            "Dmitry Dubinin",
            "Issue with build on Mac OS",
            new TreeSet<String>(Collections.singleton("release 20.1")),
            new TreeSet<String>(Collections.singleton("Ilya Grigoriev")),
            new ArrayList<String>(Collections.singleton("Something wrong with ver 20.1 on Mac OS")));

    private TMSItem fourth  = new TMSItem(4,
            "Elena Slavitina",
            "Crash on Windows 10",
            new TreeSet<String>(Collections.singleton("release 20.1")),
            new TreeSet<String>(Collections.singleton("Vasily Malov")),
            new ArrayList<String>(Collections.singleton("Something wrong with ver 20.1 on Win10")));

    @BeforeEach
    public void populateData() {
        repository = new TMSRepository();
        manager    = new TMSManager(repository);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

    }

    @Test
    void shouldGetItemsByAuthor() {
        List<TMSItem> expected = new ArrayList<TMSItem>();
        expected.add(second);
        TMSPredicate predicate = new TMSPredicate(manager);
        List<TMSItem> actual = predicate.predicateByAutor("Viktor Ivanov");
        assertEquals(expected, actual);
    }


    @Test
    void shouldNotGetItemsByAuthorIfAuthorNotExist() {
        List<TMSItem> expected = new ArrayList<TMSItem>();

        List<TMSItem> actual = manager.getItemsByAuthor("Empty Empty");

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetItemsByAssignee() {
        List<TMSItem> expected = new ArrayList<TMSItem>();
        expected.add(second);
        expected.add(third);

        List<TMSItem> actual = manager.getItemsByAssignee("Ilya Grigoriev");

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotGetItemsByAssigneeIfItNotExist() {
        List<TMSItem> expected = new ArrayList<TMSItem>();
        List<TMSItem> actual = manager.getItemsByAssignee("Petya Pupkin");

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetItemsByTag() {
        List<TMSItem> expected = new ArrayList<TMSItem>();
        expected.add(third);
        expected.add(fourth);
        expected.add(second);

        List<TMSItem> actual = manager.getItemsByTag("release 20.1");

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotGetItemsByTagIfItNotExist() {
        List<TMSItem> expected = new ArrayList<TMSItem>();
        List<TMSItem> actual = manager.getItemsByTag("release 20.2020");

        assertEquals(expected, actual);
    }
}