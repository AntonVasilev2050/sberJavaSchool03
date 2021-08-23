package Theme02.Task1To6;
// Got this from: https://askdev.ru/q/iteraciya-po-spisku-v-obratnom-poryadke-v-java-dublikat-7532/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseIterator<T> implements Iterator<String>, Iterable<String> {

    private final List<String> list;
    private int position;

    public ReverseIterator(List<String> list) {
        this.list = list;
        this.position = list.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public String next() {
        return list.get(position--);
    }

//    @Override
//    public void remove() {
//        throw new UnsupportedOperationException();
//    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//
//        for (String s : new ReverseIterator<String>(list)) {
//            System.out.println(s);
//        }
//    }
}





