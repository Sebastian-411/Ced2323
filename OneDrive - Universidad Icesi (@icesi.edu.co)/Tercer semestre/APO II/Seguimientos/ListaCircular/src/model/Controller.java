package model;

public class Controller {
    private CircularList circularList = new CircularList();
    public void addNodes(){
        Node temp;
        if (circularList.getHead() == null) {
            temp = new Node(1);
        } else {
            temp =new Node(circularList.getHead().getPrevious().getAttribute() +1);
        }
        circularList.addNode(temp);
    }

    public void editNode(int goal, int edit){
        circularList.editNode(goal, edit);
    }
    public String printNodes(){
        return circularList.print();
    }

    public void deleteNode(int goal){
        circularList.deleteNode(goal);
    }
    public String getTurn(){
        return "El turno actual es: "+ circularList.getActualTurn().getAttribute();
    }

    public void skipTurn(){
        circularList.skip();
    }

    public void continueTurn(){
        circularList.continueTurn();
    }

    public boolean thereAreTurns(){
        return circularList.getHead() != null;
    }
}
