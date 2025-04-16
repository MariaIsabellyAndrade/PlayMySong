# 🎵 PlayMySong - Sistema de Gerenciamento de Músicas

Este projeto foi desenvolvido como parte da disciplina **Ferramentas Computacionais 3**, com o objetivo de criar um sistema simples de gerenciamento de músicas utilizando Java Web. A aplicação permite autenticação, envio, organização e reprodução de músicas diretamente no navegador.

---

## 📌 Funcionalidades

- ✅ **Autenticação de Usuário** → Login com validação e mensagens dinâmicas de erro.
- ✅ **Upload de Músicas** → Envio de arquivos `.mp3` com validação no front-end e back-end.
- ✅ **Biblioteca de Músicas** → Exibição automática das músicas armazenadas no servidor.
- ✅ **Busca Inteligente** → Pesquisa por nome de músicas com carregamento assíncrono.
- ✅ **Organização por Gêneros** → Classificação automática baseada no nome do arquivo.
- ✅ **Reprodutor de Áudio** → Interface integrada para reprodução de músicas.

---

## 🛠️ Tecnologias Utilizadas

- 🔹 **Java EE (Servlets, JSP)** → Lógica e processamento dinâmico.
- 🔹 **Apache Tomcat** → Servidor de aplicações Java.
- 🔹 **Bootstrap 5** → Layout moderno e responsivo.
- 🔹 **JavaScript (Fetch API, DOM Manipulation)** → Interatividade no front-end.
- 🔹 **HTML + CSS** → Estruturação e estilização da interface.

---

## ⚙️ Configuração do Ambiente

### 1️⃣ Instalando o Apache Tomcat

1. Baixe o Tomcat 10.1.36 no site oficial.
2. Extraia o conteúdo para o diretório `C:\ApacheTomCat\apache-tomcat-10.1.36`.
3. Execute `startup.bat` para iniciar e `shutdown.bat` para parar o servidor.
4. Acesse `http://localhost:8080/` para verificar se está funcionando.

### 2️⃣ Baixando e Importando o Projeto

```bash
git clone https://github.com/MariaIsabellyAndrade/PlayMySong.git
```

Ou faça o download manual via GitHub → Code → Download ZIP.

### 3️⃣ Importando no IntelliJ IDEA Ultimate

1. Abra o IntelliJ IDEA.
2. Vá em `File → Open` e selecione a pasta do projeto.
3. Aguarde o carregamento das dependências.

### 4️⃣ Configurando o Tomcat

1. Vá em `File → Settings → Application Servers` e adicione o caminho do Tomcat.
2. Em `Run → Edit Configurations`, adicione uma configuração do tipo **Tomcat Server → Local**.
3. Clique em "Fix" e selecione a opção `...exploded`.
4. Clique em **Apply** e depois **OK**.

---

## ▶️ Rodando a Aplicação

### 1️⃣ Executando o Projeto
- No IntelliJ IDEA, clique no botão **Run** (ou pressione `Shift + F10`).
- Acesse a aplicação no navegador pelo link:  
  `http://localhost:8080/PlayMySong/`

### 2️⃣ Realizando Login
- Use **qualquer e-mail válido** para se autenticar.
- A senha é o **nome de usuário antes do “@”**.  
  **Exemplo:**  
  ```
  E-mail: usuario@gmail.com  
  Senha: usuario
  ```
- Se os dados estiverem incorretos, uma **mensagem de erro será exibida dinamicamente** na tela.

### 3️⃣ Enviando Músicas
- Vá até a aba **"Upload"** no menu do sistema.
- Selecione um arquivo **.mp3** válido e clique em **"Enviar"**.
- Após o upload, a música será adicionada automaticamente à biblioteca.

### 4️⃣ Buscando e Reproduzindo Músicas
- Acesse a aba **"Buscar Música"**.
- Digite parte do nome da música e veja os resultados em tempo real.
- Clique no botão **Play ▶️** para ouvir diretamente no navegador.



