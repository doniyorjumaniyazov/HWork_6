package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable {
    private List<T> members;
    private ParentChildChecker<T> checker;

    public FamilyTree(ParentChildChecker<T> checker) {
        this.members = new ArrayList<>();
        this.checker = checker;
    }

    public void addMember(T member) {
        members.add(member);
        if (member.getMother() != null) {
            member.getMother().addChild(member);
        }
        if (member.getFather() != null) {
            member.getFather().addChild(member);
        }
    }

    public List<T> getChildren(T parent) {
        List<T> children = new ArrayList<>();
        for (T member : members) {
            if (checker.isChildOf(member, parent)) {
                children.add(member);
            }
        }
        return children;
    }

    public List<T> getMembers() {
        return members;
    }

    public void sortByName() {
        members.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        members.sort(Comparator.comparing(Person::getBirthDate));
    }

    public void printFamilyTree() {
        for (T member : members) {
            System.out.println(member);
            List<T> children = getChildren(member);
            if (!children.isEmpty()) {
                System.out.println("Дети:");
                for (T child : children) {
                    System.out.println(" - " + child);
                }
            } else {
                System.out.println("Дети: Нет данных");
            }
            System.out.println();
        }
    }
}
