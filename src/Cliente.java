import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {

            socket = new Socket("localhost", 9998);
			System.out.println("Cliente conectado ao servidor.");

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String msg = scanner.nextLine();

                    bufferedWriter.write(msg);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    System.out.println("Server: " + bufferedReader.readLine());

                    if (msg.equalsIgnoreCase("Tchau")) {
                		System.out.println("Até a próxima <3");
                        socket.close();
                        break;
                	}else if (msg.equalsIgnoreCase("Hora")) {
                        System.out.println("Cliente: Solicitando hora atual...");
                        String horaAtual = bufferedReader.readLine();
                        System.out.println("Server: " + horaAtual);
                    }else if (msg.equalsIgnoreCase("Porta")) {
                        System.out.println("Cliente: Solicitando a porta do servidor...");
                        String portaServidor = bufferedReader.readLine();
                        System.out.println("Server: " + portaServidor);
                    }else if (msg.equalsIgnoreCase("Listar arquivos")) {
                        bufferedWriter.write("ListarArquivos");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    
                        String resposta;
                        while (!(resposta = bufferedReader.readLine()).equals("FimDaLista")) {
                            System.out.println("Arquivo: " + resposta);
                        }
                    }
                    
                }
            }
		}
		finally {
			try{
				if(socket != null){
					socket.close();
				}
				if(inputStreamReader != null){
					inputStreamReader.close();
				}
				if(outputStreamWriter != null){
					outputStreamWriter.close();
				}
				if(bufferedReader != null){
					bufferedReader.close();
				}
				if(bufferedWriter != null){
					bufferedWriter.close();
				}
        	} catch (IOException e){
				e.printStackTrace();
			}
    	}
	}
}