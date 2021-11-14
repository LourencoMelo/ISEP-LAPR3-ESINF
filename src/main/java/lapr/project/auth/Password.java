package lapr.project.auth;
import java.security.SecureRandom;
import java.util.Objects;

public class Password {
    private final String pass;

    public Password(String password) {
        if (!validate(password)) throw new IllegalArgumentException("Invalid Email Address.");
        this.pass = generateRandomPassword(9);
    }

    // Method to generate a random alphanumeric password of a specific length
    public static String generateRandomPassword(int len) {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    private boolean validate(String password) {
        return !password.isEmpty();
    }

    public boolean checkPassword(String pwd) {
        return !pwd.isEmpty();

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 7 * hash + this.pass.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Password obj = (Password) o;
        return Objects.equals(this.pass, obj.pass);
    }
}
