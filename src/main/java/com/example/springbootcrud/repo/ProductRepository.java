package com.example.springbootcrud.repo;

import com.example.springbootcrud.entity.Products;
import com.example.springbootcrud.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

//    @Query("Select P from Products P where P.name=?1")
    List<Products> findByName(String name);

    List<Products> findByPrice(int price);

    List<Products> findByNameStartingWith(String name);

    @Query("Select P1 from Products P1 where P1.price BETWEEN ?1 and ?2")
    List<Products> OrderByPrice(int price1, int price2);

    @Query("Select P from Products P where P.id=(select max(id) from Products )")
      Products  getLastProduct();








}
