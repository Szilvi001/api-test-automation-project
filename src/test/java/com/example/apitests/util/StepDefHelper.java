package com.example.apitests.util;

import com.example.apitests.repository.TestDataRepository;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.apitests.client.ApiClient;

import java.io.File;
import java.io.IOException;

public class StepDefHelper {

    protected ApiClient apiClient = new ApiClient("https://my-json-server.typicode.com/szilvi001/json-server");

    protected TestDataRepository testDataRepository = new TestDataRepository();

    public ObjectNode readJsonFile(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (ObjectNode)mapper.readTree(new File(fileName));
    }

}
