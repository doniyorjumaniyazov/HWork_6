package service;

import model.FamilyTree;
import model.Person;

import java.io.IOException;

public class FamilyTreeService {

    private FamilyTree<Person> familyTree;
    private FileHandler fileHandler;

    public FamilyTreeService(FamilyTree<Person> familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void addPerson(Person person) {
        familyTree.addMember(person);
    }

    public void saveFamilyTree(String fileName) throws IOException {
        fileHandler.saveToFile(familyTree, fileName);
    }

    public FamilyTree<Person> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        return fileHandler.loadFromFile(fileName);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void displayFamilyTree() {
        familyTree.printFamilyTree();
    }
}
