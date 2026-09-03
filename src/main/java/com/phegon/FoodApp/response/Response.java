package com.phegon.FoodApp.response;

import java.io.Serializable;
import java.util.Map;

public class Response<T> {
    private int statusCode;
    private String message;
    private T data;
    private Map<String, Serializable> meta;

}
