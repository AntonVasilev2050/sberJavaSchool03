package Theme06ModuleBuildToolsTesting.Task04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectIteratorTest {
    private ObjectIterator iterator;
    private Object[] objects;

    @Before
    public void setUp() throws Exception {
        objects = new Object[5];
        objects[0] = new Cat("Barsik", 3);
        objects[1] = new Cat("Murka", 1);
        objects[2] = new Cat("Tom", 9);
        objects[3] = new Cat("Seriy", 1);
        objects[4] = new Cat("Nika", 2);
        iterator = new ObjectIterator(objects);
    }

    @Test
    public void hasNext() throws Exception {
        boolean result = false;
        for (int i = 0; i < objects.length; i++) {
            result = iterator.hasNext();
            assertTrue(result);
        }
    }

    @Test
    public void next() {

    }

    @Test
    public void remove() {
    }
}