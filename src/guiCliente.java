import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class guiCliente {

    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;
    private Cliente cliente;

    public guiCliente() {
        // Crie a janela e configure os componentes
        cliente = new Cliente(this);

        JFrame frame = new JFrame("Cliente");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        textField = new JTextField(20);
        sendButton = new JButton("Enviar");

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                // Lógica para enviar a mensagem quando o botão for clicado
                String message = textField.getText();
                try {
                    cliente.sendMessage(message); // Correção aqui
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                textField.setText("");
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(textField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        cliente = new Cliente(this); // Crie uma instância do cliente e passe a GUI como parâmetro
    }

    public void appendMessage(String message) {
        // Método para adicionar mensagens à área de texto
        textArea.append(message + "\n");
    }

    public void enviarMensagem(String mensagem) throws IOException {
        cliente.sendMessage(mensagem); // Chame o método do cliente para enviar mensagem
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new guiCliente();
        });
    }
}
