package ApiTesting;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class PostUsingHttpClient {

	
	@Test
	public void postWithHttpClient()
	{
		String body;
		CloseableHttpClient client=HttpClients.createDefault();
		
		HttpPost postRequest= new HttpPost("https://petstore.swagger.io/v2/pet");
		
		postRequest.addHeader(HttpHeaders.ACCEPT, "application/xml");
		postRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/xml");
		try {
			body = new String (Files.readAllBytes(Paths.get("C:\\Users\\yogendar\\workspace-jyothi\\RestProject\\src\\test\\resources\\Post.xml")));
		} catch (Exception e) {
			
			e.printStackTrace();
			body="abcd";
			
		}
		StringEntity entity = new StringEntity(body, ContentType.APPLICATION_XML);
		
		postRequest.setEntity(entity);
		CloseableHttpResponse response = null;
		try {
			response= client.execute(postRequest);
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		
		InputStream responseBody = null;
		try {
			responseBody = response.getEntity().getContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//System.out.println(response.getStatusLine().getStatusCode());
		String result = new BufferedReader(new InputStreamReader(responseBody)).lines().collect(Collectors.joining("\n"));
		System.out.println(result);
		
	}

}
