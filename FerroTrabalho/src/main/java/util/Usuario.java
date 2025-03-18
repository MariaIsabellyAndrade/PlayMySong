package util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Usuario {
    private String email;


    // Expressão regular para validar e-mails
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Usuario(String email) {
        this.email = email;
    }

    public static boolean isEmailValido(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return email.split("@")[0]; // Retorna a parte antes do "@"
    }


}
