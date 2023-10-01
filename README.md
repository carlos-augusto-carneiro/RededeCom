# Como executar

### Versão do java
recomendo usar a versão java version "20.0.2"

### Como executar

Abra primeiro os dois codigos.

<img src = "fotos\abrir os codigos (1).png">

Abra um terminal no VS Code. Caso você não esteja usando o VS Code, abra dois terminais separados. No VS Code, você pode abrir dois terminais clicando com o botão direito na área de terminal atual e selecionando "Split Terminal" (Dividir Terminal) ou usando o atalho de teclado apropriado.

<img src = "fotos\abrir terminar e colocar split.png">

Após abrir o terminal, navegue até a pasta "src" onde estão localizados os arquivos do servidor e do cliente para que possam ser executados. No GitHub, já subi os executáveis, no entanto, caso ocorra algum erro, peço que compile novamente. No próprio terminal, digite os seguintes comandos para compilar os arquivos:

Para compilar o arquivo Cliente.java, utilize o comando:

* **javac Cliente.java**

Para compilar o arquivo Server.java, utilize o comando:

* **javac Server.java**

<img src = "fotos\colocar na pasta src.png">

Após a compilação bem-sucedida, você pode executar os programas Cliente e Servidor. Certifique-se de estar na pasta correta onde os arquivos compilados estão localizados antes de executar os comandos a seguir. Execute nessa ordem.

Para executar o Servidor, utilize o comando:

* **java Server**

Para executar o Cliente, utilize o comando:

* **java Cliente**
<img src = "fotos\digitar java cliente e servidor.png">

O código já está pronto para uso e as funções do servidor são as seguintes:

* **Tchau**: Essa função permite encerrar a conexão entre o cliente e o servidor.
* **hora**: A função "hora" retorna o horário exato do servidor para o cliente.
* **porta**: A função "porta" retorna a porta em que o servidor está ouvindo para comunicação.
* **Listar arquivos**: A função "Listar arquivos" lista todos os arquivos do diretório especificado no servidor. Você pode alterar o diretório para listar arquivos no código do arquivo **Server.java**, na linha 54, onde está definida a variável **diretorio**. Você pode modificar o caminho dentro dos parênteses para listar arquivos em outro diretório.

<img src = "fotos\pronto para uso.png">
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

Nesse trecho de código, estou criando um loop que permite que o cliente envie mensagens para o servidor continuamente.

* **try (Scanner scanner = new Scanner(System.in))**: Isso cria um bloco **try-with-resources**, que é uma construção do Java para garantir que recursos sejam fechados automaticamente após seu uso. Nesse caso, estou criando um objeto Scanner chamado **canner** que lê a entrada do usuário a partir do **System.in**, que é a entrada padrão.
* **while (true)**: Isso inicia um loop infinito, o que significa que o código dentro deste loop será executado repetidamente até que uma condição de parada seja atendida. Neste caso, o loop é infinito, o que significa que o cliente continuará a enviar mensagens até que ele decida encerrar a comunicação com o servidor.
* **String msg = scanner.nextLine();**: Aqui, estou lendo a próxima linha de texto que o usuário digitar no console e armazenando essa linha em uma variável chamada **msg**. Essa linha representa a mensagem que o cliente deseja enviar ao servidor.
* **bufferedWriter.write(msg);**: Esta linha escreve a mensagem lida do usuário no **BufferedWriter**, que é responsável por enviar a mensagem para o servidor.
* **bufferedWriter.newLine();**: Aqui, estou adicionando uma nova linha após a mensagem, para que a mensagem seja enviada como uma linha separada para o servidor. Isso ajuda o servidor a identificar onde uma mensagem termina e a próxima começa.
* **bufferedWriter.flush();**: Finalmente, estou usando **flush(**) para garantir que os dados sejam enviados imediatamente para o servidor. Sem isso, os dados podem ser armazenados em buffer e não enviados até que o buffer esteja cheio ou até que o método **flush()** seja chamado.

<img src = "fotos\inicio da Cliente segundo try.png">

Os blocos if e else if neste trecho de código são usados para processar as mensagens recebidas do usuário e executar ações específicas com base nas mensagens.

