package model.bst.treeAVL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Executable {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        TreeAVL<Integer, Integer> treeAVL = new TreeAVL<>();
        int s;
        for (int i = 0; i < 10; i++){
            s = sc.nextInt();
            treeAVL.insert(new NodeAVL<>(s, s));
            System.out.println(treeAVL.levels());
        }

    }
    public void xd(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("operaciones.txt"));
            int n = Integer.parseInt(br.readLine());
            TreeAVL<Integer, Integer> avlTree = new TreeAVL<>();
            for (int i = 0; i < n; i++) {
                String[] operation = br.readLine().split(" ");
                int type = Integer.parseInt(operation[0]);
                int element = Integer.parseInt(operation[1]);
                if (type == 1) {
                    avlTree.insert(new NodeAVL<>(element, element));
                } else if (type == 2) {
                    avlTree.delete(element);
                }
                System.out.println(avlTree.toString());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
