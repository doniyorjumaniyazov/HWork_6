package view;

import model.Person;

import java.util.List;

public class FamilyTreeConsoleView implements FamilyTreeView {

    @Override
    public void displayFamilyTree(List<Person> members) {
        System.out.println("Генеалогическое древо:");
        for (Person member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void displayChildren(List<Person> children) {
        System.out.println("Дети:");
        for (Person child : children) {
            System.out.println(child);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}