# WeatherApp

WeatherApp for MLB technical exam.

App has two views:
	1. MainActivity
		-Contains an input for a zipcode, since zipcodes are 5 characters (numbers only), 
		will only take a 5 character input, no more, no less.On a bad input, app will display 
		a toast with their invalid input and  prompt to input a valid zipcode.
	
		-'CheckWeather' Button to start next activity that will do API request

	2. WeatherActivity
		-Centered TextView that updates with the data received by the API request
	
Note: Unit tests for temperature convertions from K->F and K->C can be found in ExampleUnitTest.kt
