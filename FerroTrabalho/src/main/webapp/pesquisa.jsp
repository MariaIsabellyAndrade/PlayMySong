<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Musicas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/pesquisaa.css">
    <script>

          function buscarMusicas() {
             let chave = document.getElementById("chave").value.trim();
             if (chave === "") {
                 alert("Digite uma palavra-chave para buscar musicas.");
                 return;
             }

            fetch("search-servlet?query=" + encodeURIComponent(chave)) // Enviando a requisição para o servlet
                 .then(response => response.text()) // Recebe a resposta como texto (HTML)
                 .then(data => {
                     document.getElementById("resultados").innerHTML = data; // Insere o HTML da resposta diretamente
                 })
                 .catch(error => console.error("Erro ao buscar músicas:", error));
         }
    </script>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Buscar Musicas</h2>
    <div class="input-group mb-3">
        <input type="text" id="chave" class="form-control" placeholder="Digite uma palavra-chave">
        <div class="input-group-append">
            <button class="btn btn-primary" onclick="buscarMusicas()">Buscar</button>
        </div>
    </div>
    <div id="resultados"></div>
    <a href="index.html" class="btn" > <span class="material-icons"><svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#1f1f1f"><path d="M0 0h24v24H0z" fill="none"/><path d="M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z"/></svg>
</span></a>
</div>
</body>

</html>