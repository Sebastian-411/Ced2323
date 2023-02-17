package model;

public class Node {
    private Node next;
    private Node previous;
    private int attribute;

    private int timesCalled;


    // getters, setters and constructor

    public Node(int attribute) {
        this.attribute = attribute;
        this.timesCalled = 0;
    }


    public int getTimesCalled() {
        return timesCalled;
    }

    public void setTimesCalled(int timesCalled) {
        this.timesCalled = timesCalled;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
