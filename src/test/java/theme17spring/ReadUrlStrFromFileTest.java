package theme17spring;

import org.junit.Test;

import java.util.List;

public class ReadUrlStrFromFileTest {
    ReadUrlStrFromFile readUrlStrFromFile = new ReadUrlStrFromFileImpl();
    String weblinks = "src\\main\\java\\theme17spring\\weblinks.txt";

    @Test
    public void read() {
        List<String> list;
        list = readUrlStrFromFile.read(weblinks);
        System.out.println(list);
    }
}