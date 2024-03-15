import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generate_tab {

    public Generate_tab(int n, String filename) {
        create_file(filename);

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            write_in_file(filename, random.nextInt(50));
        }
    }

    public void create_file(String file_name) {
        try {
            File myObj = new File(file_name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                myObj.delete();
                myObj.createNewFile();
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void write_in_file(String file_name, int nb) {
        try {
            FileWriter myWriter = new FileWriter(file_name, true); // true for append mode
            myWriter.write(Integer.toString(nb) + " ");
            myWriter.close();
            System.out.println("Successfully wrote to the file : " + nb);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int taille = 20; //Defaut
        if (args.length > 0)
        {
            taille = Integer.parseInt(args[0]);
        }
        new Generate_tab(taille, "tab.txt");
    }

}
