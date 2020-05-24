package ru.netology.manager;

import ru.netology.domain.TMSItem;
import ru.netology.repository.TMSRepository;

import java.util.ArrayList;

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

    public ArrayList<TMSItem> getOpenItems() {

    }

    public ArrayList<TMSItem> getClosedItems() {

    }

    public ArrayList<TMSItem> getItemsByAuthor(String author) {

    }

    public ArrayList<TMSItem> getItemsByAssignee(String assignee) {

    }

    public ArrayList<TMSItem> getItemsByTag(String tag) {

    }

    public TMSItem clodeById(int id) {

    }

    public TMSItem reOpenById(int id) {

    }


}
