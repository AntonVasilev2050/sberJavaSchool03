package Theme02.Task1To6;

import java.io.*;
import java.util.*;

public class MyFileOperator {

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

    //  Задание 1: Подсчитайте количество различных слов в файле.
    public static int wordCount(String fileName) {
        List<String> list = load(fileName);
        Set<String> set = new TreeSet<>();
        for (String l : list) {
            StringTokenizer tokenizer = new StringTokenizer(l, " -,.!?:;%&#");
            String word;
            while (tokenizer.hasMoreTokens()) {
                word = tokenizer.nextToken();
                set.add(word);
            }
        }
        return set.size();
    }

    //  Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
    public static void printSortedByLength(String fileName) {
        List<String> list = load(fileName);
        Set<String> set = new TreeSet<>();
        for (String l : list) {
            StringTokenizer tokenizer = new StringTokenizer(l, " -,.!?:;%&#");
            String word;
            while (tokenizer.hasMoreTokens()) {
                word = tokenizer.nextToken();
                set.add(word);
            }
        }
        ArrayList<String> listOfWords = new ArrayList<>(set);
        Comparator<String> comparator = new StringLengthSort();
        listOfWords.sort(comparator);
        listOfWords.forEach(System.out::println);
    }

    //  Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
    public static void printWordFrequency(String fileName) {
        List<String> list = load(fileName);
        ArrayList<String> listOfWords = new ArrayList<>();
        for (String l : list) {
            StringTokenizer tokenizer = new StringTokenizer(l, " -,.!?:;%&#");
            String word;
            while (tokenizer.hasMoreTokens()) {
                word = tokenizer.nextToken();
                listOfWords.add(word);
            }
        }
        TreeSet<String> setOfWords = new TreeSet<>(listOfWords);
        for (String s : setOfWords) {
            System.out.println(s + "  -  " + Collections.frequency(listOfWords, s));
        }
    }

    //  Задание 4: Выведите на экран все строки файла в обратном порядке.
    public static void printReversedStrings(String fileName) {
        List<String> list = load(fileName);
        for (String l : list) {
            StringBuilder builder = new StringBuilder(l);
            System.out.println(builder.reverse());
        }
    }

    //  Вывод строк файла в обратном порядке
    public static void printFileReverseOrder(String fileName) {
        List<String> list = load(fileName);
        List<String> reversedList = new ArrayList<>();
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            reversedList.add(listIterator.previous());
        }
        reversedList.forEach(System.out::println);
    }

    //  Вывод строк файла в обратном порядке. Версия 2.
    public static void printFileReverseOrderV2(String fileName) {
        List<String> list = load(fileName);
        Collections.reverse(list);
        list.forEach(System.out::println);
    }

//  Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
        public static void printSelfMadeReverseIterator (String fileName){
            List<String> list = load(fileName);
            for (String l : new ReverseIterator<String>(list)) {
                System.out.println(l);
            }
        }

//  Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        public static void printLineByNumber (String fileName){
            List<String> list = load(fileName);
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nВведите номер строки в диапазоне от 1 до " + list.size() + ": ");
            try {
                int stringNumber = scanner.nextInt();
                while (!(stringNumber < 1) && !(stringNumber > list.size())) {
                    System.out.println(list.get(stringNumber - 1));
                    System.out.print("\nВведите еще один номер строки ");
                    stringNumber = scanner.nextInt();
                }
                System.out.println("Ошибка ввода!");
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }
        }


        public static void main (String[]args){
            String fileName = "text.txt";
            load(fileName).forEach(System.out::println);
            System.out.println("\nЧисло РАЗЛИЧНЫХ слов в файле = " + MyFileOperator.wordCount(fileName));

            System.out.println("\nСписок различных слов файла, отсортированный по возрастанию их длины: ");
            printSortedByLength(fileName);

            System.out.println("\nЧисло повторений каждого слова в файле: ");
            printWordFrequency(fileName);

            System.out.println("\nСтроки файла от конца к началу строки:");
            printReversedStrings(fileName);

            System.out.println("\nСтроки файла в обратном порядке:");
            printFileReverseOrder(fileName);

            System.out.println("\nСтроки файла в обратном порядке версия 2:");
            printFileReverseOrderV2(fileName);

            System.out.println("\nСамодельный итератор в обратном порядке:");
            printSelfMadeReverseIterator(fileName);

            printLineByNumber(fileName);
        }

    }
