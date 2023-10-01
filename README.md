# Sockets

### Cliente

Logo a imagem abaixo temos o codigo completo do cliente.

<img src = "fotos\classe inteira cliente.png">

Aqui temos os imports que utilizei para fazer a conecção do servido/cliente.

<img src = "fotos\imports clientes.png">

Essa parte do código está relacionada à comunicação entre o cliente e o servidor usando sockets TCP/IP.

* **Socket socket**: Este objeto representa a conexão de rede entre o cliente e o servidor. Ele permite que o cliente se comunique com o servidor através da rede.
* **InputStreamReader inputStreamReader**: É usado para ler dados que chegam do servidor para o cliente. Ele está associado ao fluxo de entrada do socket, permitindo ao cliente receber mensagens enviadas pelo servidor.
* **OutputStreamWriter outputStreamWriter**: É usado para enviar dados do cliente para o servidor. Ele está associado ao fluxo de saída do socket, permitindo ao cliente enviar mensagens para o servidor.
* **BufferedReader bufferedReader**: É uma classe que facilita a leitura de texto. Neste caso, ele é usado para ler as mensagens que chegam do servidor.
* **BufferedWriter bufferedWriter**: Similar ao **BufferedReader**, mas usado para escrever mensagens do cliente para o servidor.

<img src = "fotos\inicio da Cliente.png">

<img src = "fotos\inicio da Cliente primeiro try.png">

<img src = "fotos\inicio da Cliente segundo try.png">

<img src = "fotos\ifs e elses cliente.png">

<img src = "fotos\finally cliente.png">



<img src = "fotos\classe inteira servidor.png">

<img src = "fotos\Inicio servidor.png">

<img src = "fotos\try servidor.png">

<img src = "fotos\while servidor.png">







