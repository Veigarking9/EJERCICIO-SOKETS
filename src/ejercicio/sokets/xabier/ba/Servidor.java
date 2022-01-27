/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.sokets.xabier.ba;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Servidor {
    

    public static void main(String[] args) {
        MarcoServidor mimarco = new MarcoServidor();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}

class MarcoServidor extends JFrame implements Runnable{
    
    private JTextArea areatexto;
    
    public MarcoServidor(){
        setBounds(1200,300,200,350);
        JPanel  milamina = new JPanel();
        milamina.setLayout(new BorderLayout());
        areatexto = new JTextArea(); 
        milamina.add(areatexto, BorderLayout.CENTER);
        add(milamina);
        setVisible(true);
        Thread mihilo = new Thread(this);
        mihilo.start();  
    }
    @Override
    public void run() {
        System.out.println("Estoy a la escucha");
        try {
            ServerSocket servidor = new ServerSocket(9999);
            Socket misocket = servidor.accept();
            DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
            String mensaje_texto = flujo_entrada.readUTF();
            areatexto.append("\n" + "     " + mensaje_texto);
            misocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
