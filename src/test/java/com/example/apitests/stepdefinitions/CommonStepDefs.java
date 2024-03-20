package com.example.apitests.stepdefinitions;

import com.example.apitests.repository.TestDataRepository;
import com.example.apitests.util.StepDefHelper;
import io.cucumber.java.en.Given;
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

    final String TEST_DATA_PATH = "src/test/resources/testdata/";
    final String POST_REQUEST_FILE = "createPostRequest.json";
    final String PUT_REQUEST_FILE = "updatePostRequest.json";
    final String REQUEST_EMPTY_BODY = "createPostRequestEmpty.json";
    final String POST_RESPONSE_FILE = "expectedGetPostResponse.json";
    final String POST = "POST";

    @Given("^the (POST|PUT) request is prepared")
    public void theRequestIsPrepared(String requestType) throws IOException {
        String requestFile = POST.equals(requestType) ? POST_REQUEST_FILE : PUT_REQUEST_FILE;
        testDataRepository.setRequestAsJson(readJsonFile(TEST_DATA_PATH + requestFile));
    }

    @Given("^the (POST|PUT) request is prepared with empty request body$")
    public void thePUTRequestIsPreparedWithEmptyRequestBody(String requestType) throws IOException {
        testDataRepository.setRequestAsJson(readJsonFile(TEST_DATA_PATH + REQUEST_EMPTY_BODY));
    }

    @When("I send a POST request to {string}")
    public void iSendAPOSTRequestTo(String endpoint) {
        testDataRepository.setResponse(apiClient.sendPostRequest(endpoint,
                testDataRepository.getRequestAsJson().toString()));
    }

    @When("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endpoint) {
        testDataRepository.setResponse(apiClient.sendDeleteRequest(endpoint));
    }

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        testDataRepository.setResponse(apiClient.sendGetRequest(endpoint));
    }

    @When("I send a PUT request to {string}")
    public void iSendAPUTRequestTo(String endpoint) {
        testDataRepository.setResponse(apiClient.sendPutRequest(endpoint,
                testDataRepository.getRequestAsJson().toString()));
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        assertThat("The statuscode should be " + statusCode,
                testDataRepository.getResponse().getStatus(), is(statusCode));
    }

    @Then("the response payload should be correct")
    public void theResponsePayloadShouldBeCorrect() throws JSONException, IOException {
        testDataRepository.setExpectedResponse(readJsonFile(TEST_DATA_PATH + POST_RESPONSE_FILE));
        JSONAssert.assertEquals(testDataRepository.getExpectedResponse().toString(),
                testDataRepository.getResponse().readEntity(String.class), JSONCompareMode.LENIENT);
    }
}
