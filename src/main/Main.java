package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String NEW_LINE="\n";
    public static final String OPTION_EXIT="EXIT!!";
    public static final String ENTER_LINE_TEXT="Please enter new line and finish with enter. For Exit enter \""+OPTION_EXIT+"\":";
    public static final String ENTER_FILE_TEXT="Please enter the file name and finish with enter:";
    public static final String RESOURCE_PATH="./src/main/resources/";

    

    public static void main(String[] args) {
        String[] filesInDir = new File(RESOURCE_PATH).list();
        for (String file : filesInDir) {
            System.out.println("file in Dir: " + file);
        }

        try {
            List<String> list = readFromInputStreamJava8(RESOURCE_PATH+"myfile.txt");
            
            for(int i=0;i<list.size();i++){
                String line = list.get(i);
                System.out.println("line list1 "+i+": "+line);
            }

            List<String> list2 = readFromFileTryFinally(RESOURCE_PATH+"myfile.txt");
            for(int i=0;i<list2.size();i++){
                String line = list2.get(i);
                System.out.println("line list2 "+i+": "+line);
            }


            String option = "";
            String filenameToWrite = RESOURCE_PATH + readInput(ENTER_FILE_TEXT);
            while(!option.equals(OPTION_EXIT))
            {
                option = readInput(ENTER_LINE_TEXT);
                if(option!=null && option.length() > 0&& !option.equals(OPTION_EXIT)){
                    writeFile(filenameToWrite,option);
                }
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

    public static void writeFile(String path,String text){
         // Content to be assigned to a file
        // Custom input just for illustration purposes
 
        // Try block to check if exception occurs
        try {
 
            // Create a FileWriter object
            // to write in the file
            FileWriter fWriter = new FileWriter(
                path,true);
                
 
            // Writing into file
            // Note: The content taken above inside the
            // string
            fWriter.write(text+NEW_LINE);
 
            // Printing the contents of a file
            System.out.println(text);
 
            // Closing the file writing connection
            fWriter.close();
 
            
        }
 
        // Catch block to handle if exception occurs
        catch (IOException e) {
 
            // Print the exception
            e.printStackTrace();
        }
    
    }

    public static String readInput(String inputText) throws IOException{
        
        System.out.println(inputText);
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
 
        // Printing the read line
        System.out.println("Entered text:"+name);
        return name;
    }

}