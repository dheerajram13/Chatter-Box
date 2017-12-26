/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatterbox.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DHEERAJ
 */
public class MessageTransmiter extends Thread {

    String hostname,message;
    int port;

    public MessageTransmiter() {
    }
    
    
    public MessageTransmiter(String message,String hostname,int port) {
        
        this.hostname = hostname;
        this.message = message;
        this.port = port;
        
    }

    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname,port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmiter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
