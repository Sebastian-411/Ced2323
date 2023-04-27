package model.bst.binaryTreeAncestor;

public class BinaryTree<T, K extends Comparable<K>> implements ITree<T, K> {
    private Node<T,K> root;

    @Override
    public void insert(T element, K key) {
    }


    @Override
    public String inOrden(T element) {
        if(root==null){
            return null;
        } else {
            return inOrden(root);
        }
    }

    private String inOrden(Node<T, K> x){
        if(x != null){
            return inOrden(x.getLeft()) + x.getKey() +  inOrden(x.getRight());
        }
        return "";
    }

    @Override
    public T search(K key) {
        if(root == null){
            return null;
        } else {
            return search(root, key);
        }
    }
    private T search(Node<T, K> x, K keyS){
        if(x == null){
            return null;
        } else if ( x.getKey().equals(keyS) ){
            return x.getElement();
        } else {
            if ( keyS.compareTo(x.getKey()) < 0){
                return search(x.getLeft(), keyS);
            } else {
                return search(x.getRight(), keyS);
            }
        }
    }

    @Override
    public T minimun(Node<T, K> x) {
        while(x.getLeft()!=null){
            x = x.getLeft();
        }
        return x.getElement();
    }

    @Override
    public T maximum(Node<T, K> x) {
       while(x.getRight()!=null){
            x = x.getRight();
        }
        return x.getElement();
    }


    @Override
    public T succesor(Node<T, K> x) {
        if(x.getRight() != null ){
            return minimun(x.getRight());
        } else {
            return minimun(x.getLeft());
        }
    }

    @Override
    public T delete(K key) {
        return null;
    }
}
