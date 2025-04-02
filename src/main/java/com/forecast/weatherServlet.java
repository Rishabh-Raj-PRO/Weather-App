package com.forecast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class weatherServlet
 */
@WebServlet("/weatherServlet")
public class weatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String apikey="a66030a74d3efb1ed367423518349b89";
		String city=request.getParameter("city");
		String apiurl="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apikey;
		//@SuppressWarnings("deprecation")
		URL url =new URL(apiurl);
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		//reading the data from network
		InputStream inputStream=conn.getInputStream();
		InputStreamReader reader=new InputStreamReader(inputStream);
		
		//want to store in String which is mutable
		StringBuilder responseContent=new StringBuilder();
		
		//to take input from reader
		Scanner sc=new Scanner(reader);
		
		//now putting input to string 
		while(sc.hasNext()) {
			responseContent.append(sc.nextLine());
			
		}
		sc.close();
		
		
		//type casting=parsing the data into JSON
		Gson gson= new Gson();
		JsonObject jsonObject=gson.fromJson(responseContent.toString(), JsonObject.class);
		System.out.println(jsonObject);
		
		//fetching data from JSON
		
		//date and time
		long dataTimestamp=jsonObject.get("dt").getAsLong()*1000; // converting second to millisecond by multiplying 1000
		Date dateTime = new Date(dataTimestamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = sdf.format(dateTime);
		
		//name
		String cityName=jsonObject.get("name").getAsString();
		
		String country=jsonObject.getAsJsonObject("sys").get("country").getAsString();
		
		//Temperature
		double temperaturKelvin =jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
		int temperatureCelsius=(int)(temperaturKelvin-273.15);
		
		//Humidity
		int humidity=jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
		
		//Wind Speed
		double windSpeed=jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
		
		//weather Condition
		String weatherCondition=jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
		
		String place=cityName+ ","+country;
		
		System.out.println(weatherCondition);
		
		//sending data to JSP page
		request.setAttribute("date",formattedDateTime);
		request.setAttribute("cityName", place);
		request.setAttribute("temperatureCelsius", temperatureCelsius);
		request.setAttribute("humidity",humidity);
		request.setAttribute("windSpeed", windSpeed);
		request.setAttribute("weatherCondition", weatherCondition);
		request.setAttribute("weatherData", responseContent.toString());
		conn.disconnect();
	}catch (Exception e) {
		e.printStackTrace();
	}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

}
