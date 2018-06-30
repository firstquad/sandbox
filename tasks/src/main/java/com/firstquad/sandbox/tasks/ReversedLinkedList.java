package com.firstquad.sandbox.tasks;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class ReversedLinkedList {

    public static void main(String[] args) throws InterruptedException {
        OneDirectionList oneDirectionList = new OneDirectionList();
        oneDirectionList.addFIFO(1);
        oneDirectionList.addFIFO(2);
        oneDirectionList.addFIFO(3);
        OneDirectionList reversed = oneDirectionList.getReversed();
        System.out.println();
    }

    public static class OneDirectionList {
        public Node head;
        public Node tail;

        public class Node {
            public Object value;
            public Node nextValue;
        }

        public void addFIFO(Object value) {
            Node newNode = new Node();
            newNode.value = value;
            if (head == null) {
                head = newNode;
                tail = newNode;
                head.nextValue = tail;
            } else {
                tail.nextValue = newNode;
                tail = newNode;
            }
        }

        public void addLIFO(Object value) {
            Node newNode = new Node();
            newNode.value = value;
            if (head == null) {
                head = newNode;
                tail = newNode;
                head.nextValue = tail;
            } else {
                newNode.nextValue = head;
                head = newNode;
            }
        }

        public OneDirectionList getReversed() {
            if (head == null || head.nextValue == null)
                return this;
            OneDirectionList reversedList = new OneDirectionList();
            Node tmp = head;
            while (tmp != null) {
                reversedList.addLIFO(tmp.value);
                tmp = tmp.nextValue;
            }
            return reversedList;
        }
    }
}