* **if (msg.equalsIgnoreCase("Tchau"))**: Este bloco verifica se a mensagem digitada pelo usuário (armazenada em msg) é "Tchau", ignorando diferenças de maiúsculas e minúsculas. Se for, o programa realiza as seguintes ações, Imprime uma mensagem de despedida. Fecha o socket, encerrando a conexão com o servidor. Sai do loop while, interrompendo a execução do cliente.
* **else if (msg.equalsIgnoreCase("Hora"))**: Este bloco verifica se a mensagem é "Hora". Se for, o programa faz o seguinte, Imprime a mensagem "Cliente: Solicitando hora atual..." para indicar que o cliente está solicitando a hora atual. Lê a resposta do servidor usando bufferedReader.readLine(). O servidor deve ter respondido com a hora atual. Imprime a hora atual recebida do servidor.
* **else if (msg.equalsIgnoreCase("Porta"))**: Este bloco verifica se a mensagem é "Porta". Se for, o programa faz o seguinte, imprime a mensagem "Cliente: Solicitando a porta do servidor..." para indicar que o cliente está solicitando a porta do servidor. Lê a resposta do servidor usando bufferedReader.readLine(). O servidor deve ter respondido com a porta em que ele está escutando. Imprime a porta do servidor recebida como resposta.
* **else if (msg.equalsIgnoreCase("Listar arquivos"))**: Este bloco verifica se a mensagem é "Listar arquivos". Se for, o programa faz o seguinte, imprime a mensagem "Cliente: Solicitando lista de arquivos..." para indicar que o cliente está solicitando a lista de arquivos disponíveis no servidor. Inicia um loop que lê e imprime os nomes dos arquivos enviados pelo servidor até que a mensagem "Fim da lista" seja recebida.
* **else**: Este bloco é executado se a mensagem não corresponder a nenhum dos casos anteriores. Nesse caso, a mensagem é tratada como genérica. O programa lê a resposta do servidor e a imprime. Isso permite que o servidor envie mensagens personalizadas para o cliente, mesmo que o cliente não tenha emitido um comando específico.

<img src = "fotos\ifs e elses cliente.png">

Este trecho de código faz parte da cláusula finally e é responsável por fechar os recursos associados ao cliente de forma adequada, garantindo que eles sejam liberados, independentemente de qualquer exceção que ocorra durante a execução do programa.

<img src = "fotos\finally cliente.png">


Logo a imagem abaixo temos o codigo completo do servidor.

<img src = "fotos\classe inteira servidor.png">

* **import java.io.*;**: Este import inclui todas as classes relacionadas à entrada e saída (I/O) em Java. Isso inclui classes para leitura e gravação de dados, como **InputStream**, **OutputStream**, **Reader**, **Writer**, **BufferedReader**, **BufferedWriter**.
* **import java.net.*;**: Este import inclui todas as classes relacionadas à comunicação em rede em Java. Isso inclui classes como **Socket**, **ServerSocket**, **InetAddress**.
* **import java.text.SimpleDateFormat;**: Esse import permite o uso da classe **SimpleDateFormat**, que faz parte do pacote **java.text**. A classe **SimpleDateFormat** é usada para formatar datas e horas de acordo com um padrão específico. 
* **import java.util.Date;**: Esse import permite o uso da classe **Date**, que faz parte do pacote java.util. A classe **Date** é usada para representar instantes de tempo.

<img src = "fotos\imports servidor.png">

Essa parte do código está relacionada à inicialização do servidor e ao loop principal que permite que o servidor atenda a várias conexões de clientes.

* **ServerSocket serverSocket = null;**: Aqui, estou a declarar uma variável **serverSocket** do tipo **ServerSocket**, que é uma classe que representa um servidor de soquetes. Inicialmente, estou a define como **null** para que possa ser inicializada posteriormente.
* **boolean servidorRodando = true;**: Estou a declarar uma variável booleana chamada **servidorRodando** e a define como **true**. Essa variável será usada para controlar o loop principal do servidor. Enquanto **servidorRodando** for verdadeiro, o servidor continuará aguardando e atendendo às solicitações dos clientes.
* **serverSocket = new ServerSocket(9998);**: Aqui, estou criando uma instância de **ServerSocket** associada à **porta 9998** do servidor. Isso cria um ponto de escuta para o servidor aguardar conexões de clientes na porta especificada.
* **System.out.println("Servidor iniciado e aguardando conexões...");**: Esta linha imprime uma mensagem indicando que o servidor foi iniciado com sucesso e está aguardando conexões de clientes. Isso é útil para verificar se o servidor foi iniciado corretamente.
* **while (servidorRodando)**: Aqui, estou iniciando um loop while que continuará sendo executado enquanto **servidorRodando** for verdadeiro. Isso permite que o servidor fique ativo e atenda a várias conexões de clientes.
* **Socket socket = null;**: Dentro do loop, estou a declarar uma variável socket do tipo **Socket**. Essa variável será usada para representar a conexão entre o servidor e um cliente específico.
* **InputStreamReader inputStreamReader = null;, OutputStreamWriter outputStreamWriter = null;, BufferedReader bufferedReader = null;, BufferedWriter bufferedWriter = null;**: Estou a declarar várias variáveis para lidar com entrada e saída de dados entre o servidor e um cliente específico. 

