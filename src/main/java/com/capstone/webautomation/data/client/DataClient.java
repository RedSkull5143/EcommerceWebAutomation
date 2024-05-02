package com.capstone.webautomation.data.client;

import com.capstone.webautomation.data.mappers.DataMapper;
import com.capstone.webautomation.data.mappers.JSONDataMapper;

import java.util.Objects;

public class DataClient {
    protected DataMapper dataMapper;
    public DataClient() {
        this.dataMapper=new JSONDataMapper();
    }

    protected String getFilePath(String relativePath) {
        return Objects.requireNonNull(this.getClass()
                        .getClassLoader()
                        .getResource(String.format("data_set/%s",relativePath)))
                .getPath();
    }
}
