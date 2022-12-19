package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void test(String[] args) {
        try {
            List<String> list = readFromFile("./src/main/resources/myfile.txt");
            for(int i=0;i<list.size();i++){
                String line = list.get(i);
                System.out.println("line list2 "+i+": "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static List<String> readFromFile(String path)
            throws IOException {
        // StringBuilder ist sowas wie eine Liste. Hier kannst du alle Strings anhängen.
        BufferedReader br = null;
        //List<String> list = ?
        // try finally => finally ist wie ein Auffangnetz, der immer ausgefuert wird
        try {
            //File Objekt und InputStream Anlegen und BufferedReader erstellen
            
            //mit BufferedReader Zeile für Zeile lesen per while loop
            
        } finally {
            // wird immer ausgeführt, bei Fehler im Try-Block oder wenn der Try-Block
            // verlassen wird
            //bufferedReader wieder schließen per Close-Methode
        }
        return null;
    }

}