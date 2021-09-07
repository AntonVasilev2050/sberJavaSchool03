import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class AuthorizationTest {

    @Test
    public void signIn() {
        Authorization authorization = Mockito.mock(Authorization.class);
        Mockito.spy(Authorization.class);
        String[] credentials = {"test", "12345"};
        Mockito.when(authorization.signIn()).thenReturn(credentials);
        System.out.println(Arrays.toString(authorization.signIn()));
        Assertions.assertArrayEquals(credentials, authorization.signIn());
    }
}