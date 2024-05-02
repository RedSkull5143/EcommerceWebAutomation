package com.capstone.webautomation.data.client;

import com.capstone.webautomation.data.mappers.DataMapper;
import com.capstone.webautomation.models.Product;

public class ProductDataClient extends DataClient{
    public Product getProduct(){
        String filepath=getFilePath("products/products.json");
        return (Product) dataMapper.map(filepath,"megaraDress", Product.class);
    }
}
