package io.github.cbinarycastle;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_SIZE = 10;

    private Object[] array;
    private int dataSize;

    public ArrayList() {
        array = new Object[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        array = new Object[size];
    }

    @Override
    public E get(int index) {
        validateRange(index);

        return (E) this.array[index];
    }

    @Override
    public void add(E element) {
        validateRangeForAdd(lastIndex() + 1);
        array[lastIndex() + 1] = element;
        dataSize++;
    }

    @Override
    public void addAll(List<E> list) {
        validateRangeForAdd(lastIndex() + list.size());
        for (int i = 0; i < list.size(); i++) {
            E element = list.get(i);
            add(element);
        }
    }

    @Override
    public void set(int index, E element) throws IndexOutOfBoundsException {
        validateRange(index);

        for (int i = dataSize; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        dataSize++;
    }

    @Override
    public void remove(int index) {
        for (int i = index + 1; i < dataSize; i++) {
            array[i - 1] = array[i];
        }
        dataSize--;
    }

    @Override
    public int size() {
        return dataSize;
    }

    protected void validateRange(int index) {
        if (index >= dataSize) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, dataSize));
        }
    }

    protected void validateRangeForAdd(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, dataSize));
        }

        if (index > dataSize) {
            increaseArraySizeAndCopy();
        }
    }

    protected void increaseArraySizeAndCopy() {
        Object[] tempArray = array.clone();
        array = new Object[array.length + DEFAULT_SIZE];
        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        arrayString.append("{ ");
        for (int i = 0; i < lastIndex(); i++) {
            Object element = array[i];
            arrayString.append(element.toString());
            arrayString.append(", ");
        }
        arrayString.append(array[lastIndex()]);
        arrayString.append(" }");

        return arrayString.toString();
    }

    protected int lastIndex() {
        return dataSize - 1;
    }
}
