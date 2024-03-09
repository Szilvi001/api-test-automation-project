package org.example.apitests.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ApiClient {
    private Client client;
    private final String basePath;

    public ApiClient(String basePath) {
        this.basePath = basePath;
        this.client = ClientBuilder.newClient();
    }

    // Method to make a GET request
    public Response get(String path) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    // Method to make a POST request
    public Response post(String path, Object request) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON));
    }

    // Method to make a PUT request
    public Response put(String path, Object request) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(request, MediaType.APPLICATION_JSON));
    }

    // Method to make a DELETE request
    public Response delete(String path) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }
}
