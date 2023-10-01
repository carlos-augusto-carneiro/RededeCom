import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        boolean servidorRodando = true;

        serverSocket = new ServerSocket(9998);
        System.out.println("Servidor iniciado e aguardando conexões...");

        while (servidorRodando) {
            Socket socket = null;
            InputStreamReader inputStreamReader = null;
            OutputStreamWriter outputStreamWriter = null;
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;

            try {
                socket = serverSocket.accept();
                System.out.println("Cliente conectado!");

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                while (true) {
                    String msgCliente = bufferedReader.readLine();

                    System.out.println("Cliente: " + msgCliente);

                    if (msgCliente.equalsIgnoreCase("Tchau")) {
                        System.out.println("Até a próxima <3");
                        socket.close();
                        servidorRodando = false;
                        break;
                    } else if (msgCliente.equalsIgnoreCase("Hora")) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                        String horaAtual = dateFormat.format(new Date());
                        bufferedWriter.write(horaAtual);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } else if (msgCliente.equalsIgnoreCase("Porta")) {
                        int portaServidor = serverSocket.getLocalPort();
                        bufferedWriter.write("A porta do servidor é: " + portaServidor);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } else if (msgCliente.equalsIgnoreCase("Listar arquivos")) {
                        File diretorio = new File("C:\\Users\\carlo\\Downloads"); // Substitua pelo caminho do diretório desejado
                        File[] arquivos = diretorio.listFiles();
                    
                        if (arquivos != null) {
                            for (File arquivo : arquivos) {
                                if (arquivo.isFile()) {
                                    bufferedWriter.write(arquivo.getName());
                                    bufferedWriter.newLine();
                                    bufferedWriter.flush(); // Importante: flush após cada linha
                                }
                            }
                            bufferedWriter.write("Fim da lista");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            
                        } else {
                            bufferedWriter.write("Nenhum arquivo encontrado.");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }
                    } else {
                        bufferedWriter.write("Mensagem recebida");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
