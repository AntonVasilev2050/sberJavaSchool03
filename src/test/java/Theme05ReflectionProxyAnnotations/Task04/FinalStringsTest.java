package Theme05ReflectionProxyAnnotations.Task04;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class FinalStringsTest {

    @Test
    public void check() throws IllegalAccessException {
        Week week = new Week();
        FinalStrings finalStrings = Mockito.mock(FinalStrings.class);
        Mockito.when(finalStrings.check(week)).thenReturn(true);

        boolean mockitoCheck = finalStrings.check(week);
        boolean realCheck = new FinalStrings().check(week);
        assertTrue(mockitoCheck);
        assertFalse(realCheck);
    }
}