package com.firstquad.sandbox.tasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class CollectionsAPI {

    @Test
    public void all() throws Exception {
        List emptyList = Collections.EMPTY_LIST;

        List<String> list = new ArrayList<>();
        Collections.singleton(list);
        Collections.synchronizedCollection(list);
        Collections.unmodifiableCollection(list);
        Collections.checkedList(list, String.class);
        Collections.emptyList();

        Collections.binarySearch(new ArrayList<>(), 1);
        Collections.synchronizedList(list);
        Collections.sort(list);
        Collections.reverse(list);
        Collections.reverseOrder();
        Collections.shuffle(list);
        list.add("1");
        list.add("2");
        Collections.swap(list, 0, 1);
        Collections.fill(list, "1");
        Collections.copy(list, list);
        Collections.rotate(list, 1);
        Collections.indexOfSubList(list, list);
        Collections.nCopies(10, "test");
        Collections.frequency(list, "test");
        Collections.disjoint(list, list);
    }
}
