package ApiTesting;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Assert;

public class DeleteRequest {
	
@Test
public void DelReq() {
	//trying to commit from jyothi branch
	
	Response response=RestAssured.delete("https://petstore.swagger.io/v2/pet/130");
	
	int code=response.getStatusCode();
	
	Assert.assertEquals(200, code);
}

}
