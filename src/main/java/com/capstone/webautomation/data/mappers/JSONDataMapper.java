package com.capstone.webautomation.data.mappers;
import com.capstone.webautomation.data.mappers.DataMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class JSONDataMapper<T> implements DataMapper<T> {
    @Override
    public T map(String filepath, String key, Class<T> tClass) {
        Gson gson=new Gson();
        try {
            Map jsonMap = gson.fromJson(new FileReader(filepath), Map.class);
            LinkedTreeMap jsonElement = (LinkedTreeMap) jsonMap.get(key);
            if(Objects.isNull(jsonElement)) throw new FileNotFoundException();
            return gson.fromJson(jsonElement.toString(), tClass);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("Failed to find data for key %s in file %s or filepath %s itself is wrong", key, filepath, filepath));
        }
    }
}
