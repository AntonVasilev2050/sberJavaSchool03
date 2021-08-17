import java.util.ArrayList;

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

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : new int[]{5, -1, -33, 33, 10, 100, 100, 67, 0, 331, -90, 0, 22, 1}) {
            list.add(i);
        }
        System.out.println("Source array: ");
        printArray(list);
        bubbleSort(list);
        System.out.println("Sorted array: ");
        printArray(list);
    }

}
