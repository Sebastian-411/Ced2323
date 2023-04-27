package model.bst.treeAVL;
public class NodeAVL<K extends Comparable<K>, T>{
    private NodeAVL<K, T> father;
    private T value;
    private K key;
    private NodeAVL<K, T> left;
    private NodeAVL<K, T> right;

    public NodeAVL(T value, K key) {
        this.value = value;
        this.key = key;

    }

    public int balanced(){
        return height(right) - height(left);
    }

    public int height(NodeAVL<K, T> x){
        if(x == null){
            return 0;
        }
        return 1 + height(x.right) + height(x.left);
    }

    public NodeAVL<K, T> getFather() {
        return father;
    }

    public void setFather(NodeAVL<K, T> father) {
        this.father = father;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public NodeAVL<K, T> getLeft() {
        return left;
    }

    public void setLeft(NodeAVL<K, T> left) {
        this.left = left;
    }

    public NodeAVL<K, T> getRight() {
        return right;
    }

    public void setRight(NodeAVL<K, T> right) {
        this.right = right;
    }
}
