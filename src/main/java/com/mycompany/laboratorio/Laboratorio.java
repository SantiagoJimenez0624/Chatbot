package com.mycompany.laboratorio;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.util.Scanner;

public class Laboratorio {

    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public static void main(String[] args) {
        home form1 = new home();
        form1.setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("Chaticon.png");
        form1.setIconImage(icon);
    }

    public static String ai(){
        URI uri = URI.create(OLLAMA_URL);

        String modelName = "llama3.2";
        boolean seguir = true;
        Scanner sc = new Scanner(System.in);

        while (seguir == true) {
            System.out.println("Escribe tu pregunta para Ollama:");
            String promptText = sc.nextLine();
            System.out.println("Respondiendo...");

            try {
                String response = sendRequestToOllama(modelName, promptText, uri);
                System.out.println("Ollama: " + response);
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al conectar con Ollama: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return "";
    }
   
    
    
    public static String sendRequestToOllama(String modelName, String promptText, URI uri) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();

        String jsonInputString = String.format(
                "{\"model\": \"%s\", \"prompt\":\"%s\", \"stream\": false}", modelName, promptText
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json; utf-8")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonInputString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        System.out.println("Código de respuesta HTTP: " + statusCode);

        if (statusCode == 200) {
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getString("response");
        } else {
            System.out.println("Cuerpo de la respuesta: " + response.body());
            throw new IOException("Error en la respuesta del servidor. Código: " + statusCode);
        }
    }
}
