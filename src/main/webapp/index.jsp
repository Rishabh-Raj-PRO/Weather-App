<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/style.css" />
<meta charset="UTF-8">
<title>Weather Forecasting</title>
</head>
<body>
	<img src="<%=application.getContextPath()%>/img/wtr.png" alt="Not Found!!!" />
	<h1>Welcome to the Weather App</h1>
	<h2>Made by: Rishabh Raj</h2>
	<h2>Technology Used:</h2>
	<h3>HTML, CSS, JSP, JAVA, Sarvlet, OpenWeatherAPI</h3>
	<form action="<%=application.getContextPath()%>/weatherServlet" method="post">
		
		<label for="city">Enter City:</label>
		<input type="search" placeholder="City Name" name="city" />
		<button >🔍</button>
	
	</form>
</body>
</html>