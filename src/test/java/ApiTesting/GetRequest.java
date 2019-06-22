package ApiTesting;

import org.junit.Assert;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;



public class GetRequest {

	@Test
 public void getResponseCode() {
		
Response response=RestAssured.get("https://petstore.swagger.io/v2/pet/123");

int code=response.getStatusCode();

Assert.assertEquals(200, code);
  
}
	
	@Test
	
	 public void getResponseTime() {
			
	Response response=RestAssured.get("https://petstore.swagger.io/v2/pet/123");

	String responseBody=response.getBody().asString();
System.out.println(responseBody);

long responseTime=response.getTime();
System.out.println(responseTime);
	
	  
	}
	
	


}

