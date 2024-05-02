package com.capstone.webautomation.data.mappers;

import com.capstone.webautomation.data.mappers.DataMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONDataMapper<T> implements DataMapper<T> {
    @Override
    public T map(String filepath, String key, Class<T> tClass) {
        try {
            // Parse the JSON file using JsonParser
            JsonElement jsonElement = JsonParser.parseReader(new FileReader(filepath));

            // Navigate to the specified key
            JsonElement keyElement = jsonElement.getAsJsonObject().get(key);

            // Convert the key element back to JSON string
            String jsonString = keyElement.toString();

            // Deserialize the JSON string to the desired class
            Gson gson = new Gson();
            return gson.fromJson(jsonString, tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to find or read the file: " + filepath, e);
        }
    }
}
