/**
 * With incorrect Date
 */

package io.fixer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

public class CheckResponseDatesIncorrect {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		String url = "http://api.fixer.io/2000-01-0";
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		HttpResponse response = client.execute(request);
		int actualResponseCode = response.getStatusLine().getStatusCode();
		int expectedResponseCode = 404;
		
		Assert.assertEquals(expectedResponseCode, actualResponseCode);
		
		BufferedReader rd = new BufferedReader
				(new InputStreamReader(response.getEntity().getContent()));
		
		StringBuffer result = new StringBuffer();
		String line = "";
		while((line = rd.readLine()) !=null)
			result.append(line);
		System.out.println("Response Payload is " + result);
	}
}
