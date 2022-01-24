package com.mitcp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);

		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;

		//puerto de nuestro servidor
		final int PUERTO = 50000;


		//Creamos el socket del servidor
		try {
			servidor = new ServerSocket(PUERTO);

			System.out.println("Servidor iniciado");

			//Siempre estara escuchando peticiones
			while (true) {

				//Espero a que un cliente se conecte
				sc = servidor.accept();

				//System.out.println("Servidor iniciado: "+servidor.getChannel().toString());
				//System.out.println("Servidor iniciado: "+servidor.getChannel());
				System.out.println("Cliente conectado");
				System.out.println("Returns the port number on which this socket is listening: " + servidor.getLocalPort());
				System.out.println("Returns the local address of this server socket: " + sc.getInetAddress());

				System.out.println("aca aver: "+sc.toString());
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());

				//Leo el mensaje que me envia
				String mensaje = in.readUTF();

				System.out.println(mensaje);

				//Le envio un mensaje
				out.writeUTF("¡Hola mundo desde el servidor!" + sc.getInetAddress());


				//Cierro el socket
				//sc.close();
				//System.out.println("Cliente desconectado");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
