package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApiTest extends TestBase {
  TestBase testbase;
  String serviceurl;
  String apiurl;
  String url;
  RestClient restClient;
  
	@BeforeMethod
	public void setUp() {
	testbase= new TestBase();
	serviceurl= prop.getProperty("URL");
	apiurl= prop.getProperty("serviceURL");
	url= serviceurl + apiurl;
	
	}
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		restClient.get(url);	
	}

}
