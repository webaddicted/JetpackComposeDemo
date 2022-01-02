package com.webaddicted.jetpackcomposedemo;

import android.util.Log;

class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void test() {
        LinkedList test = new LinkedList();
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insertFirst(1);
        test.insertLast(5);
        test.getLength();
        test.findItem(5);
//        test.reverseInPair();
        test.findMidElement();
//        test.reverse();
//        test.reverseLeftAndRightFromMid();
        test.printNthFromLast(test.head, 2);
    }

    void reverseLeftAndRightFromMid() {
        Node midNode = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            midNode = midNode.next;
        }
        Log.d("TAG", "Mid Node : " + midNode.data);
        Node pre = null;
        Node current = head;
        Node next = null;
        while (current != null && current != midNode) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        Node leftReverseLinkedList = pre;
        Log.d("TAG", "Reverse Left Node From Mid : ");
        display(leftReverseLinkedList);
        pre = null;
        current = midNode;
        next = null;
        while (midNode != null) {
            next = midNode.next;
            midNode.next = pre;
            pre = midNode;
            midNode = next;
        }
        Node rightReverseLinkedList = pre;
        Log.d("TAG", "Reverse Right Node From Mid : ");
        display(rightReverseLinkedList);

        Node finalLinkedList = null;
//        while (leftReverseLinkedList.next != null) {
//            if (finalLinkedList == null) {
//                finalLinkedList = new Node(leftReverseLinkedList.data);
//            } else {
//                finalLinkedList.next = new Node(leftReverseLinkedList.data);
//            }
//            leftReverseLinkedList = leftReverseLinkedList.next;
//        }
//        while (rightReverseLinkedList != null) {
//            if (finalLinkedList == null) {
//                finalLinkedList = new Node(rightReverseLinkedList.data);
//            } else {
//                finalLinkedList.next = new Node(rightReverseLinkedList.data);
//            }
//            rightReverseLinkedList = rightReverseLinkedList.next;
//        }
        display(finalLinkedList);
    }

    void insert(int data) {
        Node node = new Node(data);
        Node current = head;
        if (current == null) {
            head = node;
        } else {
            while (current != null) {
                if (current.next == null) {
                    current.next = node;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
        Log.d("TAG", "Insert : " + data);
        display();
    }

    void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        Log.d("TAG", "Insert First Pointer : " + data);
        display();
    }

    void insertLast(int data) {
        Node newNode = new Node(data);
        Node current = head;
        while (current != null) {
            if (current.next == null) {
                current.next = newNode;
                break;
            } else {
                current = current.next;
            }
        }
        Log.d("TAG", "Insert Last Pointer : " + data);
        display();
    }

    void printNthFromLast(Node head, int n) {
        Node pre = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        current = pre;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                Log.d("TAG", "Last " + n + " item is : " + current.data);
                break;
            } else {
                current = current.next;
            }
        }
    }

    void getLength() {
        Node current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        Log.d("TAG", "Size of LinkedList : " + count);
        Log.d("TAG", ".");
    }

    void findItem(int data) {
        Node current = head;
        int index = 0;
        boolean isElementFound = false;
        while (current != null) {
            index++;
            if (current.data == data) {
                isElementFound = true;
                break;
            } else {
                current = current.next;
            }
        }
        if (isElementFound) {
            Log.d("TAG", ("Element : " + data) + " Found at index : " + index);
        } else {
            Log.d("TAG", ("Element : " + data) + " Not Found");
        }
    }

    void findMidElement() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Log.d("TAG", "LinkedList Mid Element : " + slow.data);
        Log.d("TAG", ".");
    }

    void reverseLinkedList() {
        //        1>2>3>4
        Node pre = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;//2
            current.next = pre;//null
            pre = current;//1
            current = next;//2
        }
        head = pre;
        Log.d("TAG", "Reverse Linked List : ");
        display();
        //        In this way we reverse pointer
        //        after every iteration current and next move at next position

        //       List - 1>2>3>4
        //       After 1st Iteration- null>1, 2>3>4
        //        After 2st Iteration- null<1<2, 3>4
        //        After 3st Iteration- null<1<2<3, 4
        //        After 4st Iteration- null<1<2<3<4
        //        finally O/P :  4>3>2>1>null
    }

    void reverseInPair() {
        Node current = head;
        while (current != null && current.next != null) {
            //            Swap Data in pair
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
        Log.d("TAG", "Reverse Data in Pair");
        display();
    }

    void display(Node node) {
        Node current = node;
        while (current != null) {
            Log.d("TAG", "Print LinkedList Item : " + current.data);
            current = current.next;
        }
        Log.d("TAG", "Complete Iteration : \n\n");
        Log.d("TAG", ".");
    }

    void display() {
        Node current = head;
        while (current != null) {
            Log.d("TAG", "Print LinkedList Item : " + current.data);
            current = current.next;
        }
        Log.d("TAG", "Complete Iteration : \n\n");
        Log.d("TAG", ".");
    }
}
