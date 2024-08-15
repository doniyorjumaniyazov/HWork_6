package service;

import java.util.List;

public interface Sorter<T> {
    void sort(List<T> items);
}
