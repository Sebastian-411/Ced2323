package model.bst.treeAVL;

public interface ITreeAVL<K extends Comparable<K>, T> {
    void insert(NodeAVL<K, T> root);
    void delete();
    void leftRotate(NodeAVL<K, T> x);
    void rightRotate(NodeAVL<K, T> x);
    void rebalanceNode();
}
