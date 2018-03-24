package com.example.nahomnegussie.se2sr_cl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Nahom Negussie on 3/20/2018.
 */

public class TCPServer extends Thread {

    public int SERVERPORT = 4444;
    private boolean running = false;
    private PrintWriter mOut;
    private OnMessageReceived messageListener;


    /**
     * Constructor of the class
     * @param messageListener listens for the messages
     */
    public TCPServer(OnMessageReceived messageListener,int port) {
        this.messageListener = messageListener;
        this.SERVERPORT=port;
    }

    /**
     * Method to send the messages from server to client
     * @param message the message sent by the server
     */
    public void sendMessage(String message){
        if (mOut != null && !mOut.checkError()) {
            mOut.println(message);
            mOut.flush();
        }
    }

    @Override
    public void run() {
        super.run();

        running = true;

        try {



            //create a server socket. A server socket waits for requests to come in over the network.
            ServerSocket serverSocket = new ServerSocket(SERVERPORT);
            System.out.println("S: Connecting...");
            //create client socket... the method accept() listens for a connection to be made to this socket and accepts it.
            Socket client = serverSocket.accept();
            System.out.println("S: Receiving...");
            while (running) {


                try {

                    //sends the message to the client
                    mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
                    //sendMessage("Nahom's Computer");
                    //read the message received from client
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                    //in this while we wait to receive messages from client (it's an infinite loop)
                    //this while it's like a listener for messages

                    String message="";
                    message=in.readLine();

                    //call the method messageReceived from ServerBoard class
                    sendMessage(message.toUpperCase());
                    messageListener.messageReceived(message);




                } catch (Exception e) {
                    System.out.println("S: Error");
                    e.printStackTrace();
                } finally {

                }}

        } catch (Exception e) {
            System.out.println("S: Error");
            e.printStackTrace();
        }

    }

    //Declare the interface. The method messageReceived(String message) will must be implemented in the ServerBoard
    //class at on startServer button click
    public interface OnMessageReceived {
        public void messageReceived(String message);
    }

}
