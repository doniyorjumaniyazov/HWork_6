package util;

import java.util.Iterator;

public class TreeIterable<T> implements Iterable<T> {
    private final Iterable<T> iterable;

    public TreeIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return iterable.iterator();
    }
}
