package com.capstone.webautomation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private String seller;
    private String label;
    private String originalPrice;
    private String salePrice;
    private String description;
    private List<String> sizes;
}
