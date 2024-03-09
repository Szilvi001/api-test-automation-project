package com.example.apitests.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.Response;
import org.example.apitests.client.ApiClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonStepDefs {

    ApiClient apiClient = new ApiClient("https://my-json-server.typicode.com/szilvi001/json-server");
    Response response;

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        System.out.println(apiClient.get("posts/1"));
        response = apiClient.get("posts/1");
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
        assertThat("The statuscode should be 200", response.getStatus(), is(200));
        response.getStatus();
    }
}
