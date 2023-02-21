package com.example.springbootcrud.controllers;

import com.example.springbootcrud.customexceptionclass.CustomProductExceptionHandler;
import com.example.springbootcrud.customexceptionclass.ProductException;
import com.example.springbootcrud.dto.ProductsDto;
import com.example.springbootcrud.entity.Products;
import com.example.springbootcrud.normalclass.DeleteResponseUsingResponseEntity;
import com.example.springbootcrud.response.ProductResponse;
import com.example.springbootcrud.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping ("/addAll")
    public List<ProductsDto> addProducts(@Valid @RequestBody List<ProductsDto> product){
        return productService.saveAllProduct(product);
    }

    @PostMapping ("/add")
    public ResponseEntity<Object> addProducts(@Valid @RequestBody ProductsDto product){
        return productService.saveProduct(product);
    }

    @GetMapping ("/find")
    public List<ProductsDto> findProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/findByName")
    public List<ProductsDto> findProductsByName(@RequestParam String name){
        return productService.getProductByName(name);
    }

    @GetMapping("/findById")
    public ProductsDto findProductsById(@RequestParam int id){
        return productService.getProductById(id);
    }

    @GetMapping("/findByPrice")
    public List<ProductsDto> findProductsByPrice(@RequestParam int price){
        return productService.getProductByPrice(price);
    }

    @GetMapping("/findByStart-Name")
    public List<ProductsDto> findProductsByStartingName(@RequestParam String name){
        return productService.getProductByStartingName(name);
    }

    @GetMapping("/findByPriceSort")
    public List<ProductsDto> findProductsByPriceSort(@RequestParam int price1, @RequestParam int price2){
        return productService.getProductByPriceSort(price1, price2);
    }

    @GetMapping("/findByTotalPrice")
    public int findProductsByPriceSort(@RequestBody List<ProductsDto>products){
        return productService.totalPrice(products);
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestBody Products productsDto){
        return productService.deleteProduct(productsDto.getId());
    }

    @PutMapping("/update")
    public ProductsDto updateProducts(@RequestBody ProductsDto productsDto){
        return productService.updateProduct(productsDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductByPathVariable(@PathVariable int id){

//        if(false)
//            throw new ProductException("Product Not Found");

        //throw new CustomProductExceptionHandler("I",HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now(ZoneId.of("Z")));

        return productService.deleteProduct(id);
    }

    @DeleteMapping("/delete/")
    public String deleteProductByParam(@RequestParam int id){

        return productService.deleteProduct(id);
    }

    @GetMapping ("/home")
    public ResponseEntity <String> home(){
        System.out.println("This is home view");

        try {
            String a = null;
            System.out.println(a.length());

        }catch (NullPointerException nullPointerException){
            throw new NullPointerException("NULL");

        }
//        if(a==null){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }

        return home();
    }

    @GetMapping("/divide")
    public ResponseEntity<Object> divide(@RequestParam int a, int b){
        return ResponseEntity.ok(productService.divide(a,b));
    }
}
