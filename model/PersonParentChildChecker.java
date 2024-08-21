package model;

import java.io.Serializable;

public class PersonParentChildChecker implements ParentChildChecker<Person>, Serializable {
    @Override
    public boolean isChildOf(Person child, Person parent) {
        return child.getMother() == parent || child.getFather() == parent;
    }
}
