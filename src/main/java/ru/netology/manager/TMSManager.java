package ru.netology.manager;

import ru.netology.domain.TMSItem;
import ru.netology.domain.TMSItemByAuthorComparator;
import ru.netology.domain.TMSItemByIdComparator;
import ru.netology.repository.TMSRepository;

import java.util.*;

import static java.util.Collections.sort;

public class TMSManager {

    private TMSRepository repository;
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
        return  repository.add(item);
    }

    public List<TMSItem> getOpenItems() {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            if (item.isOpen()) {
                result.add(item);
            }
        }

        TMSItemByIdComparator comparator = new TMSItemByIdComparator();
        sort(result, comparator);

        return result;
    }

    public List<TMSItem> getClosedItems() {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            if (!item.isOpen()) {
                result.add(item);
            }
        }

        TMSItemByIdComparator comparator = new TMSItemByIdComparator();
        sort(result, comparator);

        return result;
    }

    public List<TMSItem> getItemsByAuthor(String author) {

        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            if (item.getAuthor().equals(author)) {
                result.add(item);
            }
        }

        TMSItemByAuthorComparator comparator = new TMSItemByAuthorComparator();
        sort(result, comparator);

        return result;
    }

    public List<TMSItem> getItemsByAssignee(String assignee) {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            for(String s : item.getAssignees())
                if (s.equals(assignee)) {
                    result.add(item);
                }
        }

        TMSItemByIdComparator comparator = new TMSItemByIdComparator();
        sort(result, comparator);

        return result;

    }

    public List<TMSItem> getItemsByTag(String tag) {
        List<TMSItem> result = new ArrayList<>();
        List<TMSItem> items  = repository.getAll();

        for(TMSItem item: items) {
            for(String s : item.getTags())
                if (s.equals(tag)) {
                    result.add(item);
                }
        }

        TMSItemByAuthorComparator comparator = new TMSItemByAuthorComparator();
        sort(result, comparator);

        return result;
    }

}
