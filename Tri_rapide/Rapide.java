package Tri_rapide;

import Tri_fusion.Fusion;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Rapide {

    public Rapide(String filename, int size) {
        ArrayList<Integer> tab = read_file(filename, size);
        sousTriRapide(tab, 0, size);
        for (Integer i : tab) {
            System.out.println(i);
        }
    }

    public void sousTriRapide(ArrayList<Integer> tab, int p, int r) {
        if (p < r-1) {
            int q = partition(tab, p, r);
            sousTriRapide(tab, p, q);
            sousTriRapide(tab, q+1, r);
        }
    }

    public int partition(ArrayList<Integer> tab, int p, int r) {
        int pivot = tab.get(r-1);
        int i = p;
        for (int j = p; j < r-1; j++) {
            if (tab.get(j) <= pivot) {
                int temp = tab.get(i);
                tab.set(i, tab.get(j));
                tab.set(j, temp);
                i++;
            }
        }
        int temp = tab.get(i);
        tab.set(i, tab.get(r-1));
        tab.set(r-1, temp);
        return i;
    }

    public ArrayList<Integer> read_file(String filename, int nb) {
        ArrayList<Integer> tab = new ArrayList<>(nb);

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextInt()) {
                int data = myReader.nextInt();
                tab.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tab;
    }

    public static void main(String[] args) {
        new Rapide("./tab.txt", Integer.parseInt(args[0]));
    }

}
