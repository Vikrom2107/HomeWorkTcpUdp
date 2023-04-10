package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client1 {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(ServerConfig.HOST, ServerConfig.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scan = new Scanner(System.in)
        ) {
            out.println("First player");
            System.out.println(in.readLine());
            String city = scan.nextLine();
            out.println(city);
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
