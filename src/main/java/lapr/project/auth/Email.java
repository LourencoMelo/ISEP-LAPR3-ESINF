package lapr.project.auth;
import java.util.Objects;
import java.util.regex.Pattern;

public class Email {

    /**
     * Instance mail of Email
     */
    private String mail;

    /**
     * Contructor of Email
     * @param email
     */
    public Email(String email) {
        if (validate(email)) this.mail = email;
    }

    /**
     * Validates the email
     * @param email
     * @return boolean
     */
    private boolean validate(String email) {
        if (email.isEmpty()) return false;

        return checkFormat(email);
    }

    /**
     * Checks the format of the email
     * @param email
     * @return boolean
     */
    private boolean checkFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    /**
     * Gets the mail instance
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets a new Email
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * HashCode of Email
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.mail.hashCode();
        return hash;
    }

    /**
     * Equals Email method
     * @param o
     * @return boolean
     */
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

    /**
     * ToString of class Email
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s", this.mail);
    }
}
