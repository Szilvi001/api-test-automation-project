package com.example.apitests.stepdefinitions;

import com.example.apitests.repository.TestDataRepository;
import com.example.apitests.util.StepDefHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.apitests.client.ApiClient;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommonStepDefs extends StepDefHelper {

    ApiClient apiClient = new ApiClient("https://my-json-server.typicode.com/szilvi001/json-server");
    TestDataRepository testDataRepository = new TestDataRepository();

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        System.out.println(apiClient.get("posts/1"));
        testDataRepository.setResponse(apiClient.get("posts/1"));
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
        assertThat("The statuscode should be 200", testDataRepository.getResponse().getStatus(), is(200));
    }

    @Then("the response payload should be correct")
    public void theResponsePayloadShouldBeCorrect() throws JSONException, IOException {
        testDataRepository.setExpectedResponse(readJsonFile("src/test/resources/testdata/expectedGetPostResponse.json"));
        JSONAssert.assertEquals(testDataRepository.getExpectedResponse().toString(), testDataRepository.getResponse().readEntity(String.class), JSONCompareMode.LENIENT);
    }
}
