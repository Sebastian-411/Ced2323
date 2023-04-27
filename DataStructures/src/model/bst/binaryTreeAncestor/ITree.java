package model.bst.binaryTreeAncestor;

import model.bst.binaryTreeAncestor.Node;

public interface ITree<T, K> {
    void insert(T element, K key);
    String inOrden(T element);
    T search(K key);
    T minimun(Node<T, K> x);
    T maximum(Node<T, K> x);
    T succesor(Node<T, K> x);
    T delete(K key);
}
