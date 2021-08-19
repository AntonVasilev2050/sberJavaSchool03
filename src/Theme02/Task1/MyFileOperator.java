package Theme02.Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFileOperator {
    public ArrayList<String> create() {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку или \"Выход\" чтобы закончить ");
        String line = scanner.nextLine();
        while (!line.equals("Выход")) {
            list.add(line);
            line = scanner.nextLine();
        }
        return list;
    }

    public ArrayList<String> load(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static void main(String[] args) {
        MyFileOperator myFileOperator = new MyFileOperator();
        List<String> list = myFileOperator.load("text.txt");
        list.forEach(System.out::println);
    }

}
