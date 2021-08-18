package Theme01;

import java.util.ArrayList;
import java.util.Scanner;

//1 •	Написать сортировку пузырьком или бинарный поиск элемента в массиве.
public class Homework01 {
    static ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList) {
        for (int i = arrayList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    int temp = arrayList.get(j + 1);
                    arrayList.set(j + 1, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }
        return arrayList;
    }

    static void printArray(ArrayList<Integer> list) {
        for (int el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

/*    или бинарный поиск элемента в массиве.
    в разработке)*/


/*     2   •	Реализовать конвертеры температуры.
    Считаем, что значения будут поступать по шкале Цельсия,
    конвертеры должны преобразовывать значение в свою шкалу.*/
    static double converter(double tempC, String scaleType) {
        double result = 0;
        switch (scaleType) {
            case "F": {
                result = tempC * 1.8 + 32;
                break;
            }
            case "K": {
                result = tempC + 273.15;
                break;
            }
        }
        return result;
    }

    static void smartConvertor() {
        System.out.println("\nConvertor C -> F, K demo");
        double tempC;
        String scaleType;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the type of scale yor need (F or K): ");
            scaleType = scanner.nextLine().toUpperCase();
            System.out.println("Enter the temperature in Celsius: ");
            tempC = Double.parseDouble(scanner.nextLine());
            System.out.println("The result is: ");
            System.out.println(Math.round(10 * converter(tempC, scaleType)) / 10.0 + "\u00B0" + scaleType);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input! Try again! ");
            smartConvertor();
        }
    }

    //Демонстрация
    public static void main(String[] args) {
//    1.
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : new int[]{5, -1, -33, 33, 10, 100, 100, 67, 0, 331, -90, 0, 22, 1}) {
            list.add(i);
        }
        System.out.println("Source array: ");
        printArray(list);
        bubbleSort(list);
        System.out.println("Sorted array: ");
        printArray(list);

//        2.
        smartConvertor();
    }

}
