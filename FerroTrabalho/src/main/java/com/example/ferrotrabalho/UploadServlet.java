package com.example.ferrotrabalho;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;

@MultipartConfig(
        fileSizeThreshold=1024 * 1024,   // 1MB - Buffer de memória
        maxFileSize=1024 * 1024 * 100,   // 100MB - Tamanho máximo do arquivo
        maxRequestSize=1024 * 1024 * 100 // 100MB - Tamanho máximo da requisição
)
@WebServlet(name = "UploadServlet", value = "/upload-servlet")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        try {
            // Captura os parâmetros do formulário
            String nomeMusica = request.getParameter("nomeMusica");
            String artista = request.getParameter("artista");
            String estilo = request.getParameter("estilo");

            // Verifica se os valores foram enviados corretamente
            if (nomeMusica == null || nomeMusica.trim().isEmpty() ||
                    artista == null || artista.trim().isEmpty() ||
                    estilo == null || estilo.trim().isEmpty()) {
                writer.println("Erro: Nome da música, artista ou estilo não foram enviados corretamente.");
                return;
            }

            // Formatar o nome do arquivo removendo espaços
            String nomeFormatado = nomeMusica.replaceAll("\\s+", "");
            String artistaFormatado = artista.replaceAll("\\s+", "");
            String estiloFormatado = estilo.replaceAll("\\s+", "");
            String titulo = nomeFormatado + "_" + estiloFormatado + "_" + artistaFormatado + ".mp3";

            // Captura o arquivo enviado
            Part filePart = request.getPart("file");
            if (filePart == null || filePart.getSize() == 0) {
                writer.println("Erro: Nenhum arquivo foi enviado.");
                return;
            }

            // Obtém o caminho de destino dentro do projeto (pasta src/uploads)
            String uploadPath = getServletContext().getRealPath("/") + "../../target/FerroTrabalho-1.0-SNAPSHOT/uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir(); // Cria a pasta se não existir
            }

            // Salva o arquivo no servidor
            File file = new File(uploadDir, titulo);
            try (InputStream fileContent = filePart.getInputStream();
                 FileOutputStream outputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileContent.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }


            response.sendRedirect("pesquisa.jsp");
            //writer.println("Upload realizado com sucesso! Arquivo salvo em: " + file.getAbsolutePath());

        } catch (Exception e) {
            writer.println("Erro ao processar o upload: " + e.getMessage());
        }
    }
}
