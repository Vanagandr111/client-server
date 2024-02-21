package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws Exception {
        String serverAddress = "127.0.0.1"; // Адрес сервера
        int serverPort = 8080; // Порт сервера

        try (Socket socket = new Socket(serverAddress, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Подключено к серверу.");
            out.println("Пользователь"); // Отправка строки серверу
            String response = in.readLine(); // Чтение ответа от сервера
            System.out.println("Ответ сервера: " + response);
        }
    }
}