<img src = "fotos\Inicio servidor.png">

Essa parte do código lida com a aceitação de conexões de clientes e a configuração de fluxos de entrada e saída para se comunicar com o cliente recém-conectado.

* **socket = serverSocket.accept();**: A função **accept()** é chamada no objeto **serverSocket** para aguardar e aceitar uma conexão de um cliente. Quando um cliente se conecta com sucesso, essa função retorna um novo objeto **Socket** que representa a conexão com esse cliente. 
* **System.out.println("Cliente conectado!");**: Após aceitar a conexão do cliente, esta linha imprime uma mensagem no console para indicar que o servidor recebeu uma conexão e que um cliente está conectado com sucesso.
* **inputStreamReader = new InputStreamReader(socket.getInputStream());**: Esta linha cria um objeto **InputStreamReader** associado ao fluxo de entrada da conexão com o cliente. Isso permite que o servidor leia dados enviados pelo cliente.
* **outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());** : Similarmente, esta linha cria um objeto **OutputStreamWriter** associado ao fluxo de saída da conexão com o cliente. Isso permite que o servidor envie dados de volta ao cliente.
* **bufferedReader = new BufferedReader(inputStreamReader);**: Um **BufferedReader** é criado com base no **inputStreamReader**. Isso é útil para ler linhas de texto que são enviadas pelo cliente. A classe **BufferedReader** fornece métodos convenientes para ler texto linha a linha.
* **bufferedWriter = new BufferedWriter(outputStreamWriter);**: Da mesma forma, um **BufferedWriter** é criado com base no **outputStreamWriter**. Isso permite que o servidor escreva linhas de texto que serão enviadas de volta ao cliente.

<img src = "fotos\try servidor.png">

Nesse trecho do código, está implementada a lógica do servidor para receber mensagens do cliente, processar essas mensagens e responder de acordo com a mensagem recebida.

* **String msgCliente = bufferedReader.readLine();**: O servidor lê uma linha de texto do cliente por meio do objeto **bufferedReader**. Essa linha de texto representa a mensagem enviada pelo cliente.
* **System.out.println("Cliente: " + msgCliente);**: O servidor imprime a mensagem recebida do cliente no console, precedida pela indicação "Cliente:". Isso ajuda a depurar e a entender as interações com o cliente.
* A estrutura condicional if-else verifica o conteúdo da mensagem recebida (msgCliente) e toma ações diferentes com base nessa mensagem: Se a mensagem for "Tchau", o servidor responde com uma mensagem de despedida, fecha a conexão com o cliente (socket.close()), define servidorRodando como false para encerrar o loop e sai do loop com break. Se a mensagem for "Hora", o servidor obtém a hora atual no formato "HH:mm:ss" usando SimpleDateFormat e a classe Date. Em seguida, envia a hora atual de volta ao cliente por meio do objeto bufferedWriter. Se a mensagem for "Porta", o servidor obtém a porta em que está ouvindo as conexões (serverSocket.getLocalPort()) e envia essa informação de volta ao cliente. Se a mensagem for "Listar arquivos", o servidor lista os arquivos do diretório especificado ("C:\Users\carlo\Downloads" no exemplo) e envia os nomes dos arquivos de volta ao cliente, linha por linha. O servidor termina a lista de arquivos com a mensagem "Fim da lista". Se não houver arquivos no diretório, ele envia a mensagem "Nenhum arquivo encontrado. "Se a mensagem não corresponder a nenhum dos casos anteriores, o servidor responde com "Mensagem recebida".
* O uso de bufferedWriter.newLine() e bufferedWriter.flush() após cada escrita no bufferedWriter garante que as mensagens sejam enviadas corretamente e que o buffer seja esvaziado para que as mensagens sejam entregues ao cliente.
* Qualquer exceção do tipo IOException que ocorra durante a execução do código dentro do try é tratada imprimindo o rastreamento de pilha no console (e.printStackTrace()). Isso ajuda na identificação e solução de problemas de comunicação.

<img src = "fotos\while servidor.png">







