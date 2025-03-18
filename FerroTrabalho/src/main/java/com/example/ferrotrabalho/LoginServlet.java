package com.example.ferrotrabalho;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.Usuario;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        String senhaEsperada = email.split("@")[0];
        // Validação de e-mail   // Validação da senha: deve ser a parte antes do "@"
        if (!Usuario.isEmailValido(email) || !senha.equals(senhaEsperada)) {
            response.sendRedirect("login.html");
            return;
        }

        // Criar sessão e armazenar usuário
        HttpSession session = request.getSession();
        session.setAttribute("usuario", new Usuario(email));


        response.sendRedirect("form.html");
        return;
    }
}
