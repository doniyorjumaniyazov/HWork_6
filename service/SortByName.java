package service;

import model.Person;

import java.util.List;
import java.util.Comparator;

public class SortByName implements Sorter<Person> {
    @Override
    public void sort(List<Person> people) {
        people.sort(Comparator.comparing(Person::getName));
    }
}
