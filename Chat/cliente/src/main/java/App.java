
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas Dias
 */
public class App {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Socket cliente = new Socket(InetAddress.getByName("localhost"), 5050);
        DataInputStream dataEntrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream dataSaida = new DataOutputStream(cliente.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println(dataEntrada.readUTF());
        String nome = sc.nextLine();
        dataSaida.writeUTF(nome);
        
        Thread t = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        System.out.println("MSG: " + dataEntrada.readUTF());
                    } catch (IOException erro) {
                        System.err.println("Erro: " + erro.getMessage());
                        return;
                    }
                }
            }
        };
        t.start();
                
        while(true) {
            System.out.println("Digite a mensagem: ");
            String msg = sc.nextLine();
            dataSaida.writeUTF(msg);
        }
        
    }
    
}