package main;

import model.FamilyTree;
import model.Person;
import service.Sorter;
import view.FamilyTreeView;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addPerson(Person person) {
        familyTree.addMember(person);
        view.showMessage("Человек добавлен: " + person.getName());
    }

    public void displayFamilyTree() {
        List<Person> members = familyTree.getMembers();
        view.displayFamilyTree(members);
    }

    public void displayChildren(Person parent) {
        List<Person> children = familyTree.getChildren(parent);
        view.displayChildren(children);
    }

    @SuppressWarnings("unchecked")
    public void sort(@SuppressWarnings("rawtypes") Sorter sorter) {
        familyTree.sort(sorter);
        view.showMessage("Генеалогическое древо отсортировано.");
        displayFamilyTree();
    }
}
