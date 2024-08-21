package main;

import model.FamilyTree;
import model.Person;
import model.PersonParentChildChecker;
import presenter.FamilyTreePresenter;
import service.FileHandler;
import service.FamilyTreeService;
import view.FamilyTreeConsoleView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создаем необходимые объекты
        PersonParentChildChecker checker = new PersonParentChildChecker();
        FamilyTree<Person> familyTree = new FamilyTree<>(checker);
        FileHandler fileHandler = new FileHandler();
        FamilyTreeService service = new FamilyTreeService(familyTree, fileHandler);
        FamilyTreeConsoleView view = new FamilyTreeConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        // Добавляем примеры людей
        Person mother = new Person("Мария", LocalDate.of(1950, 5, 10), null, null, null);
        Person father = new Person("Иван", LocalDate.of(1948, 3, 15), null, null, null);
        Person child = new Person("Данияр", LocalDate.of(1975, 8, 21), null, mother, father);

        presenter.addPerson(mother);
        presenter.addPerson(father);
        presenter.addPerson(child);

        // Демонстрируем работу программы
        presenter.displayFamilyTree();
        presenter.sortByName();
        presenter.displayFamilyTree();
        presenter.saveFamilyTree("familyTree.dat");
        presenter.loadFamilyTree("familyTree.dat");
    }
}
