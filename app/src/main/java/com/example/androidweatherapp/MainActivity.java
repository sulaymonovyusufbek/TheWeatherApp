package com.example.androidweatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidweatherapp.client.RetrofitClient;
import com.example.androidweatherapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String API_KEY = BuildConfig.WEATHER_API_KEY;
    private EditText etCity;
    private Button btnGetWeather;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCity = findViewById(R.id.etCity);
        btnGetWeather = findViewById(R.id.btnGetWeather);
        Result = findViewById(R.id.Result);

        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = etCity.getText().toString().trim();
                if (!city.isEmpty()) {
                    getWeatherData(city);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getWeatherData(String city) {
        Call<WeatherResponse> call = RetrofitClient.getInstance().getCurrentWeather(API_KEY, city, "no");
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    float temp = response.body().getCurrent().getTemp_c();
                    String condition = response.body().getCurrent().getCondition().getText();
                    Result.setText("Temperature: " + temp + "°C\nCondition: " + condition);
                } else {
                    Result.setText("City not found or error occurred.");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Result.setText("Failed to get data: " + t.getMessage());
            }
        });
    }
}