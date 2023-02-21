package com.example.springbootcrud.services;

import com.example.springbootcrud.dto.ProductsDto;
import com.example.springbootcrud.entity.Products;
import com.example.springbootcrud.response.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<Object> saveProduct(ProductsDto products);

    List<ProductsDto> saveAllProduct(List<ProductsDto> products);

    ProductsDto getProductById(int id);

    List<ProductsDto> getProductByName(String name);
    public List<ProductsDto> getProductByPrice(int price);
    List<ProductsDto> getProductByPriceSort(int price1, int price2);
    List<ProductsDto> getProductByStartingName(String name);
    List<ProductsDto> getAllProduct();
    String deleteProduct(int id);
    ProductsDto updateProduct(ProductsDto products);
    int totalPrice(List<ProductsDto>products);

    String home();

    Object divide(int a,int b);

}
