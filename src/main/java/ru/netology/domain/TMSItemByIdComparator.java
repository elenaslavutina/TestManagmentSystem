package ru.netology.domain;

import java.util.Comparator;

public class TMSItemByIdComparator implements Comparator<TMSItem> {
    public int compare(TMSItem o1, TMSItem o2) {
        return o1.getId() - o2.getId();
    }
}
