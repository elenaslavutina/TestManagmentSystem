package ru.netology.service;
import ru.netology.domain.TMSItem;
import ru.netology.manager.TMSManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class TMSPredicate {
    public TMSPredicate(TMSManager manager) {
        this.manager = manager;
    }

    private TMSManager manager;

    public   List<TMSItem> predicateByAutor(String autor) {
       Function<String,List<TMSItem>> result = x-> manager.getItemsByAuthor(x);
        return result.apply(autor);
       }
}