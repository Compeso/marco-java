package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import main.Main;

public class UnitTest {

    @Test
    public void testReadFromFileTryFinally() throws IOException {
        //String[] files = new File("..").list();
        //String absPath = new File("..").getAbsolutePath();
        List<String> list = Main.readFromFileTryFinally("./bin/test/resources/myfile.txt");
        
        assertTrue(list.size() == 3);
        assertEquals("erste linie", list.get(0));
        assertEquals("zweite linie", list.get(1));
        assertEquals("dritte linie", list.get(2));
    }

    @Test
    public void testReadFromInputStreamJava8() throws IOException {
        //aktueller Ordner check
        // String[] files = new File(".").list();
        //Unter-Ordner check
        // String[] files = new File("..").list();
        // for (String f:files){
        //     System.out.println("file: "+ f);
        // }
        //evtl. bin durch target oder ganz weg
        List<String> list = Main.readFromInputStreamJava8("./bin/test/resources/myfile.txt");
        
        assertTrue(list.size() == 3);
        assertEquals("erste linie", list.get(0));
        assertEquals("zweite linie", list.get(1));
        assertEquals("dritte linie", list.get(2));
    }

}
