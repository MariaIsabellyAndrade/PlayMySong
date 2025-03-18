package com.example.ferrotrabalho;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String query = request.getParameter("query").toLowerCase();
        File pastaMusicas = new File(getServletContext().getRealPath("/") + "uploads");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<title>Resultados da Busca</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<link rel='stylesheet' href='css/pesquisaa.css'>");
        out.println("</head>");
        out.println("<body class='bg-custom text-light'>");


        out.println("<div class='container d-flex flex-column justify-content-center align-items-center mt-5 resultado'>");
        out.println("<h2 class='text-center mb-4'> Resultados da Busca</h2>");

        boolean encontrou = false;

        // Verifica os arquivos da pasta
        if (pastaMusicas.exists() && pastaMusicas.listFiles() != null) {
            for (File file : pastaMusicas.listFiles()) {
                if (file.isFile() && file.getName().toLowerCase().contains(query)) {
                    encontrou = true;
                    out.println("<div class='resultado'>");
                    //out.println("<p><a href='/uploads/" + file.getName() + "' target='_blank'>Clique para ouvir: " + file.getName() + "</a></p>");

                    //out.println("<audio controls class='custom-audio'><source src='/uploads/" + file.getName() + "' type='audio/mpeg'></audio>");
                    out.println("<audio controls><source src='play?file=" + file.getName() + "' type='audio/mpeg'></audio>");

                    out.println("<p class='music-title'>" + file.getName() + "</p>");
                    out.println("</div>");
                }
            }
        }

        if (!encontrou) {
            out.println("<div class='alert alert-danger text-center mt-4' role='alert'>");
            out.println("🚨 Nenhuma música encontrada para: <strong>" + query + "</strong>");
            out.println("</div>");
        }

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

