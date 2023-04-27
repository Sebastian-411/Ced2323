package model.bst.treeNario;

import java.util.ArrayList;

public class TreeNario<T>{

    private NodoNArio<T> root;



    public NodoNArio<T> buscar( T element ) {
        if ( root == null ){
            return null;
        } else {
            return root.search(element);
        }
    }

    public int giveWeight(){
        if(root ==  null){
            return 0;
        } else {
            return root.giveWeight();
        }
    }

    public int giveNumberLeaf(){
        if(root ==  null){
            return 0;
        } else {
            return root.giveNumberLeaf();
        }
    }

    public void insertElement(T ancestor, T descendant ) throws Exception{
        if(root == null){
            root = new NodoNArio<>(ancestor);
        } else {
            NodoNArio<T> ancestorTemp = buscar(ancestor);
            if ( ancestorTemp == null ){
                throw new Exception("Ancestor doesnt exist");
            } else {
                ancestorTemp.insertElement(descendant);
            }
        }
    }

    public void deleteElement(T element) throws Exception{
        if(root == null){
            throw new Exception("The three is empty");
        } else if(element.equals(root.getElem())){
            if(root.isLeaf()){
                root = null;
            } else {
                throw new Exception("Imposible delete");
            }
        } else {
            NodoNArio<T> ancestor = buscar(element);
            if(ancestor == null){
                throw new Exception("Nodo invalid");
            } else {
                ancestor.deleteElement(element);
            }
        }
    }

    public ArrayList<T> preOrden() throws Exception{
        if(root == null){
            throw new Exception("The tree is empty");
        } else {
            ArrayList<T> temp = new ArrayList<>();
            temp.add(root.getElem());
            temp.addAll(root.route());
;
            return temp;
        }
    }

    public ArrayList<T> postOrden() throws Exception{
        if(root == null){
            throw new Exception("The tree is empty");
        } else {
            ArrayList<T> temp = root.route();
            temp.add(root.getElem());
            return temp;
        }
    }
}
