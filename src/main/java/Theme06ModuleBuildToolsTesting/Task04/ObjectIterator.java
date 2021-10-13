package Theme06ModuleBuildToolsTesting.Task04;

import java.util.Iterator;

public class ObjectIterator implements Iterator<Object>{
    private final Object[] objects;
    private int pos;

    public ObjectIterator(Object[] objects){
        this.objects = objects;
    }

    @Override
    public boolean hasNext()  {
        return pos < objects.length;
    }

    @Override
    public Object next() {
        return objects[pos++];
    }

    @Override
    public void remove() {
        objects[pos] = null;
    }

    public static void main(String[] args) {
        Object[] objects = new Object[5];
        objects[0] = new Cat("Barsik", 3);
        objects[1] = new Cat("Murka", 1);
        objects[2] = new Cat("Tom", 9);
        objects[3] = new Cat("Seriy", 1);
        objects[4] = new Cat("Nika", 2);
        ObjectIterator iterator = new ObjectIterator(objects);
//        for (Object o: objects){
//            if(iterator.hasNext()){
//                System.out.println(iterator.next());;
//            }
//        }
    }
}

