package org.example.exercice_student.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

@Service
public class LoginService {
    private String LOGIN = "admin";
    private String PASSWORD = "admin123";

    @Autowired
    private HttpSession httpSession;

    public boolean login(String login, String password) {
        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
            httpSession.setAttribute("login", "OK");
            return true;
        }
        return false;

    }

    public boolean isLogged(){
        try {
            String isOk = httpSession.getAttribute("login").toString();
            return isOk.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }
    public void logout() {httpSession.removeAttribute("login");}
}
