package javaapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class App{
    public static void main(String[] args) throws IOException {
        ServerSocket server_socket = new ServerSocket(18000);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        try {
            System.out.println("Server socket started at :18000.");
            // use threadpool to handle connections            
            while (true) {
                Socket client_socket = server_socket.accept();
                System.out.println("=> connected with " +client_socket.toString());
                // submit a connection to threadpool
                Runnable worker = new WorkerThread(client_socket);
                executor.execute(worker);
            }
        }
        finally {
            executor.shutdown();
            server_socket.close();
            System.out.println("Server socket stopped.");
        }
    }
}

class WorkerThread implements Runnable {
    private Socket sock;

    public WorkerThread(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {        
        try {
            // read data from InputStream to byte[]
            byte[] buffer = new byte[1024];
            this.sock.getInputStream().read(buffer);
            System.out.println("=> got data from" + this.sock.toString() + "\n" + buffer);
            PrintWriter out = new PrintWriter(this.sock.getOutputStream(), true);
            out.println(new Date().toString());
            this.sock.close();
        } catch (IOException e) {
        }
        finally {            
        }
    }
}



