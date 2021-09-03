package Theme06ModuleBuildToolsTesting.Task04;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ObjectIteratorTest {
    private ObjectIterator iterator;
    private Object[] objects;

    @Before
    public void setUp() {
        objects = new Object[5];
        objects[0] = new Cat("Barsik", 3);
        objects[1] = new Cat("Murka", 1);
        objects[2] = new Cat("Tom", 9);
        objects[3] = new Cat("Seriy", 1);
        objects[4] = new Cat("Nika", 2);
        iterator = new ObjectIterator(objects);
    }

    @Test
    public void hasNext()  {
        boolean result;
        for (int i = 0; i < objects.length; i++) {
            result = iterator.hasNext();
            assertTrue(result);
        }
    }

    public void DoesNotHaveNext()  {
        boolean result;
        for (int i = objects.length; i < objects.length + 5; i++) {
            result = iterator.hasNext();
            assertFalse(result);
        }
    }

    @Test
    public void next() {
        Object o = iterator.next();
        assertEquals(objects[0], o);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invokeNextWhenDoesNotHaveNextThenTrowException(){
        while (iterator.hasNext()){
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void remove() {
    }
}