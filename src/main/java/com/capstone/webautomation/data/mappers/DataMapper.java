package com.capstone.webautomation.data.mappers;

public interface DataMapper<T> {
    T map(String filepath, String key, Class<T> tClass);
}
