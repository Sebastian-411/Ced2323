package model;

public class CircularList {
    private Node head;
    private Node actualTurn;

    // Continue turn
    public void continueTurn(){
        Node tmp = actualTurn.getNext();
        deleteNode(actualTurn.getAttribute());
        actualTurn = tmp;
    }

    // Skip turn
    public void skip(){
        Node tmp;
        actualTurn.setTimesCalled(actualTurn.getTimesCalled() + 1);
        if(actualTurn.getTimesCalled() == 3){
            tmp = actualTurn.getNext();
            deleteNode(actualTurn.getAttribute());
            actualTurn = actualTurn.getNext();
            return;
        }
        actualTurn = actualTurn.getNext();
    }


    // edit node
    public void editNode(int goal, int edit){
        editNode(searchNode(head, goal), edit);
    }

    private void editNode(Node node, int edit){
        if(node != null){
            node.setAttribute(edit);
        }
    }

    // print circular list
    public String print(){
        return (head != null) ? print(head) : " ";
    }

    private String print(Node node){
        if(node.getNext() == head){
            return String.valueOf(node.getAttribute());
        } else {
            return node.getAttribute() + ", " + print(node.getNext());
        }
    }
    // Search node
    private Node searchNode(Node node, int goal){
        if(node == head){
            if ( node.getAttribute() == (goal) ){
                return node;
            }
        }
        if(node.getNext() != head){
            if ( node.getAttribute() == (goal) ){
                return node;
            } else {
                return searchNode(node.getNext(), goal);
            }
        } else{
            return null;
        }
    }
    // add node
    public void addNode(Node node){
        if(head==null){
            actualTurn = node;
            head = node;
            node.setNext(head);
            node.setPrevious(head);
        } else {
            head.getPrevious().setNext(node);
            node.setNext(head);
            node.setPrevious(head.getPrevious());
            head.setPrevious(node);
        }
    }

    // delete
    public void deleteNode(int goal){
        if(head != null){
            deleteNode(searchNode(head, goal));
        }
    }
    private void deleteNode(Node node){
        if (node != null){
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            if ( node == head ){
                if(head.getPrevious() == node && head.getNext() == node){
                    head = null;
                    return;
                }
                head = node.getNext();
            }
        }
    }

    // getters and setter


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getActualTurn() {
        return actualTurn;
    }

    public void setActualTurn(Node actualTurn) {
        this.actualTurn = actualTurn;
    }

}
