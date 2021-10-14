package theme17spring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadUrlStrFromFileTest {
    ReadUrlStrFromFile readUrlStrFromFile = new ReadUrlStrFromFileImpl();
    String weblinks = "C:\\Users\\USER\\OneDrive\\BBdocuments\\IdeaProjects\\sberJavaSchool02\\src\\main\\java\\theme17spring\\weblinks.txt";

    @Test
    public void read() {
        List<String> list = new ArrayList<>();
        list = readUrlStrFromFile.read(weblinks);
        System.out.println(list);
    }
}