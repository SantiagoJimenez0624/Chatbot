package com.mycompany.laboratorio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Laboratorio {


    public static void main(String[] args) {
        home form1 = new home();
        form1.setVisible(true);
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
