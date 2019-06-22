package ApiTesting;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import org.junit.Assert;

public class PostRequest {

	/*
 @Test
public void postAPet(){
	
	
		String body;
		
	
		

		try {
			body = new String (Files.readAllBytes(Paths.get("C:\\Users\\yogendar\\workspace-jyothi\\RestProject\\src\\test\\resources\\PostBody.json")));
		} catch (Exception e) {
			
			e.printStackTrace();
			body="abcd";
			
		}
	
		System.out.println(body);
		RequestSpecification postBody=RestAssured.given();
		postBody.header("Content-Type","application/json");
        postBody.body(body)	;
    
        Response response=postBody.post("https://petstore.swagger.io/v2/pet");
        int code=response.statusCode();
        System.out.println(code);
        Assert.assertEquals(200,code );
		}*/

     @Test
    public void postAPetxml(){
	
	String body;
		
		try {
			body = new String (Files.readAllBytes(Paths.get("C:\\Users\\yogendar\\workspace-jyothi\\RestProject\\src\\test\\resources\\Post.xml")));
		} catch (Exception e) {
			
			e.printStackTrace();
			body="abcd";
			
		}
	
		System.out.println(body);
		RequestSpecification postBody=RestAssured.given();
		postBody.header("Content-Type","application/xml");
        postBody.body(body);
         
    
        Response response=postBody.post("https://petstore.swagger.io/v2/pet");
        int code=response.statusCode();
        System.out.println(code);
        Assert.assertEquals(200,code);
		

}

}
