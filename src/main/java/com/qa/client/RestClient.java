package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	//1. Get Method
	public void get(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		 HttpGet httpget=new HttpGet(url);//http get request
		 CloseableHttpResponse closeablehttpresponse = httpClient.execute(httpget);
		 
  //2.Status Code
		 int StatusCode = closeablehttpresponse.getStatusLine().getStatusCode();
		 System.out.println("Status code is"+ StatusCode );
	
		 //3.Json String
		String responseString= EntityUtils.toString( closeablehttpresponse.getEntity(),"UTF-8");
		 JSONObject responsejson= new JSONObject(responseString);
		 System.out.println("Response JSON from API"+ responsejson );
		 
		 //4.Headers
		 Header[] headersArray= closeablehttpresponse.getAllHeaders();
		 HashMap headers= new HashMap<String,String>();
		 for(Header header:headersArray)
		 {
			 headers.put(header.getName(), header.getValue());
			 
		 }
		 System.out.println("header info:" + headers);
		 
	}
}
