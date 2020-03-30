package io.github.cbinarycastle;

public interface List<E> {

    E get(int index);
    void add(E element);
    void addAll(List<E> list);
    void set(int index, E element);
    void remove(int index);
    int size();
}
