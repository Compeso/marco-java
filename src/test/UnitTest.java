package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import main.Main;

public class UnitTest {

    @Test
    public void testReadFromFile() throws IOException {
        //String[] files = new File("..").list();
        //String absPath = new File("..").getAbsolutePath();
        List<String> list = Main.readFromFile("./bin/test/resources/myfile.txt");
        
        assertTrue(list.size() == 3);
        assertEquals("erste linie", list.get(0));
        assertEquals("zweite linie", list.get(1));
        assertEquals("dritte linie", list.get(2));
    }

}
