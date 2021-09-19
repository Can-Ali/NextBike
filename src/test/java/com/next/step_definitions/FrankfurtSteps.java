package com.next.step_definitions;

import com.next.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrankfurtSteps {
    String url = ConfigurationReader.get("api_uri");
    Response response;
    List<Map<String,Object>> locations;
    List<String> actualStations;


    @When("I send a GET request to Frankfurt endpoint")
    public void iSendAGETRequestToFrankfurtEndpoint() {
        response= RestAssured.given().accept(ContentType.JSON)
                .when().get(url + "visa-frankfurt");
        actualStations= response.path("network.stations.name");
        System.out.println(actualStations.toString());

    }

    @Then("following hubs should be available")
    public void followingHubsShouldBeAvailable(List<String> expectedStations) {
       actualStations = response.path("network.stations.name");
        System.out.println(expectedStations.toString());
        System.out.println("...............");
        System.out.println(actualStations.toString());

        for (int i = 0; i < expectedStations.size(); i++) {
            Assert.assertEquals(actualStations.get(i),expectedStations.get(i));
        }

    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @Then("following {string} should have following {string}")
    public void followingShouldHaveFollowing(String arg0, String arg1) {

        actualStations = response.path("network.stations.name");
        List<String> id = response.path("network.stations.id");

        System.out.println(arg0);


        for (int i = 0; i < actualStations.size(); i++) {
            if (actualStations.get(i).equals(arg0)){
                Assert.assertEquals(id.get(i),arg1);

            }


        }

    }
}
