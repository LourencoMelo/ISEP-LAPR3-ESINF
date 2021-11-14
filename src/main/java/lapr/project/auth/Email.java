package lapr.project.auth;
import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    private String mail;

    public Email(String email) {
        if (validate(email)) this.mail = email;
    }

    private boolean validate(String email) {
        if (email.isEmpty()) return false;

        return checkFormat(email);
    }

    private boolean checkFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.mail.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

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
        Email obj = (Email) o;
        return Objects.equals(this.mail, obj.mail);
    }

    @Override
    public String toString() {
        return String.format("%s", this.mail);
    }
}
