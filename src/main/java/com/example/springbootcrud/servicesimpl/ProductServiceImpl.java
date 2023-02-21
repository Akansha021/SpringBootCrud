package com.example.springbootcrud.servicesimpl;

import com.example.springbootcrud.customexceptionclass.CustomProductExceptionHandler;
import com.example.springbootcrud.customexceptionclass.IdNotFoundException;
import com.example.springbootcrud.customexceptionclass.ProductException;
import com.example.springbootcrud.dto.ProductsDto;
import com.example.springbootcrud.entity.Products;
import com.example.springbootcrud.normalclass.DeleteResponseUsingResponseEntity;
import com.example.springbootcrud.repo.ProductRepository;
import com.example.springbootcrud.response.ProductResponse;
import com.example.springbootcrud.services.ProductService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DeleteResponseUsingResponseEntity deleteResponseUsingResponse;

    @Override
    public ResponseEntity<Object> saveProduct(ProductsDto productsDto) {
        ProductResponse productResponse=new ProductResponse();
        try {
            Products products = new Products();
            products.setName(productsDto.getName());
            products.setPrice(productsDto.getPrice());
            products.setQuantity(productsDto.getQuantity());

            //productRepository.save(products);

            products=productRepository.save(products);

            productResponse.setId(products.getId());
            productResponse.setName(products.getName());
            productResponse.setQuantity(products.getQuantity());
            productResponse.setPrice(products.getPrice());
        } catch (Exception e) {
            HttpStatus request= HttpStatus.INTERNAL_SERVER_ERROR;
            deleteResponseUsingResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            deleteResponseUsingResponse.setHttpStatusCode(HttpStatusCode.valueOf(500));
            deleteResponseUsingResponse.setMessage("Not Success");
            return new ResponseEntity<>(deleteResponseUsingResponse,request);
        }

        return ResponseEntity.ok().body(productResponse);
    }

    @Override
    public List<ProductsDto> saveAllProduct(List<ProductsDto> productsDtoList) {
        List<Products> productsList = new ArrayList<>();
        Products products = new Products();

        try {
            for (ProductsDto productsDto : productsDtoList) {
                //products.setId(productsDto.getId());
                products.setName(productsDto.getName());
                products.setPrice(productsDto.getPrice());
                products.setQuantity(productsDto.getQuantity());
                productsList.add(products);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        productRepository.saveAll(productsList);
        return productsDtoList;

    }

    @Override
    public ProductsDto getProductById(int id) {
        ProductsDto productsDto = new ProductsDto();
        Products products = productRepository.findById(id).orElse(null);
        try {
            //productsDto.setId(productsDto.getId());
            productsDto.setName(products.getName());
            productsDto.setPrice(products.getPrice());
            productsDto.setQuantity(products.getQuantity());
        } catch (Exception e) {
            System.out.println(e);
        }
        return productsDto;
    }

    @Override
    public List<ProductsDto> getProductByName(String name) {
        List<Products> products = productRepository.findByName(name);
        List<ProductsDto> productsDtoList = new ArrayList<>();

        try {
            for (Products product : products) {
                ProductsDto productsDto = new ProductsDto();
                //productsDto.setId(product.getId());
                productsDto.setName(product.getName());
                productsDto.setPrice(product.getPrice());
                productsDto.setQuantity(product.getQuantity());
                productsDtoList.add(productsDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return productsDtoList;

    }

    @Override
    public List<ProductsDto> getProductByPrice(int price) {
        List<Products> products = productRepository.findByPrice(price);
        List<ProductsDto> productsDtoList = new ArrayList<>();

        try {
            for (Products product : products) {
                ProductsDto productsDto = new ProductsDto();
                //productsDto.setId(product.getId());
                productsDto.setName(product.getName());
                productsDto.setPrice(product.getPrice());
                productsDto.setQuantity(product.getQuantity());
                productsDtoList.add(productsDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductByPriceSort(int price1, int price2) {
        List<Products> products = productRepository.OrderByPrice(price1, price2);
        List<ProductsDto> productsDtoList = new ArrayList<>();

        try {
            for (Products product : products) {
                ProductsDto productsDto = new ProductsDto();
                //productsDto.setId(product.getId());
                productsDto.setName(product.getName());
                productsDto.setPrice(product.getPrice());
                productsDto.setQuantity(product.getQuantity());
                productsDtoList.add(productsDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductByStartingName(String name) {
        List<Products> products = productRepository.findByNameStartingWith(name);
        List<ProductsDto> productsDtoList = new ArrayList<>();

        try {
            for (Products product : products) {
                ProductsDto productsDto = new ProductsDto();
                //productsDto.setId(product.getId());
                productsDto.setName(product.getName());
                productsDto.setPrice(product.getPrice());
                productsDto.setQuantity(product.getQuantity());
                productsDtoList.add(productsDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getAllProduct() {

        List<Products> products = productRepository.findAll();
        List<ProductsDto> productsDtoList = new ArrayList<>();

        try {
            for (Products product : products) {
                ProductsDto productsDto = new ProductsDto();
                //productsDto.setId(product.getId());
                productsDto.setName(product.getName());
                productsDto.setPrice(product.getPrice());
                productsDto.setQuantity(product.getQuantity());
                productsDtoList.add(productsDto);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return productsDtoList;
    }

    @Override
    public String deleteProduct(int id) {

//        productRepository.findById(id);

        Optional<Products> products = productRepository.findById(id);


/*

    Another Way

    if(!products.isPresent()){
            throw new IdNotFoundException("Id Not Found");
        }

        if(products.isPresent()) {
            try {
                productRepository.deleteById(id);
            } catch (Exception e) {
                System.out.println(e.toString());

            }
            return "Product Id "+ id+" deleted";
        }
        return "Product Not Present";

        try{
            productRepository.deleteById(id);
        }catch (Exception c){
            throw new ProductException("Id Not Found");
       }


*/

        if (!products.isPresent()) {
            // throw new ProductException("Id Not Found");
            throw new CustomProductExceptionHandler("Item Not Exist");

        }
        productRepository.deleteById(id);
        return "Product Id " + id + " deleted";
    }

    @Override
    public ProductsDto updateProduct(ProductsDto products) {
        ProductsDto productsDto = new ProductsDto();
//        Products oldProduct = productRepository.findById(products.getId()).orElse(null);
       /* try {
            oldProduct.setName(products.getName());
            oldProduct.setPrice(products.getPrice());
            oldProduct.setQuantity(products.getQuantity());

            productRepository.save(oldProduct);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        */
        return productsDto;
    }

    @Override
    public int totalPrice(List<ProductsDto> products) {
        int sum = 0;
        try {
            for (ProductsDto products1 : products) {
                sum += products1.getPrice() * products1.getQuantity();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return sum;
    }

    public String home() {

/*

        System.out.println("This is home view");
        String a=null;
        if(a.equals(null)){
            throw new RuntimeException("Exception");
        }
        System.out.println(a.length());

*/
        return "home";
    }

    public DeleteResponseUsingResponseEntity divide(int a, int b) {
        if (b != 0) {
            deleteResponseUsingResponse.setHttpStatus(HttpStatus.OK);
            deleteResponseUsingResponse.setHttpStatusCode(HttpStatusCode.valueOf(200));
            deleteResponseUsingResponse.setMessage("Success");
        } else {
            deleteResponseUsingResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            deleteResponseUsingResponse.setHttpStatusCode(HttpStatusCode.valueOf(500));
            deleteResponseUsingResponse.setMessage("Not Success");
        }
        return deleteResponseUsingResponse;
    }
}
