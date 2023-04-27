package model.bst.treeNario;

import java.util.ArrayList;

public class NodoNArio<T>{
    private T elem;
    private ArrayList<NodoNArio<T>> descendents;

    public NodoNArio(T elem) {
        this.elem = elem;
    }


    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public ArrayList<NodoNArio<T>> getDescendents() {
        return descendents;
    }

    public void setDescendents(ArrayList<NodoNArio<T>> descendents) {
        this.descendents = descendents;
    }

    public boolean isLeaf(){
        return descendents.size() == 0;
    }

    public NodoNArio<T> search(T element){
        if(elem.equals(element)){
            return this;
        } else if ( isLeaf() ){
            return null;
        } else {
            for (int i = 0; i < descendents.size(); i++){
                NodoNArio<T> temp = descendents.get(i).search(element);
                if(temp != null){
                    return temp;
                }
            }
        }
        return null;
    }

    public int giveWeight(){
        if(isLeaf()){
            return 1;
        } else {
            int weightTotal = 1;
            for (int i = 0; i < descendents.size(); i++){
                weightTotal += descendents.get(i).giveWeight();
            }
            return weightTotal;
        }
    }

    public int giveNumberLeaf(){
        if ( isLeaf() ){
            return 1;
        } else {
            int numLeaf = 0;
            for (int i = 0; i < descendents.size(); i++){
                numLeaf += descendents.get(i).giveNumberLeaf();
            }
            return numLeaf;
        }
    }

    public int giveHeight(){
        if(isLeaf()){
            return 1;
        } else {
            int maxHeight = 0;
            for (int i = 0; i < descendents.size(); i++){
                NodoNArio<T> descendent = descendents.get(i);
                int tempHeight = descendent.giveHeight();
                maxHeight = Math.max(tempHeight, maxHeight);
            }
            return maxHeight + 1;
        }
    }

    public void insertElement(T element){
        descendents.add(new NodoNArio<T>(element));
    }

    public void deleteElement(T element) throws Exception{
        for (int i = 0; i < descendents.size(); i++){
            NodoNArio<T> descendent = descendents.get(i);
            if(descendent.getElem().equals(element) && descendent.isLeaf()){
                descendents.remove(i);
            } else {
                throw new Exception("No deletable");
            }
        }
    }

    public ArrayList<T> route(){
        ArrayList<T> temp = new ArrayList<>();
        temp.add(elem);
        if(!isLeaf()){
            for (int i = 0; i < descendents.size(); i++){
                temp.addAll(descendents.get(i).route());
            }
        }
        return temp;
    }
}
