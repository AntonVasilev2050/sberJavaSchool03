package Theme02.Task1To6;

import java.util.Comparator;

public class StringLengthSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
