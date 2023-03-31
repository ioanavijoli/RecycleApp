package com.example.demo.repository;

import com.example.demo.exception.NoProductFoundException;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByName(String name);
   List<Product> findAllByNameContains(String name);
   List<Product> getAllByCategoryId(Long id)throws NoProductFoundException;
   /* @Query(value = "SELECT p FROM Product p WHERE p.name IN :name")
    List<Product> (@Param("name") String name);
*/
}

