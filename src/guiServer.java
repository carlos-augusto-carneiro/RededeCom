import javax.swing.*;
import java.awt.*;

public class guiServer {
    private JTextArea textArea;

    public guiServer() {
        // Crie a janela e configure os componentes
        JFrame frame = new JFrame("Servidor");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void addMessage(String message) {
        // Método para adicionar mensagens à área de texto
        textArea.append(message + "\n");
    }

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            guiServer guiServer = new guiServer();
            Server server = new Server(guiServer); // Crie uma instância do servidor e passe a GUI como parâmetro
            server.start();
        });
    }
}
