<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/result.css" />
<meta charset="UTF-8">
<title>Weather Details</title>
</head>
<body>
<div class="container">
	<form action="<%=application.getContextPath()%>/weatherServlet" method="post">
	<input type="search" placeholder="City Name" name="city" />
		<button >🔍</button>	
	</form>
	
	<div class="weatherdeatil">
	
		<div class="weathericon">
			<img src="" alt="Clouds" id="weather-icon">
			<h2>${temperatureCelsius}°C</h2>
			<input type="hidden" id="wc" value="${weatherCondition}" />
			<h2>${weatherCondition}</h2>
		</div>
		
		<div class="citydetail">
			<div class="desc"><h2><strong>${cityName}</strong></h2></div>
			<div class="date">${date}</div>
		</div>
		
		<div class="winddetail">
			
			<div class="humiditybox">
				<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhgr7XehXJkOPXbZr8xL42sZEFYlS-1fQcvUMsS2HrrV8pcj3GDFaYmYmeb3vXfMrjGXpViEDVfvLcqI7pJ03pKb_9ldQm-Cj9SlGW2Op8rxArgIhlD6oSLGQQKH9IqH1urPpQ4EAMCs3KOwbzLu57FDKv01PioBJBdR6pqlaxZTJr3HwxOUlFhC9EFyw/s320/thermometer.png">
				<div class="humidity">
					<span>Humidity</span>
					<h2>${humidity}%</h2>
				</div>
			</div>
			
			<div class="windSpeed">
            	<img src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiyaIguDPkbBMnUDQkGp3wLRj_kvd_GIQ4RHQar7a32mUGtwg3wHLIe0ejKqryX8dnJu-gqU6CBnDo47O7BlzCMCwRbB7u0Pj0CbtGwtyhd8Y8cgEMaSuZKrw5-62etXwo7UoY509umLmndsRmEqqO0FKocqTqjzHvJFC2AEEYjUax9tc1JMWxIWAQR4g/s320/wind.png">
                <div class="wind">
	            	<span>Wind Speed</span>
	                <h2> ${windSpeed} km/h</h2>
				</div>
             </div>
			
		</div>
	
	</div>
	
</div>

<script src="<%=application.getContextPath()%>/js/result.js"></script>


</body>
</html>
