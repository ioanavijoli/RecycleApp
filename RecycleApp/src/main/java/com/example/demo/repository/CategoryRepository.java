package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.RecyclingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);
    List<Category> findAllByNameContains(String name);
    List<Category> getCategoriesByRecyclingCenterListContaining(RecyclingCenter recyclingCenter);

}
