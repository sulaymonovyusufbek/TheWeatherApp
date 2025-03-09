package com.example.androidweatherapp.model;

public class WeatherResponse {
    private Current current;

    public Current getCurrent() {
        return current;
    }

    public class Current {
        private float temp_c;
        private Condition condition;

        public float getTemp_c() {
            return temp_c;
        }

        public Condition getCondition() {
            return condition;
        }
    }

    public class Condition {
        private String text;

        public String getText() {
            return text;
        }
    }
}
