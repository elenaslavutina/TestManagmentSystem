package ru.netology.domain;

import java.util.Comparator;

public class TMSItemByAuthorComparator implements Comparator<TMSItem> {
    public int compare(TMSItem o1, TMSItem o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
