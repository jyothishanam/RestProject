package ApiTesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;







public class GetRequestUsingHttpClient {
	
	@Test
	public void getHttpClient() {
		CloseableHttpClient client=HttpClients.createDefault();
		HttpGet getRequest=new HttpGet("https://petstore.swagger.io/v2/pet/123");
		getRequest.addHeader("Content-Type", "application/json");
		getRequest.addHeader("Accept", "application/json");
		CloseableHttpResponse response=null;
		try {
			response=client.execute(getRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int statusCode=response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		/*InputStream responseBody=null;
		try {
			responseBody=response.getEntity().getContent();
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = new BufferedReader(new InputStreamReader(responseBody)).lines().collect(Collectors.joining("\n"));*/
		
		try {
			String json = EntityUtils.toString(response.getEntity());
			System.out.println(json);
		
			int actual=JsonPath.parse(json).read("$.category.id");
		
			Assert.assertEquals(112,actual);
			
		
		System.out.println(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

	
	
}
