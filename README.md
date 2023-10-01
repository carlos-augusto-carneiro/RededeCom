# Sockets

### Cliente

Logo a imagem abaixo temos o codigo completo do cliente.

<img src = "fotos\classe inteira cliente.png">

Aqui temos os imports que utilizei para fazer a conecção do servido/cliente.

* **import java.io.*;**: Este import inclui todas as classes relacionadas à entrada e saída (I/O) em Java. Isso inclui classes para leitura e gravação de dados, como **InputStream**, **OutputStream**, **Reader**, **Writer**, **BufferedReader**, **BufferedWriter**.
* **import java.net.*;**: Este import inclui todas as classes relacionadas à comunicação em rede em Java. Isso inclui classes como **Socket**, **ServerSocket**, **InetAddress**.
* **import java.util.Scanner;**: Este import inclui a classe **Scanner**, que é uma classe útil para ler entrada de texto do usuário através do console. 

<img src = "fotos\imports clientes.png">

Essa parte do código está relacionada à comunicação entre o cliente e o servidor usando sockets TCP/IP.

* **Socket socket**: Este objeto representa a conexão de rede entre o cliente e o servidor. Ele permite que o cliente se comunique com o servidor através da rede.
* **InputStreamReader inputStreamReader**: É usado para ler dados que chegam do servidor para o cliente. Ele está associado ao fluxo de entrada do socket, permitindo ao cliente receber mensagens enviadas pelo servidor.
* **OutputStreamWriter outputStreamWriter**: É usado para enviar dados do cliente para o servidor. Ele está associado ao fluxo de saída do socket, permitindo ao cliente enviar mensagens para o servidor.
* **BufferedReader bufferedReader**: É uma classe que facilita a leitura de texto. Neste caso, ele é usado para ler as mensagens que chegam do servidor.
* **BufferedWriter bufferedWriter**: Similar ao **BufferedReader**, mas usado para escrever mensagens do cliente para o servidor.

<img src = "fotos\inicio da Cliente.png">

Essa parte do código é responsável por estabelecer a conexão do cliente com o servidor.

* **socket = new Socket("localhost", 9998);**: Nesta linha, o cliente cria um novo objeto Socket. O construtor **Socket** é usado para especificar o endereço do servidor e o número da porta à qual o cliente deseja se conectar. No exemplo, o cliente está se conectando ao servidor que está em execução na mesma máquina ("localhost") e na porta 9998.
* **System.out.println("Cliente conectado ao servidor.");**: Após a conexão bem-sucedida, o cliente exibe uma mensagem indicando que foi conectado ao servidor. Isso é apenas para fins informativos.
* **inputStreamReader = new InputStreamReader(socket.getInputStream());**: Aqui, o cliente cria um **InputStreamReader**. Ele está associado ao fluxo de entrada do socket (**socket.getInputStream()**), o que significa que ele será usado para ler dados que o servidor envia de volta para o cliente. Isso é necessário para receber as respostas do servidor.
* **outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());**: O cliente também cria um **OutputStreamWriter**. Ele está associado ao fluxo de saída do socket (**socket.getOutputStream()**), o que permite que o cliente escreva dados e envie mensagens para o servidor. Isso é necessário para enviar comandos e solicitações ao servidor.
* **bufferedReader = new BufferedReader(inputStreamReader);**: Aqui, o cliente cria um **BufferedReader** que usa o **InputStreamReader**. Isso permite que o cliente leia as mensagens enviadas pelo servidor. O **BufferedReader** facilita a leitura de texto em linhas.
* **bufferedWriter = new BufferedWriter(outputStreamWriter);**: O cliente também cria um **BufferedWriter** que usa o **OutputStreamWriter**. Isso permite que o cliente escreva mensagens e envie-as para o servidor. O BufferedWriter é útil para escrever mensagens de texto.



<img src = "fotos\inicio da Cliente primeiro try.png">

<img src = "fotos\inicio da Cliente segundo try.png">

<img src = "fotos\ifs e elses cliente.png">

<img src = "fotos\finally cliente.png">



<img src = "fotos\classe inteira servidor.png">

<img src = "fotos\Inicio servidor.png">

<img src = "fotos\try servidor.png">

<img src = "fotos\while servidor.png">







