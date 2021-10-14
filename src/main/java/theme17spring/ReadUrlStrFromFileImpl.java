package theme17spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadUrlStrFromFileImpl implements ReadUrlStrFromFile {
    @Override
    public List<String> read(String fileWithUrls) {
        List<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileWithUrls));
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
