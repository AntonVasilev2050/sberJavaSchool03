package Theme02.Task1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class MyFileOperator {

//    private ArrayList<String> stringArrayList;
//
//    public ArrayList<String> getStringArrayList() {
//        return stringArrayList;
//    }
//
//    public void setStringArrayList(ArrayList<String> stringArrayList) {
//        this.stringArrayList = stringArrayList;
//    }

    public static ArrayList<String> create() {
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

    public static ArrayList<String> load(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("-------!!!!!!------\nОшибка загрузки файла. Введите текст с клавиатуры ");
            list = create();
        }
        return list;
    }

    public static int wordCount(String fileName){
        List<String> list = load(fileName);
        int wordCount = 0;
        for (String s: list){
            wordCount += new StringTokenizer(s, " -,.!?:;%&#").countTokens();
        }
        return wordCount;
    }

    public static void printSortedByLength(String fileName){
        List<String> list = load(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: list){
            stringBuilder.append(s).append(" ");
        }
        String[] strings = stringBuilder.toString().replaceAll("[-,.!?:;%&#]", " ").split(" ");
        Arrays.sort(strings, Comparator.comparing(String::length));
        for (String s: strings){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        MyFileOperator.load("text.txt").forEach(System.out::println);
        System.out.println("\nОбщее число слов в файле = " + MyFileOperator.wordCount("text.txt"));
        printSortedByLength("text.txt");

    }

}
