package org.example.apitests.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ApiClient {
    private final Client client;
    private final String basePath;

    public ApiClient(String basePath) {
        this.basePath = basePath;
        this.client = ClientBuilder.newClient();
    }

    public Response sendGetRequest(String path) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response sendPostRequest(String path, Object request) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON));
    }

    public Response sendPutRequest(String path, Object request) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(request, MediaType.APPLICATION_JSON));
    }

    public Response sendDeleteRequest(String path) {
        return client
                .target(basePath)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }
}
