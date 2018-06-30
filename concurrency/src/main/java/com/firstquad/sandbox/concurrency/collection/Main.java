package com.firstquad.sandbox.concurrency.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by dmitriy on 02.05.17.
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Collection<String> syncList = Collections.synchronizedCollection(list);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);

        ConcurrentSkipListMap skipListMap = new ConcurrentSkipListMap();

        ArrayList<Object> list1 = new ArrayList<>();
        Collections.synchronizedList(list1);
    }
}
