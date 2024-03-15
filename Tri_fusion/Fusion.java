package Tri_fusion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fusion {

    public Fusion(String filename, int size) {
        ArrayList<Integer> tab = read_file(filename, size);
        sous_tri_fusion(tab, 0, size);
        for (Integer i : tab) {
            System.out.println(i);
        }
    }

    public void sous_tri_fusion(ArrayList<Integer> tab, int p, int r) {
        if (p < r -1) {
            int q = (p+r) / 2;
            sous_tri_fusion(tab, p, q);
            sous_tri_fusion(tab, q, r);
            fusion(tab, p, q, r);
        }
    }

    public void fusion(ArrayList<Integer> tab, int p, int q, int r) {
        int n1 = q-p;
        int n2 = r-q;

        ArrayList<Integer> tabG = new ArrayList<>(n1);
        ArrayList<Integer> tabD = new ArrayList<>(n2);

        copy_tab(tab, tabG, p, q);
        copy_tab(tab, tabD, q, r);

        int indG = 0;
        int indD = 0;

        int i = p;

        while(i < r) {
            if (indG == n1) {
                tab.set(i, tabD.get(indD));
                indD++;
            } else if (indD == n2) {
                tab.set(i, tabG.get(indG));
                indG++;
            } else if (tabG.get(indG) < tabD.get(indD)) {
                tab.set(i, tabG.get(indG));
                indG++;
            } else {
                tab.set(i, tabD.get(indD));
                indD ++;
            }
            i++;
        }
    }

    public void copy_tab(ArrayList<Integer> tab1, ArrayList<Integer> tab2, int borne1, int borne2) {
        for (int i = borne1; i < borne2; i++) {
            tab2.add(tab1.get(i));
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

    public static void main(String[] args) {
        new Fusion("tab.txt", Integer.parseInt(args[0]));
    }

}
