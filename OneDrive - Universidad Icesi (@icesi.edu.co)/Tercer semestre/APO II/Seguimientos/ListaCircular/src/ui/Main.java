package ui;
import model.*;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Controller controller = new Controller();

    public static void main(String[] args) {
        Main m = new Main();
        while(true){
            System.out.println("1. Dar turno" );
            if(controller.thereAreTurns()){
                System.out.println("2. Mostrar turno actual\n" +
                        "3. Pasar turno\n" +
                        "4. Seguir\n" +
                        "5. Salir");
                System.out.println("Ingresa el numero de tu opcion");
                m.menu1();
            } else {
                System.out.println("No hay turnos, por lo tanto utiliza la opcion 1 para desbloquear mas opciones! O... \n2. Para salir!");
                System.out.println("Ingresa el numero de tu opcion");
                m.menu0();
            }
        }
    }

    public void menu1(){
        switch (sc.nextInt()){
            case 1:
                controller.addNodes();
                System.out.println("Asi queda la fila actual: \n" + controller.printNodes());
                break;
            case 2:
                System.out.println(controller.getTurn());
                break;
            case 3:
                controller.skipTurn();
                System.out.println(controller.printNodes());

                break;
            case 4:
                controller.continueTurn();
                System.out.println("Asi queda la fila actual: \n" + controller.printNodes());
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Ingresa una opcion valida!");
                break;
        }
    }

    public void menu0(){
        switch (sc.nextInt()){
            case 1:
                controller.addNodes();
                System.out.println("Asi queda la fila actual: \n" + controller.printNodes());
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Ingresa una opcion valida!");
                break;
        }
    }
}