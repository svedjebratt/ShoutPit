package controllers;

/**
 * Security class for managing the authentication.
 */
public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        return "magnus".equals(username) && "morbid".equals(password);
    }

    static boolean check(String profile) {
        return "admin".equals(profile) && "magnus".equals(connected());
    }
}
