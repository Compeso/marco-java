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
        System.out.println("Hello Worold!!");
        String[] filesInDir = new File("./src/main/resources").list();
        for (String file : filesInDir) {
            System.out.println("file in Dir: " + file);
        }

        try {
            List<String> list = readFromInputStreamJava8("./src/main/resources/myfile.txt");
            
            for(int i=0;i<list.size();i++){
                String line = list.get(i);
                System.out.println("line list1 "+i+": "+line);
            }

            List<String> list2 = readFromFileTryFinally("./src/main/resources/myfile.txt");
            for(int i=0;i<list2.size();i++){
                String line = list2.get(i);
                System.out.println("line list2 "+i+": "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> readFromInputStreamJava8(String path)
            throws IOException {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        List<String> list = new ArrayList<>();
        // try with resource => schließt die BufferReader automatisch nach dem Try block
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } // hier ist der unsichtbare Code. Hier wird der Buffered Reader geschlossen
        return list;
    }

    public static List<String> readFromFileTryFinally(String path)
            throws IOException {
        // StringBuilder ist sowas wie eine Liste. Hier kannst du alle Strings anhängen.
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        // try finally => finally ist wie ein Auffangnetz, der immer ausgefuert wird
        try {
            File file = new File(path);
            InputStream inputStream = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } finally {
            // wird immer ausgeführt, bei Fehler im Try-Block oder wenn der Try-Block
            // verlassen wird
            if (br != null) {
                br.close();
            }
        }
        return list;
    }

}