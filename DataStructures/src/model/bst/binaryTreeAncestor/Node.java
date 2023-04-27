package model.bst.binaryTreeAncestor;

public class Node<T,K>{
    private T element;
    private K key;
    private Node<T, K> left;
    private Node<T, K> right;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<T, K> getLeft() {
        return left;
    }

    public void setLeft(Node<T, K> left) {
        this.left = left;
    }

    public Node<T, K> getRight() {
        return right;
    }

    public void setRight(Node<T, K> right) {
        this.right = right;
    }
}
