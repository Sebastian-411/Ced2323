package model.bst.treeAVL;


import model.bst.binaryTreeAncestor.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeAVL<K extends Comparable<K>,T> {
    private NodeAVL<K, T> root;

    public void insert(NodeAVL<K, T> x) {
        if ( root == null ){
            root = x;
        } else {
            insert(root, x);
        }

    }

    private void insert(NodeAVL<K, T> f, NodeAVL<K, T> nodeToInsert) {
        NodeAVL<K,T> father = null;
        NodeAVL<K,T> temporalFather = root;

        while (temporalFather != null){
            father = temporalFather;
            if (nodeToInsert.getKey().compareTo(temporalFather.getKey()) < 0) temporalFather = temporalFather.getLeft();
            else temporalFather = temporalFather.getRight();
        }

        if (nodeToInsert.getKey().compareTo(father.getKey()) < 0 ) father.setLeft(nodeToInsert);
        else father.setRight(nodeToInsert);
        nodeToInsert.setFather(father);
        rebalanceAVL(nodeToInsert);
    }

    public void delete(K key) {
        if ( root == null ){
            System.out.println("Arbol vacio");
            return;
        }

        NodeAVL<K, T> toDelete = search(key);
        if ( toDelete == null ){
            return;
        }
        NodeAVL<K, T> temporalToDelete;
        NodeAVL<K, T> connection;

        if ( toDelete.getRight() == null || toDelete.getLeft() == null ) temporalToDelete = toDelete;
        else temporalToDelete = succesor(toDelete);

        if ( temporalToDelete.getLeft() != null ) connection = temporalToDelete.getLeft();
        else connection = temporalToDelete.getRight();

        if ( connection != null ) connection.setFather(temporalToDelete.getFather());

        if ( temporalToDelete.getFather() == null ){
            root.setKey(connection.getKey());
            root.setValue(connection.getValue());
        } else {
            if ( temporalToDelete == temporalToDelete.getFather().getLeft() )
                temporalToDelete.getFather().setLeft(connection);
            else temporalToDelete.getFather().setRight(connection);
        }

        if ( temporalToDelete != toDelete ){
            toDelete.setKey(temporalToDelete.getKey());
            toDelete.setValue(temporalToDelete.getValue());
        }
        rebalanceAVL(toDelete);
    }


    private void leftRotate(NodeAVL<K, T> current) {
        NodeAVL<K, T> tem = null;
        if (current.getRight().getLeft() != null ) tem = current.getRight().getRight();
        // Asignar padre
        if (current.getFather() == null) root = current.getRight();
        else {
            if (current.getFather(). getRight() == current) current.getFather().setRight(current.getRight());
            else current.getFather().setLeft(current.getRight());
        }

        current.getRight().setFather(current.getFather());
        current.setFather(current.getRight());
        current.getFather().setLeft(current);

        current.setRight(tem);
    }

    private void rightRotate(NodeAVL<K, T> current) {
        NodeAVL<K, T> tem = null;

        if (current.getLeft().getRight() != null ) tem = current.getLeft().getRight();

        if (current.getFather() == null) root = current.getLeft();
        else {
            if (current.getFather(). getRight() == current) current.getFather().setRight(current.getLeft());
            else current.getFather().setLeft(current.getLeft());
        }

        current.getLeft().setFather(current.getFather());
        current.setFather(current.getLeft());
        current.getFather().setRight(current);

        current.setLeft(tem);
    }

    private void rebalanceAVL(NodeAVL<K, T> x) {
        NodeAVL<K,T> current = x;
        while (current != null){
            if(Math.abs((current.balanced())) > 1){
                if ((current.balanced()) > 0){

                    if (current.getRight().balanced() == 1){
                        leftRotate(current);
                    } else if (current.getRight().balanced() == -1) {
                        rightRotate(current.getRight());
                        leftRotate(current);
                    } else {
                        leftRotate(current);
                    }

                } else { //rightRotation
                    if ((current.getLeft()).balanced() == 1){
                        leftRotate(current.getLeft());
                        rightRotate(current);
                    } else if ((current.getLeft()).balanced() == -1) {
                        rightRotate(current);
                    } else {
                        rightRotate(current);
                    }
                }
            }

            current = current.getFather();
        }
    }

    public String inOrden() {
        if ( root == null ){
            return null;
        } else {
            return inOrden(root);
        }
    }

    private String inOrden(NodeAVL<K, T> x) {
        if ( x != null ){
            return inOrden(x.getLeft()) + x.getKey() + inOrden(x.getRight());
        }
        return "";
    }

    public NodeAVL<K, T> search(K key) {
        if ( root == null ){
            return null;
        } else {
            return search(root, key);
        }
    }

    private NodeAVL<K, T> search(NodeAVL<K, T> x, K keyS) {
        if ( x == null ){
            return null;
        } else if ( x.getKey().equals(keyS) ){
            return x;
        } else {
            if ( keyS.compareTo(x.getKey()) < 0 ){
                return search(x.getLeft(), keyS);
            } else {
                return search(x.getRight(), keyS);
            }
        }
    }

    public NodeAVL<K, T> minimun(NodeAVL<K, T> x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    public NodeAVL<K, T> maximum(NodeAVL<K, T> x) {
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }

    public NodeAVL<K, T> succesor(NodeAVL<K, T> x) {
        if ( x.getRight() != null ){
            return minimun(x.getRight());
        } else {
            return minimun(x.getLeft());
        }
    }

    public String levels() {
        if(root == null) return "Arbol vacio";
        String txt = "";
        Queue<NodeAVL<K,T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeAVL<K,T> node = queue.poll();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            txt += node.getValue() + " ";

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return txt;
    }
}
