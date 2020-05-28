package ru.netology.repository;

import ru.netology.domain.TMSItem;

import java.util.*;

public class TMSRepository {
    private List<TMSItem> items = new ArrayList<>();

    public List<TMSItem> getAll() {
        return items;
    }

    public TMSItem getById(int id) {
        for (TMSItem item : items) {
            if (item.getId() == id)
                return item;
        }

        return null;
    }

    public boolean add(TMSItem item) {
        return this.items.add(item);
    }

    public boolean remove(TMSItem item) {
        return this.items.remove(item);
    }
    public boolean addAll(Collection<? extends TMSItem> items) {
        return this.items.addAll(items);
    }

    public boolean removeAll(Collection<? extends TMSItem> items) {
        return this.items.removeAll(items);
    }

    public void updateById(int id, String comment) {
        TMSItem item = getById(id);
        item.addComment(comment);
    }


    public void clodeById(int id) {
        TMSItem item = getById(id);
        if (item != null) {
            item.close();
        }
    }

    public void reOpenById(int id) {
        TMSItem item = getById(id);
        if (item != null) {
            item.reOpen();
        }
    }
}
