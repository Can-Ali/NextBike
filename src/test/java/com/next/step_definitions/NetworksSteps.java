package com.next.step_definitions;


import com.next.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NetworksSteps {

    String url = ConfigurationReader.get("api_uri");
    Response response;
    List<Map<String,Object>> locations;

    @When("I send a GET request to networks")
    public void iSendAGETRequestToNetworks() {
        response= RestAssured.given().accept(ContentType.JSON)
                .when().get(url);
        locations= response.path("networks.location");
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }


    @Then("Frankfurt should be in Germany")
    public void frankfurtShouldBeInGermany() {

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).get("city").equals("Frankfurt")) {
                Assert.assertTrue(locations.get(i).get("country").equals("DE"));
            }
        }
    }



    @And("I should be  able get location info")
    public void iShouldBeAbleGetLocationInfo() {

        List<Map<String,Object>> locations = response.path("networks.location");
        for (int i = 0; i < locations.size(); i++) {
            if(locations.get(i).get("city").equals("Frankfurt")){
                System.out.println(locations.get(i).get("latitude"));
                System.out.println(locations.get(i).get("longitude"));
            }
        }
    }


    @Then("contentType should be json")
    public void contenttype_should_be_json() {
        assertTrue(response.contentType().contains("application/json"));
       // throw new cucumber.api.PendingException();
    }

}
