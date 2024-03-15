package com.example.apitests.hooks;

import com.example.apitests.repository.TestDataRepository;
import io.cucumber.java.After;

public class Hooks {

    TestDataRepository testDataRepository = new TestDataRepository();

    @After
    public void cleanTestData(){
        testDataRepository.resetTestData();
    }
}
