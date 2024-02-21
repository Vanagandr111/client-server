package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080); // Используйте порт 8080
        System.out.println("Сервер запущен и ожидает подключения...");
        Socket clientSocket = serverSocket.accept(); // Ожидание подключения клиента
        System.out.println("Подключение принято.");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String name = in.readLine(); // Чтение строки от клиента
            System.out.printf("Получено сообщение от %d: %s%n", clientSocket.getPort(), name);
            out.println("Привет, " + name + ", твой порт: " + clientSocket.getPort());
        } finally {
            serverSocket.close();
        }
    }
}
