
# Android Weather App

This is a simple Android weather application that uses the WeatherAPI to fetch the current weather data for a given city. The app is built using Retrofit for network calls and displays temperature and weather condition data.

## Requirements

- Android Studio
- Java 8 or higher
- Gradle
- WeatherAPI API key 

## Steps to Install and Use

## 1. Clone the Repository:
First, clone this repository to your local machine:
```bash
git clone https://github.com/sulaymonovyusufbek/TheWeatherApp.git
 ```` 

## 2. Open in Android Studio:

Open Android Studio and select "Open an existing project" and navigate to the folder where the project was cloned.

## 3.  Add Your Weather API Key:

In the local.properties file (create in root folder if not already there), add the following line:

```bash
WEATHER_API_KEY=your_api_key_here

 ```` 

 ## 4. Build the Project:

 Once the API key is added, sync the Gradle files to download dependencies and build the project.

  ## 5.  Run the App:

Start an emulator.


In Android Studio, click on the "Run" button (the green triangle) to launch the app.


  ## 6.Usage:

  Enter a city name in the text input field and click the "Get Weather" button to fetch the current weather.
The app will display the temperature in Celsius and the weather condition (e.g., sunny, rainy).



  ## How the App Works:
   ##  1. API Interaction (Retrofit):
  The **Api**  interface defines the endpoint current.json which is used to get the current weather for a city.

**getCurrentWeather()**   method sends a GET request with parameters for the API key, city name.

 ## 2. Retrofit Client:

 The **RetrofitClient** class initializes Retrofit with the base URL of the WeatherAPI and a Gson converter to parse the JSON responses into Java objects.

## 3. MainActivity:

The app prompts the user for a city name and, upon clicking the button, it makes an asynchronous API call.

If successful, it displays the temperature and weather condition. If the city is not found, it displays an error message.


## Dependencies

- **Retrofit2** for making network calls  
  ```groovy
  implementation 'com.squareup.retrofit2:retrofit:2.9.0'

 
- **GsonConverterFactory** for parsing JSON responses  
  ```groovy
  implementation 'com.squareup.retrofit2:converter-gson:2.9.0'


## Configuration

**API Key Configuration:** The API key is stored in the **BuildConfig** via **local.properties** file and accessed in the app using **BuildConfig.WEATHER_API_KEY**.

**Build Config**: In the build.gradle file, the project is configured to:

Use the API key in both debug and release build types.



## Troubleshooting

**Error: "City not found"**: Make sure the city name is spelled correctly and the WeatherAPI is working.

**Error: "Failed to get data"**: Check your internet connection and verify the API key is correct.


## Project Structure

- **MainActivity.java**: Main activity that interacts with the user interface.  
- **WeatherResponse.java**: Model class that represents the response from the WeatherAPI.  
- **RetrofitClient.java**: Manages Retrofit instance and makes network requests.  
- **Api.java**: Defines the Retrofit interface for the API endpoints.
