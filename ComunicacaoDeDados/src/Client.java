
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class Client extends JFrame {

    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String chatServer;
    private Socket client;

    public Client(String host) {
        super("Cliente");
        chatServer = host;
        Container container = getContentPane();
        enterField = new JTextField();
        enterField.setEditable(true);
        enterField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                sendData(event.getActionCommand());
            }
        });
        container.add(enterField, BorderLayout.NORTH);
        displayArea = new JTextArea();
        container.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300, 150);
        setVisible(true);
    }

    public void runClient() {
        try {
            connectionToServer();
            getStreams();
            processConnection();
            closeConnection();
        } catch (EOFException eofException) {
            System.out.println("Server terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        input = new ObjectInputStream(client.getInputStream());
        displayArea.append("\n Got I/O streams\n");
    }

    private void connectionToServer() throws IOException {
        displayArea.setText("Tentando conexão\n");
        client = new Socket(InetAddress.getByName(chatServer), 5000);
        displayArea.append("Conectado ao Host: " + client.getInetAddress().getHostName());
    }

    private void processConnection() throws IOException {
        enterField.setEnabled(true);
        do {
            try {
                message = (String) input.readObject();
                displayArea.append("\n" + message);
                displayArea.setCaretPosition(
                        displayArea.getText().length());
            } catch (ClassNotFoundException classNotFoundException) {
                displayArea.append("\nTipo desconhecido de objeto recebido");
            }
        } while (!message.equals("SERVER>>>TERMINATE"));
    }

    private void closeConnection() throws IOException {
        displayArea.append("\nFechando a conexão");
        output.close();
        input.close();
        client.close();
    }

    private void sendData(String message) {
        try {
            String time = (new Date()).toString();
            output.writeObject(time + "CLIENT>>> " + message);
            output.flush();
            displayArea.append(time + "\nCLIENT>>>" + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    public static void main(String[] args) {
        Client application;
        if (args.length == 0) {
            application = new Client("172.16.5.147");
        } else {
            application = new Client(args[0]);
        }
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient();
    }
}
