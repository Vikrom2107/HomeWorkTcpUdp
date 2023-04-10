package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(ServerConfig.PORT)) {
            String lastCity = null;
            System.out.println("Server start");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    System.out.println(name);

                    if (lastCity == null) {
                        out.println("???");
                        lastCity = in.readLine();
                        System.out.println("Приняли первое название города");
                        out.println("Значение принято");
                    } else {
                        out.println(lastCity);
                        System.out.println(lastCity.substring(lastCity.length()-1));
                        String city = in.readLine();
                        System.out.println("Приняли название города");
                        if (city.startsWith(lastCity.substring(lastCity.length()-1))) {
                            out.println("OK");
                            lastCity = city;
                        } else
                            out.println("NOT OK");
                    }
                }
            }
        } catch(IOException e){
            e.getMessage();
        }
    }
}