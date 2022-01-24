package com.mitcp.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class cliente {

    public static void main(String[] args){
        //Host del servidor
        final String HOST = "192.168.0.12";
        //Puerto del servidor
        final int PUERTO = 50000;
        DataInputStream in;
        DataOutputStream out;

        try{
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            //Envio un mensaje al cliente
            out.writeUTF("¡Hola mundo desde el cliente!");

            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();

            System.out.println(mensaje);

            //sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
