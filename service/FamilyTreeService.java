package service;

import model.FamilyTree;
import model.Person;

import java.io.*;

public class FamilyTreeService {

    private FileHandler fileHandler;

    public FamilyTreeService(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void saveFamilyTree(FamilyTree<Person> familyTree, String fileName) throws IOException {
        fileHandler.saveToFile(familyTree, fileName);
    }

    public FamilyTree<Person> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        return fileHandler.loadFromFile(fileName);
    }
}
