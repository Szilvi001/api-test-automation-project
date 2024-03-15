package com.example.apitests.util;


import com.example.apitests.repository.TestDataRepository;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class StepDefHelper {

    TestDataRepository testDataRepository = new TestDataRepository();

    public ObjectNode readJsonFile(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (ObjectNode)mapper.readTree(new File(fileName));
    }
}
