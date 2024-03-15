package com.example.apitests.repository;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.ws.rs.core.Response;

public class TestDataRepository {

    private Response response;
    private String id;
    private ObjectNode expectedResponse;
    private ObjectNode requestAsJson;

    public TestDataRepository() {
    }

    public TestDataRepository(Response response, String id, ObjectNode expectedResponse, ObjectNode requestAsJson) {
        this.response = response;
        this.id = id;
        this.expectedResponse = expectedResponse;
        this.requestAsJson = requestAsJson;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectNode getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(ObjectNode expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public ObjectNode getRequestAsJson() {
        return requestAsJson;
    }

    public void setRequestAsJson(ObjectNode requestAsJson) {
        this.requestAsJson = requestAsJson;
    }

    public void resetTestData(){
        this.setResponse(null);
        this.setId(null);
        this.setExpectedResponse(null);
        this.setRequestAsJson(null);
    }
}
