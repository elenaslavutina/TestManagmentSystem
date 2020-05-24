package ru.netology.manager;

import ru.netology.domain.TMSItem;
import ru.netology.domain.TMSItemByAuthorComparator;
import ru.netology.domain.TMSItemByIdComparator;
import ru.netology.repository.TMSRepository;

import java.util.*;

public class TMSManager {

    private TMSRepository repository = new TMSRepository();
    public TMSManager(TMSRepository repository) {
        this.repository = repository;
    }

    /* Список требуемой функциональности
    Добавление Issue (набор полей и типы данных для Issue определяете сами, но можете подсмотреть подсказку)
    Отображение списка открытых и закрытых Issue (два отдельных метода)
    Фильтрация* (3 отдельных метода):
    По имени автора (кто создал)
    По Label'у (вам нужно проанализировать механику и подобрать нужный метод самостоятельно, но можете посмотреть подсказку)
    По Assignee (на кого назначено)
    Сортировка (самостоятельно проанализируйте, как выполняется сортировка)
    Закрытие/открытие Issue по id (фактически, это и есть update)*/

    public boolean add(TMSItem item){
        return  this.repository.add(item);
    }

    public List<TMSItem> getOpenItems() {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            if (item.isOpen() == true) {
                result.add(item);
            }
        }

        TMSItemByIdComparator comparator = new TMSItemByIdComparator();
        Collections.sort(result, comparator);

        return result;
    }

    public List<TMSItem> getClosedItems() {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            if (item.isOpen() == false) {
                result.add(item);
            }
        }

        TMSItemByIdComparator comparator = new TMSItemByIdComparator();
        Collections.sort(result, comparator);

        return result;
    }

    public List<TMSItem> getItemsByAuthor(String author) {

        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            if (item.getAuthor() == author) {
                result.add(item);
            }
        }

        TMSItemByAuthorComparator comparator = new TMSItemByAuthorComparator();
        Collections.sort(result, comparator);

        return result;
    }

    public List<TMSItem> getItemsByAssignee(String assignee) {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            for(String s : item.getAssignees())
                if (s == assignee) {
                    result.add(item);
                }
        }

        TMSItemByIdComparator comparator = new TMSItemByIdComparator();
        Collections.sort(result, comparator);

        return result;

    }

    public List<TMSItem> getItemsByTag(String tag) {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            for(String s : item.getTags())
                if (s == tag) {
                    result.add(item);
                }
        }

        TMSItemByAuthorComparator comparator = new TMSItemByAuthorComparator();
        Collections.sort(result, comparator);

        return result;
    }

    public boolean clodeById(int id) {
        TMSItem item = repository.getById(id);
        if (item != null) {
            item.close();
            return true;
        }

        return false;
    }

    public boolean reOpenById(int id) {
        TMSItem item = repository.getById(id);
        if (item != null) {
            item.reOpen();
            return true;
        }

        return false;
    }
}
