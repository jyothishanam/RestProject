package MyApiTestingSteps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class ApiStepDefinations {
	Response response;
	
	@Given("^performing get request$")
	public void performing_get_request() {
		System.out.println("get request method");
		
	}

	@When("^I performs a get request$")
	public void i_performs_a_get_request() { 
		response=RestAssured.get("https://petstore.swagger.io/v2/pet/123");

		int code=response.getStatusCode();

		
	}

	@Then("^I should get a response code as (\\d+)$")
	public void i_should_get_a_response_code_as(int code) {
	code=response.getStatusCode();

		Assert.assertEquals(200, code);
		
	}

	@Then("^I should have below details in response$")
	public void i_should_have_below_details_in_response(DataTable table)  {
	
	
	}

}
