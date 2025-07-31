import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    void testAddAndGet() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        Assertions.assertEquals("apple", list.get(0));
        Assertions.assertEquals("banana", list.get(1));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        list.remove(Integer.valueOf(20));
        Assertions.assertEquals(Arrays.asList(10, 30), list);
    }

    @Test
    void testContainsAndSet() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Assertions.assertTrue(list.contains("b"));
        list.set(1, "z");
        Assertions.assertEquals(Arrays.asList("a", "z", "c"), list);
    }

    @Test
    void testReverseList() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.reverse(list);
        Assertions.assertEquals(Arrays.asList(3, 2, 1), list);
    }

    @Test
    void testSortNaturalOrder() {
        List<String> list = new ArrayList<>(Arrays.asList("banana", "apple", "cherry"));
        Collections.sort(list);
        Assertions.assertEquals(Arrays.asList("apple", "banana", "cherry"), list);
    }

    @Test
    void testCustomSortByLength() {
        List<String> list = new ArrayList<>(Arrays.asList("apple", "kiwi", "banana"));
        list.sort(Comparator.comparingInt(String::length));
        Assertions.assertEquals(Arrays.asList("kiwi", "apple", "banana"), list);
    }

    @Test
    void testStreamFilterAndCollect() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evens = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Assertions.assertEquals(Arrays.asList(2, 4), evens);
    }

    @Test
    void testMapToLength() {
        List<String> list = Arrays.asList("a", "abcd", "xyz");
        List<Integer> lengths = list.stream().map(String::length).collect(Collectors.toList());
        Assertions.assertEquals(Arrays.asList(1, 4, 3), lengths);
    }

    @Test
    void testSublist() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> sub = list.subList(1, 4);  // 20,30,40
        Assertions.assertEquals(Arrays.asList(20, 30, 40), sub);
    }

    @Test
    void testNestedListAccess() {
        List<List<Integer>> matrix = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4)
        );
        Assertions.assertEquals(3, matrix.get(1).get(0));
    }

    @Test
    void testDistinctElements() {
        List<String> list = Arrays.asList("a", "b", "a", "c", "b");
        List<String> unique = list.stream().distinct().collect(Collectors.toList());
        Assertions.assertEquals(Arrays.asList("a", "b", "c"), unique);
    }

    @Test
    void testEmptyAndNullHandling() {
        List<String> list = new ArrayList<>();
        Assertions.assertTrue(list.isEmpty());

        list.add(null);
        Assertions.assertNull(list.get(0));
    }

    @Test
    void testImmutableList() {
        List<Integer> immutable = List.of(1, 2, 3);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> immutable.add(4));
    }
}