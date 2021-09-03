import java.util.HashMap;

public interface SingOnSignIn {
    String[] askCredentials();  // login, pass
    String[] registration();  // login, pass, email
    void sendRegistrationEmail(String email);
}
