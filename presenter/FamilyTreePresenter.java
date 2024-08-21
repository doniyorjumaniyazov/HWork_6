package presenter;

import java.io.IOException;

import model.Person;
import service.FamilyTreeService;
import view.FamilyTreeView;

public class FamilyTreePresenter {

    private FamilyTreeService service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    public void addPerson(Person person) {
        service.addPerson(person);
        view.showMessage("Человек добавлен: " + person.getName());
    }

    public void displayFamilyTree() {
        service.displayFamilyTree();
    }

    public void sortByName() {
        service.sortByName();
        view.showMessage("Генеалогическое древо отсортировано по имени.");
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.showMessage("Генеалогическое древо отсортировано по дате рождения.");
    }

    public void saveFamilyTree(String fileName) {
        try {
            service.saveFamilyTree(fileName);
            view.showMessage("Данные сохранены в файл: " + fileName);
        } catch (IOException e) {
            view.showMessage("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    public void loadFamilyTree(String fileName) {
        try {
            service.loadFamilyTree(fileName);
            view.showMessage("Данные загружены из файла: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage("Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}
