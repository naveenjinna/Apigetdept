package com.getdept1701.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class Apidept1701 {
	////private final String USER_AGENT="Mozilla/5.0";
	public String GetResponse() throws ClientProtocolException, IOException
	{

		StringBuffer result=new StringBuffer();
		HttpClient client=new DefaultHttpClient();
		String url="http://localhost:8080/employee-management/employees/getDepartments";
		HttpGet request=new HttpGet(url);
		////request.addHeader("User-Agent",USER_AGENT);
		HttpResponse response=client.execute(request);
		int responseCode=response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try{
		if(responseCode==200)
		
		{
			System.out.println("Get Response is Successfull");
			BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line="";
			while((line=reader.readLine())!=null)
			{
				result.append(line);
				System.out.println(result.toString());
			}
		}
		return result.toString();
	}  
		catch(Exception ex)
	{
		result.append("Get Response Failed");
		return result.toString();
	}

}
}