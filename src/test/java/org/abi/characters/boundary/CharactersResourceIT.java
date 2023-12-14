package org.abi.characters.boundary;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

public class CharactersResourceIT {

    private static final Logger LOGGER = Logger.getLogger(CharactersResourceIT.class.getName());

    private static final String baseURL = "http://localhost:8080/characters";


    @Test
    public void shouldGetCharacter() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseURL))
                    .build();

        HttpResponse<String> httpResponse;
        System.out.println("Sending request...");
        try {
            httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            final var name = httpResponse.body();
            assertTrue(name.equals("The character is Mario!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        System.out.println("All done!");
    }

    // @Test
    // public void shouldGetSpecificCharacter() {
    //     final String name = "peach";

    //     HttpClient client = HttpClient.newHttpClient();
    //     HttpRequest request = HttpRequest.newBuilder()
    //                 .uri(URI.create(baseURL))
    //                 .a(name)
    //                 .build();

    //     HttpResponse<String> httpResponse;
    //     try {
    //         httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }       
    // }

}
