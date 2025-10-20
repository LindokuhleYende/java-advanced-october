package Tutorials.InputOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {
        String[] names = {"Lee Devs", "Lindokuhle", "Yende", "Siphosami"};

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Ohh Lindo, it's a beautiful Monday");
            for (String name : names){
                writer.write("\n" + name);


            }
            writer.close();

        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
