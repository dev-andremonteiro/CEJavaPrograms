import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {

    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket[] connection;
    private int counter = 1;

    public Server() {
        super("Servidor");
        Container container = getContentPane();
        enterField = new JTextField();
        enterField.setEnabled(false);
        enterField.addActionListener(
                new ActionListener() {
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

    public void runServer() {
        try {
            server = new ServerSocket(5000, 100);
            while (true) {
                waitForConnection();
                getStreams();
                processConnection();
                ++counter;
            }
        } catch (EOFException eofException) {
            System.out.println("Client terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void waitForConnection() throws IOException {
        int x = counter-1;
        while(x >= 0){
            connection[x] = server.accept();
            displayArea.append("Conexão " + counter + " recebida de: " + connection[x].getInetAddress().getHostName());
            x--;
        }
    }

    private void getStreams() throws IOException {
        int x = counter-1;
        while(x > 0){
            output = new ObjectOutputStream(connection[x].getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection[x].getInputStream());
            x--;
        }
    }

    private void processConnection() throws IOException {
        String message = "";
        enterField.setEnabled(true);
            try {
                message = (String) input.readObject();
                displayArea.append("\n" + message);
                displayArea.setCaretPosition(
                displayArea.getText().length());
            } catch (ClassNotFoundException classNotFoundException) {
                displayArea.append("\n Unknown object type received");
            }
        if(message.equals("CLIENT>>> TERMINATE")){
            closeConnection();
        }
    }

    private void closeConnection() throws IOException {
        displayArea.append("\nUser terminated connection");
        enterField.setEnabled(false);
        output.close();
        input.close();
        int x = counter-1;
        while(x > 0){
            connection[x].close();
            x--;
        }
    }

    private void sendData(String message) {
        try {
            output.writeObject("SERVER>>> " + message);
            output.flush();
            displayArea.append("\nSERVER>>>" + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    public static void main(String[] args) {
        Server application = new Server();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer();
    }
}
