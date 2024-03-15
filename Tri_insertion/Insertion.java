package Tri_insertion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Insertion {

    public Insertion(String filename, int size) {
        ArrayList<Integer> tab = read_file(filename, size);
        tab = tri_tab(tab);
        for (Integer i : tab) {
            System.out.println(i);
        }
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

    public ArrayList<Integer> tri_tab(ArrayList<Integer> tab) {
        for (int i = 1; i < tab.size(); i++) {
            int key = tab.get(i);
            int j = i-1;

            while (j>=0 && tab.get(j) > key) {
                tab.set((j+1), tab.get(j));
                j--;
            }
            tab.set((j+1), key);
        }

        return tab;
    }

    public static void main(String[] args) {
        new Insertion("tab.txt", Integer.parseInt(args[0]));
    }
}
