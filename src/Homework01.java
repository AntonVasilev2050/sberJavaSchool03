import java.util.ArrayList;

public class Homework01 {
    static ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList){
        for (int i = arrayList.size() - 2; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arrayList.get(j) > arrayList.get(j + 1)){
                    int temp = arrayList.get(j + 1);
                    arrayList.set(j + 1, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }

        return arrayList;
    }

}
