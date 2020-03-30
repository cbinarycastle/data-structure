package io.github.cbinarycastle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTests {

    private static final int[] DATA = { 325, 21, 10, 239, 692 };

    private List<Integer> arrayList;

    @BeforeEach
    void init() {
        this.arrayList = new ArrayList<>();
        for (int d : DATA) {
            arrayList.add(d);
        }
    }

    @Test
    void whenAddThenSuccess() {
        String expected = "{ 325, 21, 10, 239, 692 }";
        assertEquals(expected, arrayList.toString());
    }

    @Test
    void whenAddAllThenSuccess() {
        int[] additionalData = { 512, 2349, 21 };
        List<Integer> additional = new ArrayList<>();
        for (int d : additionalData) {
            additional.add(d);
        }

        arrayList.addAll(additional);
    }

    @Test
    void whenAddAllOverDefaultSizeThenSuccess() {
        int[] additionalData = { 512, 2349, 21, 3451, 924, 13, 9 };
        List<Integer> additional = new ArrayList<>();
        for (int d : additionalData) {
            additional.add(d);
        }

        arrayList.addAll(additional);
    }

    @Test
    void whenSetThenSuccess() {
        arrayList.set(2, 125);

        String expected = "{ 325, 21, 125, 10, 239, 692 }";
        assertEquals(expected, arrayList.toString());
    }

    @Test
    void whenSetToInvalidIndexThenIndexOutOfBoundException() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.set(5, 125));
    }

    @Test
    void whenGetThenSuccess() {
        for (int i = 0; i < DATA.length; i++) {
            assertEquals(DATA[i], arrayList.get(i));
        }
    }

    @Test
    void whenRemoveThenSuccess() {
        arrayList.remove(1);

        String expected = "{ 325, 10, 239, 692 }";
        assertEquals(expected, arrayList.toString());
    }

    @Test
    void whenSizeThenSuccess() {
        assertEquals(DATA.length, arrayList.size());
    }
}
