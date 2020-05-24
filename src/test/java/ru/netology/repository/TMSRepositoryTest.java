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

    private TMSItem first  = new TMSItem(1,
                                         "Elena Slavutina",
                                         "Issue with java version",
                                         new   TreeSet<String>(Collections.singleton("version1")),
                                         new TreeSet<String>(Collections.singleton("Ivan Penov")),
                                         new ArrayList<String>(Collections.singleton("Some initial comments")));


    @BeforeEach
    public void populateData() {
        repository = new TMSRepository();
        repository.add(first);
    }

    @Test
    void shouldAddCommentById() {
        TMSItem item    = repository.getById(1);
        String expected = "Additional comment";

        item.addComment(expected);

        item = repository.getById(1);

        ArrayList<String> comments = item.getComments();

        int       idx = comments.size() - 1;
        String actual = comments.get(idx);

        assertEquals(expected, actual);
    }

}